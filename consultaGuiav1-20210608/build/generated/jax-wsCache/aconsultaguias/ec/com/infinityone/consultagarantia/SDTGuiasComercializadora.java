
package ec.com.infinityone.consultagarantia;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para SDTGuiasComercializadora complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SDTGuiasComercializadora">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CBTCODCOM" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="CBTNUMCBT" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CBTNUMORE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CBTFECEMI" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CBTARMERC" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="CBTCODPRO" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="CBTUNIMED" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="UMENOMABR" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CPRNOMPRO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CBTVOLENT" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="AUTPLAAUT" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SDTGuiasComercializadora", propOrder = {
    "cbtcodcom",
    "cbtnumcbt",
    "cbtnumore",
    "cbtfecemi",
    "cbtarmerc",
    "cbtcodpro",
    "cbtunimed",
    "umenomabr",
    "cprnompro",
    "cbtvolent",
    "autplaaut"
})
public class SDTGuiasComercializadora {

    @XmlElement(name = "CBTCODCOM")
    protected short cbtcodcom;
    @XmlElement(name = "CBTNUMCBT")
    protected int cbtnumcbt;
    @XmlElement(name = "CBTNUMORE")
    protected int cbtnumore;
    @XmlElement(name = "CBTFECEMI")
    protected int cbtfecemi;
    @XmlElement(name = "CBTARMERC")
    protected byte cbtarmerc;
    @XmlElement(name = "CBTCODPRO")
    protected byte cbtcodpro;
    @XmlElement(name = "CBTUNIMED")
    protected byte cbtunimed;
    @XmlElement(name = "UMENOMABR", required = true)
    protected String umenomabr;
    @XmlElement(name = "CPRNOMPRO", required = true)
    protected String cprnompro;
    @XmlElement(name = "CBTVOLENT")
    protected double cbtvolent;
    @XmlElement(name = "AUTPLAAUT", required = true)
    protected String autplaaut;

    /**
     * Obtiene el valor de la propiedad cbtcodcom.
     * 
     */
    public short getCBTCODCOM() {
        return cbtcodcom;
    }

    /**
     * Define el valor de la propiedad cbtcodcom.
     * 
     */
    public void setCBTCODCOM(short value) {
        this.cbtcodcom = value;
    }

    /**
     * Obtiene el valor de la propiedad cbtnumcbt.
     * 
     */
    public int getCBTNUMCBT() {
        return cbtnumcbt;
    }

    /**
     * Define el valor de la propiedad cbtnumcbt.
     * 
     */
    public void setCBTNUMCBT(int value) {
        this.cbtnumcbt = value;
    }

    /**
     * Obtiene el valor de la propiedad cbtnumore.
     * 
     */
    public int getCBTNUMORE() {
        return cbtnumore;
    }

    /**
     * Define el valor de la propiedad cbtnumore.
     * 
     */
    public void setCBTNUMORE(int value) {
        this.cbtnumore = value;
    }

    /**
     * Obtiene el valor de la propiedad cbtfecemi.
     * 
     */
    public int getCBTFECEMI() {
        return cbtfecemi;
    }

    /**
     * Define el valor de la propiedad cbtfecemi.
     * 
     */
    public void setCBTFECEMI(int value) {
        this.cbtfecemi = value;
    }

    /**
     * Obtiene el valor de la propiedad cbtarmerc.
     * 
     */
    public byte getCBTARMERC() {
        return cbtarmerc;
    }

    /**
     * Define el valor de la propiedad cbtarmerc.
     * 
     */
    public void setCBTARMERC(byte value) {
        this.cbtarmerc = value;
    }

    /**
     * Obtiene el valor de la propiedad cbtcodpro.
     * 
     */
    public byte getCBTCODPRO() {
        return cbtcodpro;
    }

    /**
     * Define el valor de la propiedad cbtcodpro.
     * 
     */
    public void setCBTCODPRO(byte value) {
        this.cbtcodpro = value;
    }

    /**
     * Obtiene el valor de la propiedad cbtunimed.
     * 
     */
    public byte getCBTUNIMED() {
        return cbtunimed;
    }

    /**
     * Define el valor de la propiedad cbtunimed.
     * 
     */
    public void setCBTUNIMED(byte value) {
        this.cbtunimed = value;
    }

    /**
     * Obtiene el valor de la propiedad umenomabr.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUMENOMABR() {
        return umenomabr;
    }

    /**
     * Define el valor de la propiedad umenomabr.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUMENOMABR(String value) {
        this.umenomabr = value;
    }

    /**
     * Obtiene el valor de la propiedad cprnompro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCPRNOMPRO() {
        return cprnompro;
    }

    /**
     * Define el valor de la propiedad cprnompro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCPRNOMPRO(String value) {
        this.cprnompro = value;
    }

    /**
     * Obtiene el valor de la propiedad cbtvolent.
     * 
     */
    public double getCBTVOLENT() {
        return cbtvolent;
    }

    /**
     * Define el valor de la propiedad cbtvolent.
     * 
     */
    public void setCBTVOLENT(double value) {
        this.cbtvolent = value;
    }

    /**
     * Obtiene el valor de la propiedad autplaaut.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAUTPLAAUT() {
        return autplaaut;
    }

    /**
     * Define el valor de la propiedad autplaaut.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAUTPLAAUT(String value) {
        this.autplaaut = value;
    }

}
