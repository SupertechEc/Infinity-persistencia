/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinityone.rest.servicios.service;

import ec.com.infinity.modelo.Notapedido;
import ec.com.infinity.modelo.NotapedidoPK;
import ec.com.infinity.modelo2.NotaPedidoSOAP;
import ec.com.infinity.rest.seguridad.EjecucionMensaje;
import ec.com.infinity.rest.seguridad.ErrorMessage;
import ec.com.infinity.rest.seguridad.Secured;
import ec.com.infinityone.anulacion.AnulacionOEAbasPrv;
import ec.com.infinityone.anulacion.AnulacionOEAbasPrvService;
import ec.com.infinityone.envio.GeneracionOEAbasPrv;
import ec.com.infinityone.envio.GeneracionOEAbasPrvService;
import java.util.ArrayList;
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

/**
 *
 * @author Paul
 */
@Stateless
@Path("ec.com.infinity.modelo.notapedido")
public class NotapedidoFacadeREST extends AbstractFacade<Notapedido> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    private NotapedidoPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;codigoabastecedora=codigoabastecedoraValue;codigocomercializadora=codigocomercializadoraValue;numero=numeroValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        ec.com.infinity.modelo.NotapedidoPK key = new ec.com.infinity.modelo.NotapedidoPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> codigoabastecedora = map.get("codigoabastecedora");
        if (codigoabastecedora != null && !codigoabastecedora.isEmpty()) {
            key.setCodigoabastecedora(codigoabastecedora.get(0));
        }
        java.util.List<String> codigocomercializadora = map.get("codigocomercializadora");
        if (codigocomercializadora != null && !codigocomercializadora.isEmpty()) {
            key.setCodigocomercializadora(codigocomercializadora.get(0));
        }
        java.util.List<String> numero = map.get("numero");
        if (numero != null && !numero.isEmpty()) {
            key.setNumero(numero.get(0));
        }
        return key;
    }

    public NotapedidoFacadeREST() {
        super(Notapedido.class);
    }

    @Override
    public Notapedido create(Notapedido entity) {
        return super.create(entity);
    }

    @Override
    public List<Notapedido> findAll() {
        return super.findAll();
    }

    @Override
    public Notapedido edit(Notapedido entity) {
        super.edit(entity);
        return entity;
    }

    @POST
    @Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response create1(Notapedido entity) {
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
    public Response remove(Notapedido entity) {
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

    @PUT
    @Path("/porId")
    @Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response edit1(Notapedido entity) {
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
    public Response find(NotapedidoPK entity) {
        try {

            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");
            List<Notapedido> lst = new ArrayList<>();
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
            List<Notapedido> lst = this.findAll();
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
    @Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
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
    /*
    
     */

    @GET
    @Path("/envio")
    @Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response envio(NotaPedidoSOAP entity) {
        try {
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");

            NotapedidoPK key = new NotapedidoPK();
            key.setCodigoabastecedora(entity.getCodigoabastecedora());
            key.setCodigocomercializadora(entity.getCodigocomercializadora());
            key.setNumero(entity.getNumero());
            Notapedido agregar = null;
            agregar = super.find(key);
            if (agregar == null) {
                List<String> respuesta = new ArrayList<>();
                respuesta.add("no hay registro");
                succesMessage.setRetorno(respuesta);
                succesMessage.setStatusCode(400);

                return Response.status(200)
                        .entity(succesMessage)
                        .type(MediaType.APPLICATION_JSON).
                        build();
            } else {
                List<Notapedido> lst = new ArrayList<>();
                lst.add(agregar);
                Notapedido modificar = lst.get(0);
                modificar.setTramaenviadagoe(entity.getCadena());
                GeneracionOEAbasPrvService service = new GeneracionOEAbasPrvService();
                GeneracionOEAbasPrv port = service.getGeneracionOEAbasPrv();
                String arespuesta = port.generarOrdenEntrega(entity.getCadena());
                modificar.setRespuestageneracionoeepp(arespuesta);
                List<String> respuesta = new ArrayList<>();
                respuesta.add(arespuesta);
                super.edit(modificar);
                succesMessage.setRetorno(respuesta);
                return Response.status(200)
                        .entity(succesMessage)
                        .type(MediaType.APPLICATION_JSON).
                        build();
            }
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
    @Path("/cancelacion")
    @Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response anulacion(NotaPedidoSOAP entity) {
        try {
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");

            NotapedidoPK key = new NotapedidoPK();
            key.setCodigoabastecedora(entity.getCodigoabastecedora());
            key.setCodigocomercializadora(entity.getCodigocomercializadora());
            key.setNumero(entity.getNumero());
            Notapedido agregar = null;
            agregar = super.find(key);
            if (agregar == null) {
                List<String> respuesta = new ArrayList<>();
                respuesta.add("no hay registro");
                succesMessage.setRetorno(respuesta);
                succesMessage.setStatusCode(400);
                return Response.status(200)
                        .entity(succesMessage)
                        .type(MediaType.APPLICATION_JSON).
                        build();
            } else {
                List<Notapedido> lst = new ArrayList<>();
                lst.add(agregar);
                Notapedido modificar = lst.get(0);
                modificar.setTramaenviadagoe(entity.getCadena());
                AnulacionOEAbasPrvService service = new AnulacionOEAbasPrvService();
                AnulacionOEAbasPrv port = service.getAnulacionOEAbasPrv();
                String arespuesta = port.anularOrdenEntrega(entity.getCadena());
                modificar.setRespuestaanulacionoeepp(arespuesta);
                List<String> respuesta = new ArrayList<>();
                respuesta.add(arespuesta);
                super.edit(modificar);
                succesMessage.setRetorno(respuesta);
                return Response.status(200)
                        .entity(succesMessage)
                        .type(MediaType.APPLICATION_JSON).
                        build();
            }   //return JAXRSUtils.fromResponse(ex.getResponse()).entity(errorMessage).build();
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
