/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinityone.rest.servicios.service;

import ec.com.infinity.modelo.Listaprecioterminalproducto;
import ec.com.infinity.modelo.ListaprecioterminalproductoPK;
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
@Path("ec.com.infinity.modelo.listaprecioterminalproducto")
public class ListaprecioterminalproductoFacadeREST extends AbstractFacade<Listaprecioterminalproducto> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    private ListaprecioterminalproductoPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;codigocomercializadora=codigocomercializadoraValue;codigolistaprecio=codigolistaprecioValue;codigoterminal=codigoterminalValue;codigoproducto=codigoproductoValue;codigomedida=codigomedidaValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        ec.com.infinity.modelo.ListaprecioterminalproductoPK key = new ec.com.infinity.modelo.ListaprecioterminalproductoPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> codigocomercializadora = map.get("codigocomercializadora");
        if (codigocomercializadora != null && !codigocomercializadora.isEmpty()) {
            key.setCodigocomercializadora(codigocomercializadora.get(0));
        }
        java.util.List<String> codigolistaprecio = map.get("codigolistaprecio");
        if (codigolistaprecio != null && !codigolistaprecio.isEmpty()) {
            key.setCodigolistaprecio(codigolistaprecio.get(0));
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
        return key;
    }

    public ListaprecioterminalproductoFacadeREST() {
        super(Listaprecioterminalproducto.class);
    }

    @Override
    public Listaprecioterminalproducto create(Listaprecioterminalproducto entity) {
        return super.create(entity);
    }

    @Override
    public List<Listaprecioterminalproducto> findAll() {
        return super.findAll();
    }

    @Override
    public Listaprecioterminalproducto edit(Listaprecioterminalproducto entity) {
        super.edit(entity);
        return entity;
    }

    @POST
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response create1(Listaprecioterminalproducto entity) {
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
            @QueryParam("codigolistaprecio") String codigolistaprecio,
            @QueryParam("codigoterminal") String codigoterminal,
            @QueryParam("codigoproducto") String codigoproducto,
            @QueryParam("codigomedida") String codigomedida) {
        try {
            
            ListaprecioterminalproductoPK entity = new ListaprecioterminalproductoPK();
            entity.setCodigocomercializadora(codigocomercializadora);
            entity.setCodigolistaprecio(codigolistaprecio);
            entity.setCodigoterminal(codigoterminal);
            entity.setCodigoproducto(codigoproducto);
            entity.setCodigomedida(codigomedida);
            
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
    public Response edit1(Listaprecioterminalproducto entity) {
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
            @QueryParam("codigolistaprecio") String codigolistaprecio,
            @QueryParam("codigoterminal") String codigoterminal,
            @QueryParam("codigoproducto") String codigoproducto,
            @QueryParam("codigomedida") String codigomedida) {
        try {
            
            ListaprecioterminalproductoPK entity = new ListaprecioterminalproductoPK();
            entity.setCodigocomercializadora(codigocomercializadora);
            entity.setCodigolistaprecio(codigolistaprecio);
            entity.setCodigoterminal(codigoterminal);
            entity.setCodigoproducto(codigoproducto);
            entity.setCodigomedida(codigomedida);
            
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");
            List<Listaprecioterminalproducto> lst = new ArrayList<>();
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
            List<Listaprecioterminalproducto> lst = this.findAll();
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
    @Path("/paraPreciodos")
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response findPorProd(@QueryParam("codigocomercializadora") String codigocomercializadora, @QueryParam("codigoproducto") String codigoproducto,
                         @QueryParam("codigomedida") String codigomedida) {
        try {
            
            ListaprecioterminalproductoPK entity = new ListaprecioterminalproductoPK();
            entity.setCodigocomercializadora(codigocomercializadora);
            entity.setCodigoproducto(codigoproducto);
            entity.setCodigomedida(codigomedida);
            
            TypedQuery<Listaprecioterminalproducto> consulta = em.createNamedQuery("Listaprecioterminalproducto.paraPreciodos", Listaprecioterminalproducto.class);
            consulta.setParameter("codigocomercializadora", codigocomercializadora);
            consulta.setParameter("codigoproducto", codigoproducto);
            consulta.setParameter("codigomedida", codigomedida);            
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");
            List<Listaprecioterminalproducto> lst = new ArrayList<>();
            lst = consulta.getResultList();
            //lst.add(super.find(entity));
            //lst.add(clip.)
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
    @Path("/porLista")
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response findPorCodLista(@QueryParam("codigolistaprecio") String codigolistaprecio) {
        try {
            
            ListaprecioterminalproductoPK entity = new ListaprecioterminalproductoPK();
            entity.setCodigolistaprecio(codigolistaprecio);
            TypedQuery<Listaprecioterminalproducto> consulta = em.createNamedQuery("Listaprecioterminalproducto.findByCodigolistaprecio", Listaprecioterminalproducto.class);
            consulta.setParameter("codigolistaprecio", codigolistaprecio);
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");
            List<Listaprecioterminalproducto> lst = new ArrayList<>();
            lst = consulta.getResultList();
            //lst.add(super.find(entity));
            //lst.add(clip.)
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
    @Path("/paraPrecioUno")
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response findDiferenteTerminal(@QueryParam("codigocomercializadora") String codigocomercializadora, @QueryParam("codigoproducto") String codigoproducto,
                         @QueryParam("codigomedida") String codigomedida) {
        
        ListaprecioterminalproductoPK entity = new ListaprecioterminalproductoPK();
        Listaprecioterminalproducto entityPrincipal = new Listaprecioterminalproducto();
        
        List<Object[]> objetosList;
        StringBuilder sqlQuery = new StringBuilder();
        List<Listaprecioterminalproducto> lista = new ArrayList<>();
       sqlQuery.append("SELECT DISTINCT on(codigocomercializadora, codigolistaprecio, codigoproducto, codigomedida) codigocomercializadora, codigolistaprecio, codigoproducto, codigomedida, codigoterminal, margenporcentaje, margenvalorcomercializadora, usuarioactual")
               .append(" FROM public.listaprecioterminalproducto")
               .append(" where codigocomercializadora= :pcodigocomercializadora and codigoproducto = :pcodigoproducto and codigomedida = :pcodigomedida")
               .append(" order by codigoproducto");

        System.out.println("findMejorCliente FT:: "+ sqlQuery.toString());
       try {
            Query qry = this.em.createNativeQuery(sqlQuery.toString());
            qry.setParameter("pcodigocomercializadora", codigocomercializadora);
            qry.setParameter("pcodigoproducto", codigoproducto);
            qry.setParameter("pcodigomedida", codigomedida);
            //lista = qry.getResultList();
            objetosList = qry.getResultList();

            for (Object[] o : objetosList) {
                Listaprecioterminalproducto obj = new Listaprecioterminalproducto();
                ListaprecioterminalproductoPK objPk = new ListaprecioterminalproductoPK();
                objPk.setCodigocomercializadora(String.valueOf(o[0]));
                objPk.setCodigolistaprecio(String.valueOf(o[1]));
                objPk.setCodigoproducto(String.valueOf(o[2]));
                objPk.setCodigomedida(String.valueOf(o[3]));
                objPk.setCodigoterminal(String.valueOf(o[4]));
                obj.setListaprecioterminalproductoPK(objPk);
                BigDecimal valorAux = new BigDecimal(String.valueOf(o[5]));
                if (valorAux == new BigDecimal("-99")){
                    obj.setMargenporcentaje((BigDecimal)null);
                }else{
                     obj.setMargenporcentaje(valorAux);
                }
                valorAux = new BigDecimal(String.valueOf(o[6]));
                if (valorAux == new BigDecimal("-99")){
                    obj.setMargenvalorcomercializadora((BigDecimal)null);
                }else{
                     obj.setMargenvalorcomercializadora(valorAux);
                }
                obj.setUsuarioactual(String.valueOf(o[7]));
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
