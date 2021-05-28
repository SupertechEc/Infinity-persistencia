/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.soap;

import ec.com.infinity.modelo.NotapedidoPK;

/**
 *
 * @author Paul
 */
public class Procedimientos {

    public String armaEncuentra(String cadena) {
        String cabecera = "01";
        String codigoabastecedora = "0001";
//        String cadena = "32000202123456000000000000000000000000000";
        String banco = "";
        for (int x = 0; x <= 1; x++) {
            banco = banco + cadena.charAt(x);
        }
        String codigocomercializadora = "";
        for (int x = 2; x <= 5; x++) {
            codigocomercializadora = codigocomercializadora + cadena.charAt(x);
        }
        String numero = "";
        for (int x = 6; x <= 13; x++) {
            numero = numero + cadena.charAt(x);
        }
        return cabecera + banco + codigocomercializadora + numero + "00000000000000";
    }

    public String armaNoEncuentra(String cadena) {
        String cabecera = "00";
        String codigoabastecedora = "0001";
//        String cadena = "32000202123456000000000000000000000000000";
        String banco = "";
        for (int x = 0; x <= 1; x++) {
            banco = banco + cadena.charAt(x);
        }
        String codigocomercializadora = "";
        for (int x = 2; x <= 5; x++) {
            codigocomercializadora = codigocomercializadora + cadena.charAt(x);
        }
        String numero = "";
        for (int x = 6; x <= 13; x++) {
            numero = numero + cadena.charAt(x);
        }
        return cabecera + banco + codigocomercializadora + numero + "00000000000000";
    }

    public NotapedidoPK recorrer(String cadena) {

        String codigoabastecedora = "0001";
//        String cadena = "32000202123456000000000000000000000000000";
        String banco = "";
        for (int x = 0; x <= 1; x++) {
            banco = banco + cadena.charAt(x);
        }
        String codigocomercializadora = "";
        for (int x = 2; x <= 5; x++) {
            codigocomercializadora = codigocomercializadora + cadena.charAt(x);
        }
        String numero = "";
        for (int x = 6; x <= 13; x++) {
            numero = numero + cadena.charAt(x);
        }
        NotapedidoPK key = new NotapedidoPK();
        key.setCodigoabastecedora(codigoabastecedora);
        key.setCodigocomercializadora(codigocomercializadora);
        key.setNumero(numero);
        return key;
    }
}
