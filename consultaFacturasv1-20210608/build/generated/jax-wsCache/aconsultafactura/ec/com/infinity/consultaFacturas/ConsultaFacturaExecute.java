
package ec.com.infinity.consultaFacturas;

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
 *         &lt;element name="Faucodcom" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="Clave" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Faufecven" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "faucodcom",
    "clave",
    "faufecven"
})
@XmlRootElement(name = "ConsultaFactura.Execute")
public class ConsultaFacturaExecute {

    @XmlElement(name = "Faucodcom")
    protected short faucodcom;
    @XmlElement(name = "Clave", required = true)
    protected String clave;
    @XmlElement(name = "Faufecven")
    protected int faufecven;

    /**
     * Obtiene el valor de la propiedad faucodcom.
     * 
     */
    public short getFaucodcom() {
        return faucodcom;
    }

    /**
     * Define el valor de la propiedad faucodcom.
     * 
     */
    public void setFaucodcom(short value) {
        this.faucodcom = value;
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

    /**
     * Obtiene el valor de la propiedad faufecven.
     * 
     */
    public int getFaufecven() {
        return faufecven;
    }

    /**
     * Define el valor de la propiedad faufecven.
     * 
     */
    public void setFaufecven(int value) {
        this.faufecven = value;
    }

}
