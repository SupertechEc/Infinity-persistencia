/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.soap;

/**
 *
 * @author Paul
 */
import ec.com.infinity.modelo.Notapedido;
import ec.com.infinity.modelo.NotapedidoPK;
import ec.com.infinityone.envio.GeneracionOEAbasPrv;
import ec.com.infinityone.envio.GeneracionOEAbasPrvService;
import ec.com.infinityone.rest.servicios.service.NotapedidoFacadeREST;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class ReenvioPedido {

    @EJB
    private NotapedidoFacadeREST servicio;

    @WebMethod
    public String reenvio(String cadena) {
        System.out.println("INCIA reenvio: "+cadena);
        Procedimientos proces = new Procedimientos();

        NotapedidoPK busqueda = proces.recorrer(cadena);
        System.out.println("TERMINA busqueda: "+busqueda.getCodigocomercializadora()+" num: "+busqueda.getNumero());
        @SuppressWarnings("UnusedAssignment")
        Notapedido agregar = null;
        agregar = servicio.findOtro(busqueda);
        
        if (agregar == null) {
            System.out.println("TERMINA findOtro NO ENCONTRÓ NP:" );
            System.out.println("RETORNO CON NO ENCUENTRA armaNoEncuentra+CADENA:"+ cadena );
            return proces.armaNoEncuentra(cadena);
        } else {
            System.out.println("TERMINA findOtro SI ENCONTRÓ NP LA VA A RE-ENVIAR:" );
            Notapedido respuesta = agregar;
            GeneracionOEAbasPrvService service = new GeneracionOEAbasPrvService();
            GeneracionOEAbasPrv port = service.getGeneracionOEAbasPrv();
            String arespuesta = port.generarOrdenEntrega(respuesta.getTramaenviadagoe());
                        System.out.println("TERMINA  RE-ENVIO NP:" +arespuesta );
            respuesta.setRespuestageneracionoeepp(arespuesta.substring(0, 2));//2 primeros caracteres
            respuesta.setTramarecibidagoe(arespuesta);
            servicio.edit(respuesta);
                        System.out.println("TERMINA ACTUALIZACION DE NP EN BDD CON RESPUESTA DE EPP:" );
                                    System.out.println("RETORNO CON armaEncuentra+CADENA:"+ cadena );
            return proces.armaEncuentra(cadena);
        }
    }
}
