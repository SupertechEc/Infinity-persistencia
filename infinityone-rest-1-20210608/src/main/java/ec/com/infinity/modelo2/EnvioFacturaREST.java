/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.modelo2;

import ec.com.infinity.modelo.Detallefactura;
import ec.com.infinity.modelo.Factura;

/**
 *
 * @author Paul
 */
public class EnvioFacturaREST {

    private Factura factura;
    private Detallefactura detalle;

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
    public Detallefactura getDetalle() {
        return detalle;
    }

    /**
     * @param detalle the detalle to set
     */
    public void setDetalle(Detallefactura detalle) {
        this.detalle = detalle;
    }

}
