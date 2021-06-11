
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
 *         &lt;element name="tramaEnviadaXBanco" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "tramaEnviadaXBanco"
})
@XmlRootElement(name = "anularOrdenEntrega")
public class AnularOrdenEntrega {

    @XmlElement(required = true, nillable = true)
    protected String tramaEnviadaXBanco;

    /**
     * Obtiene el valor de la propiedad tramaEnviadaXBanco.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTramaEnviadaXBanco() {
        return tramaEnviadaXBanco;
    }

    /**
     * Define el valor de la propiedad tramaEnviadaXBanco.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTramaEnviadaXBanco(String value) {
        this.tramaEnviadaXBanco = value;
    }

}
