
package au.com.ors.soap.pdv;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
 *         &lt;element name="pdvResult" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="crvResult" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "pdvResult",
    "crvResult"
})
@XmlRootElement(name = "PDVCheckResponseMsg")
public class PDVCheckResponseMsg {

    @XmlElement(required = true)
    protected String pdvResult;
    @XmlElement(required = true)
    protected String crvResult;

    /**
     * 获取pdvResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPdvResult() {
        return pdvResult;
    }

    /**
     * 设置pdvResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPdvResult(String value) {
        this.pdvResult = value;
    }

    /**
     * 获取crvResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCrvResult() {
        return crvResult;
    }

    /**
     * 设置crvResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCrvResult(String value) {
        this.crvResult = value;
    }

}
