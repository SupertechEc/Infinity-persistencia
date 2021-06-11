
package ec.com.infinity.consultaFacturas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para SDTFacturaProducto.ProductoFactura complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SDTFacturaProducto.ProductoFactura">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Area" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="CodProducto" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="CodMedida" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="Medida" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Producto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Volumen" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Precio" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Valor" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SDTFacturaProducto.ProductoFactura", propOrder = {
    "area",
    "codProducto",
    "codMedida",
    "medida",
    "producto",
    "volumen",
    "precio",
    "valor"
})
public class SDTFacturaProductoProductoFactura {

    @XmlElement(name = "Area")
    protected byte area;
    @XmlElement(name = "CodProducto")
    protected byte codProducto;
    @XmlElement(name = "CodMedida")
    protected byte codMedida;
    @XmlElement(name = "Medida", required = true)
    protected String medida;
    @XmlElement(name = "Producto", required = true)
    protected String producto;
    @XmlElement(name = "Volumen")
    protected double volumen;
    @XmlElement(name = "Precio")
    protected double precio;
    @XmlElement(name = "Valor")
    protected double valor;

    /**
     * Obtiene el valor de la propiedad area.
     * 
     */
    public byte getArea() {
        return area;
    }

    /**
     * Define el valor de la propiedad area.
     * 
     */
    public void setArea(byte value) {
        this.area = value;
    }

    /**
     * Obtiene el valor de la propiedad codProducto.
     * 
     */
    public byte getCodProducto() {
        return codProducto;
    }

    /**
     * Define el valor de la propiedad codProducto.
     * 
     */
    public void setCodProducto(byte value) {
        this.codProducto = value;
    }

    /**
     * Obtiene el valor de la propiedad codMedida.
     * 
     */
    public byte getCodMedida() {
        return codMedida;
    }

    /**
     * Define el valor de la propiedad codMedida.
     * 
     */
    public void setCodMedida(byte value) {
        this.codMedida = value;
    }

    /**
     * Obtiene el valor de la propiedad medida.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedida() {
        return medida;
    }

    /**
     * Define el valor de la propiedad medida.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedida(String value) {
        this.medida = value;
    }

    /**
     * Obtiene el valor de la propiedad producto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProducto() {
        return producto;
    }

    /**
     * Define el valor de la propiedad producto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProducto(String value) {
        this.producto = value;
    }

    /**
     * Obtiene el valor de la propiedad volumen.
     * 
     */
    public double getVolumen() {
        return volumen;
    }

    /**
     * Define el valor de la propiedad volumen.
     * 
     */
    public void setVolumen(double value) {
        this.volumen = value;
    }

    /**
     * Obtiene el valor de la propiedad precio.
     * 
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Define el valor de la propiedad precio.
     * 
     */
    public void setPrecio(double value) {
        this.precio = value;
    }

    /**
     * Obtiene el valor de la propiedad valor.
     * 
     */
    public double getValor() {
        return valor;
    }

    /**
     * Define el valor de la propiedad valor.
     * 
     */
    public void setValor(double value) {
        this.valor = value;
    }

}
