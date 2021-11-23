/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinityone.rest.servicios.service; 

import ec.com.infinity.modelo.Detallenotapedido;
import ec.com.infinity.modelo.Notapedido;
import ec.com.infinity.modelo.NotapedidoPK;
import ec.com.infinity.modelo.Numeracion;
import ec.com.infinity.modelo2.EnvioPedidoREST;
import ec.com.infinity.modelo2.NotaPedidoSOAP;
import ec.com.infinity.rest.seguridad.EjecucionMensaje;
import ec.com.infinity.rest.seguridad.ErrorMessage;
import ec.com.infinity.rest.seguridad.Secured;
import ec.com.infinityone.anulacion.AnulacionOEAbasPrv;
import ec.com.infinityone.anulacion.AnulacionOEAbasPrvService;
import ec.com.infinityone.envio.GeneracionOEAbasPrv;
import ec.com.infinityone.envio.GeneracionOEAbasPrvService;
import ec.com.infinityone.rest.resources.GeneradorTramasOE;
import java.math.BigDecimal;
import java.net.URL;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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

/**
 *
 * @author Paul
 */
@Stateless
@Path("ec.com.infinity.modelo.notapedido")
public class NotapedidoFacadeREST extends AbstractFacade<Notapedido> {

    @EJB
    private NumeracionFacadeREST servicioNumeracion;

    @EJB
    private DetallenotapedidoFacadeREST servicioDetalleNP;

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager bloqueo;

    private NotapedidoPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;codigoabastecedora=codigoabastecedoraValue;codigocomercializadora=codigocomercializadoraValue;numero=numeroValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        ec.com.infinity.modelo.NotapedidoPK key = new ec.com.infinity.modelo.NotapedidoPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> codigoabastecedora = map.get("codigoabastecedora");
        if (codigoabastecedora != null && !codigoabastecedora.isEmpty()) {
            key.setCodigoabastecedora(codigoabastecedora.get(0));
        }
        java.util.List<String> codigocomercializadora = map.get("codigocomercializadora");
        if (codigocomercializadora != null && !codigocomercializadora.isEmpty()) {
            key.setCodigocomercializadora(codigocomercializadora.get(0));
        }
        java.util.List<String> numero = map.get("numero");
        if (numero != null && !numero.isEmpty()) {
            key.setNumero(numero.get(0));
        }
        return key;
    }

    public NotapedidoFacadeREST() {
        super(Notapedido.class);
    }

    @Override
    public Notapedido create(Notapedido entity) {
        return super.create(entity);
    }

    @Override
    public List<Notapedido> findAll() {
        return super.findAll();
    }

    @Override
    public Notapedido edit(Notapedido entity) {
        super.edit(entity);
        return entity;
    }

    @POST
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
//    public Response create1(Notapedido entity) {
    public Response create1(EnvioPedidoREST entity) {
        String tipodocumento = "NPE";
        try {
            Numeracion respuestaNumeracion = new Numeracion();
            try{
                respuestaNumeracion = servicioNumeracion.consulta(tipodocumento, entity.getNotapedido().getComercializadora().getCodigo());
            }catch(Throwable x){
                throw new WebApplicationException(x);
            }
            bloqueo.lock(respuestaNumeracion, LockModeType.PESSIMISTIC_WRITE);
            
            DecimalFormat df = new DecimalFormat("000000");
            
            int numeracion = respuestaNumeracion.getUltimonumero() + 1;
            String numeroNPE = (df.format(new BigDecimal(numeracion)));
           
            entity.getNotapedido().getNotapedidoPK().setNumero(entity.getNotapedido().getPrefijo()+ numeroNPE);

            super.createS(entity.getNotapedido());

            Detallenotapedido notapedidoDetalle = new Detallenotapedido();
            notapedidoDetalle = entity.getDetalle();
            notapedidoDetalle.getDetallenotapedidoPK().setCodigoabastecedora(entity.getNotapedido().getNotapedidoPK().getCodigoabastecedora());
            notapedidoDetalle.getDetallenotapedidoPK().setCodigocomercializadora(entity.getNotapedido().getComercializadora().getCodigo());
            notapedidoDetalle.getDetallenotapedidoPK().setNumero(entity.getNotapedido().getNotapedidoPK().getNumero());
            servicioDetalleNP.createS(notapedidoDetalle);
  
            respuestaNumeracion.setUltimonumero(numeracion);
            getServicioNumeracion().edit(respuestaNumeracion);
            //bloqueo.getTransaction().commit();
            //bloqueo.close();

            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            //succesMessage.setDeveloperMessage("ejecuciÃ³n correcta");
            succesMessage.setDeveloperMessage(entity.getNotapedido().getNotapedidoPK().getNumero());

            return Response.status(200)
                    .entity(succesMessage)
                    .type(MediaType.APPLICATION_JSON).
                    build();

            //return JAXRSUtils.fromResponse(ex.getResponse()).entity(errorMessage).build();
        } catch (WebApplicationException ex) {
            Response exResponse = ex.getResponse();
            ErrorMessage errorMessage = new ErrorMessage(exResponse.getStatus(), ex.getMessage());
            //return JAXRSUtils.fromResponse(ex.getResponse()).entity(errorMessage).build();
            return Response.status(ex.getResponse().getStatus())
                    .entity(errorMessage)
                    .type(MediaType.APPLICATION_JSON).
                    build();
        }
    }

    @DELETE
    @Path("/porId")
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response remove(@QueryParam("codigoabastecedora") String codigoabastecedora, 
            @QueryParam("codigocomercializadora") String codigocomercializadora,
            @QueryParam("numero") String numero) {
        try {
            
            NotapedidoPK entity = new NotapedidoPK();
            entity.setCodigoabastecedora(codigoabastecedora);
            entity.setCodigocomercializadora(codigocomercializadora);
            entity.setNumero(numero);
            
            super.remove(entity);
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecuciÃ³n correcta");
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
    public Response edit1(Notapedido entity) {
        try {
            this.edit(entity);
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecuciÃ³n correcta");
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
            @QueryParam("numero") String numero) {
        try {

            NotapedidoPK entity = new NotapedidoPK();
            entity.setCodigoabastecedora(codigoabastecedora);
            entity.setCodigocomercializadora(codigocomercializadora);
            entity.setNumero(numero);
            
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecuciÃ³n correcta");
            List<Notapedido> lst = new ArrayList<>();
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
    public Response find(@QueryParam("codigoabastecedora") String codigoabastecedora, 
            @QueryParam("codigocomercializadora") String codigocomercializadora, 
            @QueryParam("codigoterminal") String codigoterminal,
            @QueryParam("tipofecha") String tipofecha,  
            @QueryParam("fecha") Date fecha) {
        try {

            NotapedidoPK entity = new NotapedidoPK();
            entity.setCodigoabastecedora(codigoabastecedora);
            entity.setCodigocomercializadora(codigocomercializadora);
            //entity.setNumero(numero);
            List<Notapedido> lst = new ArrayList<>();
            //List<EnvioPedidoRest> lst = new ArrayList<>();
            
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
                
                TypedQuery<Notapedido> consultaPorFVenta = em.createNamedQuery("Notapedido.findForVenta", Notapedido.class);
                consultaPorFVenta.setParameter("codigoabastecedora", codigoabastecedora);
                consultaPorFVenta.setParameter("codigocomercializadora", codigocomercializadora);
                consultaPorFVenta.setParameter("codigoterminal", codigoterminal);
                //consultaPorAbastecedora.setParameter("tipofecha", tipofecha);
                consultaPorFVenta.setParameter("fecha", fecha);
                
                /*TypedQuery<Notapedido> consultaPorAbastecedora = em.createNamedQuery("Notapedido.findForVenta", Notapedido.class);
                //TypedQuery<Notapedido> consultaPorAbastecedora = em.createQuery("SELECT * FROM Notapedido n join Detallenotapeido d on n.numero = d.numero WHERE n.notapedidoPK.codigoabastecedora = :codigoabastecedora and n.notapedidoPK.codigocomercializadora = :codigocomercializadora and n.codigoterminal.codigo = :codigoterminal and n.fechaventa = :fecha");
                consultaPorAbastecedora.setParameter("codigoabastecedora", codigoabastecedora);
                consultaPorAbastecedora.setParameter("codigocomercializadora", codigocomercializadora);
                consultaPorAbastecedora.setParameter("codigoterminal", codigoterminal);
                //consultaPorAbastecedora.setParameter("tipofecha", tipofecha);
                consultaPorAbastecedora.setParameter("fecha", fecha);*/
                lst = consultaPorFVenta.getResultList();
            }else {
                System.out.println("2");
                TypedQuery<Notapedido> consultaPorFDespacho = em.createNamedQuery("Notapedido.findForDespacho", Notapedido.class);
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
            //lst.add(super.find(entity));
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

      @POST
    @Path("/tramaOE") 
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"}) 
    public Response find(@QueryParam("nfactura") String nfactura, 
            @QueryParam("clave") String clave, EnvioPedidoREST entity) {
        try {
            
            String tramaResp = "-";
            GeneradorTramasOE generadorOE = new GeneradorTramasOE();
            tramaResp = generadorOE.generarTramaEnvioOE(entity, nfactura, clave);
            System.out.println("Trama: "+tramaResp);
            
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("Trama: OK!");
            List<String> lst = new ArrayList<>();
            lst.add(tramaResp);
            //lst.add(super.find(entity));
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
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response findAll2() {
        try {
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecuciÃ³n correcta");
            List<Notapedido> lst = this.findAll();
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
    /*
    
     */

    @POST
    @Path("/envio")
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response envio(NotaPedidoSOAP entity) {
        try {
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");

            NotapedidoPK key = new NotapedidoPK();
            key.setCodigoabastecedora(entity.getCodigoabastecedora());
            key.setCodigocomercializadora(entity.getCodigocomercializadora());
            key.setNumero(entity.getNumero());
            Notapedido agregar = null;
            agregar = super.find(key);
            if (agregar == null) {
                List<String> respuesta = new ArrayList<>();
                respuesta.add("no hay registro");
                succesMessage.setRetorno(respuesta);
                succesMessage.setStatusCode(400);

                return Response.status(400)
                        .entity(succesMessage)
                        .type(MediaType.APPLICATION_JSON).
                        build();
            } else {
                List<Notapedido> lst = new ArrayList<>();
                lst.add(agregar);
                Notapedido modificar = lst.get(0);
                modificar.setTramaenviadagoe(entity.getCadena());
                //GeneracionOEAbasPrvService service = new GeneracionOEAbasPrvService();
                URL nuevaUrl = new URL("http://190.152.15.66/SCI_WS_GOEA_SrvPrv/services/GeneracionOEAbasPrv?wsdl");
                GeneracionOEAbasPrvService service = new GeneracionOEAbasPrvService(nuevaUrl);
                GeneracionOEAbasPrv port = service.getGeneracionOEAbasPrv();
                String arespuesta = port.generarOrdenEntrega(entity.getCadena());
                modificar.setRespuestageneracionoeepp(arespuesta.substring(0, 2));//2 primeros caracteres
                modificar.setTramarecibidagoe(arespuesta);
                List<String> respuesta = new ArrayList<>();
                respuesta.add(arespuesta);
                super.edit(modificar);
                succesMessage.setRetorno(respuesta);
                return Response.status(200)
                        .entity(succesMessage)
                        .type(MediaType.APPLICATION_JSON).
                        build();
            }
        } catch (Throwable ex) {
            System.out.println("FT::ERROR EN NotaPedidoSOAP::envio "+ex.getMessage()+" -Causa-. "+ex.getCause().getMessage());
            
            //Response exResponse = ex.getResponse();
            ErrorMessage errorMessage = new ErrorMessage(555, ex.getCause().getMessage());
            //return JAXRSUtils.fromResponse(ex.getResponse()).entity(errorMessage).build();
            return Response.status(Response.Status.CONFLICT)
                    .entity(errorMessage)
                    .type(MediaType.APPLICATION_JSON).
                    build();

        }
    }

    @POST
    @Path("/cancelacion")
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response anulacion(NotaPedidoSOAP entity) {
        try {
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");

            NotapedidoPK key = new NotapedidoPK();
            key.setCodigoabastecedora(entity.getCodigoabastecedora());
            key.setCodigocomercializadora(entity.getCodigocomercializadora());
            key.setNumero(entity.getNumero());
            Notapedido agregar = null;
            agregar = super.find(key);
            if (agregar == null) {
                List<String> respuesta = new ArrayList<>();
                respuesta.add("no hay registro");
                succesMessage.setRetorno(respuesta);
                succesMessage.setStatusCode(400);
                return Response.status(200)
                        .entity(succesMessage)
                        .type(MediaType.APPLICATION_JSON).
                        build();
            } else {
                List<Notapedido> lst = new ArrayList<>();
                lst.add(agregar);
                Notapedido modificar = lst.get(0);
                modificar.setTramarenviadaaoe(entity.getCadena());
                AnulacionOEAbasPrvService service = new AnulacionOEAbasPrvService();
                AnulacionOEAbasPrv port = service.getAnulacionOEAbasPrv();
                String arespuesta = port.anularOrdenEntrega(entity.getCadena());
                modificar.setRespuestaanulacionoeepp(arespuesta.substring(0, 2));//2 primeros caracteres
                modificar.setTramarecibidaaoe(arespuesta);
                List<String> respuesta = new ArrayList<>();
                respuesta.add(arespuesta);
                super.edit(modificar);
                succesMessage.setRetorno(respuesta);
                return Response.status(200)
                        .entity(succesMessage)
                        .type(MediaType.APPLICATION_JSON).
                        build();
            }   //return JAXRSUtils.fromResponse(ex.getResponse()).entity(errorMessage).build();
        } catch (Throwable ex) {
             System.out.println("FT::ERROR EN NotaPedidoSOAP::Cancelación "+ex.getMessage()+" -Causa-. "+ex.getCause().getMessage());
            
            //Response exResponse = ex.getResponse();
            ErrorMessage errorMessage = new ErrorMessage(555, ex.getCause().getMessage());
            return Response.status(Response.Status.CONFLICT)
                    .entity(errorMessage)
                    .type(MediaType.APPLICATION_JSON).
                    build();
        }
    }

    /**
     * @return the bloqueo
     */
    public EntityManager getBloqueo() {
        return bloqueo;
    }

    /**
     * @param bloqueo the bloqueo to set
     */
    public void setBloqueo(EntityManager bloqueo) {
        this.bloqueo = bloqueo;
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
     * @return the servicioDetalleNP
     */
    public DetallenotapedidoFacadeREST getServicioDetalleNP() {
        return servicioDetalleNP;
    }

    /**
     * @param servicioDetalleNP the servicioDetalleNP to set
     */
    public void setServicioDetalleNP(DetallenotapedidoFacadeREST servicioDetalleNP) {
        this.servicioDetalleNP = servicioDetalleNP;
    }
    
    @GET
    @Path("/Comerterminal")  
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response findComerTerminal(@QueryParam("codigocomercializadora") String codigocomercializadora, 
            @QueryParam("codigoterminal") String codigoterminal) {
        try {
            List<Notapedido> lst = new ArrayList<>();
            TypedQuery<Notapedido> consulta = em.createNamedQuery("Notapedido.findByComerterminal", Notapedido.class);

            consulta.setParameter("codigocomercializadora", codigocomercializadora);
            consulta.setParameter("codigoterminal", codigoterminal);

            lst = consulta.getResultList();
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecuciòn correcta");
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
        
}
