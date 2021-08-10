/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinityone.rest.servicios.service;

import ec.com.infinity.modelo.Consultagarantia;
import ec.com.infinity.modelo.ConsultagarantiaPK;
import ec.com.infinity.modelo2.ParametrosSOAP;
import ec.com.infinity.rest.seguridad.EjecucionMensaje;
import ec.com.infinity.rest.seguridad.ErrorMessage;
import ec.com.infinity.rest.seguridad.Secured;
import ec.com.infinityone.consultagarantia.ConsultaGarantia;
import ec.com.infinityone.consultagarantia.ConsultaGarantiaExecute;
import ec.com.infinityone.consultagarantia.ConsultaGarantiaExecuteResponse;
import ec.com.infinityone.consultagarantia.ConsultaGarantiaSoapPort;
import java.math.BigDecimal;
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

/**
 *
 * @author Paul
 */
@Stateless
@Path("ec.com.infinity.modelo.consultagarantia")
public class ConsultagarantiaFacadeREST extends AbstractFacade<Consultagarantia> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    private ConsultagarantiaPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;codigocomercializadora=codigocomercializadoraValue;fecharecepcion=fecharecepcionValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        ec.com.infinity.modelo.ConsultagarantiaPK key = new ec.com.infinity.modelo.ConsultagarantiaPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> codigocomercializadora = map.get("codigocomercializadora");
        if (codigocomercializadora != null && !codigocomercializadora.isEmpty()) {
            key.setCodigocomercializadora(codigocomercializadora.get(0));
        }
        java.util.List<String> fecharecepcion = map.get("fecharecepcion");
        if (fecharecepcion != null && !fecharecepcion.isEmpty()) {
            key.setFecharecepcion(new java.util.Date(fecharecepcion.get(0)));
        }
        return key;
    }

    public ConsultagarantiaFacadeREST() {
        super(Consultagarantia.class);
    }

    @Override
    public Consultagarantia create(Consultagarantia entity) {
        return super.create(entity);
    }

    @Override
    public List<Consultagarantia> findAll() {
        return super.findAll();
    }

    @Override
    public Consultagarantia edit(Consultagarantia entity) {
        super.edit(entity);
        return entity;
    }

    @POST
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response create1(Consultagarantia entity) {
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
    public Response remove(Consultagarantia entity) {
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
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response edit1(Consultagarantia entity) {
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
    public Response find(ConsultagarantiaPK entity) {
        try {

            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");
            List<Consultagarantia> lst = new ArrayList<>();
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

    @POST
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @Path("/actualizacion")
    public Response consultaSOAPGarantia(ParametrosSOAP parametros) {
        try {
            System.out.println("FT:: consultaSOAPGarantia");
            ConsultaGarantiaExecute paramWS = new ConsultaGarantiaExecute();
            ConsultaGarantiaExecuteResponse respuesta = new ConsultaGarantiaExecuteResponse();

            paramWS.setCgccodcom((short) parametros.getCbtcodcom());
            paramWS.setClave(parametros.getClave());
            respuesta = execute(paramWS);
            List<ConsultaGarantiaExecuteResponse> lst = new ArrayList<>();
            lst.add(respuesta);
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");
            Consultagarantia entity = new Consultagarantia();
            ConsultagarantiaPK entityPk = new ConsultagarantiaPK();
            entityPk.setCodigocomercializadora(parametros.getCodigoComercializadora());
            entityPk.setFecharecepcion(new Date());
            entity.setConsultagarantiaPK(entityPk);
            entity.setActivo(true);
            entity.setUsuarioactual("EPPETROECUADOR");
            entity.setCodigomoneda("" + respuesta.getGarantia().getCGCUNIMON());
            entity.setGarantia98(new BigDecimal(respuesta.getGarantia().getGarantia98()));
            entity.setPorcentajeuso(new BigDecimal(respuesta.getGarantia().getPorcentajeUso()));
            entity.setSaldo(new BigDecimal(respuesta.getGarantia().getCGCSALDO()));
            entity.setSaldodisponible(new BigDecimal(respuesta.getGarantia().getSaldoDisponible()));
            entity.setSumaavalizada(new BigDecimal(respuesta.getGarantia().getCGCSUMAVA()));
            entity.setValorcomercializadora(new BigDecimal(respuesta.getGarantia().getCGCVALCOM()));

            List<Consultagarantia> lstConsulta = findAll();
            if (lstConsulta != null) {
                lstConsulta.stream().map((tmp) -> {
                    tmp.setActivo(false);
                    return tmp;
                }).forEach((tmp) -> {
                    super.edit(tmp);
                });
            }
            super.create(entity);
            succesMessage.setRetorno(selectActivo());

            return Response.status(200)
                    .entity(succesMessage)
                    .type(MediaType.APPLICATION_JSON).
                    build();
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

    private ConsultaGarantiaExecuteResponse execute(ConsultaGarantiaExecute parameters) {
        ConsultaGarantia service = new ConsultaGarantia();
        ConsultaGarantiaSoapPort port = service.getConsultaGarantiaSoapPort();
        return port.execute(parameters);
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
            List<Consultagarantia> lst = this.findAll();
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

    public List<Consultagarantia> selectActivo() {
        String queryStr = "SELECT t FROM Consultagarantia t WHERE t.activo='true'";
        TypedQuery<Consultagarantia> query = em.createQuery(queryStr, Consultagarantia.class);
        return query.getResultList();
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
