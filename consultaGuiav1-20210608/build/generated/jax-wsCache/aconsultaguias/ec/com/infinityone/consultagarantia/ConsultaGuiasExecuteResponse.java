
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
 *         &lt;element name="Guias" type="{Sistema_Abastcedora}ArrayOfSDTGuiasComercializadora"/>
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
    "guias"
})
@XmlRootElement(name = "ConsultaGuias.ExecuteResponse")
public class ConsultaGuiasExecuteResponse {

    @XmlElement(name = "Guias", required = true)
    protected ArrayOfSDTGuiasComercializadora guias;

    /**
     * Obtiene el valor de la propiedad guias.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSDTGuiasComercializadora }
     *     
     */
    public ArrayOfSDTGuiasComercializadora getGuias() {
        return guias;
    }

    /**
     * Define el valor de la propiedad guias.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSDTGuiasComercializadora }
     *     
     */
    public void setGuias(ArrayOfSDTGuiasComercializadora value) {
        this.guias = value;
    }

}
