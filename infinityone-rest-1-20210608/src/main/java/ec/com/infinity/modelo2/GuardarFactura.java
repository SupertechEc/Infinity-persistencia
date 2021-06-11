/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.modelo2;

import ec.com.infinity.consultaFacturas.SDTFacturaProductoProductoFactura;
import ec.com.infinity.modelo.Consultafacturaunica;
import java.util.List;

/**
 *
 * @author Paul
 */
public class GuardarFactura {

    private Consultafacturaunica guardado;
    private List<SDTFacturaProductoProductoFactura> lstProducto;

    /**
     * @return the guardado
     */
    public Consultafacturaunica getGuardado() {
        return guardado;
    }

    /**
     * @param guardado the guardado to set
     */
    public void setGuardado(Consultafacturaunica guardado) {
        this.guardado = guardado;
    }

    /**
     * @return the lstProducto
     */
    public List<SDTFacturaProductoProductoFactura> getLstProducto() {
        return lstProducto;
    }

    /**
     * @param lstProducto the lstProducto to set
     */
    public void setLstProducto(List<SDTFacturaProductoProductoFactura> lstProducto) {
        this.lstProducto = lstProducto;
    }

}
