
package au.com.ors.soap.pdv;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.0.4
 * 2015-10-14T17:57:18.402+11:00
 * Generated source version: 3.0.4
 */

@WebFault(name = "pdvFault", targetNamespace = "http://soap.ors.com.au/pdv")
public class PdvFault_Exception extends Exception {
    
    private au.com.ors.soap.pdv.PdvFault pdvFault;

    public PdvFault_Exception() {
        super();
    }
    
    public PdvFault_Exception(String message) {
        super(message);
    }
    
    public PdvFault_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public PdvFault_Exception(String message, au.com.ors.soap.pdv.PdvFault pdvFault) {
        super(message);
        this.pdvFault = pdvFault;
    }

    public PdvFault_Exception(String message, au.com.ors.soap.pdv.PdvFault pdvFault, Throwable cause) {
        super(message, cause);
        this.pdvFault = pdvFault;
    }

    public au.com.ors.soap.pdv.PdvFault getFaultInfo() {
        return this.pdvFault;
    }
}
