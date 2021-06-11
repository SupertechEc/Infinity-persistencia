/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultagarantiav1;

import ec.com.infinityone.consultagarantia.*;

/**
 *
 * @author Paul
 */
public class ConsultaGarantiav1 {

    public static ConsultaGarantiaExecute paramWS = new ConsultaGarantiaExecute();
    public static ConsultaGarantiaExecuteResponse respuesta;
    public static short codcom = 2;

    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hola mundo");
        paramWS.setCgccodcom(codcom);
        paramWS.setClave("1234");
        System.out.println("llamando al ws");
        respuesta = execute(paramWS);
        System.out.println("respuesta del ws");
        System.out.println(respuesta.getGarantia().getCGCCODCOM());
        System.out.println(respuesta.getGarantia().getCGCComercializadora());
        System.out.println(respuesta.getGarantia().getCGCSALDO());
        System.out.println(respuesta.getGarantia().getCGCSUMAVA());
        System.out.println(respuesta.getGarantia().getCGCUNIMON());
        System.out.println(respuesta.getGarantia().getCGCVALCOM());
        System.out.println(respuesta.getGarantia().getGarantia98());
        System.out.println(respuesta.getGarantia().getPorcentajeUso());
        System.out.println(respuesta.getGarantia().getSaldoDisponible());
    }

    private static ConsultaGarantiaExecuteResponse execute(ConsultaGarantiaExecute parameters) {
        ConsultaGarantia service = new ConsultaGarantia();
        ConsultaGarantiaSoapPort port = service.getConsultaGarantiaSoapPort();
        return port.execute(parameters);
    }
}
