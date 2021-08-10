/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinityone.rest.servicios.service;

import ec.com.infinity.modelo.Precio;
import ec.com.infinity.modelo.PrecioPK;
import ec.com.infinity.rest.seguridad.EjecucionMensaje;
import ec.com.infinity.rest.seguridad.ErrorMessage;
import ec.com.infinity.rest.seguridad.Secured;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
@Path("ec.com.infinity.modelo.precio")
public class PrecioFacadeREST extends AbstractFacade<Precio> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

   
    public PrecioFacadeREST() {
        super(Precio.class);
    }

    @Override
    public Precio create(Precio entity) {
        return super.create(entity);
    }

    @Override
    public List<Precio> findAll() {
        return super.findAll();
    }

    @Override
    public Precio edit(Precio entity) {
        super.edit(entity);
        return entity;
    }

    @POST
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response create1(Precio entity) {
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
    public Response remove(@QueryParam("codigocomercializadora") String codigocomercializadora, 
            @QueryParam("codigoterminal") String codigoterminal,
            @QueryParam("codigoproducto") String codigoproducto,
            @QueryParam("codigomedida") String codigomedida,
            @QueryParam("codigolistaprecio") String codigolistaprecio,
            @QueryParam("fechainicio") Date fechainicio,
            @QueryParam("secuencial") int secuencial,
            @QueryParam("codigoPrecio") String codigoPrecio) {
        try {
            
            PrecioPK  entity = new PrecioPK();
            entity.setCodigocomercializadora(codigocomercializadora);
            entity.setCodigoterminal(codigoterminal);
            entity.setCodigoproducto(codigoproducto);
            entity.setCodigomedida(codigomedida);
            entity.setCodigolistaprecio(codigolistaprecio);
            entity.setFechainicio(fechainicio);
            entity.setSecuencial(secuencial);
            entity.setCodigoPrecio(codigoPrecio);
            
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
    public Response edit1(Precio entity) {
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
    public Response find(@QueryParam("codigocomercializadora") String codigocomercializadora, 
            @QueryParam("codigoterminal") String codigoterminal,
            @QueryParam("codigoproducto") String codigoproducto,
            @QueryParam("codigomedida") String codigomedida,
            @QueryParam("codigolistaprecio") String codigolistaprecio,
            @QueryParam("fechainicio") Date fechainicio,
            @QueryParam("secuencial") int secuencial,
            @QueryParam("codigoPrecio") String codigoPrecio) {
        try {
            
            PrecioPK  entity = new PrecioPK();
            entity.setCodigocomercializadora(codigocomercializadora);
            entity.setCodigoterminal(codigoterminal);
            entity.setCodigoproducto(codigoproducto);
            entity.setCodigomedida(codigomedida);
            entity.setCodigolistaprecio(codigolistaprecio);
            entity.setFechainicio(fechainicio);
            entity.setSecuencial(secuencial);
            entity.setCodigoPrecio(codigoPrecio);
            
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");
            List<Precio> lst = new ArrayList<>();
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
    public Response findparafactura(@QueryParam("codigocomercializadora") String codigocomercializadora, 
            @QueryParam("codigoterminal") String codigoterminal,
            @QueryParam("codigoproducto") String codigoproducto,
            @QueryParam("codigomedida") String codigomedida,
            @QueryParam("fechainicio") Date fechainicio,
            @QueryParam("codigolistaprecio") String codigolistaprecio) {
        try {
            
            PrecioPK  entity = new PrecioPK();
            entity.setCodigocomercializadora(codigocomercializadora);
            entity.setCodigoterminal(codigoterminal);
            entity.setCodigoproducto(codigoproducto);
            entity.setCodigomedida(codigomedida);
            entity.setCodigolistaprecio(codigolistaprecio);
            entity.setFechainicio(fechainicio);             
            TypedQuery<Precio> consultaPrecioParafacturar = em.createNamedQuery("Precio.findForFactura", Precio.class);
            consultaPrecioParafacturar.setParameter("codigocomercializadora", codigocomercializadora);
            consultaPrecioParafacturar.setParameter("codigoterminal", codigoterminal);
            consultaPrecioParafacturar.setParameter("codigoproducto", codigoproducto);
            consultaPrecioParafacturar.setParameter("codigomedida", codigomedida);
            consultaPrecioParafacturar.setParameter("codigolistaprecio", codigolistaprecio);
            consultaPrecioParafacturar.setParameter("fechainicio", fechainicio);
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");
            List<Precio> lst = new ArrayList<>();
            lst = consultaPrecioParafacturar.getResultList();
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
    @Path("/porComerEstado")
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response findComerEstado(@QueryParam("codigocomercializadora") String codigocomercializadora, 
            @QueryParam("activo") boolean activo) {
        try {
            
            PrecioPK  entity = new PrecioPK();
            Precio entityPrincipal = new Precio();
            entity.setCodigocomercializadora(codigocomercializadora);
            entityPrincipal.setActivo(activo);             
            TypedQuery<Precio> consultaPrecioParaConsulta = em.createNamedQuery("Precio.findByCodigocomercializadoraYEstado", Precio.class);
            consultaPrecioParaConsulta.setParameter("codigocomercializadora", codigocomercializadora);
            consultaPrecioParaConsulta.setParameter("activo", activo); 
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");
            List<Precio> lst = new ArrayList<>();
            lst = consultaPrecioParaConsulta.getResultList();
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
            succesMessage.setDeveloperMessage("ejecución correcta");
            List<Precio> lst = this.findAll();
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
