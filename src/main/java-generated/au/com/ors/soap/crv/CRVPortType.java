package au.com.ors.soap.crv;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;

/**
 * This class was generated by Apache CXF 3.0.4
 * 2015-10-13T12:00:32.393+11:00
 * Generated source version: 3.0.4
 * 
 */
@WebService(targetNamespace = "http://soap.ors.com.au/crv", name = "CRVPortType")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface CRVPortType {

    @WebResult(name = "CRVCheckResponseMsg", targetNamespace = "http://soap.ors.com.au/crv", partName = "parameters")
    @Action(input = "urn:CRVCheckRequestMsg", output = "urn:CRVCheckResponseMsg", fault = {})
    @WebMethod(operationName = "CRVCheck", action = "urn:CRVCheckRequestMsg")
    public CRVCheckResponseMsg crvCheck(
        @WebParam(partName = "parameters", name = "CRVCheckRequestMsg", targetNamespace = "http://soap.ors.com.au/crv")
        CRVCheckRequestMsg parameters
    ) throws CRVFault_Exception;
}
