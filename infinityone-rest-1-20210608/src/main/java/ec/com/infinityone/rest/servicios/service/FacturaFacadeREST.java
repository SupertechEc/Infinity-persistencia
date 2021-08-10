/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinityone.rest.servicios.service;


import org.primefaces.shaded.json.JSONArray;
import org.primefaces.shaded.json.JSONObject;
import ec.com.infinity.modelo.Cliente;
import ec.com.infinity.modelo.Detallefactura;
import ec.com.infinity.modelo.Detallenotapedido;
import ec.com.infinity.modelo.DetallenotapedidoPK;
import ec.com.infinity.modelo.Factura;
import ec.com.infinity.modelo.FacturaPK;
import ec.com.infinity.modelo.MejorCliente;
import ec.com.infinity.modelo.Notapedido;
import ec.com.infinity.modelo.NotapedidoPK;
import ec.com.infinity.modelo.Numeracion;
import ec.com.infinity.modelo2.EnvioFacturaREST;
import ec.com.infinity.modelo2.EnvioPedidoREST;
import ec.com.infinity.rest.seguridad.EjecucionMensaje;
import ec.com.infinity.rest.seguridad.ErrorMessage;
import ec.com.infinity.rest.seguridad.Secured;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.text.NumberFormatter;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;
import javax.ws.rs.QueryParam;
import com.google.gson.Gson;
import ec.com.infinity.modelo.DetallefacturaPK;
import ec.com.infinity.modelo.Detalleprecio;
import ec.com.infinity.modelo.DetalleprecioPK;
import ec.com.infinity.modelo.Medida;
import ec.com.infinity.modelo.Precio;
import ec.com.infinity.modelo.PrecioPK;
import java.math.RoundingMode;

/**
 *
 * @author Paul
 */
@Stateless
@Path("ec.com.infinity.modelo.factura")
public class FacturaFacadeREST extends AbstractFacade<Factura> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @EJB
    private NumeracionFacadeREST servicioNumeracion;

    @EJB
    private DetallefacturaFacadeREST servicioDetalleFact;
    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager bloqueo;
    /*
    Variable precio
     */
    private Precio precio;
    /*
    Variable PrecioPk
     */
    private PrecioPK precioPK;
    /*
    Variable Detalleprecio
     */
    private Detalleprecio detallePrecio;
    /*
    Variable DetalleprecioPK
     */
    private DetalleprecioPK detallePrecioPK;
    
    private FacturaPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;codigoabastecedora=codigoabastecedoraValue;codigocomercializadora=codigocomercializadoraValue;numeronotapedido=numeronotapedidoValue;numero=numeroValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        ec.com.infinity.modelo.FacturaPK key = new ec.com.infinity.modelo.FacturaPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> codigoabastecedora = map.get("codigoabastecedora");
        if (codigoabastecedora != null && !codigoabastecedora.isEmpty()) {
            key.setCodigoabastecedora(codigoabastecedora.get(0));
        }
        java.util.List<String> codigocomercializadora = map.get("codigocomercializadora");
        if (codigocomercializadora != null && !codigocomercializadora.isEmpty()) {
            key.setCodigocomercializadora(codigocomercializadora.get(0));
        }
        java.util.List<String> numeronotapedido = map.get("numeronotapedido");
        if (numeronotapedido != null && !numeronotapedido.isEmpty()) {
            key.setNumeronotapedido(numeronotapedido.get(0));
        }
        java.util.List<String> numero = map.get("numero");
        if (numero != null && !numero.isEmpty()) {
            key.setNumero(numero.get(0));
        }
        return key;
    }

    public FacturaFacadeREST() {
        super(Factura.class);
    }

    @Override
    public Factura create(Factura entity) {
        return super.create(entity);
    }

    @Override
    public List<Factura> findAll() {
        return super.findAll();
    }

    @Override
    public Factura edit(Factura entity) {
        super.edit(entity);
        return entity;
    }

    @PUT
    @Path("/crear")
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public boolean createCrear(EnvioFacturaREST entity) {
        
        boolean respuesta = false;
        
        if (entity == null){
        System.out.println("FACTURAFACADEREST::create1: esta nullo");
         return respuesta;
        }
        else{
                System.out.println("FACTURAFACADEREST::create1: NOOOOO nullo");
                
                
                
        }
     
        String tipodocumento = "fct";
        
        System.out.println("FACTURAFACADEREST::create1: +entity.getClass()");
        
                
        try {
            //System.out.println("FACTURAFACADEREST::create1: "+entity.toString());
                        
            Numeracion respuestaNumeracion = getServicioNumeracion().consulta(tipodocumento, entity.getFactura().getFacturaPK().getCodigocomercializadora());
            
            bloqueo.lock(respuestaNumeracion, LockModeType.PESSIMISTIC_WRITE);
            int numeracion = respuestaNumeracion.getUltimonumero() + 1;
             
            DecimalFormat df = new DecimalFormat("000000000");
            String numeroFactura = (df.format(new BigDecimal(numeracion)));
            entity.getFactura().getFacturaPK().setNumero( entity.getFactura().getSeriesri()+ numeroFactura);
            
            entity.getFactura().setClaveacceso(GeneradorClaveAccesoSRI.crearClaveAcceso(
                    entity.getFactura().getFechaventa(), 
                    entity.getFactura().getFacturaPK().getNumero().substring(0, 3),
                    entity.getFactura().getFacturaPK().getNumero().substring(3, 6),
                    entity.getFactura().getFacturaPK().getNumero().substring(6, 15),
                    entity.getFactura().getRuccomercializadora(),
                    String.valueOf(entity.getFactura().getAmbientesri()),
                    String.valueOf(entity.getFactura().getCodigodocumento()))); 
                    
            System.out.println("fecha: "+entity.getFactura().getFechaventa());
                    //entity.getFactura().getRucComercializadora
                    //entity.getFactura().getAmbienteSri()
                    //entity.getFactura().getCodigoDocumento()
            super.createS(entity.getFactura());

            // iterar la lista y grabar lista de DETALLES DE FACTURA
            
            List<Detallefactura> listafacturaDetalle = new ArrayList<>();
            Detallefactura facturaDetalle = new Detallefactura();
            listafacturaDetalle = entity.getDetalle();
            for(int i = 0; i < listafacturaDetalle.size(); i++){
                listafacturaDetalle.get(i).getDetallefacturaPK().setCodigoabastecedora(entity.getFactura().getFacturaPK().getCodigoabastecedora());
                listafacturaDetalle.get(i).getDetallefacturaPK().setCodigocomercializadora(entity.getFactura().getFacturaPK().getCodigocomercializadora());
                listafacturaDetalle.get(i).getDetallefacturaPK().setNumero(entity.getFactura().getFacturaPK().getNumero());
                listafacturaDetalle.get(i).getDetallefacturaPK().setNumeronotapedido(entity.getFactura().getFacturaPK().getNumeronotapedido());
            }
            for(Detallefactura det: listafacturaDetalle){
                 servicioDetalleFact.createS(det);
            }
            /*facturaDetalle = entity.getDetalle();
            facturaDetalle.getDetallefacturaPK().setCodigoabastecedora(entity.getFactura().getFacturaPK().getCodigoabastecedora());
            facturaDetalle.getDetallefacturaPK().setCodigocomercializadora(entity.getFactura().getFacturaPK().getCodigocomercializadora());
            facturaDetalle.getDetallefacturaPK().setNumero(entity.getFactura().getFacturaPK().getNumero());
            facturaDetalle.getDetallefacturaPK().setNumeronotapedido(entity.getFactura().getFacturaPK().getNumeronotapedido());
            servicioDetalleFact.createS(facturaDetalle);*/            
            //listafacturaDetalle.add(facturaDetalle);
            /*for(Detallefactura det: listafacturaDetalle){
                 servicioDetalleFact.createS(det);
            }*/
            // iterar la lista y grabar lista de DETALLES DE FACTURA
            
            
            respuestaNumeracion.setUltimonumero(numeracion);
            getServicioNumeracion().edit(respuestaNumeracion);
            //bloqueo.getTransaction().commit();
            //bloqueo.close();

//            EjecucionMensaje succesMessage = new EjecucionMensaje();
//            succesMessage.setStatusCode(200);
//            succesMessage.setDeveloperMessage(entity.getFactura().getFacturaPK().getNumero());
//                        
//            return Response.status(200)
//                    .entity(succesMessage)
//                    .type(MediaType.APPLICATION_JSON).
//                    build();

            //return JAXRSUtils.fromResponse(ex.getResponse()).entity(errorMessage).build();
         respuesta = true;
        } catch (WebApplicationException ex) {
            System.out.println("INCIO FACTURAFACADEREST::create1- WebApplicationException: "+ex.getMessage());
            ex.printStackTrace(System.out);
            System.out.println("FIN FACTURAFACADEREST::create1- WebApplicationException: "+ex.getMessage());
//            Response exResponse = ex.getResponse();
//            ErrorMessage errorMessage = new ErrorMessage(exResponse.getStatus(), ex.getMessage());
//            //return JAXRSUtils.fromResponse(ex.getResponse()).entity(errorMessage).build();
//            return Response.status(ex.getResponse().getStatus())
//                    .entity(errorMessage)
//                    .type(MediaType.APPLICATION_JSON).
//                    build();
        }
        return respuesta;
    }
    
    
    @PUT
    @Path("/crearF")
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response createF(@QueryParam("codigoabastecedora") String codigoabastecedora, 
            @QueryParam("codigocomercializadora") String codigocomercializadora,
            @QueryParam("numeronotapedido") String numeronotapedido,
            @QueryParam("numero") String numero) {
         List<EnvioFacturaREST> lst = new ArrayList<>();
         precio = new Precio();
        precioPK = new PrecioPK();
        detallePrecio = new Detalleprecio();
        detallePrecioPK = new DetalleprecioPK();
        try{
  
            boolean res = false;
            EnvioPedidoREST objeto = new EnvioPedidoREST();
            EnvioFacturaREST factura = new EnvioFacturaREST();
            
            
            objeto = buscarNP(codigoabastecedora, codigocomercializadora, numeronotapedido, numero);
           // System.out.println("FT::createF::buscarNP "+objeto.getNotapedido().getNotapedidoPK().getNumero());
            
            factura = generarFactura(objeto);
            //System.out.println("FT::createF::generarFactura "+factura.getDetalle().get(0).getPrecioproducto());
            
            Detallefactura unDetalleFac= factura.getDetalle().get(0);
            factura = actionFactura(factura.getFactura(), objeto,unDetalleFac , unDetalleFac.getCodigoprecio(), factura);
            
            res = createCrear(factura);
            //System.out.println("createCrear(factura):: "+ res);
            lst.add(factura);
            //addItems(factura);
                        
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("SOLO CON PARAMETROS");
            succesMessage.setRetorno(lst);
            return Response.status(200)
                    .entity(succesMessage)
                    .type(MediaType.APPLICATION_JSON).
                    build();
        }catch(Throwable t){
            System.out.println("FT:: Throwable capturada: "+t.getMessage());
            t.printStackTrace(System.out);
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("SOLO CON PARAMETROS");
            succesMessage.setRetorno(lst);
            return Response.status(200)
                    .entity(succesMessage)
                    .type(MediaType.APPLICATION_JSON).
                    build();
        }
    }
    
    public EnvioPedidoREST buscarNP(String codigoabastecedora, String codigocomercializadora, String numeronotapedido, String numero){
        
        EnvioPedidoREST pedido = new EnvioPedidoREST();
        Notapedido unaNP = new Notapedido();
        NotapedidoPK unaNPPk = new NotapedidoPK();
        Detallenotapedido unDetNP = new Detallenotapedido();
        DetallenotapedidoPK unDetNPPK = new DetallenotapedidoPK();
        List<Notapedido> lst = new ArrayList<>();
        List<Detallenotapedido> lstD = new ArrayList<>();
        try{
            TypedQuery<Notapedido> consultaNP = em.createNamedQuery("Notapedido.findByNumero", Notapedido.class);
            consultaNP.setParameter("numero", numeronotapedido);
            lst = consultaNP.getResultList();
            if (lst.isEmpty()){
                  throw new Throwable("No se ha encontrado la NP para Facturar: "
                        +codigoabastecedora + " " + codigocomercializadora + " " + numeronotapedido + " " + numero);
            }else{
                unaNP = (Notapedido)lst.get(0);
            }
            
            TypedQuery<Detallenotapedido> consultaDNP = em.createNamedQuery("Detallenotapedido.findByNumero", Detallenotapedido.class);
            consultaDNP.setParameter("numero", numeronotapedido);
            lstD = consultaDNP.getResultList();
            if (lstD.isEmpty()){
                throw new Throwable("No se ha encontrado el Detalle de la Nota de Pedido para Facturar: "
                        +codigoabastecedora + " " + codigocomercializadora + " " + numeronotapedido + " " + numero);
            }else{
                unDetNP = (Detallenotapedido)lstD.get(0);
            }
            
            pedido.setNotapedido(unaNP);
            pedido.setDetalle(unDetNP);
            
        }catch(Throwable t){
            System.out.println("Throwable capturada: "+this.toString()+" - "+t.getMessage());
        }
        return pedido;
    }
    
    @DELETE
    @Path("/porId")
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response remove(@QueryParam("codigoabastecedora") String codigoabastecedora, 
            @QueryParam("codigocomercializadora") String codigocomercializadora,
            @QueryParam("numeronotapedido") String numeronotapedido,
            @QueryParam("numero") String numero) {
        try {
            
            FacturaPK  entity = new FacturaPK();
            entity.setCodigoabastecedora(codigoabastecedora);
            entity.setCodigocomercializadora(codigocomercializadora);
            entity.setNumeronotapedido(numeronotapedido);
            entity.setNumero(numero);
                        
            super.remove(entity);
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");
            return Response.status(200)
                    .entity(succesMessage)
                    .type(MediaType.APPLICATION_JSON).
                    build();
            //return JAXRSUtils.fromResponse(ex.getResponse()).entity(errorMessage).build();
        } catch (WebApplicationException ex) {
            Response exResponse = ex.getResponse();
            ErrorMessage errorMessage = new ErrorMessage(exResponse.getStatus(), ex.getMessage());
            //return JAXRSUtils.fromResponse(ex.getResponse()).entity(errorMessage).build();
            return Response.status(Response.Status.CONFLICT)
                    .entity(errorMessage)
                    .type(MediaType.APPLICATION_JSON).
                    build();
        }

    }

    @PUT
    @Path("/porId")
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response edit1(Factura entity) {
        try {
            this.edit(entity);
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");
            return Response.status(200)
                    .entity(succesMessage)
                    .type(MediaType.APPLICATION_JSON).
                    build();

            //return JAXRSUtils.fromResponse(ex.getResponse()).entity(errorMessage).build();
        } catch (WebApplicationException ex) {
           
            Response exResponse = ex.getResponse();
            ErrorMessage errorMessage = new ErrorMessage(exResponse.getStatus(), ex.getMessage());
            //return JAXRSUtils.fromResponse(ex.getResponse()).entity(errorMessage).build();
            return Response.status(Response.Status.CONFLICT)
                    .entity(errorMessage)
                    .type(MediaType.APPLICATION_JSON).
                    build();
        }
    }

    @GET
    @Path("/porId")
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response find(@QueryParam("codigoabastecedora") String codigoabastecedora, 
            @QueryParam("codigocomercializadora") String codigocomercializadora,
            @QueryParam("numeronotapedido") String numeronotapedido,
            @QueryParam("numero") String numero) {
        try {

            FacturaPK  entity = new FacturaPK();
            entity.setCodigoabastecedora(codigoabastecedora);
            entity.setCodigocomercializadora(codigocomercializadora);
            entity.setNumeronotapedido(numeronotapedido);
            entity.setNumero(numero);
            
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");
            List<Factura> lst = new ArrayList<>();
            lst.add(super.find(entity));
            succesMessage.setRetorno(lst);
            return Response.status(200)
                    .entity(succesMessage)
                    .type(MediaType.APPLICATION_JSON).
                    build();
            //return JAXRSUtils.fromResponse(ex.getResponse()).entity(errorMessage).build();
        } catch (WebApplicationException ex) {
            Response exResponse = ex.getResponse();
            ErrorMessage errorMessage = new ErrorMessage(exResponse.getStatus(), ex.getMessage());
            //return JAXRSUtils.fromResponse(ex.getResponse()).entity(errorMessage).build();
            return Response.status(Response.Status.CONFLICT)
                    .entity(errorMessage)
                    .type(MediaType.APPLICATION_JSON).
                    build();
        }
    }
 
    @GET
    @Path("/paraFactura")  
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response findParaFactura(@QueryParam("codigoabastecedora") String codigoabastecedora, 
            @QueryParam("codigocomercializadora") String codigocomercializadora, 
            @QueryParam("codigoterminal") String codigoterminal,
            @QueryParam("tipofecha") String tipofecha,  
            @QueryParam("fecha") Date fecha) {
        try {

            FacturaPK entity = new FacturaPK();
            entity.setCodigoabastecedora(codigoabastecedora);
            entity.setCodigocomercializadora(codigocomercializadora);
            //entity.setNumero(numero);
            List<Factura> lst = new ArrayList<>();
            
//            DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");  
//            String date = "2021/06/18";
//            
            if(tipofecha.equals("1")){
                System.out.println("1");
//                StringBuilder sb = new StringBuilder();
//                    sb.append("select *")
//                    .append(" FROM Notapedido n join Detallenotapedido d" )
//                    .append(" on n.numero = d.numero")
//                    .append(" where n.codigoabastecedora = '").append(codigoabastecedora).append("'")
//                    .append(" and n.codigocomercializadora = '").append(codigocomercializadora).append("'")
//                    .append(" and n.codigoterminal = '").append(codigoterminal).append("'")
//                    .append(" and n.fechaventa = '").append(date).append("'");
//                Query qry = em.createNativeQuery(sb.toString(), Notapedido.class);
                
                TypedQuery<Factura> consultaPorFVenta = em.createNamedQuery("Factura.findForVenta", Factura.class);
                consultaPorFVenta.setParameter("codigoabastecedora", codigoabastecedora);
                consultaPorFVenta.setParameter("codigocomercializadora", codigocomercializadora);
                consultaPorFVenta.setParameter("codigoterminal", codigoterminal);
                //consultaPorAbastecedora.setParameter("tipofecha", tipofecha);
                consultaPorFVenta.setParameter("fecha", fecha);
                lst = consultaPorFVenta.getResultList();
            }else {
                System.out.println("2");
                TypedQuery<Factura> consultaPorFDespacho = em.createNamedQuery("Factura.findForDespacho", Factura.class);
                consultaPorFDespacho.setParameter("codigoabastecedora", codigoabastecedora);
                consultaPorFDespacho.setParameter("codigocomercializadora", codigocomercializadora);
                consultaPorFDespacho.setParameter("codigoterminal", codigoterminal);
                //consultaPorAbastecedora.setParameter("tipofecha", tipofecha);
                consultaPorFDespacho.setParameter("fecha", fecha);
                lst = consultaPorFDespacho.getResultList();
            }
            
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecuciòn correcta");
            //List<Notapedido> lst = new ArrayList<>();
            //lst = consultaPorAbastecedora.getResultList();
           // lst.add(super.find(entity));
            succesMessage.setRetorno(lst);
            return Response.status(200)
                    .entity(succesMessage)
                    .type(MediaType.APPLICATION_JSON).
                    build();
            //return JAXRSUtils.fromResponse(ex.getResponse()).entity(errorMessage).build();
        } catch (WebApplicationException ex) {
            Response exResponse = ex.getResponse();
            ErrorMessage errorMessage = new ErrorMessage(exResponse.getStatus(), ex.getMessage());
            //return JAXRSUtils.fromResponse(ex.getResponse()).entity(errorMessage).build();
            return Response.status(Response.Status.CONFLICT)
                    .entity(errorMessage)
                    .type(MediaType.APPLICATION_JSON).
                    build();
        }
    }

    
     
    @GET
    @Path("/mejorCliente")  
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response findMejorCliente(@QueryParam("activo") boolean activo) {
        
        List<Object[]> objetosList;
        StringBuilder sqlQuery = new StringBuilder();
        List<MejorCliente> lista = new ArrayList<>();
       sqlQuery.append("select n.nombrecliente as nomcliente, count (n.nombrecliente) as facturas, sum(n.valortotal) as sumatotal from Factura n where n.activa = :activo group by n.nombrecliente order by sumatotal desc");

        System.out.println("findMejorCliente FT:: "+ sqlQuery.toString());
       try {
            Query qry = this.em.createNativeQuery(sqlQuery.toString());
            qry.setParameter("activo", activo);
             
             objetosList = qry.getResultList();

            for (Object[] o : objetosList) {
                MejorCliente mc = new MejorCliente();
                mc.setNombrecliente(String.valueOf(o[0]));
                mc.setFacturas(new Integer(String.valueOf(o[1])));
                mc.setSumatotal(new BigDecimal(String.valueOf(o[2])));
                lista.add(mc);
            }
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecuciòn correcta");
            succesMessage.setRetorno(lista);
            return Response.status(200)
                    .entity(succesMessage)
                    .type(MediaType.APPLICATION_JSON).
                    build();
            
        } catch (WebApplicationException ex) {
            Response exResponse = ex.getResponse();
            ErrorMessage errorMessage = new ErrorMessage(exResponse.getStatus(), ex.getMessage());
            return Response.status(Response.Status.CONFLICT)
                    .entity(errorMessage)
                    .type(MediaType.APPLICATION_JSON).
                    build();
        }   
    }
    
       
    @GET
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response findAll2() {
        try {
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");
            List<Factura> lst = this.findAll();
            succesMessage.setRetorno(lst);
            return Response.status(200)
                    .entity(succesMessage)
                    .type(MediaType.APPLICATION_JSON).
                    build();
            //return JAXRSUtils.fromResponse(ex.getResponse()).entity(errorMessage).build();
        } catch (WebApplicationException ex) {
            Response exResponse = ex.getResponse();
            ErrorMessage errorMessage = new ErrorMessage(exResponse.getStatus(), ex.getMessage());
            //return JAXRSUtils.fromResponse(ex.getResponse()).entity(errorMessage).build();
            return Response.status(Response.Status.CONFLICT)
                    .entity(errorMessage)
                    .type(MediaType.APPLICATION_JSON).
                    build();
        }

    }

    @GET
    @Path("{from}/{to}")
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response countREST() {
        return super.count();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * @return the servicioNumeracion
     */
    public NumeracionFacadeREST getServicioNumeracion() {
        return servicioNumeracion;
    }

    /**
     * @param servicioNumeracion the servicioNumeracion to set
     */
    public void setServicioNumeracion(NumeracionFacadeREST servicioNumeracion) {
        this.servicioNumeracion = servicioNumeracion;
    }

    /**
     * @return the servicioDetalleFact
     */
    public DetallefacturaFacadeREST getServicioDetalleFact() {
        return servicioDetalleFact;
    }
 
    /**
     * @param servicioDetalleFact the servicioDetalleFact to set
     */
    public void setServicioDetalleFact(DetallefacturaFacadeREST servicioDetalleFact) {
        this.servicioDetalleFact = servicioDetalleFact;
    }

     public EnvioFacturaREST generarFactura(EnvioPedidoREST envNP) {
         
         SimpleDateFormat  date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Factura fac = new Factura();
        Cliente cli = new Cliente();
        FacturaPK fpk = new FacturaPK();
        Detallefactura dtF = new Detallefactura();
        List<Detallefactura> listDetF = new ArrayList<>();
        EnvioFacturaREST envF = new EnvioFacturaREST();
         try{
        
        short s = 0;
        fpk.setCodigoabastecedora(envNP.getNotapedido().getNotapedidoPK().getCodigoabastecedora());
        fpk.setCodigocomercializadora(envNP.getNotapedido().getNotapedidoPK().getCodigocomercializadora());
        fpk.setNumeronotapedido(envNP.getNotapedido().getNotapedidoPK().getNumero());
        fpk.setNumero("0");
        fac.setFacturaPK(fpk);
        //String fd = date.format(envNP.getNotapedido().getFechadespacho());
        //String fv = date.format(envNP.getNotapedido().getFechaventa());
        //String fvc = date.format(calcularFechaV(envNP.getNotapedido()));

        fac.setFechaventa(envNP.getNotapedido().getFechaventa());
        String fechaString = calcularFechaV(envNP.getNotapedido());
        
        /* parse para DATE
        2021/06/04
        String sDate1="31/12/1998";  
        Date date1=new SimpleDateFormat("yyyy/MM/dd").parse(fechaString);  
        System.out.println(sDate1+"\t"+date1);
        */
        
        fac.setFechavencimiento(new SimpleDateFormat("yyyy/MM/dd").parse(fechaString));
        fac.setFechaacreditacion(fac.getFechavencimiento());
        fac.setFechadespacho(envNP.getNotapedido().getFechadespacho());
        fac.setActiva(true);
        fac.setValortotal(new BigDecimal(0));
        fac.setIvatotal(new BigDecimal(0));
        fac.setObservacion("Generación Automática con NP: " + envNP.getNotapedido().getNotapedidoPK().getNumero());
        fac.setPagada(false);
        fac.setOeenpetro(false);
        fac.setCodigocliente(envNP.getNotapedido().getCodigocliente().getCodigo());
        fac.setCodigoterminal(envNP.getNotapedido().getCodigoterminal().getCodigo());
        fac.setCodigobanco(envNP.getNotapedido().getCodigobanco().getCodigo());
        fac.setAdelantar(envNP.getNotapedido().getAdelantar());
        fac.setUsuarioactual("ft");
        fac.setNombrecomercializadora(envNP.getNotapedido().getComercializadora().getNombre());
        fac.setRuccomercializadora(envNP.getNotapedido().getComercializadora().getRuc());
        fac.setDireccionmatrizcomercializadora(envNP.getNotapedido().getComercializadora().getDireccion());
        fac.setNombrecliente(envNP.getNotapedido().getCodigocliente().getNombre());
        fac.setRuccliente(envNP.getNotapedido().getCodigocliente().getRuc());
        fac.setValorsinimpuestos(new BigDecimal(0));
        fac.setCorreocliente(envNP.getNotapedido().getCodigocliente().getCorreo1());
        fac.setDireccioncliente(envNP.getNotapedido().getCodigocliente().getDireccion());
        fac.setTelefonocliente(envNP.getNotapedido().getCodigocliente().getTelefono1());
        fac.setClienteformapago(envNP.getNotapedido().getCodigocliente().getCodigoformapago().getCodigo());
        fac.setNumeroautorizacion("");
        fac.setFechaautorizacion("");
        fac.setPlazocliente(envNP.getNotapedido().getCodigocliente().getDiasplazocredito().intValue());
        fac.setClaveacceso("0");
        fac.setCampoadicionalCampo1("");
        fac.setCampoadicionalCampo2("");
        fac.setCampoadicionalCampo3("");
        fac.setCampoadicionalCampo4("");
        fac.setCampoadicionalCampo5("");
        fac.setCampoadicionalCampo6("");
        fac.setEstado("NUEVA");
        fac.setErrordocumento(s);
        fac.setHospedado(s);
        fac.setAmbientesri(envNP.getNotapedido().getComercializadora().getAmbientesri());
        fac.setTipoemision(envNP.getNotapedido().getComercializadora().getTipoemision());
        fac.setCodigodocumento("01");
        fac.setEsagenteretencion(envNP.getNotapedido().getComercializadora().getEsagenteretencion());
        fac.setEscontribuyenteespacial(envNP.getNotapedido().getComercializadora().getEscontribuyenteespacial());
        fac.setObligadocontabilidad(envNP.getNotapedido().getComercializadora().getObligadocontabilidad());
        fac.setTipocomprador("04");
        fac.setMoneda("DOLAR");
        fac.setSeriesri(envNP.getNotapedido().getComercializadora().getEstablecimientofac() + envNP.getNotapedido().getComercializadora().getPuntoventafac());
        fac.setTipoplazocredito(envNP.getNotapedido().getCodigocliente().getTipoplazocredito());
        envF.setFactura(fac);
        envF.setDetalle(listDetF);
        System.out.println("FT::-generarFactura-obtenerPrecio");
        envF = obtenerPrecio(envNP, envF, envF.getFactura());
         }catch(Throwable t){
             System.out.println("FT::ERROR EN "+this.toString() + "::generarFactura "+ t.getMessage());
             t.printStackTrace(System.out);
         }
             
        return envF;
    }
     
     public String calcularFechaV(Notapedido ntp) {
        Date fechaFestiva = new Date();
        String fechav = "";
        try {
            DateFormat date = new SimpleDateFormat("yyyy/MM/dd");
            String fechaS = date.format(ntp.getFechadespacho());
            //String direcc = "https://www.supertech.ec:8443/infinityone1/resources/ec.com.infinity.modelo.fechafestiva/fechafinal?";
            String direcc = "https://www.supertech.ec:8443/infinityone1/resources/ec.com.infinity.modelo.fechafestiva/fechafinal?";
            URL url = new URL(direcc + "codigocomercializadora=" + ntp.getNotapedidoPK().getCodigocomercializadora() + "&fechainicial=" + fechaS + "&tipoplazo=" + ntp.getCodigocliente().getTipoplazocredito() + "&plazo=" + ntp.getCodigocliente().getDiasplazocredito());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            InputStreamReader reader = new InputStreamReader(connection.getInputStream());

            BufferedReader br = new BufferedReader(reader);
            String tmp = null;
            String respuesta = "";
            while ((tmp = br.readLine()) != null) {
                respuesta += tmp;
            }
            JSONObject objetoJson = new JSONObject(respuesta);
            JSONArray retorno = objetoJson.getJSONArray("retorno");
            for (int indice = 0; indice < retorno.length(); indice++) {
                if (!retorno.isNull(indice)) {
                    Long fecha = retorno.getLong(indice);
                    fechaFestiva = new Date(fecha);
                }
            }
            
            fechav = date.format(fechaFestiva);
            System.out.println("FT:: calcularFechaV OK!! getResponseCode: " + connection.getResponseCode());
            System.out.println("FT:: calcularFechaV OK!! getResponseMessage: " +connection.getResponseMessage());
           System.out.println("FT:: calcularFechaV OK!! RESPUESTA: " +fechaS + " - " + fechav);

            
        } catch (IOException e) {
            System.out.println("FT::ERROR EN calcularFechaV::"+e.getMessage());
            e.printStackTrace();
        }
         return fechav;
    }
    
     public EnvioFacturaREST obtenerPrecio(EnvioPedidoREST envNP, EnvioFacturaREST envF, Factura fac) {
        try {
            Detallefactura detalleFactura = new Detallefactura();
            DetallefacturaPK detalleFacturaPK = new DetallefacturaPK();
            BigDecimal subtotal = new BigDecimal(0);
            precio = buscarPrecio(envNP);
            
            DateFormat date = new SimpleDateFormat("yyyy/MM/dd");

            detalleFacturaPK.setCodigoabastecedora(envNP.getNotapedido().getNotapedidoPK().getCodigoabastecedora());
            detalleFacturaPK.setCodigocomercializadora(envNP.getNotapedido().getNotapedidoPK().getCodigocomercializadora());
            detalleFacturaPK.setNumeronotapedido(envNP.getNotapedido().getNotapedidoPK().getNumero());
            detalleFacturaPK.setNumero("0");
            detalleFacturaPK.setCodigoproducto(envNP.getDetalle().getDetallenotapedidoPK().getCodigoproducto());

            detalleFactura.setDetallefacturaPK(detalleFacturaPK);
            Medida med = new Medida();
            med.setCodigo(envNP.getDetalle().getDetallenotapedidoPK().getCodigomedida());
            detalleFactura.setCodigomedida(med);
            detalleFactura.setVolumennaturalautorizado(envNP.getDetalle().getVolumennaturalautorizado());
            detalleFactura.setVolumennaturalrequerido(envNP.getDetalle().getVolumennaturalrequerido());
            detalleFactura.setCodigoprecio(precio.getPrecioPK().getCodigoPrecio());
            detalleFactura.setPrecioproducto(precio.getPrecioproducto());
            subtotal = envNP.getDetalle().getVolumennaturalautorizado().multiply(precio.getPrecioproducto());
            detalleFactura.setSubtotal(subtotal.setScale(2, RoundingMode.HALF_UP));
            detalleFactura.setUsuarioactual("ft");
            detalleFactura.setRuccomercializadora(fac.getRuccomercializadora());
            detalleFactura.setCodigoimpuesto("");
            detalleFactura.setNombreimpuesto("");
            detalleFactura.setSeimprime(false);
            detalleFactura.setValordefecto(new BigDecimal(0));

            fac.setValorsinimpuestos(detalleFactura.getSubtotal());
            envF.setFactura(fac);
            envF.getDetalle().add(detalleFactura);
            System.out.println("FT:: AL TERMINAR obtenerPrecio:: "+envF.getDetalle().size());
            precio = new Precio();
            precioPK = new PrecioPK();
        } catch (Throwable e) {
            System.out.println("error  en obtenerPrecio:: "+ e.getMessage());
            e.printStackTrace();
        }
        return envF;
    }
     
     
     public EnvioFacturaREST actionFactura(Factura fac, EnvioPedidoREST envNP, Detallefactura detalleFactura, String codigoPecio, EnvioFacturaREST envF) {

        List<Detallefactura> detFact = new ArrayList<>();
        Detallefactura detalleFact = new Detallefactura();
        DetallefacturaPK detalleFactPK = new DetallefacturaPK();
        BigDecimal totalimpuestos = new BigDecimal(0);
        BigDecimal subtotal = new BigDecimal(0);
        int count = 1;
        try {
            String direcc = "https://www.supertech.ec:8443/infinityone1/resources/ec.com.infinity.modelo.detalleprecio/paraFactura?";
            URL url = new URL(direcc + "codigo=" + codigoPecio);
            //url = new URL("https://www.supertech.ec:8443/infinityone1/resources/ec.com.infinity.modelo.precio/paraFactura?codigocomercializadora=0002&codigoterminal=02&codigoproducto=0101&codigomedida=01&fechainicio=2021/06/25&codigolistaprecio=a0000001");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            InputStreamReader reader = new InputStreamReader(connection.getInputStream());

            BufferedReader br = new BufferedReader(reader);
            String tmp = null;
            String respuesta = "";
            while ((tmp = br.readLine()) != null) {
                respuesta += tmp;
            }
            System.out.println("FT:: actionFactura::-respuesta del servicio buscardetalle precio" + respuesta);
            JSONObject objetoJson = new JSONObject(respuesta);
            JSONArray retorno = objetoJson.getJSONArray("retorno");
            for (int indice = 0; indice < retorno.length(); indice++) {
                String bandera = "000" + count;
                if (!retorno.isNull(indice)) {
                    JSONObject detailP = retorno.getJSONObject(indice);
                    JSONObject detailPePK = detailP.getJSONObject("detalleprecioPK");
                    JSONObject grv = detailP.getJSONObject("gravamen");
                    JSONObject grvPK = grv.getJSONObject("gravamenPK");
                    if (grvPK.getString("codigo").equals("0001") || grvPK.getString("codigo").equals("0009")) {
                        System.out.println("FT:: actionFactura::Impuesto no usado" + grvPK.getString("codigo"));
                    } else {
                        detalleFactPK.setCodigoabastecedora(fac.getFacturaPK().getCodigoabastecedora());
                        detalleFactPK.setCodigocomercializadora(fac.getFacturaPK().getCodigocomercializadora());
                        detalleFactPK.setNumeronotapedido(fac.getFacturaPK().getNumeronotapedido());
                        detalleFactPK.setNumero(fac.getFacturaPK().getNumero());
                        detalleFactPK.setCodigoproducto(bandera);
                        detalleFact.setDetallefacturaPK(detalleFactPK);
                        Medida med = new Medida();
                        detalleFact.setCodigomedida(envNP.getDetalle().getMedida());
                        detalleFact.setVolumennaturalautorizado(envNP.getDetalle().getVolumennaturalautorizado());
                        detalleFact.setVolumennaturalrequerido(envNP.getDetalle().getVolumennaturalrequerido());
                        detalleFact.setCodigoprecio(detalleFactura.getCodigoprecio());
                        detalleFact.setPrecioproducto(detalleFactura.getPrecioproducto());
                        subtotal = detalleFactura.getVolumennaturalautorizado().multiply(detailP.getBigDecimal("valor"));
                        detalleFact.setSubtotal(subtotal.setScale(2, RoundingMode.HALF_UP));
                        detalleFact.setUsuarioactual("ft");
                        detalleFact.setRuccomercializadora(fac.getRuccomercializadora());
                        detalleFact.setCodigoimpuesto(detailPePK.getString("codigogravamen"));
                        detalleFact.setNombreimpuesto(grv.getString("nombre"));
                        detalleFact.setSeimprime(grv.getBoolean("seimprime"));
                        detalleFact.setValordefecto(new BigDecimal(0));
                        if (detalleFact.getCodigoimpuesto().equals("0002")) {
                            fac.setIvatotal(detalleFact.getSubtotal());
                        }
                        totalimpuestos = totalimpuestos.add(detalleFact.getSubtotal());
                        detFact.add(detalleFact);
                        count++;
                        detalleFact = new Detallefactura();
                        detalleFactPK = new DetallefacturaPK();
                    }
                }
            }
            System.out.println("FT:: actionFactura::Impuesto no usado");
            fac.setValortotal(totalimpuestos.add(fac.getValorsinimpuestos()).setScale(2, RoundingMode.HALF_UP));
            detFact.add(detalleFactura);
            
            envF.setDetalle(detFact);
            System.out.println("FT:: actionFactura::FIN DE CARGA DE DETALLES:: "+envF.getDetalle().size());
            detFact = new ArrayList<>();
            
            //this.getTrama2(envF);
            //this.getTrama3(envF);
            System.out.println(connection.getResponseCode());
            System.out.println(connection.getResponseMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println("FT:: TERMINÓ ACTIONFACTURA-FAC::  "+envF.getFactura().getFacturaPK().getNumeronotapedido());
//        System.out.println("FT:: TERMINÓ ACTIONFACTURA-DETFA:: + "+envF.getDetalle().get(0).getSubtotal());
//        System.out.println("FT:: TERMINÓ ACTIONFACTURA-DETFA:: + "+envF.getDetalle().get(1).getSubtotal());
        return envF;
    }

    public Precio buscarPrecio(EnvioPedidoREST envNP){
            Precio res = new Precio();
            PrecioPK  entity = new PrecioPK();
            try{
            entity.setCodigocomercializadora(envNP.getNotapedido().getNotapedidoPK().getCodigocomercializadora());
            entity.setCodigoterminal(envNP.getNotapedido().getCodigoterminal().getCodigo());
            entity.setCodigoproducto(envNP.getDetalle().getProducto().getCodigo());
            entity.setCodigomedida(envNP.getDetalle().getMedida().getCodigo());
            entity.setCodigolistaprecio(envNP.getNotapedido().getCodigocliente().getCodigolistaprecio());
            entity.setFechainicio(envNP.getNotapedido().getFechadespacho());             
            TypedQuery<Precio> consultaPrecioParafacturar = em.createNamedQuery("Precio.findForFactura", Precio.class);
            consultaPrecioParafacturar.setParameter("codigocomercializadora", envNP.getNotapedido().getNotapedidoPK().getCodigocomercializadora());
            consultaPrecioParafacturar.setParameter("codigoterminal", envNP.getNotapedido().getCodigoterminal().getCodigo());
            consultaPrecioParafacturar.setParameter("codigoproducto", envNP.getDetalle().getProducto().getCodigo());
            consultaPrecioParafacturar.setParameter("codigomedida", envNP.getDetalle().getMedida().getCodigo());
            consultaPrecioParafacturar.setParameter("codigolistaprecio", envNP.getNotapedido().getCodigocliente().getCodigolistaprecio());
            consultaPrecioParafacturar.setParameter("fechainicio", envNP.getNotapedido().getFechadespacho());
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");
            List<Precio> lst = new ArrayList<>();
            lst = consultaPrecioParafacturar.getResultList();
            System.out.println("FT:: buscarPrecio OK");
            if (!lst.isEmpty()){
                res = lst.get(0);
                System.out.println("FT::buscarPrecio:: PRECIO ENCONTRADO "+res.getPrecioPK().getCodigoPrecio());
            }
            } catch (Throwable ex) {
                System.out.println("FT:: ERROR EN buscarPrecio: "+ex.getMessage());
                ex.printStackTrace(System.out);
    
            }
        return res; 
    }
}
