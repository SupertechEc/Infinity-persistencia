/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultaguiav1;

import ec.com.infinityone.consultagarantia.ArrayOfSDTGuiasComercializadora;
import ec.com.infinityone.consultagarantia.ConsultaGuias;
import ec.com.infinityone.consultagarantia.ConsultaGuiasExecute;
import ec.com.infinityone.consultagarantia.ConsultaGuiasExecuteResponse;
import ec.com.infinityone.consultagarantia.ConsultaGuiasSoapPort;
import ec.com.infinityone.consultagarantia.SDTGuiasComercializadora;

/**
 *
 * @author Paul
 */
public class ConsultaGuiav1 {

    public static Integer codcom = 2;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ConsultaGuias service = new ConsultaGuias();
        ConsultaGuiasSoapPort port = service.getConsultaGuiasSoapPort();
        ConsultaGuiasExecute paramWs = new ConsultaGuiasExecute();
        ConsultaGuiasExecuteResponse respuesta;
        //paramWs.setCbtcodcom(codcom);
        paramWs.setCbtcodcom(new Short("2"));
        paramWs.setClave("12345678");
        paramWs.setCbtfecemi(20210401);
        paramWs.setCbtcoddep(new Byte("02"));

        respuesta = port.execute(paramWs);
        for (SDTGuiasComercializadora tmp : respuesta.getGuias().getSDTGuiasComercializadora()) {
            System.out.println("CODIGOCOMERCIALIZADORA " + tmp.getCBTCODCOM());
            System.out.println("Numero " + tmp.getCBTNUMCBT());
            System.out.println("NUMEROOE " + tmp.getCBTNUMORE());
            System.out.println("FECHA " + tmp.getCBTFECEMI());
        }
    }
}
