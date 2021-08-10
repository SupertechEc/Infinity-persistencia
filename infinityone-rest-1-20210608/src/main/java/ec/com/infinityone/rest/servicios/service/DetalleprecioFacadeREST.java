/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinityone.rest.servicios.service;

import ec.com.infinity.modelo.Detalleprecio;
import ec.com.infinity.modelo.DetalleprecioPK;
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
@Path("ec.com.infinity.modelo.detalleprecio")
public class DetalleprecioFacadeREST extends AbstractFacade<Detalleprecio> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    private DetalleprecioPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;codigocomercializadora=codigocomercializadoraValue;codigoterminal=codigoterminalValue;codigoproducto=codigoproductoValue;codigomedida=codigomedidaValue;codigolistaprecio=codigolistaprecioValue;fechainicio=fechainicioValue;secuencial=secuencialValue;codigo=codigoValue;codigogravamen=codigogravamenValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        ec.com.infinity.modelo.DetalleprecioPK key = new ec.com.infinity.modelo.DetalleprecioPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> codigocomercializadora = map.get("codigocomercializadora");
        if (codigocomercializadora != null && !codigocomercializadora.isEmpty()) {
            key.setCodigocomercializadora(codigocomercializadora.get(0));
        }
        java.util.List<String> codigoterminal = map.get("codigoterminal");
        if (codigoterminal != null && !codigoterminal.isEmpty()) {
            key.setCodigoterminal(codigoterminal.get(0));
        }
        java.util.List<String> codigoproducto = map.get("codigoproducto");
        if (codigoproducto != null && !codigoproducto.isEmpty()) {
            key.setCodigoproducto(codigoproducto.get(0));
        }
        java.util.List<String> codigomedida = map.get("codigomedida");
        if (codigomedida != null && !codigomedida.isEmpty()) {
            key.setCodigomedida(codigomedida.get(0));
        }
        java.util.List<String> codigolistaprecio = map.get("codigolistaprecio");
        if (codigolistaprecio != null && !codigolistaprecio.isEmpty()) {
            key.setCodigolistaprecio(codigolistaprecio.get(0));
        }
        java.util.List<String> fechainicio = map.get("fechainicio");
        if (fechainicio != null && !fechainicio.isEmpty()) {
            key.setFechainicio(new java.util.Date(fechainicio.get(0)));
        }
        java.util.List<String> secuencial = map.get("secuencial");
        if (secuencial != null && !secuencial.isEmpty()) {
            key.setSecuencial(new java.lang.Integer(secuencial.get(0)));
        }
        java.util.List<String> codigo = map.get("codigo");
        if (codigo != null && !codigo.isEmpty()) {
            key.setCodigo(codigo.get(0));
        }
        java.util.List<String> codigogravamen = map.get("codigogravamen");
        if (codigogravamen != null && !codigogravamen.isEmpty()) {
            key.setCodigogravamen(codigogravamen.get(0));
        }
        return key;
    }

    public DetalleprecioFacadeREST() {
        super(Detalleprecio.class);
    }

    @Override
    public Detalleprecio create(Detalleprecio entity) {
        return super.create(entity);
    }

    @Override
    public List<Detalleprecio> findAll() {
        return super.findAll();
    }

    @Override
    public Detalleprecio edit(Detalleprecio entity) {
        super.edit(entity);
        return entity;
    }

    @POST
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response create1(Detalleprecio entity) {
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
            @QueryParam("codigo") String codigo,
             @QueryParam("codigogravamen") String codigogravamen) {
        try {
            
            DetalleprecioPK  entity = new DetalleprecioPK();
            entity.setCodigocomercializadora(codigocomercializadora);
            entity.setCodigoterminal(codigoterminal);
            entity.setCodigoproducto(codigoproducto);
            entity.setCodigomedida(codigomedida);
            entity.setCodigolistaprecio(codigolistaprecio);
            entity.setFechainicio(fechainicio);
            entity.setSecuencial(secuencial);
            entity.setCodigo(codigo);
            entity.setCodigogravamen(codigogravamen);
            
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
    public Response edit1(Detalleprecio entity) {
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
            @QueryParam("codigo") String codigo,
             @QueryParam("codigogravamen") String codigogravamen) {
        try {
            
            DetalleprecioPK  entity = new DetalleprecioPK();
            entity.setCodigocomercializadora(codigocomercializadora);
            entity.setCodigoterminal(codigoterminal);
            entity.setCodigoproducto(codigoproducto);
            entity.setCodigomedida(codigomedida);
            entity.setCodigolistaprecio(codigolistaprecio);
            entity.setFechainicio(fechainicio);
            entity.setSecuencial(secuencial);
            entity.setCodigo(codigo);
            entity.setCodigogravamen(codigogravamen);
                        
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");
            List<Detalleprecio> lst = new ArrayList<>();
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
    public Response findparafactura(@QueryParam("codigo") String codigo) {
        try {
            
            DetalleprecioPK  entity = new DetalleprecioPK();
               
            entity.setCodigo(codigo); 
                    
            TypedQuery<Detalleprecio> consultaDetallePrecioParafacturar = em.createNamedQuery("Detalleprecio.findByCodigo", Detalleprecio.class);
            consultaDetallePrecioParafacturar.setParameter("codigo", codigo);
             
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");
            List<Detalleprecio> lst = new ArrayList<>();
            lst = consultaDetallePrecioParafacturar.getResultList();
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
            succesMessage.setDeveloperMessage("ejecución correcta");
            List<Detalleprecio> lst = this.findAll();
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
