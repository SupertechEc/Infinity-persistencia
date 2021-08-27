/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinityone.rest.servicios.service;

import ec.com.infinity.modelo.Cuotarubroterceros;
import ec.com.infinity.modelo.CuotarubrotercerosPK;
import ec.com.infinity.modelo.Precio;
import ec.com.infinity.modelo.PrecioPK;
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
import javax.ws.rs.core.PathSegment;
import ec.com.infinity.rest.seguridad.EjecucionMensaje;
import ec.com.infinity.rest.seguridad.ErrorMessage;
import ec.com.infinity.rest.seguridad.Secured;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;

/**
 *
 * @author Fernando Tapia
 */
@Stateless
@Path("ec.com.infinity.modelo.cuotarubroterceros")
public class CuotarubrotercerosFacadeREST1 extends AbstractFacade<Cuotarubroterceros> {
    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    private CuotarubrotercerosPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;codigocomercializadora=codigocomercializadoraValue;codigo=codigoValue;codigocliente=codigoclienteValue;cuota=cuotaValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        ec.com.infinity.modelo.CuotarubrotercerosPK key = new ec.com.infinity.modelo.CuotarubrotercerosPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> codigocomercializadora = map.get("codigocomercializadora");
        if (codigocomercializadora != null && !codigocomercializadora.isEmpty()) {
            key.setCodigocomercializadora(codigocomercializadora.get(0));
        }
        java.util.List<String> codigorubrotercero = map.get("codigorubrotercero");
        if (codigorubrotercero != null && !codigorubrotercero.isEmpty()) {
            key.setCodigorubrotercero(new java.lang.Long(codigorubrotercero.get(0)));
        }
        java.util.List<String> codigocliente = map.get("codigocliente");
        if (codigocliente != null && !codigocliente.isEmpty()) {
            key.setCodigocliente(codigocliente.get(0));
        }
        java.util.List<String> cuota = map.get("cuota");
        if (cuota != null && !cuota.isEmpty()) {
            key.setCuota(new java.lang.Integer(cuota.get(0)));
        }
        return key;
    }

    public CuotarubrotercerosFacadeREST1() {
        super(Cuotarubroterceros.class);
    }

    //@POST
    @Override
    //@Consumes({"application/xml", "application/json"})
    public Cuotarubroterceros create(Cuotarubroterceros entity) {
        return super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") PathSegment id, Cuotarubroterceros entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        ec.com.infinity.modelo.CuotarubrotercerosPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Cuotarubroterceros find(@PathParam("id") PathSegment id) {
        ec.com.infinity.modelo.CuotarubrotercerosPK key = getPrimaryKey(id);
        return super.find(key);
    }

   // @GET
    @Override
    //@Produces({"application/xml", "application/json"})
    public List<Cuotarubroterceros> findAll() {
        return super.findAll();
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
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
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
            List<Cuotarubroterceros> lst = this.findAll();
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
    @Path("/porId")
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response find( CuotarubrotercerosPK entity) {
        try {

            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");
            List<Cuotarubroterceros> lst = new ArrayList<>();
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
    
     @PUT
    @Path("/porId")
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response edit1(Cuotarubroterceros entity) {
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
    
     @DELETE
    @Path("/porId")
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response remove(Cuotarubroterceros entity) {
        try {

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
    
     @POST
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response create1(Cuotarubroterceros entity) {
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
            //ErrorMessage errorMessage = new ErrorMessage(exResponse.getStatus(), ex.getMessage());
            //return JAXRSUtils.fromResponse(ex.getResponse()).entity(errorMessage).build();
            return Response.status(ex.getResponse().getStatus())
                    .entity(errorMessage)
                    .type(MediaType.APPLICATION_JSON).
                    build();
        }
    }
    
      @Override
    public Cuotarubroterceros edit(Cuotarubroterceros entity) {
        super.edit(entity);
        return entity;
    }

    
    @GET
    @Path("/paraCobrar")
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response findParaCobrar(@QueryParam("codigocomercializadora") String codigocomercializadora, 
            @QueryParam("codigocliente") String codigocliente,
            @QueryParam("fechaventa") Date fechaventa) {
        try {
            
            
            List<Object[]> objetosList;
            StringBuilder sqlQuery = new StringBuilder();
            List<Cuotarubroterceros> lista = new ArrayList<>();
            
            // DEBE BUSCAR CUOTAS DE CLIENTERUBROS ACTIVOS
            
//            SELECT c.* FROM Cuotarubroterceros c, clienterubrotercero cl WHERE 
//             cl.codigocomercializadora = c.codigocomercializadora
//             and cl.codigorubrotercero = c.codigorubrotercero
//				and cl.codigocliente = c.codigocliente 
//             and c. codigocliente = '02010001' 
//              and cl.activo = true
//           and c.pagada = FALSE
//           and c. tipocobro = 'LIB'
//		   and c.fechainiciocobro <= '2021-10-05'
//           and c.fechacobro <= '2021-10-05'
//           --order by fechacobro  limit 1
//           UNION
//           SELECT c.* FROM Cuotarubroterceros c, clienterubrotercero cl WHERE 
//            cl.codigocomercializadora = c.codigocomercializadora
//            and cl.codigorubrotercero = c.codigorubrotercero
//            and cl.codigocliente = c.codigocliente 
//             and c. codigocliente = '02010001' 
//             and cl.activo = true
//           and c.pagada = FALSE
//           and c. tipocobro = 'MEN'
//		   and c.fechainiciocobro <= '2021-10-05'
//           and c.fechacobro <= '2021-10-05'
//           order by fechacobro  limit 2
//            
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
                qry.setParameter("pcodigocomercializadora", codigocomercializadora);
                qry.setParameter("pcodigocliente", codigocliente);
                qry.setParameter("pfecha", fechaventa);
                lista = qry.getResultList();
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");
            succesMessage.setRetorno(lista);
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
    @Path("/comercli")
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response findXComerCli(@QueryParam("codigocomercializadora") String codigocomercializadora, @QueryParam("codigocliente") String codigocliente, @QueryParam("codigorubrotercero") long codigorubrotercero) {
        try {
            System.out.println("FT::findXComerCli");
            CuotarubrotercerosPK entity = new CuotarubrotercerosPK();
            entity.setCodigocomercializadora(codigocomercializadora);
 
            TypedQuery<Cuotarubroterceros> consulta = em.createNamedQuery("Cuotarubroterceros.findByComerCli", Cuotarubroterceros.class);
            consulta.setParameter("codigocomercializadora", codigocomercializadora);            
            consulta.setParameter("codigocliente", codigocliente);
            consulta.setParameter("codigorubrotercero", codigorubrotercero);
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");
            List<Cuotarubroterceros> lst = new ArrayList<>();
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
