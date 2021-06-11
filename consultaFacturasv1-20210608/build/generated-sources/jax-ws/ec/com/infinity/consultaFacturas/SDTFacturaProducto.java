
package ec.com.infinity.consultaFacturas;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para SDTFacturaProducto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SDTFacturaProducto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numFactura" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numSRI" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="banco" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="fechaEmi" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fechaVmto" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fechaGuia" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="estadoFac" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="estadoPago" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Detalle">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ProductoFactura" type="{Sistema_Abastcedora}SDTFacturaProducto.ProductoFactura" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SDTFacturaProducto", propOrder = {
    "numFactura",
    "numSRI",
    "banco",
    "fechaEmi",
    "fechaVmto",
    "fechaGuia",
    "estadoFac",
    "estadoPago",
    "detalle"
})
public class SDTFacturaProducto {

    protected int numFactura;
    protected long numSRI;
    protected byte banco;
    protected int fechaEmi;
    protected int fechaVmto;
    protected int fechaGuia;
    @XmlElement(required = true)
    protected String estadoFac;
    @XmlElement(required = true)
    protected String estadoPago;
    @XmlElement(name = "Detalle", required = true)
    protected SDTFacturaProducto.Detalle detalle;

    /**
     * Obtiene el valor de la propiedad numFactura.
     * 
     */
    public int getNumFactura() {
        return numFactura;
    }

    /**
     * Define el valor de la propiedad numFactura.
     * 
     */
    public void setNumFactura(int value) {
        this.numFactura = value;
    }

    /**
     * Obtiene el valor de la propiedad numSRI.
     * 
     */
    public long getNumSRI() {
        return numSRI;
    }

    /**
     * Define el valor de la propiedad numSRI.
     * 
     */
    public void setNumSRI(long value) {
        this.numSRI = value;
    }

    /**
     * Obtiene el valor de la propiedad banco.
     * 
     */
    public byte getBanco() {
        return banco;
    }

    /**
     * Define el valor de la propiedad banco.
     * 
     */
    public void setBanco(byte value) {
        this.banco = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaEmi.
     * 
     */
    public int getFechaEmi() {
        return fechaEmi;
    }

    /**
     * Define el valor de la propiedad fechaEmi.
     * 
     */
    public void setFechaEmi(int value) {
        this.fechaEmi = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaVmto.
     * 
     */
    public int getFechaVmto() {
        return fechaVmto;
    }

    /**
     * Define el valor de la propiedad fechaVmto.
     * 
     */
    public void setFechaVmto(int value) {
        this.fechaVmto = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaGuia.
     * 
     */
    public int getFechaGuia() {
        return fechaGuia;
    }

    /**
     * Define el valor de la propiedad fechaGuia.
     * 
     */
    public void setFechaGuia(int value) {
        this.fechaGuia = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoFac.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoFac() {
        return estadoFac;
    }

    /**
     * Define el valor de la propiedad estadoFac.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoFac(String value) {
        this.estadoFac = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoPago.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoPago() {
        return estadoPago;
    }

    /**
     * Define el valor de la propiedad estadoPago.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoPago(String value) {
        this.estadoPago = value;
    }

    /**
     * Obtiene el valor de la propiedad detalle.
     * 
     * @return
     *     possible object is
     *     {@link SDTFacturaProducto.Detalle }
     *     
     */
    public SDTFacturaProducto.Detalle getDetalle() {
        return detalle;
    }

    /**
     * Define el valor de la propiedad detalle.
     * 
     * @param value
     *     allowed object is
     *     {@link SDTFacturaProducto.Detalle }
     *     
     */
    public void setDetalle(SDTFacturaProducto.Detalle value) {
        this.detalle = value;
    }


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
     *         &lt;element name="ProductoFactura" type="{Sistema_Abastcedora}SDTFacturaProducto.ProductoFactura" maxOccurs="unbounded" minOccurs="0"/>
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
        "productoFactura"
    })
    public static class Detalle {

        @XmlElement(name = "ProductoFactura")
        protected List<SDTFacturaProductoProductoFactura> productoFactura;

        /**
         * Gets the value of the productoFactura property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the productoFactura property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getProductoFactura().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SDTFacturaProductoProductoFactura }
         * 
         * 
         */
        public List<SDTFacturaProductoProductoFactura> getProductoFactura() {
            if (productoFactura == null) {
                productoFactura = new ArrayList<SDTFacturaProductoProductoFactura>();
            }
            return this.productoFactura;
        }

    }

}
