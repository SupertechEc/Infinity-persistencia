/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.modelo2;

import ec.com.infinity.modelo.Detallefactura;
import ec.com.infinity.modelo.Factura;
import java.util.List;
/**
 *
 * @author Paul
 */
public class EnvioFacturaREST {

    private Factura factura;
    private List<Detallefactura> detalle;

    public EnvioFacturaREST() {
    }

    /**
     * @return the factura
     */
    public Factura getFactura() {
        return factura;
    }

    /**
     * @param factura the factura to set
     */
    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    /**
     * @return the detalle
     */
    public List<Detallefactura> getDetalle() {
        return detalle;
    }

    /**
     * @param detalle the detalle to set
     */
    public void setDetalle(List<Detallefactura>  detalle) {
        this.detalle = detalle;
    }

}
