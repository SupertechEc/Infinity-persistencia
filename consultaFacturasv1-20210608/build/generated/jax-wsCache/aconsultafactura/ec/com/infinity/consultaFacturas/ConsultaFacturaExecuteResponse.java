
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
 *         &lt;element name="Facturas" type="{Sistema_Abastcedora}ArrayOfSDTFacturaProducto"/>
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
    "facturas"
})
@XmlRootElement(name = "ConsultaFactura.ExecuteResponse")
public class ConsultaFacturaExecuteResponse {

    @XmlElement(name = "Facturas", required = true)
    protected ArrayOfSDTFacturaProducto facturas;

    /**
     * Obtiene el valor de la propiedad facturas.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSDTFacturaProducto }
     *     
     */
    public ArrayOfSDTFacturaProducto getFacturas() {
        return facturas;
    }

    /**
     * Define el valor de la propiedad facturas.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSDTFacturaProducto }
     *     
     */
    public void setFacturas(ArrayOfSDTFacturaProducto value) {
        this.facturas = value;
    }

}
