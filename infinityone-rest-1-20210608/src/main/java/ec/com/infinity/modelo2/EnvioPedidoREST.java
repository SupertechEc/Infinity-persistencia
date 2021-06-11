/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.modelo2;

import ec.com.infinity.modelo.Detallenotapedido;
import ec.com.infinity.modelo.Notapedido;

/**
 *
 * @author Paul
 */
public class EnvioPedidoREST {

    private Notapedido notapedido;
    private Detallenotapedido detalle;

    public EnvioPedidoREST() {
    }

    /**
     * @return the notapedido
     */
    public Notapedido getNotapedido() {
        return notapedido;
    }

    /**
     * @param notapedido the notapedido to set
     */
    public void setNotapedido(Notapedido notapedido) {
        this.notapedido = notapedido;
    }

    /**
     * @return the detalle
     */
    public Detallenotapedido getDetalle() {
        return detalle;
    }

    /**
     * @param detalle the detalle to set
     */
    public void setDetalle(Detallenotapedido detalle) {
        this.detalle = detalle;
    }
}
