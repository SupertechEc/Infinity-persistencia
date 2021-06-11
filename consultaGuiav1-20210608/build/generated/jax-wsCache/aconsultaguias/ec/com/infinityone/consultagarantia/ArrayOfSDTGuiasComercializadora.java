
package ec.com.infinityone.consultagarantia;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfSDTGuiasComercializadora complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfSDTGuiasComercializadora">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SDTGuiasComercializadora" type="{Sistema_Abastcedora}SDTGuiasComercializadora" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfSDTGuiasComercializadora", propOrder = {
    "sdtGuiasComercializadora"
})
public class ArrayOfSDTGuiasComercializadora {

    @XmlElement(name = "SDTGuiasComercializadora")
    protected List<SDTGuiasComercializadora> sdtGuiasComercializadora;

    /**
     * Gets the value of the sdtGuiasComercializadora property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sdtGuiasComercializadora property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSDTGuiasComercializadora().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SDTGuiasComercializadora }
     * 
     * 
     */
    public List<SDTGuiasComercializadora> getSDTGuiasComercializadora() {
        if (sdtGuiasComercializadora == null) {
            sdtGuiasComercializadora = new ArrayList<SDTGuiasComercializadora>();
        }
        return this.sdtGuiasComercializadora;
    }

}
