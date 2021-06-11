/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinityone.rest.servicios.service;

import java.text.SimpleDateFormat;
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
 * @author Fernando Tapia
 */
public class GeneradorClaveAccesoSRI {

public static String crearClaveAcceso(Date fecha, String establecimiento, String puntoEmision, String secuencial, String ruc, String ambiente, String tipoDocumento) {
        String claveAcceso = "";
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        StringBuilder sb = new StringBuilder();
        sb.append(sdf.format(fecha));
        sb.append(tipoDocumento);
        sb.append(ruc);
        sb.append(ambiente);
        sb.append(establecimiento);
        sb.append(puntoEmision);
        sb.append(generarSecuencial(secuencial));
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
