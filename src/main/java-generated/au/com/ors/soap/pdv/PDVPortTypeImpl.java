package au.com.ors.soap.pdv;

import java.io.IOException;
import java.net.URL;

import javax.jws.WebService;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@WebService(endpointInterface = "au.com.ors.soap.pdv.PDVPortType")
public class PDVPortTypeImpl implements PDVPortType {
	
	static private final String ALLMATCHED = "PDV result: the given details are correct against our records";
	static private final String NOTMATCHED = "PDV result: the given license number is correct, but details are different to our records";
	static private final String NOTFOUND = "PDV result: the given license number is incorrect.";
	
	ObjectFactory obj = new ObjectFactory();
	
	@Override
	public PDVCheckResponseMsg pdvCheck(PDVCheckRequestMsg parameters)
			throws PdvFault_Exception {
		// TODO Auto-generated method stub
		PDVCheckResponseMsg res = obj.createPDVCheckResponseMsg();
		String driverLicenseNumber = parameters.getDriverLicenseNumber();
		String fullName = parameters.getFullName();
		String postCode = parameters.getPostCode();
		try {
			String result = check(driverLicenseNumber, fullName, postCode);
			res.setResult(result);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			PdvFault fault = obj.createPdvFault();
			fault.setFaultMessage("Server internal error.");
			fault.setFaultType(PDVFaultType.PROGRAM_ERROR);
			PdvFault_Exception faultException = new PdvFault_Exception(fault.getFaultMessage(), fault);
			throw faultException;
		} 
		return res;
	}

	public String check(String driverLicenseNumber, String fullName,
			String postCode) throws ParserConfigurationException, SAXException, IOException {
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
					} else if (currentNode.getNodeName().equalsIgnoreCase("fullName")) {
						if (!currentNode.getTextContent().equalsIgnoreCase(fullName)) {
							return NOTMATCHED;
						}
					} else if (currentNode.getNodeName().equalsIgnoreCase("postCode")) {
						if (!currentNode.getTextContent().equalsIgnoreCase(postCode)) {
							return NOTMATCHED;
						} else {
							return ALLMATCHED;
						}
					}
				}
			}
		}

		return NOTFOUND;
	}
}
