
package ec.com.infinityone.consultagarantia;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para SDTGarantia complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SDTGarantia">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CGCCODCOM" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="CGCComercializadora" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CGCUNIMON" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="CGCVALCOM" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="CGCSUMAVA" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Garantia98" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="CGCSALDO" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="SaldoDisponible" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="PorcentajeUso" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SDTGarantia", propOrder = {
    "cgccodcom",
    "cgcComercializadora",
    "cgcunimon",
    "cgcvalcom",
    "cgcsumava",
    "garantia98",
    "cgcsaldo",
    "saldoDisponible",
    "porcentajeUso"
})
public class SDTGarantia {

    @XmlElement(name = "CGCCODCOM")
    protected short cgccodcom;
    @XmlElement(name = "CGCComercializadora", required = true)
    protected String cgcComercializadora;
    @XmlElement(name = "CGCUNIMON")
    protected byte cgcunimon;
    @XmlElement(name = "CGCVALCOM")
    protected double cgcvalcom;
    @XmlElement(name = "CGCSUMAVA")
    protected double cgcsumava;
    @XmlElement(name = "Garantia98")
    protected double garantia98;
    @XmlElement(name = "CGCSALDO")
    protected double cgcsaldo;
    @XmlElement(name = "SaldoDisponible")
    protected double saldoDisponible;
    @XmlElement(name = "PorcentajeUso")
    protected double porcentajeUso;

    /**
     * Obtiene el valor de la propiedad cgccodcom.
     * 
     */
    public short getCGCCODCOM() {
        return cgccodcom;
    }

    /**
     * Define el valor de la propiedad cgccodcom.
     * 
     */
    public void setCGCCODCOM(short value) {
        this.cgccodcom = value;
    }

    /**
     * Obtiene el valor de la propiedad cgcComercializadora.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCGCComercializadora() {
        return cgcComercializadora;
    }

    /**
     * Define el valor de la propiedad cgcComercializadora.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCGCComercializadora(String value) {
        this.cgcComercializadora = value;
    }

    /**
     * Obtiene el valor de la propiedad cgcunimon.
     * 
     */
    public byte getCGCUNIMON() {
        return cgcunimon;
    }

    /**
     * Define el valor de la propiedad cgcunimon.
     * 
     */
    public void setCGCUNIMON(byte value) {
        this.cgcunimon = value;
    }

    /**
     * Obtiene el valor de la propiedad cgcvalcom.
     * 
     */
    public double getCGCVALCOM() {
        return cgcvalcom;
    }

    /**
     * Define el valor de la propiedad cgcvalcom.
     * 
     */
    public void setCGCVALCOM(double value) {
        this.cgcvalcom = value;
    }

    /**
     * Obtiene el valor de la propiedad cgcsumava.
     * 
     */
    public double getCGCSUMAVA() {
        return cgcsumava;
    }

    /**
     * Define el valor de la propiedad cgcsumava.
     * 
     */
    public void setCGCSUMAVA(double value) {
        this.cgcsumava = value;
    }

    /**
     * Obtiene el valor de la propiedad garantia98.
     * 
     */
    public double getGarantia98() {
        return garantia98;
    }

    /**
     * Define el valor de la propiedad garantia98.
     * 
     */
    public void setGarantia98(double value) {
        this.garantia98 = value;
    }

    /**
     * Obtiene el valor de la propiedad cgcsaldo.
     * 
     */
    public double getCGCSALDO() {
        return cgcsaldo;
    }

    /**
     * Define el valor de la propiedad cgcsaldo.
     * 
     */
    public void setCGCSALDO(double value) {
        this.cgcsaldo = value;
    }

    /**
     * Obtiene el valor de la propiedad saldoDisponible.
     * 
     */
    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    /**
     * Define el valor de la propiedad saldoDisponible.
     * 
     */
    public void setSaldoDisponible(double value) {
        this.saldoDisponible = value;
    }

    /**
     * Obtiene el valor de la propiedad porcentajeUso.
     * 
     */
    public double getPorcentajeUso() {
        return porcentajeUso;
    }

    /**
     * Define el valor de la propiedad porcentajeUso.
     * 
     */
    public void setPorcentajeUso(double value) {
        this.porcentajeUso = value;
    }

}
