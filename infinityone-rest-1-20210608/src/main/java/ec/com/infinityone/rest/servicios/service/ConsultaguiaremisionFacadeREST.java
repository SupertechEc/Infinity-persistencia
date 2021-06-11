/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinityone.rest.servicios.service;

import ec.com.infinity.modelo.Consultaguiaremision;
import ec.com.infinity.modelo.ConsultaguiaremisionPK;
import ec.com.infinity.modelo2.ParametrosSOAP;
import ec.com.infinity.rest.seguridad.EjecucionMensaje;
import ec.com.infinity.rest.seguridad.ErrorMessage;
import ec.com.infinity.rest.seguridad.Secured;
import ec.com.infinityone.consultagarantia.ConsultaGuias;
import ec.com.infinityone.consultagarantia.ConsultaGuiasExecute;
import ec.com.infinityone.consultagarantia.ConsultaGuiasExecuteResponse;
import ec.com.infinityone.consultagarantia.ConsultaGuiasSoapPort;
import ec.com.infinityone.consultagarantia.SDTGuiasComercializadora;
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
@Path("ec.com.infinity.modelo.consultaguiaremision")
public class ConsultaguiaremisionFacadeREST extends AbstractFacade<Consultaguiaremision> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    private ConsultaguiaremisionPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;codigocomercializadora=codigocomercializadoraValue;numero=numeroValue;fecha=fechaValue;fecharecepcion=fecharecepcionValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        ec.com.infinity.modelo.ConsultaguiaremisionPK key = new ec.com.infinity.modelo.ConsultaguiaremisionPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> codigocomercializadora = map.get("codigocomercializadora");
        if (codigocomercializadora != null && !codigocomercializadora.isEmpty()) {
            key.setCodigocomercializadora(codigocomercializadora.get(0));
        }
        java.util.List<String> numero = map.get("numero");
        if (numero != null && !numero.isEmpty()) {
            key.setNumero(numero.get(0));
        }
        java.util.List<String> fecha = map.get("fecha");
        if (fecha != null && !fecha.isEmpty()) {
            key.setFecha(fecha.get(0));
        }
        java.util.List<String> fecharecepcion = map.get("fecharecepcion");
        if (fecharecepcion != null && !fecharecepcion.isEmpty()) {
            key.setFecharecepcion(new java.util.Date(fecharecepcion.get(0)));
        }
        return key;
    }

    public ConsultaguiaremisionFacadeREST() {
        super(Consultaguiaremision.class);
    }

    @Override
    public Consultaguiaremision create(Consultaguiaremision entity) {
        return super.create(entity);
    }

    @Override
    public List<Consultaguiaremision> findAll() {
        return super.findAll();
    }

    @Override
    public Consultaguiaremision edit(Consultaguiaremision entity) {
        super.edit(entity);
        return entity;
    }

    @POST
    @Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response create1(Consultaguiaremision entity) {
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
    public Response remove(Consultaguiaremision entity) {
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
    public Response edit1(Consultaguiaremision entity) {
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
    public Response find(ConsultaguiaremisionPK entity) {
        try {

            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");
            List<Consultaguiaremision> lst = new ArrayList<>();
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
            List<Consultaguiaremision> lst = this.findAll();
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

    @GET
    @Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @Path("/actualizacion")
    public Response consultaSOAPGarantia(ParametrosSOAP parametros) {
        List<Consultaguiaremision> lstGuardar = new ArrayList<>();
        try {
            ConsultaGuiasExecute paramWS = new ConsultaGuiasExecute();
            ConsultaGuiasExecuteResponse respuesta = new ConsultaGuiasExecuteResponse();
            paramWS.setCbtcodcom((short)parametros.getCbtcodcom());
            paramWS.setClave(parametros.getClave());
            paramWS.setCbtfecemi(parametros.getCbtfecemi());
            paramWS.setCbtcoddep(new Byte(parametros.getCbtcoddep()));
            respuesta = execute(paramWS);

            for (SDTGuiasComercializadora tmp : respuesta.getGuias().getSDTGuiasComercializadora()) {
                Consultaguiaremision entity = new Consultaguiaremision();
                ConsultaguiaremisionPK entityPk = new ConsultaguiaremisionPK();
                entityPk.setCodigocomercializadora(parametros.getCodigoComercializadora());
                entityPk.setFecharecepcion(new Date());
                entityPk.setFecha("" + tmp.getCBTFECEMI());
                entity.setConsultaguiaremisionPK(entityPk);
                entity.setActivo(true);
                entityPk.setNumero("" + tmp.getCBTNUMCBT());
                entity.setAutotanque(tmp.getAUTPLAAUT());
                entity.setCodigoareamercadeo("" + tmp.getCBTARMERC());
                entity.setCodigomedida("" + tmp.getCBTUNIMED());
                entity.setCodigoproducto("" + tmp.getCBTCODPRO());
                entity.setCodigoterminal("" + paramWS.getCbtcoddep());
                entity.setEstado("ACT");
                entity.setMedida("" + tmp.getUMENOMABR());
                entity.setNumerooe("" + tmp.getCBTNUMORE());
                entity.setProducto("" + tmp.getCPRNOMPRO());
                entity.setUsuarioactual("EPPETROECUADOR");
                entity.setVolumenentregado(new BigDecimal(tmp.getCBTVOLENT()));
                lstGuardar.add(entity);
            }

            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");
            List<Consultaguiaremision> lstConsulta = findAll();
            if (lstConsulta != null) {

                lstConsulta.stream().map((tmp) -> {
                    tmp.setActivo(false);
                    return tmp;
                }).forEach((tmp) -> {
                    super.edit(tmp);
                });
            }

            lstGuardar.stream().forEach((tmp) -> {
                super.create(tmp);
            });

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

    public List<Consultaguiaremision> selectActivo() {
        String queryStr = "SELECT t FROM Consultaguiaremision t WHERE t.activo='true'";
        TypedQuery<Consultaguiaremision> query = em.createQuery(queryStr, Consultaguiaremision.class);
        return query.getResultList();
    }

    private ConsultaGuiasExecuteResponse execute(ConsultaGuiasExecute parameters) {
        ConsultaGuias service = new ConsultaGuias();
        ConsultaGuiasSoapPort port = service.getConsultaGuiasSoapPort();
        return port.execute(parameters);
    }
}
