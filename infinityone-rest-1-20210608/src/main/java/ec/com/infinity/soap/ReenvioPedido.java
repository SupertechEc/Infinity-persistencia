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
        Procedimientos proces = new Procedimientos();

        NotapedidoPK busqueda = proces.recorrer(cadena);
        @SuppressWarnings("UnusedAssignment")
        Notapedido agregar = null;
        agregar = servicio.findOtro(busqueda);
        if (agregar == null) {
            return proces.armaNoEncuentra(cadena);
        } else {
            Notapedido respuesta = agregar;
            GeneracionOEAbasPrvService service = new GeneracionOEAbasPrvService();
            GeneracionOEAbasPrv port = service.getGeneracionOEAbasPrv();
            String arespuesta = port.generarOrdenEntrega(respuesta.getTramaenviadagoe());
            respuesta.setRespuestageneracionoeepp(arespuesta.substring(0, 1));//2 primeros caracteres
            respuesta.setTramarecibidagoe(arespuesta);
            servicio.edit(respuesta);
            return proces.armaEncuentra(cadena);
        }
    }
}
