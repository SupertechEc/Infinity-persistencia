/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinityone.rest.servicios.service;

import ec.com.infinity.modelo.Temporalparacobrar;
import ec.com.infinity.modelo.TemporalparacobrarPK;
import ec.com.infinity.modelo.TotalParaCobrar;
import ec.com.infinity.rest.seguridad.EjecucionMensaje;
import ec.com.infinity.rest.seguridad.ErrorMessage;
import ec.com.infinity.rest.seguridad.Secured;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Paul
 */
@Stateless
@Path("ec.com.infinity.modelo.temporalparacobrar")
public class TemporalparacobrarFacadeREST extends AbstractFacade<Temporalparacobrar> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    public TemporalparacobrarFacadeREST() {
        super(Temporalparacobrar.class);
    }

    @Override
    public Temporalparacobrar create(Temporalparacobrar entity) {
        return super.create(entity);
    }

    @Override
    public List<Temporalparacobrar> findAll() {
        return super.findAll();
    }

    @Override
    public Temporalparacobrar edit(Temporalparacobrar entity) {
        super.edit(entity);
        return entity;
    }

    @POST
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response create1(Temporalparacobrar entity) {
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
    public Response remove(Temporalparacobrar entity) {
        try {

            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");
            super.remove(entity);
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
    public Response edit1(Temporalparacobrar entity) {
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
    public Response find(@QueryParam("fechahoraproceso") String fechahoraproceso, 
            @QueryParam("usuarioactual") String usuarioactual,
            @QueryParam("codigocomercializadora") String codigocomercializadora,
            @QueryParam("numerofactura") String numerofactura
            ) {
            TemporalparacobrarPK entity = new TemporalparacobrarPK();
            entity.setFechahoraproceso(fechahoraproceso);
            entity.setUsuarioactual(usuarioactual);
            entity.setCodigocomercializadora(codigocomercializadora);
            entity.setNumerofactura(numerofactura);
        try {

            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");
            List<Temporalparacobrar> lst = new ArrayList<>();
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
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");
            List<Temporalparacobrar> lst = this.findAll();
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
    
    @POST
    @Path("/deleteporUsuarioProceso")
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response deletePorUsuarioFechahora(@QueryParam("fechahoraproceso") String fechahoraproceso, 
            @QueryParam("usuarioactual") String usuarioactual,
            @QueryParam("codigocomercializadora") String codigocomercializadora) {
        int resQuery = 0;
        try {

            StringBuilder sqlQuery = new StringBuilder();
            sqlQuery.append("DELETE FROM Temporalparacobrar t WHERE t.fechahoraproceso = :fechahoraproceso "
                    + "and t.usuarioactual = :usuarioactual "
                    + "and t.codigocomercializadora = :codigocomercializadora");

            System.out.println("deletePorUsuarioFechahora-query FT:: " + sqlQuery.toString());

            Query qry = this.em.createNativeQuery(sqlQuery.toString());
            qry.setParameter("fechahoraproceso", fechahoraproceso);
            qry.setParameter("usuarioactual", usuarioactual);
            qry.setParameter("codigocomercializadora", codigocomercializadora);

            resQuery = qry.executeUpdate();
                         
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");
            List<Integer> lst = new ArrayList<>();
            lst.add(resQuery);
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
    @Path("/Totalparacobrar")  
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response findTotalParaCobrar(@QueryParam("fechahoraproceso") String fechahoraproceso, 
            @QueryParam("usuarioactual") String usuarioactual,
            @QueryParam("codigocomercializadora") String codigocomercializadora) {
        
     List<Object[]> objetosList;
        
        StringBuilder sqlQuery = new StringBuilder();
          List<TotalParaCobrar> lista = new ArrayList<>();
        sqlQuery.append("select codigobanco, fechavencimiento, count(*) as cantidadFacturas, sum(valortotal) as sumaTotal " +
        "from temporalparacobrar where fechahoraproceso = :fechahoraproceso and " +
        "usuarioactual = :usuarioactual AND codigocomercializadora = :codigocomercializadora " +
        "group by usuarioactual, codigocomercializadora, codigobanco, fechavencimiento " +
        "ORDER BY codigobanco, fechavencimiento");

        System.out.println("TotalParaCobrar FT:: "+ sqlQuery.toString());
       try {
            Query qry = this.em.createNativeQuery(sqlQuery.toString());
            qry.setParameter("fechahoraproceso", fechahoraproceso);
            qry.setParameter("usuarioactual", usuarioactual);
            qry.setParameter("codigocomercializadora", codigocomercializadora);
            
            objetosList = qry.getResultList();

            for (Object[] o : objetosList) {
                TotalParaCobrar obj = new TotalParaCobrar();
                obj.setBanco(String.valueOf(o[0]));
                obj.setFechavencimiento(String.valueOf(o[1]));
                obj.setFacturas(new Integer(String.valueOf(o[2])));
                obj.setValortotal(new BigDecimal(String.valueOf(o[3])));
                
                lista.add(obj);
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
}
