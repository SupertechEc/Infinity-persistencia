/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinityone.rest.servicios.service;

import ec.com.infinity.modelo.Fechafestiva;
import ec.com.infinity.modelo.FechafestivaPK;
import ec.com.infinity.rest.seguridad.EjecucionMensaje;
import ec.com.infinity.rest.seguridad.ErrorMessage;
import ec.com.infinity.rest.seguridad.Secured;
import ec.com.infinityone.rest.resources.CalendarioPco1;
import java.text.SimpleDateFormat;
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
@Path("ec.com.infinity.modelo.fechafestiva")
public class FechafestivaFacadeREST extends AbstractFacade<Fechafestiva> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    private FechafestivaPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;codigocomercializadora=codigocomercializadoraValue;codigo=codigoValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        ec.com.infinity.modelo.FechafestivaPK key = new ec.com.infinity.modelo.FechafestivaPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> codigocomercializadora = map.get("codigocomercializadora");
        if (codigocomercializadora != null && !codigocomercializadora.isEmpty()) {
            key.setCodigocomercializadora(codigocomercializadora.get(0));
        }
        java.util.List<String> codigo = map.get("codigocomercializadora");
        if (codigo != null && !codigo.isEmpty()) {
            key.setCodigocomercializadora(codigo.get(0));
        }
        return key;
    }

    public FechafestivaFacadeREST() {
        super(Fechafestiva.class);
    }

    @Override
    public Fechafestiva create(Fechafestiva entity) {
        return super.create(entity);
    }

    @Override
    public List<Fechafestiva> findAll() {
        return super.findAll();
    }

    @Override
    public Fechafestiva edit(Fechafestiva entity) {
        super.edit(entity);
        return entity;
    }

    @POST
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response create1(Fechafestiva entity) {
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
            @QueryParam("festivo") Date festivo) {
        try {
            FechafestivaPK entity = new FechafestivaPK ();
            entity.setCodigocomercializadora(codigocomercializadora);
            entity.setFestivo(festivo);
                    
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
    public Response edit1(Fechafestiva entity) {
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
            @QueryParam("festivo") Date festivo) {
        try {

            FechafestivaPK entity = new FechafestivaPK ();
            entity.setCodigocomercializadora(codigocomercializadora);
            entity.setFestivo(festivo);
            
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");
            List<Fechafestiva> lst = new ArrayList<>();
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
    @Path("/fechafinal")
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response findfechafinal(@QueryParam("codigocomercializadora") String codigocomercializadora, 
            @QueryParam("fechainicial") Date fechainicial,
            @QueryParam("tipoplazo") String tipoplazo,
            @QueryParam("plazo") int plazo) {
        
           List<Date> respuestaFechaFinal = new ArrayList<>();
           List<Fechafestiva> lst = new ArrayList<>();
           FechafestivaPK entity = new FechafestivaPK ();
           String feriados = new String();
           try {
            
            entity.setCodigocomercializadora(codigocomercializadora);
            entity.setFestivo(fechainicial);
            
            TypedQuery<Fechafestiva> consultaPorComer = em.createNamedQuery("Fechafestiva.findByCodigocomercializadora", Fechafestiva.class);
            consultaPorComer.setParameter("codigocomercializadora", codigocomercializadora);
            lst = consultaPorComer.getResultList();           
            //s="2021/7/7,2021/7/10,2021/7/15,/2/27,/3/1,/3/2,/3/3,/3/4";
            for (int i = 0; i < lst.size(); i++) {
            entity = lst.get(i).getFechafestivaPK();
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            StringBuilder sb = new StringBuilder();
            feriados = feriados + sdf.format(entity.getFestivo())+","; 
            }
            feriados = feriados.substring(0, (feriados.length()-1));
            System.out.println("FechafestivaFACADE.findfechafinal::feriados: "+feriados);
          } catch (Throwable ex) {
            lst = new ArrayList<>();
          }
                           
        java.sql.Date fechafinal = new java.sql.Date(System.currentTimeMillis());
        java.sql.Date fechaInicialSql = new java.sql.Date(fechainicial.getTime());
         Response exResponse;
        try{
        fechafinal = CalendarioPco1.calcularFechaFinal(fechaInicialSql, plazo, tipoplazo, feriados);
        System.out.println("FECHA: "+fechafinal); 
        respuestaFechaFinal.add(fechafinal);
         EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta: "+fechafinal); 
            succesMessage.setRetorno(respuestaFechaFinal); 
            return Response.status(200)
                    .entity(succesMessage)
                    .type(MediaType.APPLICATION_JSON).
                    build();
        }
        catch (Throwable ex){
            if (ex instanceof WebApplicationException){
            exResponse = ((WebApplicationException)ex).getResponse();
            }else{
            WebApplicationException error = new WebApplicationException();
            exResponse = error.getResponse();
            }
            System.out.println(" error " + ex.getMessage());
            //Response exResponse = ex.getResponse();
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
            List<Fechafestiva> lst = this.findAll();
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

    
    @GET
    @Path("/comer")
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response findXComer(@QueryParam("codigocomercializadora") String codigocomercializadora) {
        try {
                             
            TypedQuery<Fechafestiva> consulta = em.createNamedQuery("Fechafestiva.findByCodigocomercializadora", Fechafestiva.class);
            consulta.setParameter("codigocomercializadora", codigocomercializadora);
            
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");
            List<Fechafestiva> lst = new ArrayList<>();
            lst = consulta.getResultList();
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
