
package ec.com.infinityone.envio;

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
 *         &lt;element name="generarOrdenEntregaReturn" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "generarOrdenEntregaReturn"
})
@XmlRootElement(name = "generarOrdenEntregaResponse")
public class GenerarOrdenEntregaResponse {

    @XmlElement(required = true, nillable = true)
    protected String generarOrdenEntregaReturn;

    /**
     * Obtiene el valor de la propiedad generarOrdenEntregaReturn.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenerarOrdenEntregaReturn() {
        return generarOrdenEntregaReturn;
    }

    /**
     * Define el valor de la propiedad generarOrdenEntregaReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenerarOrdenEntregaReturn(String value) {
        this.generarOrdenEntregaReturn = value;
    }

}
