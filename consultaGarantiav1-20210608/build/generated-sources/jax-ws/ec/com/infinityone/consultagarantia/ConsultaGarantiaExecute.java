
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
 *         &lt;element name="Cgccodcom" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="Clave" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "cgccodcom",
    "clave"
})
@XmlRootElement(name = "ConsultaGarantia.Execute")
public class ConsultaGarantiaExecute {

    @XmlElement(name = "Cgccodcom")
    protected short cgccodcom;
    @XmlElement(name = "Clave", required = true)
    protected String clave;

    /**
     * Obtiene el valor de la propiedad cgccodcom.
     * 
     */
    public short getCgccodcom() {
        return cgccodcom;
    }

    /**
     * Define el valor de la propiedad cgccodcom.
     * 
     */
    public void setCgccodcom(short value) {
        this.cgccodcom = value;
    }

    /**
     * Obtiene el valor de la propiedad clave.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClave() {
        return clave;
    }

    /**
     * Define el valor de la propiedad clave.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClave(String value) {
        this.clave = value;
    }

}
