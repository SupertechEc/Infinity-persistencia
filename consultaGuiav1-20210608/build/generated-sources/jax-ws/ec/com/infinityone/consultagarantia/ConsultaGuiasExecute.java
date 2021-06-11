
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
 *         &lt;element name="Cbtcodcom" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="Clave" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Cbtfecemi" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Cbtcoddep" type="{http://www.w3.org/2001/XMLSchema}byte"/>
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
    "cbtcodcom",
    "clave",
    "cbtfecemi",
    "cbtcoddep"
})
@XmlRootElement(name = "ConsultaGuias.Execute")
public class ConsultaGuiasExecute {

    @XmlElement(name = "Cbtcodcom")
    protected short cbtcodcom;
    @XmlElement(name = "Clave", required = true)
    protected String clave;
    @XmlElement(name = "Cbtfecemi")
    protected int cbtfecemi;
    @XmlElement(name = "Cbtcoddep")
    protected byte cbtcoddep;

    /**
     * Obtiene el valor de la propiedad cbtcodcom.
     * 
     */
    public short getCbtcodcom() {
        return cbtcodcom;
    }

    /**
     * Define el valor de la propiedad cbtcodcom.
     * 
     */
    public void setCbtcodcom(short value) {
        this.cbtcodcom = value;
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
     * Obtiene el valor de la propiedad cbtfecemi.
     * 
     */
    public int getCbtfecemi() {
        return cbtfecemi;
    }

    /**
     * Define el valor de la propiedad cbtfecemi.
     * 
     */
    public void setCbtfecemi(int value) {
        this.cbtfecemi = value;
    }

    /**
     * Obtiene el valor de la propiedad cbtcoddep.
     * 
     */
    public byte getCbtcoddep() {
        return cbtcoddep;
    }

    /**
     * Define el valor de la propiedad cbtcoddep.
     * 
     */
    public void setCbtcoddep(byte value) {
        this.cbtcoddep = value;
    }

}
