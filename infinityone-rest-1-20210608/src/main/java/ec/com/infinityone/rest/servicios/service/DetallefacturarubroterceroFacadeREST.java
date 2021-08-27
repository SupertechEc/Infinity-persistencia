/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinityone.rest.servicios.service;

import ec.com.infinity.modelo.Detallefacturarubrotercero;
import ec.com.infinity.modelo.DetallefacturarubroterceroPK;
import ec.com.infinity.rest.seguridad.EjecucionMensaje;
import ec.com.infinity.rest.seguridad.ErrorMessage;
import ec.com.infinity.rest.seguridad.Secured;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
@Path("ec.com.infinity.modelo.detallefacturarubrotercero")
public class DetallefacturarubroterceroFacadeREST extends AbstractFacade<Detallefacturarubrotercero> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;
    
    private DetallefacturarubroterceroPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;codigoabastecedora=codigoabastecedoraValue;codigocomercializadora=codigocomercializadoraValue;numeronotapedido=numeronotapedidoValue;numero=numeroValue;codigoproducto=codigoproductoValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        ec.com.infinity.modelo.DetallefacturarubroterceroPK key = new ec.com.infinity.modelo.DetallefacturarubroterceroPK();
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
            key.setNumerofactura(numero.get(0));
        }
        java.util.List<String> codigorubrotercero = map.get("codigorubrotercero");
        if (codigorubrotercero != null && !codigorubrotercero.isEmpty()) {
            key.setCodigorubrotercero(new Long(codigorubrotercero.get(0)).longValue());
        }
        java.util.List<String> codigoclientecuota = map.get("codigoclientecuota");
        if (codigoclientecuota != null && !codigoclientecuota.isEmpty()) {
            key.setCodigoclientecuota(codigoclientecuota.get(0));
        }
        java.util.List<String> cuota = map.get("cuota");
        if (cuota != null && !cuota.isEmpty()) {
            key.setCuota(new Integer(cuota.get(0)).intValue());
        }
        return key;
    }

    public DetallefacturarubroterceroFacadeREST() {
        super(Detallefacturarubrotercero.class);
    }

    @Override
    public Detallefacturarubrotercero create(Detallefacturarubrotercero entity) {
        return super.create(entity);
    }

    @Override
    public List<Detallefacturarubrotercero> findAll() {
        return super.findAll(); 
    }

    @Override
    public Detallefacturarubrotercero edit(Detallefacturarubrotercero entity) {
        super.edit(entity);
        return entity;
    }

    @POST
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response create1(Detallefacturarubrotercero entity) {
        try {
            this.create(entity);

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
            @QueryParam("numeronotapedido") String numeronotapedido,
            @QueryParam("numero") String numero,
            @QueryParam("codigorubrotercero") long codigorubrotercero, 
            @QueryParam("codigoclientecuota") String codigoclientecuota,
            @QueryParam("cuota") int cuota) {
        try {
                
            DetallefacturarubroterceroPK  entity = new DetallefacturarubroterceroPK();
            entity.setCodigoabastecedora(codigoabastecedora);
            entity.setCodigocomercializadora(codigocomercializadora);
            entity.setNumeronotapedido(numeronotapedido);
            entity.setNumerofactura(numero);
            entity.setCodigorubrotercero(codigorubrotercero);
            entity.setCodigoclientecuota(codigoclientecuota);
            entity.setCuota(cuota);
                    
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            super.remove(entity);
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
    public Response edit1(Detallefacturarubrotercero entity) {
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
            @QueryParam("numero") String numero,
            @QueryParam("codigorubrotercero") long codigorubrotercero, 
            @QueryParam("codigoclientecuota") String codigoclientecuota,
            @QueryParam("cuota") int cuota) {
        try {

            DetallefacturarubroterceroPK  entity = new DetallefacturarubroterceroPK();
            entity.setCodigoabastecedora(codigoabastecedora);
            entity.setCodigocomercializadora(codigocomercializadora);
            entity.setNumeronotapedido(numeronotapedido);
            entity.setNumerofactura(numero);
            entity.setCodigorubrotercero(codigorubrotercero);
            entity.setCodigoclientecuota(codigoclientecuota);
            entity.setCuota(cuota);
            
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");
            List<Detallefacturarubrotercero> lst = new ArrayList<>();
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
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response findAll2() {
        try {
            System.out.println("GET-FINDALL2::");
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");
            List<Detallefacturarubrotercero> lst = this.findAll();
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

}
