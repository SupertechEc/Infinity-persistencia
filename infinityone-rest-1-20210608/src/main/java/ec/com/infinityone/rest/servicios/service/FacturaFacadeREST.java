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
import ec.com.infinity.modelo.Clienterubrotercero;
import ec.com.infinity.modelo.Cuotarubroterceros;
import ec.com.infinity.modelo.CuotarubrotercerosPK;
import ec.com.infinity.modelo.DetallefacturaPK;
import ec.com.infinity.modelo.Detallefacturarubrotercero;
import ec.com.infinity.modelo.DetallefacturarubroterceroPK;
import ec.com.infinity.modelo.Detalleprecio;
import ec.com.infinity.modelo.DetalleprecioPK;
import ec.com.infinity.modelo.Medida;
import ec.com.infinity.modelo.Precio;
import ec.com.infinity.modelo.PrecioPK;
import ec.com.infinity.modelo.Totalgarantizado;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.math.MathContext;
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
    private DetallefacturarubroterceroFacadeREST servicioDetFacRubro;
    //@PersistenceContext(unitName = "my_persistence_unit")

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
    public boolean createCrear(EnvioFacturaREST entity) throws Throwable{
        
        boolean respuesta = false;
        
        if (entity == null){
        System.out.println("FACTURAFACADEREST::create1: esta nullo");
         return respuesta;
        }
        else{
                System.out.println("FACTURAFACADEREST::create1: NOOOOO nullo");  
        }
     
        String tipodocumento = "FAC";
        
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
            System.out.println("FT:: terminó de grabar factura y detalles de FACTURA");
            respuestaNumeracion.setUltimonumero(numeracion);
            getServicioNumeracion().edit(respuestaNumeracion);
            System.out.println("FT:: terminó de getServicioNumeracion().edit(respuestaNumeracion)::"+numeracion);
            System.out.println("FT:: INCIA CREACION DE DETALLESRUBROSFACTURAS)::"+numeracion);
            crearDetallesFacturaCuotasRubros(entity);
            System.out.println("FT::crearDetallesFacturaCuotasRubros(entity)::"+entity.toString());
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
        } catch (Throwable t) {
            System.out.println("FT:: Error Capturado: "+this.toString()+" - "+t.getMessage());
            t.printStackTrace(System.out);
            throw new Throwable ("Error Capturado: "+this.toString()+":createCrear - "+t.getMessage());
             
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
            succesMessage.setDeveloperMessage("Factura se ha generado correctamente!");
            succesMessage.setRetorno(lst);
            return Response.status(200)
                    .entity(succesMessage)
                    .type(MediaType.APPLICATION_JSON).
                    build();
        }catch(Throwable t){
            List<String> lstError = new ArrayList<>();
            System.out.println("FT:: Throwable capturada:createF "+t.getMessage());
            lstError.add(t.getMessage());
            t.printStackTrace(System.out);
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(299);
            succesMessage.setDeveloperMessage("Error al crear la Factura: "+t.getMessage());
            succesMessage.setRetorno(lstError);
            return Response.status(299)
                    .entity(succesMessage)
                    .type(MediaType.APPLICATION_JSON).
                    build();
        } 
    }
    
    public EnvioPedidoREST buscarNP(String codigoabastecedora, String codigocomercializadora, String numeronotapedido, String numero)throws Throwable{
        
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
            System.out.println("FT:: Error Capturado: "+this.toString()+" - "+t.getMessage());
            t.printStackTrace(System.out);
            throw new Throwable ("Error Capturado: "+this.toString()+" - "+t.getMessage());
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

     public EnvioFacturaREST generarFactura(EnvioPedidoREST envNP) throws Throwable {
         
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
             System.out.println("FT:: ERROR EN "+this.toString() + "::generarFactura "+ t.getMessage());
             t.printStackTrace(System.out);
             throw new Throwable("FT:: ERROR EN "+this.toString() + "::generarFactura "+ t.getMessage()); 
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
            detalleFactura.setCodigoprecio(String.valueOf(precio.getPrecioPK().getCodigoPrecio()));
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
     
     
     public EnvioFacturaREST actionFactura(Factura fac, EnvioPedidoREST envNP, Detallefactura detalleFactura, String codigoPecio, EnvioFacturaREST envF) throws Throwable {

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
//            System.out.println("FT:: actionFactura::-respuesta del servicio buscardetalle precio" + respuesta);
            JSONObject objetoJson = new JSONObject(respuesta);
            JSONArray retorno = objetoJson.getJSONArray("retorno");
            BigDecimal valor3xmilSRI = new BigDecimal("0");
            for (int indice = 0; indice < retorno.length(); indice++) {
                String bandera = "000" + count;
                if (!retorno.isNull(indice)) {
                    JSONObject detailP = retorno.getJSONObject(indice);
                    JSONObject detailPePK = detailP.getJSONObject("detalleprecioPK");
                    JSONObject grv = detailP.getJSONObject("gravamen");
                    JSONObject grvPK = grv.getJSONObject("gravamenPK");
                    if (grvPK.getString("codigo").equals("0001") || grvPK.getString("codigo").equals("0009")|| grvPK.getString("codigo").equals("0005")) {
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
                        valor3xmilSRI = grv.getBigDecimal("valordefecto");
                        if (detalleFact.getCodigoimpuesto().equalsIgnoreCase("0328")){
                            valor3xmilSRI = valor3xmilSRI.multiply(new BigDecimal("100"));
                        }
                        detalleFact.setValordefecto(valor3xmilSRI);
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
//            System.out.println("FT:: actionFactura::Impuesto no usado");
            fac.setValortotal(totalimpuestos.add(fac.getValorsinimpuestos()).setScale(2, RoundingMode.HALF_UP));
            fac.setValorconrubro(fac.getValortotal());
            if (envNP.getNotapedido().getCodigocliente().getControlagarantia()){
                try{
                    System.out.println("FT:: VA A REALIZAR CONTROL DE GARANTÍAS");
                    validarGarantia(fac);
                }catch(Throwable a){
                    throw a;//new Throwable("Error al validar la garantía de este cliente");
                }
            }
            detFact.add(detalleFactura);
            
            envF.setDetalle(detFact);
//            System.out.println("FT:: actionFactura::FIN DE CARGA DE DETALLES:: "+envF.getDetalle().size());
            detFact = new ArrayList<>();
            
            //this.getTrama2(envF);
            //this.getTrama3(envF);
            System.out.println(connection.getResponseCode());
            System.out.println(connection.getResponseMessage());
        } catch (Throwable t) {
             System.out.println("FT:: ERROR EN "+this.toString() + "::actionFactura "+ t.getMessage());
             t.printStackTrace(System.out);
             throw t;  
        }
//        System.out.println("FT:: TERMINÓ ACTIONFACTURA-FAC::  "+envF.getFactura().getFacturaPK().getNumeronotapedido());
//        System.out.println("FT:: TERMINÓ ACTIONFACTURA-DETFA:: + "+envF.getDetalle().get(0).getSubtotal());
          System.out.println("FT:: TERMINÓ ACTIONFACTURA-DETFA:: Y AUN CON FT:: ERROR EN CONTINUA--- MALLLL - SE DEBE VERIFICAR CANCELAR EL PROCESO Y ENVIAR UN ERROR AL USUARIO ");
        return envF;
    }
     public void validarGarantia(Factura fac)throws Throwable{
         
        Totalgarantizado totalGarantizado = null;
        List<Totalgarantizado> lst = new ArrayList<>();
        List<Detallenotapedido> lstD = new ArrayList<>();
        try{
            TypedQuery<Totalgarantizado> consulta = em.createNamedQuery("Totalgarantizado.findByComerCli", Totalgarantizado.class);
            consulta.setParameter("codigocomercializadora", fac.getFacturaPK().getCodigocomercializadora().trim());
            consulta.setParameter("codigocliente", fac.getCodigocliente().trim());
            try{
            totalGarantizado = consulta.getSingleResult();
            }catch(Throwable a){
               throw new Throwable("Error al buscar Totalgarantizado para este cliente (Verifique Garantías): " + fac.getCodigocliente().trim());     
            }
            BigDecimal saldo = new BigDecimal("0.00"); 
            if (totalGarantizado == null ){
                  throw new Throwable("No se ha encontrado un valor garantizado para este cliente: " + fac.getCodigocliente().trim());
            }else{
                saldo = totalGarantizado.getTotalgarantizado().subtract(totalGarantizado.getTotaldeuda().add((fac.getValorconrubro())));
                if( saldo.compareTo(new BigDecimal(BigInteger.ZERO))== -1){
                    throw new Throwable("El valor de esta compra SUPERARÁ el saldo garantizado de este cliente: "+ fac.getCodigocliente().trim()+ "V. garantizado: "+totalGarantizado.getTotalgarantizado() + " V. deuda actual: "+ totalGarantizado.getTotaldeuda()+ "v. Factura+rubros solicitada: "+fac.getValorconrubro()); 
                }
            }
        }catch(Throwable x){
            throw x;
        }
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
    
    @GET
    @Path("/paraCobrar")  
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response findParaCobrar(@QueryParam("codigocomercializadora") String  codigocomercializadora,
            @QueryParam("tipofecha") String  tipofecha, 
            @QueryParam("oeenpetro") boolean oeenpetro, 
            @QueryParam("activa") boolean activa, 
            @QueryParam("pagada") boolean pagada,
            @QueryParam("fecha") Date fecha) {
        try {

            FacturaPK entity = new FacturaPK();
            
            List<Factura> lst = new ArrayList<>();
            
//            DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");  
//            String date = "2021/06/18";
//            
            if(tipofecha.equals("1")){
                System.out.println("1-fecha de venta");
                TypedQuery<Factura> consulta = em.createNamedQuery("Factura.findByPagarFVenta", Factura.class);
                consulta.setParameter("codigocomercializadora", codigocomercializadora);
                consulta.setParameter("oeenpetro", oeenpetro);
                consulta.setParameter("activa", activa);
                consulta.setParameter("pagada", pagada);
                consulta.setParameter("fechaventa", fecha);
                lst = consulta.getResultList();
            }else {
                System.out.println("2-fecha de despacho");
                TypedQuery<Factura> consulta = em.createNamedQuery("Factura.findByPagarFVencimiento", Factura.class);
                consulta.setParameter("codigocomercializadora", codigocomercializadora);
                consulta.setParameter("oeenpetro", oeenpetro);
                consulta.setParameter("activa", activa);
                consulta.setParameter("pagada", pagada);
                consulta.setParameter("fechavencimiento", fecha);
                lst = consulta.getResultList();
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
    public void crearDetallesFacturaCuotasRubros (EnvioFacturaREST unaFactura)throws Throwable{
        System.out.println("ENTRA EN crearDetallesFacturaCuotasRubros FT:: ");
        List<Cuotarubroterceros> cuotas = new ArrayList<>();
        Cuotarubroterceros unaCuota = new Cuotarubroterceros(); 
        CuotarubrotercerosPK unaCuotaPK = new CuotarubrotercerosPK(); 
        Detallefacturarubrotercero detalleFactCuota = new Detallefacturarubrotercero();
        DetallefacturarubroterceroPK detalleFactCuotaPK = new DetallefacturarubroterceroPK();
        List<Object[]> objetosList;
        StringBuilder sqlQuery = new StringBuilder();
        List<Cuotarubroterceros> lista = new ArrayList<>();
        try{    
            // DEBE BUSCAR CUOTAS DE CLIENTERUBROS ACTIVOS  
            sqlQuery.append("SELECT c.* FROM Cuotarubroterceros c, clienterubrotercero cl WHERE  ")
            .append(" cl.codigocomercializadora = c.codigocomercializadora ") 
            .append(" and cl.codigorubrotercero = c.codigorubrotercero ")
            .append(" and cl.codigocliente = c.codigocliente ")
            .append(" and c.codigocomercializadora = :pcodigocomercializadora ") 
            .append(" and c.codigocliente = :pcodigocliente ")
            .append(" and cl.activo = true ")
            .append(" and c.pagada = false ")
            .append(" and c.tipocobro = 'LIB' ")
            .append(" and c.fechainiciocobro <= :pfecha ") 
            .append(" and c.fechacobro <= :pfecha  ")
            .append(" UNION ")
            .append("SELECT c.* FROM Cuotarubroterceros c, clienterubrotercero cl WHERE  ")
            .append(" cl.codigocomercializadora = c.codigocomercializadora ") 
            .append(" and cl.codigorubrotercero = c.codigorubrotercero ")
            .append(" and cl.codigocliente = c.codigocliente ")
            .append(" and c.codigocomercializadora = :pcodigocomercializadora ") 
            .append(" and c.codigocliente = :pcodigocliente ")
            .append(" and cl.activo = true ")
            .append(" and c.pagada = false ")
            .append(" and c.tipocobro = 'MEN' ")
            .append(" and c.fechainiciocobro <= :pfecha  ") 
            .append(" and c.fechacobro <= :pfecha  ")
            .append(" order by fechacobro  limit 2"); 
            
             System.out.println("findParaCobrar FT:: "+ sqlQuery.toString());
                Query qry = this.em.createNativeQuery(sqlQuery.toString());
                qry.setParameter("pcodigocomercializadora", unaFactura.getFactura().getFacturaPK().getCodigocomercializadora().trim());
                qry.setParameter("pcodigocliente", unaFactura.getFactura().getCodigocliente().trim());
                qry.setParameter("pfecha", unaFactura.getFactura().getFechaventa());
                objetosList = qry.getResultList();
            System.out.println("findParaCobrar FT-RESULTADO:: "+ objetosList.size());    
                for (Object[] o : objetosList) {
                     
                 detalleFactCuotaPK.setCodigoabastecedora(unaFactura.getFactura().getFacturaPK().getCodigoabastecedora().trim());
                 detalleFactCuotaPK.setCodigocomercializadora(unaFactura.getFactura().getFacturaPK().getCodigocomercializadora().trim());
                 detalleFactCuotaPK.setNumerofactura(unaFactura.getFactura().getFacturaPK().getNumero());
                 detalleFactCuotaPK.setNumeronotapedido(unaFactura.getFactura().getFacturaPK().getNumeronotapedido());
                 detalleFactCuotaPK.setCodigoclientecuota(String.valueOf(o[2]));
                 detalleFactCuotaPK.setCodigorubrotercero(new BigInteger(String.valueOf(o[1])).longValue());
                 detalleFactCuotaPK.setCuota(new Integer(String.valueOf(o[3])).intValue());
                 detalleFactCuota.setDetallefacturarubroterceroPK(detalleFactCuotaPK);
                 System.out.println("FT::----Fechacobrocuota:: "+String.valueOf(o[5]));
                 detalleFactCuota.setFechacobrocuota(new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(o[5])));
//                 detalleFactCuota.setFechacobrocuota(new Date(new Long(String.valueOf(o[5]))));
                 detalleFactCuota.setFechacobroreal(unaFactura.getFactura().getFechaventa());
                 detalleFactCuota.setValorcuota(new BigDecimal(String.valueOf(o[6])));
                 detalleFactCuota.setUsuarioactual("ft");
//                 lista.add(mc);
                 //grabarDetFacRubr(detalleFactCuota);
                servicioDetFacRubro.create(detalleFactCuota);
                detalleFactCuotaPK = new DetallefacturarubroterceroPK();
                detalleFactCuota = new Detallefacturarubrotercero();
            }
                
                gestionarCuotasXFactura(unaFactura);
                
        }catch (Throwable t){
            System.out.println("Error en crearDetallesFacturaCuotasRubros:: "+t.getMessage()+" causa:: "+t.getCause());
            t.printStackTrace(System.out);
            throw t;
        }
        
        //--------------
        
        
         
    }
    
    public void gestionarCuotasXFactura(EnvioFacturaREST unaFactura)throws Throwable{
        
        List<Clienterubrotercero> lst = new ArrayList<>();
        Cuotarubroterceros nuevaCuota = new Cuotarubroterceros();
        CuotarubrotercerosPK nuevaCuotaPK = new CuotarubrotercerosPK();
        Detallefacturarubrotercero detalleFactCuota = new Detallefacturarubrotercero();
        DetallefacturarubroterceroPK detalleFactCuotaPK = new DetallefacturarubroterceroPK();
        int contadorCuota = 1;
        int contadorCuotaBDD = 1;
        try{
            TypedQuery<Clienterubrotercero> consulta = em.createNamedQuery("Clienterubrotercero.findByFAC", Clienterubrotercero.class);
            consulta.setParameter("codigocomercializadora", unaFactura.getFactura().getFacturaPK().getCodigocomercializadora().trim());
            consulta.setParameter("codigocliente", unaFactura.getFactura().getCodigocliente().trim());
            consulta.setParameter("tipocobro", "FAC");
            consulta.setParameter("activo", true);
            consulta.setParameter("fechainiciocobro", unaFactura.getFactura().getFechaventa());
            lst = consulta.getResultList();
             for (Clienterubrotercero o : lst) {
                 nuevaCuotaPK.setCodigocomercializadora(o.getClienterubroterceroPK().getCodigocomercializadora());
                 nuevaCuotaPK.setCodigocliente(o.getClienterubroterceroPK().getCodigocliente());
                 nuevaCuotaPK.setCodigorubrotercero(o.getClienterubroterceroPK().getCodigorubrotercero());
                 nuevaCuotaPK.setCuota(contadorCuota);
                 nuevaCuota.setCuotarubrotercerosPK(nuevaCuotaPK);
                 nuevaCuota.setFechacobro(unaFactura.getFactura().getFechaventa());
                 nuevaCuota.setFechainiciocobro(o.getFechainiciocobro());
                 nuevaCuota.setPagada(true);
                 nuevaCuota.setTipocobro("FAC");
                 nuevaCuota.setValor(unaFactura.getFactura().getValortotal());
                 nuevaCuota.setUsuarioactual(o.getUsuarioactual());
             
                 //------ servicio de creacion
                  String respuesta;
//            String fechaS = "";
//            DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
//            if (listaCuotarubro.get(i).getFechacobro() != null) {
//                fechaS = date.format(listaCuotarubro.get(i).getFechacobro());
//            }
//            String fechaIniS = date.format(listaCuotarubro.get(i).getFechainiciocobro());
            contadorCuotaBDD = buscarMaxCuota(o.getClienterubroterceroPK().getCodigocomercializadora(), o.getClienterubroterceroPK().getCodigorubrotercero(), o.getClienterubroterceroPK().getCodigocliente(), "FAC");
            if(contadorCuota < contadorCuotaBDD){
                contadorCuota = contadorCuotaBDD;
            }
            
            URL url = new URL("https://www.supertech.ec:8443/infinityone1/resources/ec.com.infinity.modelo.cuotarubroterceros");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-type", "application/json");

            System.out.println("FT:: CREAR UNA CUOTA TIPO -FAC- POR EJECUTAR: " + url.toString());
            
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            JSONObject obj = new JSONObject();
            JSONObject objPk = new JSONObject();
            objPk.put("codigocomercializadora", o.getClienterubroterceroPK().getCodigocomercializadora());
            objPk.put("codigorubrotercero", o.getClienterubroterceroPK().getCodigorubrotercero());
            objPk.put("codigocliente", o.getClienterubroterceroPK().getCodigocliente());
            objPk.put("cuota", contadorCuota);
            obj.put("cuotarubrotercerosPK", objPk);
            obj.put("pagada", "true");
            System.out.println("FT:: FECHA DE VENTA PARA GRABAR EN NUEVA CUOTA. "+unaFactura.getFactura().getFechaventa());
            SimpleDateFormat fechD = new SimpleDateFormat("yyyy-MM-dd'T'11:00:00'Z'");
            String fechaV = fechD.format(unaFactura.getFactura().getFechaventa());
            obj.put("fechacobro", fechaV);
            obj.put("valor", (unaFactura.getDetalle().get(0).getVolumennaturalautorizado().multiply(o.getValor(), MathContext.UNLIMITED)));
            obj.put("tipocobro", "FAC");
            obj.put("fechainiciocobro", o.getFechainiciocobro());
            obj.put("usuarioactual", "ft");
            respuesta = obj.toString();
            writer.write(respuesta);
            writer.close();
            if (connection.getResponseCode() == 200) {
                System.out.println("FT:: grabación CUOTA OK: "+objPk.toString());
            } else {
                System.out.println("FT:: grabación CUOTA ERROR: "+objPk.toString());
            }
            
            // generar detallefacrubro
            System.out.println("FT:: INICIA CREACION DE detalleFactCuotaPK: ");
             detalleFactCuotaPK.setCodigoabastecedora(unaFactura.getFactura().getFacturaPK().getCodigoabastecedora().trim());
             detalleFactCuotaPK.setCodigocomercializadora(unaFactura.getFactura().getFacturaPK().getCodigocomercializadora().trim());
             detalleFactCuotaPK.setNumerofactura(unaFactura.getFactura().getFacturaPK().getNumero());
             detalleFactCuotaPK.setNumeronotapedido(unaFactura.getFactura().getFacturaPK().getNumeronotapedido());
             detalleFactCuotaPK.setCodigoclientecuota(unaFactura.getFactura().getCodigocliente());
             detalleFactCuotaPK.setCodigorubrotercero(o.getClienterubroterceroPK().getCodigorubrotercero());
             detalleFactCuotaPK.setCuota(contadorCuota);
             detalleFactCuota.setDetallefacturarubroterceroPK(detalleFactCuotaPK);
//             System.out.println("FT::----Fechacobrocuota:: " + String.valueOf(o[5]));
             detalleFactCuota.setFechacobrocuota(unaFactura.getFactura().getFechaventa());
//                 detalleFactCuota.setFechacobrocuota(new Date(new Long(String.valueOf(o[5]))));
             detalleFactCuota.setFechacobroreal(unaFactura.getFactura().getFechaventa());
             detalleFactCuota.setValorcuota(unaFactura.getDetalle().get(0).getVolumennaturalautorizado().multiply(o.getValor(), MathContext.UNLIMITED));
             detalleFactCuota.setUsuarioactual("ft");
//                 lista.add(mc);
             //grabarDetFacRubr(detalleFactCuota);
            System.out.println("FT:: INICIA GRABACIÓN DE detalleFactCuotaPK: ");
             servicioDetFacRubro.create(detalleFactCuota);
             System.out.println("FT:: TERMINA GRABACIÓN DE detalleFactCuotaPK: ");
            
            // generar detallefacrubro
            
            contadorCuota++;
            
           }            
        }catch(Throwable t){
            System.out.println("Error en crearDetallesFacturaCuotasRubros::gestionarCuotasXFactura- "+t.getMessage()+" causa:: "+t.getCause());
            t.printStackTrace(System.out);
            throw new Throwable("Error en crearDetallesFacturaCuotasRubros::gestionarCuotasXFactura. "+t.getMessage()+" causa. "+t.getCause());
        }
    }
  //  public void(Detallefacturarubrotercero detalleFactCuota){
        
    //}
    
     
 

//--and f.fechavencimiento = '2021-08-24'
//
//     
//         @GET
//    @Path("/totalbcofec")  
//    //@Secured
//    @Consumes({"application/json"})
//    @Produces({"application/json"})
//    public Response findTotalXbcoFec(@QueryParam("codigocomercializadora") String  codigocomercializadora,
//            @QueryParam("tipofecha") String  tipofecha, 
//            @QueryParam("oeenpetro") boolean oeenpetro, 
//            @QueryParam("activa") boolean activa, 
//            @QueryParam("pagada") boolean pagada,
//            @QueryParam("fecha") Date fecha){
//        
//        List<Object[]> objetosList;
//        StringBuilder sqlQuery = new StringBuilder();
//        List<MejorCliente> lista = new ArrayList<>();
//       sqlQuery.append("select f.codigobanco, f.fechaventa, f.fechavencimiento, count (f.codigobanco) as facturas, sum(f.valortotal) as sumatotal from Factura f"
//               + "where f.codigocomercializadora = :codigocomercializadora" 
//            + " f.oeenpetro = :oeenpetro and"
//            + " f.activa = :activa and"
//            + " f.pagada = :pagada and "
//            + " f.fechaventa = :fechaventa"   
//            + "group by f.codigobanco, f.fechaventa, f.fechavencimiento"
//            + " order by f.codigobanco, f.fechaventa, f.fechavencimiento"
//
//        System.out.println("findMejorCliente FT:: "+ sqlQuery.toString());
//       try {
//            Query qry = this.em.createNativeQuery(sqlQuery.toString());
//            qry.setParameter("activo", activo);
//             
//             objetosList = qry.getResultList();
//
//            for (Object[] o : objetosList) {
//                MejorCliente mc = new MejorCliente();
//                mc.setNombrecliente(String.valueOf(o[0]));
//                mc.setFacturas(new Integer(String.valueOf(o[1])));
//                mc.setSumatotal(new BigDecimal(String.valueOf(o[2])));
//                lista.add(mc);
//            }
//            EjecucionMensaje succesMessage = new EjecucionMensaje();
//            succesMessage.setStatusCode(200);
//            succesMessage.setDeveloperMessage("ejecuciòn correcta");
//            succesMessage.setRetorno(lista);
//            return Response.status(200)
//                    .entity(succesMessage)
//                    .type(MediaType.APPLICATION_JSON).
//                    build();
//            
//        } catch (WebApplicationException ex) {
//            Response exResponse = ex.getResponse();
//            ErrorMessage errorMessage = new ErrorMessage(exResponse.getStatus(), ex.getMessage());
//            return Response.status(Response.Status.CONFLICT)
//                    .entity(errorMessage)
//                    .type(MediaType.APPLICATION_JSON).
//                    build();
//        }   
//    }
        
    public int buscarMaxCuota(String codigocomercializadora, long codigorubrotercero, String codigocliente, String tipocobro){
        int maxCuota = 0;
        
        Object objetosList;
        StringBuilder sqlQuery = new StringBuilder();
        List<MejorCliente> lista = new ArrayList<>();
       System.out.println("FT:: buscarMaxCuota parametros: comer "+ codigocomercializadora+" codigorubrotercero "+codigorubrotercero+" codigocliente "+codigocliente+ "tipocobro " +tipocobro);
       sqlQuery.append("select max(cuota) from public.cuotarubroterceros"
               + " where codigocomercializadora = :pcodigocomercializadora and codigorubrotercero = :pcodigorubrotercero and "
               + " codigocliente = :pcodigocliente and tipocobro = :ptipocobro");

        System.out.println("FT:: BUSCAR EL MAX DE CUOTAS TIPO FAC"+ sqlQuery.toString());
       try {
            Query qry = this.em.createNativeQuery(sqlQuery.toString());
            qry.setParameter("pcodigocomercializadora", codigocomercializadora);
           qry.setParameter("pcodigorubrotercero", codigorubrotercero);
           qry.setParameter("pcodigocliente", codigocliente);
           qry.setParameter("ptipocobro", tipocobro);
             
             objetosList = qry.getSingleResult();
           
                maxCuota = (new Integer(String.valueOf(objetosList))).intValue();
                
            return maxCuota + 1;
            
        } catch (Throwable ex) {
            System.out.println("FT:: ERROR-BUSCAR EL MAX DE CUOTAS TIPO FAC     Throwable. "+ex.getMessage());
            return maxCuota;
        }   
    }
    
}
