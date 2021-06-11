/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinityone.consulta;

import ec.com.infinityone.anulacion.AnulacionOEAbasPrv;
import ec.com.infinityone.anulacion.AnulacionOEAbasPrvService;

/**
 *
 * @author Paul
 */
public class AnulacionNotaPedido {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AnulacionOEAbasPrvService service = new AnulacionOEAbasPrvService();
        AnulacionOEAbasPrv port = service.getAnulacionOEAbasPrv();
        String arespuesta = port.anularOrdenEntrega("B350002141234560000AAA000000000000000000");
        System.out.println(arespuesta);
    }
}
