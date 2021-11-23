/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinityone.rest.servicios.service;

import ec.com.infinity.modelo.Comercializadoraproducto;
import ec.com.infinity.modelo.ComercializadoraproductoPK;
import ec.com.infinity.modelo.Listaprecio;
import ec.com.infinity.modelo.ListaprecioPK;
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
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Paul
 */
@Stateless
@Path("ec.com.infinity.modelo.comercializadoraproducto")
public class ComercializadoraproductoFacadeREST extends AbstractFacade<Comercializadoraproducto> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    private ComercializadoraproductoPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;codigocomercializadora=codigocomercializadoraValue;codigoproducto=codigoproductoValue;codigomedida=codigomedidaValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        ec.com.infinity.modelo.ComercializadoraproductoPK key = new ec.com.infinity.modelo.ComercializadoraproductoPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> codigocomercializadora = map.get("codigocomercializadora");
        if (codigocomercializadora != null && !codigocomercializadora.isEmpty()) {
            key.setCodigocomercializadora(codigocomercializadora.get(0));
        }
        java.util.List<String> codigoproducto = map.get("codigoproducto");
        if (codigoproducto != null && !codigoproducto.isEmpty()) {
            key.setCodigoproducto(codigoproducto.get(0));
        }
        java.util.List<String> codigomedida = map.get("codigomedida");
        if (codigomedida != null && !codigomedida.isEmpty()) {
            key.setCodigomedida(codigomedida.get(0));
        }
        return key;
    }

    public ComercializadoraproductoFacadeREST() {
        super(Comercializadoraproducto.class);
    }

    @Override
    public Comercializadoraproducto create(Comercializadoraproducto entity) {
        return super.create(entity);
    }

    @Override
    public List<Comercializadoraproducto> findAll() {
        return super.findAll();
    }

    @Override
    public Comercializadoraproducto edit(Comercializadoraproducto entity) {
        super.edit(entity);
        return entity;
    }

    @POST
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response create1(Comercializadoraproducto entity) {
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
            @QueryParam("codigoproducto") String codigoproducto,
            @QueryParam("codigomedida") String codigomedida) {
        try {
            
             ComercializadoraproductoPK entity = new ComercializadoraproductoPK();
            entity.setCodigocomercializadora(codigocomercializadora);
            entity.setCodigoproducto(codigoproducto);
            entity.setCodigomedida(codigomedida);
                
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
    public Response edit1(Comercializadoraproducto entity) {
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
            @QueryParam("codigoproducto") String codigoproducto,
            @QueryParam("codigomedida") String codigomedida) {
        try {
            
              ComercializadoraproductoPK entity = new ComercializadoraproductoPK();
            entity.setCodigocomercializadora(codigocomercializadora);
            entity.setCodigoproducto(codigoproducto);
            entity.setCodigomedida(codigomedida);
            
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");
            List<Comercializadoraproducto> lst = new ArrayList<>();
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
            List<Comercializadoraproducto> lst = this.findAll();
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
    @Path("/porComercializadora")
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response findXComer(@QueryParam("codigocomercializadora") String codigocomercializadora) {
        try {
            
            ComercializadoraproductoPK entity = new ComercializadoraproductoPK();
            entity.setCodigocomercializadora(codigocomercializadora);
 
                  
            TypedQuery<Comercializadoraproducto> consultaComerProd = em.createNamedQuery("Comercializadoraproducto.findByCodigocomercializadora", Comercializadoraproducto.class);
            consultaComerProd.setParameter("codigocomercializadora", codigocomercializadora);
            
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");
            List<Comercializadoraproducto> lst = new ArrayList<>();
            lst = consultaComerProd.getResultList();
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
    @Path("/sinListaP")
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response findSinListaPrecio(@QueryParam("codigocomercializadora") String codigocomercializadora, @QueryParam("codigolistaprecio") Long codigolistaprecio) {
        try {
            Comercializadoraproducto entity;
            ComercializadoraproductoPK entityPk;
            
            List<Object[]> objetosList;
            StringBuilder sqlQuery = new StringBuilder();
            List<Comercializadoraproducto> lista = new ArrayList<>();
            sqlQuery.append("SELECT c.* FROM Comercializadoraproducto as c "
                    + " where c.codigocomercializadora = :codigocomercializadora  and not exists (select l.codigoproducto "
                    + " from listaprecioterminalproducto  as l where l.codigoproducto = c.codigoproducto "
                    + " and l.codigocomercializadora = :codigocomercializadora "
                    + " and l.codigolistaprecio = :codigolistaprecio)");

            System.out.println("FT:: Buscar ProductosComer que NO estén en una listaPrecioTerminalProducto:. " + sqlQuery.toString());
            Query qry = this.em.createNativeQuery(sqlQuery.toString());
            qry.setParameter("codigocomercializadora", codigocomercializadora);
            qry.setParameter("codigolistaprecio", codigolistaprecio);
            objetosList = qry.getResultList();

            
            for (Object[] o : objetosList) {
                entity = new Comercializadoraproducto();
                entityPk = new ComercializadoraproductoPK();
                
                 entityPk.setCodigocomercializadora(String.valueOf(o[0]));
                 entityPk.setCodigoproducto(String.valueOf(o[1]));
                 entityPk.setCodigomedida(String.valueOf(o[2]));
                 entity.setComercializadoraproductoPK(entityPk);
                 entity.setActivo(new Boolean(String.valueOf(o[3])).booleanValue());
                 entity.setMargencomercializacion(new BigDecimal(String.valueOf(o[4])));
                 entity.setPrecioepp(new BigDecimal(String.valueOf(o[5])));
                 entity.setPvpsugerido(new BigDecimal(String.valueOf(o[6])));
                 entity.setSoloaplicaiva(new Boolean(String.valueOf(o[7])).booleanValue());
                 entity.setUsuarioactual(String.valueOf(o[8]));
                 entity.setProcesar(new Boolean(String.valueOf(o[9])).booleanValue());
                 lista.add(entity);
            }
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");
//            List<Comercializadoraproducto> lst = new ArrayList<>();
//            lst = consulta.getResultList();
            succesMessage.setRetorno(lista);
            System.out.println("FT:: Buscar ProductosComer que NO estén en una listaPrecioTerminalProducto OK!!:. " + lista.size());
            return Response.status(200)
                    .entity(succesMessage)
                    .type(MediaType.APPLICATION_JSON).
                    build();
            //return JAXRSUtils.fromResponse(ex.getResponse()).entity(errorMessage).build();
        } catch (WebApplicationException ex) {
            
            System.out.println("FT:: ERROR EN Buscar ProductosComer que NO estén en una listaPrecioTerminalProducto:." + ex.getMessage());
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
    @Path("/enListaP")
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response findEnListaPrecio(@QueryParam("codigocomercializadora") String codigocomercializadora, @QueryParam("codigolistaprecio") Long codigolistaprecio) {
        try {
            Comercializadoraproducto entity;
            ComercializadoraproductoPK entityPk;
            
            List<Object[]> objetosList;
            StringBuilder sqlQuery = new StringBuilder();
            List<Comercializadoraproducto> lista = new ArrayList<>();
            sqlQuery.append("SELECT c.* FROM Comercializadoraproducto as c "
                    + " where c.codigocomercializadora = :codigocomercializadora  and exists (select l.codigoproducto "
                    + " from listaprecioterminalproducto  as l where l.codigoproducto = c.codigoproducto "
                    + " and l.codigocomercializadora = :codigocomercializadora "
                    + " and l.codigolistaprecio = :codigolistaprecio)");

            System.out.println("FT:: Buscar ProductosComer que ESTÉN en una listaPrecioTerminalProducto:. " + sqlQuery.toString());
            Query qry = this.em.createNativeQuery(sqlQuery.toString());
            qry.setParameter("codigocomercializadora", codigocomercializadora);
            qry.setParameter("codigolistaprecio", codigolistaprecio);
            objetosList = qry.getResultList();

            
            for (Object[] o : objetosList) {
                entity = new Comercializadoraproducto();
                entityPk = new ComercializadoraproductoPK();
                
                 entityPk.setCodigocomercializadora(String.valueOf(o[0]));
                 entityPk.setCodigoproducto(String.valueOf(o[1]));
                 entityPk.setCodigomedida(String.valueOf(o[2]));
                 entity.setComercializadoraproductoPK(entityPk);
                 entity.setActivo(new Boolean(String.valueOf(o[3])).booleanValue());
                 entity.setMargencomercializacion(new BigDecimal(String.valueOf(o[4])));
                 entity.setPrecioepp(new BigDecimal(String.valueOf(o[5])));
                 entity.setPvpsugerido(new BigDecimal(String.valueOf(o[6])));
                 entity.setSoloaplicaiva(new Boolean(String.valueOf(o[7])).booleanValue());
                 entity.setUsuarioactual(String.valueOf(o[8]));
                 entity.setProcesar(new Boolean(String.valueOf(o[9])).booleanValue());
                 lista.add(entity);
            }
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");
//            List<Comercializadoraproducto> lst = new ArrayList<>();
//            lst = consulta.getResultList();
            succesMessage.setRetorno(lista);
            System.out.println("FT:: Buscar ProductosComer que ESTÉN en una listaPrecioTerminalProducto OK!!:. " + lista.size());
            return Response.status(200)
                    .entity(succesMessage)
                    .type(MediaType.APPLICATION_JSON).
                    build();
            //return JAXRSUtils.fromResponse(ex.getResponse()).entity(errorMessage).build();
        } catch (WebApplicationException ex) {
            
            System.out.println("FT:: ERROR EN Buscar ProductosComer que ESTÉN en una listaPrecioTerminalProducto:." + ex.getMessage());
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
