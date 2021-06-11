/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultafacturasv1;

import ec.com.infinity.consultaFacturas.ConsultaFactura;
import ec.com.infinity.consultaFacturas.ConsultaFacturaExecute;
import ec.com.infinity.consultaFacturas.ConsultaFacturaExecuteResponse;
import ec.com.infinity.consultaFacturas.ConsultaFacturaSoapPort;
import ec.com.infinity.consultaFacturas.SDTFacturaProducto;
import ec.com.infinity.consultaFacturas.SDTFacturaProductoProductoFactura;

/**
 *
 * @author Paul
 */
public class ConsultaFacturasv1 {

    public static ConsultaFacturaExecute paramWS = new ConsultaFacturaExecute();
    public static ConsultaFacturaExecuteResponse respuesta;
    public static short codcom = 2;

    public static void main(String[] args) {
        System.out.println("Hola mundo");
        paramWS.setFaucodcom(codcom);
        paramWS.setClave("1234");
        paramWS.setFaufecven(20210401);
        System.out.println("llamando al ws");
        respuesta = execute(paramWS);
        System.out.println("respuesta del ws");
        for (SDTFacturaProducto tmp : respuesta.getFacturas().getSDTFacturaProducto()) {
            System.out.println("PRODUCTO FACTURA INICIA");
            System.out.println("" + tmp.getEstadoFac());
            System.out.println("" + tmp.getEstadoPago());
            System.out.println("" + tmp.getBanco());

            for (SDTFacturaProductoProductoFactura tmp1 : tmp.getDetalle().getProductoFactura()) {
                System.out.println("\t" + tmp1.getMedida());
                System.out.println("\t" + tmp1.getProducto());
                System.out.println("\t" + tmp1.getArea());
                System.out.println("\t" + tmp1.getCodMedida());
                System.out.println("\t" + tmp1.getCodProducto());
                System.out.println("\t" + tmp1.getPrecio());
                System.out.println("\t" + tmp1.getValor());
                System.out.println("\t" + tmp1.getVolumen());
                System.out.println("-----");
            }

            System.out.println("" + tmp.getFechaEmi());
            System.out.println("" + tmp.getFechaGuia());
            System.out.println("" + tmp.getFechaVmto());
            System.out.println("" + tmp.getNumFactura());
            System.out.println("" + tmp.getNumSRI());

            System.out.println("PRODUCTO FACTURA TERMINA");
        }

    }

    private static ConsultaFacturaExecuteResponse execute(ConsultaFacturaExecute parameters) {
        ConsultaFactura service = new ConsultaFactura();
        ConsultaFacturaSoapPort port = service.getConsultaFacturaSoapPort();
        return port.execute(parameters);
    }
}
