
package au.com.ors.soap.pdv;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>PDVFaultType的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="PDVFaultType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="InvalidCurrencyCode"/&gt;
 *     &lt;enumeration value="InvalidServiceCode"/&gt;
 *     &lt;enumeration value="ProgramError"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "PDVFaultType")
@XmlEnum
public enum PDVFaultType {

    @XmlEnumValue("InvalidCurrencyCode")
    INVALID_CURRENCY_CODE("InvalidCurrencyCode"),
    @XmlEnumValue("InvalidServiceCode")
    INVALID_SERVICE_CODE("InvalidServiceCode"),
    @XmlEnumValue("ProgramError")
    PROGRAM_ERROR("ProgramError");
    private final String value;

    PDVFaultType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PDVFaultType fromValue(String v) {
        for (PDVFaultType c: PDVFaultType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
