/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinityone.rest.servicios.service;

import ec.com.infinity.modelo.Numeracion;
import ec.com.infinity.rest.seguridad.EjecucionMensaje;
import ec.com.infinity.rest.seguridad.ErrorMessage;
import ec.com.infinity.rest.seguridad.Secured;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
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
import javax.ws.rs.core.Response;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Paul
 */
@Stateless
@Path("ec.com.infinity.modelo.numeracion")

public class NumeracionFacadeREST extends AbstractFacade<Numeracion> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    public NumeracionFacadeREST() {
        super(Numeracion.class);
    }

    public Numeracion generarNumero(String tipodocumento, String codigocomercializadora) { //tipodocumento codigocomercializadora
        String queryStr = "SELECT t FROM Numeracion t WHERE t.tipodocumento='"
                + tipodocumento + "' and t.codigocomercializadora='" + codigocomercializadora + "'";
        TypedQuery<Numeracion> query = em.createQuery(queryStr, Numeracion.class);
        return query.getResultList().get(0);
    }

    @Override
    public Numeracion create(Numeracion entity) {
        return super.create(entity);
    }

    @Override
    public List<Numeracion> findAll() {
        return super.findAll();
    }

    @Override
    public Numeracion edit(Numeracion entity) {
        super.edit(entity);
        return entity;
    }

    @POST
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response create1(Numeracion entity) {
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
    public Response remove(@QueryParam("id") Long id) {
        try {
            super.remove(id); 
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
    public Response edit1(Numeracion entity) {
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
    public Response find(@QueryParam("id") Long id) {
        try {

            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");
            List<Numeracion> lst = new ArrayList<>();
            lst.add(super.find(id)); 
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
            List<Numeracion> lst = this.findAll();
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
    public Response findRange(@PathParam("from") Integer from, @PathParam("to") Integer to
    ) {
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

    public Numeracion consulta(String tipodocumento, String codigo) {
        String queryStr = "SELECT t FROM Numeracion t WHERE t.tipodocumento='"
                + tipodocumento + "' and t.codigocomercializadora='" + codigo + "'";
        //         bloqueo.getTransaction().begin();
        TypedQuery<Numeracion> query = em.createQuery(queryStr, Numeracion.class);
        Numeracion respuestaNumeracion = query.getResultList().get(0);
        return respuestaNumeracion;
    }
    
    @POST
    @Path("/agregar")  
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response crearAutonumerado(Numeracion entity) {
        
        StringBuilder sqlQuery = new StringBuilder();
       
       sqlQuery.append("INSERT INTO public.numeracion (" +
       "codigocomercializadora, " +
       " tipodocumento" +
       ", activo" +
       ", ultimonumero" +
       ", version" + 
       ", usuarioactual)" +
       " values (:pcodigocomercializadora, :ptipodocumento, :pactivo, :pultimonumero, :pversion, :pusuarioactual)");
       
        System.out.println("INSERTAR NUMERCION FT:: "+ sqlQuery.toString());
       try {
            Query qry = this.em.createNativeQuery(sqlQuery.toString());
            qry.setParameter("pcodigocomercializadora", entity.getCodigocomercializadora().getCodigo());
            qry.setParameter("ptipodocumento", entity.getTipodocumento().trim().toUpperCase());
            qry.setParameter("pactivo", entity.getActivo());
            qry.setParameter("pultimonumero", entity.getUltimonumero());
            qry.setParameter("pversion", entity.getVersion());
            qry.setParameter("pusuarioactual", entity.getUsuarioactual());
             
             qry.executeUpdate();
  
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("Inserción correcta");
            
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
    
}
