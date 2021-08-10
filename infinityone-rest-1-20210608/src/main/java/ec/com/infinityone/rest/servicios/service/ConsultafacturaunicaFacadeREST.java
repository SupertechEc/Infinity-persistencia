/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinityone.rest.servicios.service;

import ec.com.infinity.consultaFacturas.ConsultaFactura;
import ec.com.infinity.consultaFacturas.ConsultaFacturaExecute;
import ec.com.infinity.consultaFacturas.ConsultaFacturaExecuteResponse;
import ec.com.infinity.consultaFacturas.ConsultaFacturaSoapPort;
import ec.com.infinity.consultaFacturas.SDTFacturaProducto;
import ec.com.infinity.consultaFacturas.SDTFacturaProductoProductoFactura;
import ec.com.infinity.modelo.Consultafacturaunica;
import ec.com.infinity.modelo.Detalleconsultafacturaunica;
import ec.com.infinity.modelo2.GuardarFactura;
import ec.com.infinity.modelo2.ParametrosSOAP;
import ec.com.infinity.rest.seguridad.EjecucionMensaje;
import ec.com.infinity.rest.seguridad.ErrorMessage;
import ec.com.infinity.rest.seguridad.Secured;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
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
@Path("ec.com.infinity.modelo.consultafacturaunica")
public class ConsultafacturaunicaFacadeREST extends AbstractFacade<Consultafacturaunica> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;
    @EJB
    private DetalleconsultafacturaunicaFacadeREST servicioDetalleFac;

    public ConsultafacturaunicaFacadeREST() {
        super(Consultafacturaunica.class);
    }

    @Override
    public Consultafacturaunica create(Consultafacturaunica entity) {
        return super.create(entity);
    }

    @Override
    public List<Consultafacturaunica> findAll() {
        return super.findAll();
    }

    @Override
    public Consultafacturaunica edit(Consultafacturaunica entity) {
        super.edit(entity);
        return entity;
    }

    @POST
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response create1(Consultafacturaunica entity) {
        try {
            this.create(entity);

            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecuciÃ³n correcta");
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
    public Response remove(Consultafacturaunica entity) {
        try {

            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecuciÃ³n correcta");
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
    public Response edit1(Consultafacturaunica entity) {
        try {
            this.edit(entity);
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecuciÃ³n correcta");
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
    public Response find(Consultafacturaunica entity) {
        try {

            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");
            List<Consultafacturaunica> lst = new ArrayList<>();
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
            succesMessage.setDeveloperMessage("ejecuciÃ³n correcta");
            List<Consultafacturaunica> lst = this.findAll();
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
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @Path("/actualizacion")
    public Response consultaSOAPGarantia(ParametrosSOAP parametros) {
        try {
            ConsultaFacturaExecute paramWS = new ConsultaFacturaExecute();
            ConsultaFacturaExecuteResponse respuesta = new ConsultaFacturaExecuteResponse();

            paramWS.setFaucodcom((short) parametros.getCbtcodcom());
            paramWS.setClave(parametros.getClave());
            paramWS.setFaufecven(parametros.getCbtfecemi());
            respuesta = execute(paramWS);
            guardar(respuesta);

            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");

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

    public void guardar(ConsultaFacturaExecuteResponse respuesta) {
        try {
            short codcom = 2;
            List<GuardarFactura> lstguardarFin = new ArrayList<>();
            List<Consultafacturaunica> lstConsulta = findAll();
            if (lstConsulta != null) {
                lstConsulta.stream().map((tmp) -> {
                    tmp.setActivo(false);
                    return tmp;
                }).forEach((tmp) -> {
                    super.edit(tmp);
                });
            }
            for (SDTFacturaProducto tmp : respuesta.getFacturas().getSDTFacturaProducto()) {
                Consultafacturaunica entity = new Consultafacturaunica();
                entity.setCodigocomercializadora("" + codcom);
                entity.setFecha("" + tmp.getFechaEmi());
                entity.setFecharecepcion(new Date());
                entity.setNumerofactura("" + tmp.getNumFactura());
                entity.setActivo(true);
                entity.setCodigobanco("" + tmp.getBanco());
                entity.setEstadofactura(tmp.getEstadoFac());
                entity.setEstadopago(tmp.getEstadoPago());
                entity.setFechaguia("" + tmp.getFechaGuia());
                entity.setFechavencimiento("" + tmp.getFechaVmto());
                entity.setNumerosri("" + tmp.getNumSRI());
                entity.setUsuarioactual("EPPETROECUADOR");
                Consultafacturaunica guardado = super.create(entity);
                GuardarFactura tmpF = new GuardarFactura();
                tmpF.setGuardado(guardado);
                tmpF.setLstProducto(tmp.getDetalle().getProductoFactura());
                lstguardarFin.add(tmpF);
            }

            for (GuardarFactura tmp2 : lstguardarFin) {
                for (SDTFacturaProductoProductoFactura tmp1 : tmp2.getLstProducto()) {
                    Detalleconsultafacturaunica det1 = new Detalleconsultafacturaunica();
                    det1.setIdfacturaunica(tmp2.getGuardado());
                    det1.setCodigocomercializadora("" + codcom);
                    det1.setCodigomedida("" + tmp1.getCodMedida());
                    det1.setCodigoproducto("" + tmp1.getCodProducto());
                    det1.setNumerofactura("" + tmp2.getGuardado().getNumerofactura());
                    det1.setFecharecepcion(new Date());
                    det1.setFecha("" + tmp2.getGuardado().getFecha());
                    det1.setCodigoareamercadeo("" + tmp1.getArea());
                    det1.setMedida(tmp1.getMedida());
                    det1.setNumerosri("" + tmp2.getGuardado().getNumerosri());
                    det1.setPrecio(new BigDecimal(tmp1.getPrecio()));
                    det1.setProducto(tmp1.getProducto());
                    det1.setUsuarioactual("EPPETROECUADOR");
                    det1.setValor(new BigDecimal(tmp1.getValor()));
                    det1.setActivo(true);
                    det1.setVolumen(new BigDecimal(tmp1.getVolumen()));
                    servicioDetalleFac.create(det1);
                    System.out.println(det1);
                }
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    public List<Consultafacturaunica> selectActivo() {
        String queryStr = "SELECT t FROM Consultafacturaunica t WHERE t.activo='true'";
        TypedQuery<Consultafacturaunica> query = em.createQuery(queryStr, Consultafacturaunica.class);
        return query.getResultList();
    }

    private ConsultaFacturaExecuteResponse execute(ConsultaFacturaExecute parameters) {
        ConsultaFactura service = new ConsultaFactura();
        ConsultaFacturaSoapPort port = service.getConsultaFacturaSoapPort();
        return port.execute(parameters);
    }

}
