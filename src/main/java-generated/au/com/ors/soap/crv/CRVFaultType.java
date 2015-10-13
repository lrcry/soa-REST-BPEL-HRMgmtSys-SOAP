
package au.com.ors.soap.crv;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>CRVFaultType的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="CRVFaultType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="InvalidCurrencyCode"/&gt;
 *     &lt;enumeration value="InvalidServiceCode"/&gt;
 *     &lt;enumeration value="ProgramError"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CRVFaultType")
@XmlEnum
public enum CRVFaultType {

    @XmlEnumValue("InvalidCurrencyCode")
    INVALID_CURRENCY_CODE("InvalidCurrencyCode"),
    @XmlEnumValue("InvalidServiceCode")
    INVALID_SERVICE_CODE("InvalidServiceCode"),
    @XmlEnumValue("ProgramError")
    PROGRAM_ERROR("ProgramError");
    private final String value;

    CRVFaultType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CRVFaultType fromValue(String v) {
        for (CRVFaultType c: CRVFaultType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
