package au.com.ors.soap.crv;

import java.io.IOException;
import java.net.URL;

import javax.jws.WebService;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.util.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@WebService(endpointInterface = "au.com.ors.soap.crv.CRVPortType")
public class CRVPortTypeImpl implements CRVPortType{
	
	static private final String NORECORD = "CRV result: the given license number has no records to report";
	static private final String HASRECORD = "CRV result: the given license number is known in our database, a further discussion is recommended.";
	
	ObjectFactory obj = new ObjectFactory();
	
	@Override
	public CRVCheckResponseMsg crvCheck(CRVCheckRequestMsg parameters)
			throws CRVFault_Exception {
		// TODO Auto-generated method stub
		CRVCheckResponseMsg res = obj.createCRVCheckResponseMsg();
		String driverLicenseNumber = parameters.getDriverLicenseNumber();
		try {
			String result = check(driverLicenseNumber);
			res.setResult(result);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			CRVFault fault = obj.createCRVFault();
			fault.setFaultMessage("Server internal error");
			fault.setFaultType(CRVFaultType.PROGRAM_ERROR);
			CRVFault_Exception faultException = new CRVFault_Exception(fault.getFaultMessage(), fault);
			throw faultException;
		}
		
		return res;
	}
	
	public String check(String driverLicenseNumber) throws ParserConfigurationException, SAXException, IOException {
		Document dom;

		URL path = this.getClass().getClassLoader().getResource("../db/bpeldb.xml");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		DocumentBuilder db;
		db = dbf.newDocumentBuilder();
		dom = db.parse(path.toString());
	
		
		Element rootElement = dom.getDocumentElement();
		NodeList nodeList = rootElement.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); ++i) {
			Node node = nodeList.item(i);
			if (!node.getNodeName().equalsIgnoreCase("bpelElement")) {
				continue;
			}
			NodeList attributeList = node.getChildNodes();
			for (int j = 0; j < attributeList.getLength(); ++j) {
				Node currentNode = attributeList.item(j);
				
				if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
					if (currentNode.getNodeName().equalsIgnoreCase("driverLicenseNumber")) {
						if (!currentNode.getTextContent().equalsIgnoreCase(driverLicenseNumber)) {
							break;
						}
					} else if (currentNode.getNodeName().equalsIgnoreCase("criminalRecord")) {
						if (!StringUtils.isEmpty(currentNode.getTextContent())) {
							return HASRECORD;
						}
					}
				}
			}
		}
		return NORECORD;
	}
}
