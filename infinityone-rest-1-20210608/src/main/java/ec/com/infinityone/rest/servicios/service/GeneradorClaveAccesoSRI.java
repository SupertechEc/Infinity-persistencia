/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinityone.rest.servicios.service;

import java.text.SimpleDateFormat;
import static java.time.Clock.system;
import java.util.Date;

/**
     * Method for generate clave de acceso SRI
     *
     * @param fecha Fecha Transaccion
     * @param establecimiento No. de establecimiento del RUC
     * @param puntoEmision Punto de emisión del documento
     * @param secuencial No. de factura
     * @param ruc No. de RUC del establecimiento
     * @param ambiente Ambiente del SRI
     * @param tipoDocumento Tipo de documento (01 Factura, 04 NC, 05 ND, 07 Retenciones)
     * @return Clave de Acceso generada
     */


/**
 *
 *
 */
public class GeneradorClaveAccesoSRI {

public static String crearClaveAcceso(Date fecha, String establecimiento, String puntoEmision, String secuencial, String ruc, String ambiente, String tipoDocumento) {
                System.out.println("parame fec:"+ fecha.toString());
                System.out.println("parame esta:"+ establecimiento);
                System.out.println("parame emisi:"+ puntoEmision);
                System.out.println("parame secu:"+ secuencial);
                System.out.println("parame ruc:"+ ruc);
                System.out.println("parame ambi:"+ ambiente);
                System.out.println("parame tipoDocumento:"+ tipoDocumento);
       
        String claveAcceso = "";
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        StringBuilder sb = new StringBuilder();
        sb.append(sdf.format(fecha));
        System.out.println("Fecha:"+ sdf.format(fecha));
        sb.append(tipoDocumento);
        System.out.println("Documento:" + tipoDocumento);
        sb.append(ruc);
        System.out.println("Ruc:" + ruc);
        sb.append(ambiente);
        System.out.println("Ambiente:" + ambiente);
        sb.append(establecimiento);
        System.out.println("Establecimiento:" + establecimiento);
        sb.append(puntoEmision);
        System.out.println("PuntoEmision:" + puntoEmision);
        sb.append(generarSecuencial(secuencial));
        System.out.println("Secuecnial:" + generarSecuencial(secuencial));
        sb.append("000009991");
        claveAcceso = sb.toString();
        return claveAcceso + obtenerDigitoVerificadorModuloOnce(claveAcceso);
    }
    /**
     * Method for convert to format Secuencial 999999999
     *
     * @param sec No. de Factura
     * @return No. de factura en formato 999999999
     */
    public static String generarSecuencial(String sec) {
        String secuencial = sec;
        String aux = "0";
        for (int i = secuencial.length(); i < 9; i++) {
            secuencial = aux + secuencial;
        }
        return secuencial;
    }

    /**
     * Method for calculate verificator digit
     *
     * @param array Codes for positions; calculate digit verificator
     * @return No. con el digito verificador SRI
     */
    private static String obtenerDigitoVerificadorModuloOnce(String array) {
        System.out.println("Entrado:" + array);
        int a = 2;
        int rutSumado = 0;
        int mulDig = 1;
        char[] arrayC = invertir(array.toCharArray());
        for (int i = 0; i < array.length(); i++) {
            mulDig = Integer.parseInt(String.valueOf(arrayC[i])) * a;
            rutSumado += mulDig;
            if (a == 7) {
                a = 1;
            }
            a++;
        }

        int resto = rutSumado % 11;
        String Digito = String.valueOf(11 - resto);

        if (Digito.equals("11")) {
            Digito = "0";
        }

        if (Digito.equals("10")) {
            Digito = "1";
        }
        System.out.println("Saliendo:" + Digito);
        return Digito;
    }
    /**
     * Method for invert an array
     *
     * @param array Objet type array
     * @return Array inverted
     */
    private static char[] invertir(char[] array) {
        char[] invertir_int = new char[array.length];
        int maximo = array.length;
        for (int i = 0; i < array.length; i++) {
            char j = array[maximo - 1];
            invertir_int[maximo - 1] = array[i];
            maximo--;
        }
        return invertir_int;
    }



}
