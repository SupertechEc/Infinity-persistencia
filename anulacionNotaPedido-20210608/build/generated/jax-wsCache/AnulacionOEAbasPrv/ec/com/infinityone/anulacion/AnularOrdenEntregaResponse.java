
package ec.com.infinityone.anulacion;

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
 *         &lt;element name="anularOrdenEntregaReturn" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "anularOrdenEntregaReturn"
})
@XmlRootElement(name = "anularOrdenEntregaResponse")
public class AnularOrdenEntregaResponse {

    @XmlElement(required = true, nillable = true)
    protected String anularOrdenEntregaReturn;

    /**
     * Obtiene el valor de la propiedad anularOrdenEntregaReturn.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnularOrdenEntregaReturn() {
        return anularOrdenEntregaReturn;
    }

    /**
     * Define el valor de la propiedad anularOrdenEntregaReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnularOrdenEntregaReturn(String value) {
        this.anularOrdenEntregaReturn = value;
    }

}
