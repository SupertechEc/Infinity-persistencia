/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package envionotapedido;

import ec.com.infinityone.envio.GeneracionOEAbasPrv;
import ec.com.infinityone.envio.GeneracionOEAbasPrvService;
import ec.com.infinityone.envio.GenerarOrdenEntrega;

/**
 *
 * @author Paul
 */
public class EnvioNotaPedido {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GeneracionOEAbasPrvService service = new GeneracionOEAbasPrvService();
        GeneracionOEAbasPrv port = service.getGeneracionOEAbasPrv();
        String arespuesta = port.generarOrdenEntrega("0000AAAAC020002141234560220200616020122680101012000678900000678900100000B35000000000000000000000000000100112345671000000000000000000000");
        System.out.println(arespuesta);
    }

}
