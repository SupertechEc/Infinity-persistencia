/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinityone.rest.resources;

import ec.com.infinity.modelo.Notapedido;
import ec.com.infinity.modelo2.EnvioPedidoREST;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Fernando Tapia
 */
public class GeneradorTramasOE {
    
    public String generarTramaEnvioOE(EnvioPedidoREST entidad, String nfactura, String clave){
    System.out.println("ENTRA en generarTramaEnvioOE: "+nfactura + " " + clave);
    String trama = "";
    System.out.println("1- generarTramaEnvioOE trama: "+trama);    
    //WPE.CLAING	char(8)	"CLAVE COMERCIALIZADORA
    trama = trama+ String.format("%8s", clave).replace(' ','0');
    System.out.println("2- generarTramaEnvioOE trama: "+trama);    
    //WPE.COTIIN	char(3)	TIPO DE EMPRESA Y CÓDIGO c02
    trama = trama+ "C"+entidad.getNotapedido().getNotapedidoPK().getCodigocomercializadora().substring(2, 4);
    System.out.println("3- generarTramaEnvioOE trama: "+trama);    
    //WPE CODCOM	numeric(4.0)	CÓDIGO COMERCIALIZADORA
    trama = trama+ entidad.getNotapedido().getNotapedidoPK().getCodigocomercializadora();
    System.out.println("4- generarTramaEnvioOE trama: "+trama);    
    //WPE NUMFAC	numeric(8.0)	NÚMERO DE PEDIDO
    trama = trama+ entidad.getNotapedido().getNotapedidoPK().getNumero();
    System.out.println("5- generarTramaEnvioOE trama: "+trama);    
    //WPE CODDEP	numeric (2.0)	CÓDIGO DEL DEPÓSITO
    trama = trama+ entidad.getNotapedido().getCodigoterminal().getCodigo();
    System.out.println("6- generarTramaEnvioOE trama: "+trama);
    
    //WPE FECFAC numeric(8.0)
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    StringBuilder sb = new StringBuilder();
    String f = sdf.format(entidad.getNotapedido().getFechaventa());
    trama = trama + f;
    System.out.println("7- generarTramaEnvioOE trama: "+trama);    
    
    //WPE IDECLI	numeric(8.0)	CÓDIGO DE CLIENTE.
    trama = trama+ entidad.getNotapedido().getCodigocliente().getCodigo();
    System.out.println("8- generarTramaEnvioOE trama: "+trama);    
    //WPE ARMERC	Numeric (2.0)	ÁREA DE MERCADEO
    //trama = trama+ entidad.getDetalle().getDetallenotapedidoPK().getCodigoproducto().substring(0, 2);
    System.out.println("9- generarTramaEnvioOE trama: "+trama);    
    //WPE CODPRO	Numeric (2.0)	CÓDIGO DEL PRODUCTO
    trama = trama+ entidad.getDetalle().getDetallenotapedidoPK().getCodigoproducto();
    System.out.println("10- generarTramaEnvioOE trama: "+trama);    
    //WPE UNIMED	Numeric (2.0)	MEDIDA
    trama = trama+ entidad.getDetalle().getMedida().getCodigo();
               System.out.println("11- generarTramaEnvioOE trama: "+trama);    
    //WPE UNIMON	Numeric (1.0)	MONEDA
    trama = trama+ "2";   
    //WPE VOLFAC	Numeric (9.2) -(7 ENTEROS Y 2 DECIMALES)	VOLUMEN DE NOTA DEPEDIDO  (000600000)
    //trama = trama+ entidad.getDetalle().getVolumennaturalautorizado().toString();
    DecimalFormat myFormatter = new DecimalFormat("0000000.00");
    String output = myFormatter.format(entidad.getDetalle().getVolumennaturalautorizado());
    String dato = output.substring(0, 7) + output.substring(8, 10); 
    System.out.println("12- generarTramaEnvioOE trama : "+entidad.getDetalle().getVolumennaturalautorizado().toPlainString() + " - "+ entidad.getDetalle().getVolumennaturalautorizado().toString() + " - " +output + " -- "+ dato);    
    System.out.println("12- generarTramaEnvioOE trama : "+trama);    
    //WPE VOLNAT	Numeric (9.2)	VOLUMEN NATURAL
    trama = trama+ dato+dato;
    System.out.println("13- generarTramaEnvioOE trama: "+trama);    
    //WPE FACCNV	Numeric (6.5)	FACTOR DE CONVERSIÓN
    trama = trama+ "100000";   
    System.out.println("14- generarTramaEnvioOE trama: "+trama);     
    //WPE_CODBCO	char(3)	CÓDIGO DE BANCO
    trama = trama+ "B"+entidad.getNotapedido().getCodigobanco().getCodigo();
            System.out.println("15- generarTramaEnvioOE trama: "+trama);    
    //WPE FL	char(25)	Espacios en blanco va con cero
    trama = trama+ String.format("%25s", "0").replace(' ','0');
        System.out.println("16- generarTramaEnvioOE trama: "+trama);    
    //WPE FACSRI	Numeric (13.0)	# FACTURA DE SRI
    trama = trama+ nfactura;  
            System.out.println("17- generarTramaEnvioOE trama: "+trama);    
    //FL	char(22)	Espacio en blanco va con cero
    trama = trama+ String.format("%22s", "0").replace(' ','0');    
    System.out.println("18- generarTramaEnvioOE trama: "+trama);    
    return trama;   
    }
       
  
    
}
