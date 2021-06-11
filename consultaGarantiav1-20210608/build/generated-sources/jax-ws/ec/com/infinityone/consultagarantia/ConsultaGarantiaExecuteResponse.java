
package ec.com.infinityone.consultagarantia;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Garantia" type="{Sistema_Abastcedora}SDTGarantia"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "garantia"
})
@XmlRootElement(name = "ConsultaGarantia.ExecuteResponse")
public class ConsultaGarantiaExecuteResponse {

    @XmlElement(name = "Garantia", required = true)
    protected SDTGarantia garantia;

    /**
     * Obtiene el valor de la propiedad garantia.
     * 
     * @return
     *     possible object is
     *     {@link SDTGarantia }
     *     
     */
    public SDTGarantia getGarantia() {
        return garantia;
    }

    /**
     * Define el valor de la propiedad garantia.
     * 
     * @param value
     *     allowed object is
     *     {@link SDTGarantia }
     *     
     */
    public void setGarantia(SDTGarantia value) {
        this.garantia = value;
    }

}
