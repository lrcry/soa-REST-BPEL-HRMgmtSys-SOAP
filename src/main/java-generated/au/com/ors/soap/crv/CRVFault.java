
package au.com.ors.soap.crv;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="faultType" type="{http://soap.ors.com.au/crv}CRVFaultType"/&gt;
 *         &lt;element name="faultMessage" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "faultType",
    "faultMessage"
})
@XmlRootElement(name = "CRVFault")
public class CRVFault {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected CRVFaultType faultType;
    @XmlElement(required = true)
    protected String faultMessage;

    /**
     * 获取faultType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CRVFaultType }
     *     
     */
    public CRVFaultType getFaultType() {
        return faultType;
    }

    /**
     * 设置faultType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CRVFaultType }
     *     
     */
    public void setFaultType(CRVFaultType value) {
        this.faultType = value;
    }

    /**
     * 获取faultMessage属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFaultMessage() {
        return faultMessage;
    }

    /**
     * 设置faultMessage属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFaultMessage(String value) {
        this.faultMessage = value;
    }

}
