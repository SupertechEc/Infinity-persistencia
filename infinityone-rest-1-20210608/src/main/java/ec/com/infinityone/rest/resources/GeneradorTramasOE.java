/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinityone.rest.resources;

import ec.com.infinity.modelo.Notapedido;
import ec.com.infinity.modelo2.EnvioPedidoREST;

/**
 *
 * @author Fernando Tapia
 */
public class GeneradorTramasOE {
    
    public String generarTramaEnvioOE(EnvioPedidoREST entidad, String numeroFactura, String clave){
       
    String trama = "";
        
    //WPE.CLAING	char(8)	"CLAVE COMERCIALIZADORA
    trama = trama+ String.format("%8s", clave).replace(' ','0');
    
    //WPE.COTIIN	char(3)	TIPO DE EMPRESA Y CÓDIGO c02
    trama = trama+ entidad.getNotapedido().getNotapedidoPK().getCodigocomercializadora().subSequence(2, 3);
    
    //WPE CODCOM	numeric(4.0)	CÓDIGO COMERCIALIZADORA
    trama = trama+ entidad.getNotapedido().getNotapedidoPK().getCodigocomercializadora();
    
    //WPE NUMFAC	numeric(8.0)	NÚMERO DE PEDIDO
    trama = trama+ entidad.getNotapedido().getNotapedidoPK().getNumero();
    
    //WPE CODDEP	numeric (2.0)	CÓDIGO DEL DEPÓSITO
    trama = trama+ entidad.getNotapedido().getCodigoterminal();
           
    // PENDIENTE //WPE FECFAC	numeric(8.0)	Fecha de pedido (yyyymmdd)
    // PENDIENTE//trama = trama+ String.format(entidad..getNotapedido().getFechaventa().toString().replace('-', '\b'));
    trama = trama+"20210618"; 
    
    //WPE IDECLI	numeric(8.0)	CÓDIGO DE CLIENTE.
    trama = trama+ entidad.getNotapedido().getCodigocliente();
               
    //WPE ARMERC	Numeric (2.0)	ÁREA DE MERCADEO
    trama = trama+ entidad.getDetalle().getDetallenotapedidoPK().getCodigoproducto().substring(0, 2);
                           
    //WPE CODPRO	Numeric (2.0)	CÓDIGO DEL PRODUCTO
    trama = trama+ entidad.getDetalle().getDetallenotapedidoPK().getCodigoproducto();
               
    //WPE UNIMED	Numeric (2.0)	MEDIDA
    trama = trama+ entidad.getDetalle().getMedida();
               
    //WPE UNIMON	Numeric (1.0)	MONEDA
    trama = trama+ "2";   
            
    //WPE VOLFAC	Numeric (9.2)	VOLUMEN DE NOTA DEPEDIDO  (000600000)
    trama = trama+ entidad.getDetalle().getVolumennaturalautorizado().toString();
            
    //WPE VOLNAT	Numeric (9.2)	VOLUMEN NATURAL
    trama = trama+ entidad.getDetalle().getVolumennaturalautorizado().toString();
    
    //WPE FACCNV	Numeric (6.5)	FACTOR DE CONVERSIÓN
    trama = trama+ "1";   
    
    //WPE_CODBCO	char(3)	CÓDIGO DE BANCO
    trama = trama+ "B"+entidad.getNotapedido().getCodigobanco();
            
    //WPE FL	char(25)	Espacios en blanco va con cero
    trama = trama+ String.format("%25s", "0").replace(' ','0');
        
    //WPE FACSRI	Numeric (13.0)	# FACTURA DE SRI
    trama = trama+ numeroFactura;
            
    //FL	char(22)	Espacio en blanco va con cero
    trama = trama+ String.format("%22s", "0").replace(' ','0');        
    return trama;   
    }
    
  
    
}
