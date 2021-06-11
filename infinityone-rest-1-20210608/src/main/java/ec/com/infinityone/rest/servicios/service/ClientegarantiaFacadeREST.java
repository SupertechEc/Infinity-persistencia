/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinityone.rest.servicios.service;

import ec.com.infinity.modelo.Clientegarantia;
import ec.com.infinity.modelo.ClientegarantiaPK;
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
@Path("ec.com.infinity.modelo.clientegarantia")
public class ClientegarantiaFacadeREST extends AbstractFacade<Clientegarantia> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    private ClientegarantiaPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;codigocomercializadora=codigocomercializadoraValue;codigocliente=codigoclienteValue;codigobanco=codigobancoValue;numero=numeroValue;secuencial=secuencialValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        ec.com.infinity.modelo.ClientegarantiaPK key = new ec.com.infinity.modelo.ClientegarantiaPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> codigocomercializadora = map.get("codigocomercializadora");
        if (codigocomercializadora != null && !codigocomercializadora.isEmpty()) {
            key.setCodigocomercializadora(codigocomercializadora.get(0));
        }
        java.util.List<String> codigocliente = map.get("codigocliente");
        if (codigocliente != null && !codigocliente.isEmpty()) {
            key.setCodigocliente(codigocliente.get(0));
        }
        java.util.List<String> codigobanco = map.get("codigobanco");
        if (codigobanco != null && !codigobanco.isEmpty()) {
            key.setCodigobanco(codigobanco.get(0));
        }
        java.util.List<String> numero = map.get("numero");
        if (numero != null && !numero.isEmpty()) {
            key.setNumero(numero.get(0));
        }
        java.util.List<String> secuencial = map.get("secuencial");
        if (secuencial != null && !secuencial.isEmpty()) {
            key.setSecuencial(new java.lang.Integer(secuencial.get(0)));
        }
        return key;
    }

    public ClientegarantiaFacadeREST() {
        super(Clientegarantia.class);
    }

    @Override
    public Clientegarantia create(Clientegarantia entity) {
        return super.create(entity);
    }

    @Override
    public List<Clientegarantia> findAll() {
        return super.findAll();
    }

    @Override
    public Clientegarantia edit(Clientegarantia entity) {
        super.edit(entity);
        return entity;
    }

    @POST
    @Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response create1(Clientegarantia entity) {
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
    @Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response remove(@QueryParam("codigocomercializadora") String codigocomercializadora, 
            @QueryParam("codigocliente") String codigocliente,
            @QueryParam("codigobanco") String codigobanco,
            @QueryParam("numero") String numero,
            @QueryParam("secuencial") String secuencial
            ) {
        try {
            //Clientegarantia entityP = new Clientegarantia();
            ClientegarantiaPK entity = new ClientegarantiaPK();
            entity.setCodigocomercializadora(codigocomercializadora);
            entity.setCodigocliente(codigocliente);
            entity.setCodigobanco(codigobanco);
            entity.setNumero(numero);
            entity.setSecuencial(Integer.parseInt(secuencial));
            
            //entityP.setClientegarantiaPK(entity);
            
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
    @Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response edit1(Clientegarantia entity) {
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
    @Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response find(@QueryParam("codigocomercializadora") String codigocomercializadora, 
            @QueryParam("codigocliente") String codigocliente,
            @QueryParam("codigobanco") String codigobanco,
            @QueryParam("numero") String numero,
            @QueryParam("secuencial") String secuencial) {
        try {
            
            ClientegarantiaPK entity = new ClientegarantiaPK();
            entity.setCodigocomercializadora(codigocomercializadora);
            entity.setCodigocliente(codigocliente);
            entity.setCodigobanco(codigobanco);
            entity.setNumero(numero);
            entity.setSecuencial(Integer.parseInt(secuencial));
            
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");
            List<Clientegarantia> lst = new ArrayList<>();
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
    @Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response findAll2() {
        try {
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");
            List<Clientegarantia> lst = this.findAll();
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
    @Secured
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
