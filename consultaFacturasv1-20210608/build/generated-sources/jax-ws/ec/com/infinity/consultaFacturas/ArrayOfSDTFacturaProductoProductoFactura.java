
package ec.com.infinity.consultaFacturas;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfSDTFacturaProducto.ProductoFactura complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfSDTFacturaProducto.ProductoFactura">
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
@XmlType(name = "ArrayOfSDTFacturaProducto.ProductoFactura", propOrder = {
    "productoFactura"
})
public class ArrayOfSDTFacturaProductoProductoFactura {

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
