/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinityone.rest.servicios.service;

import ec.com.infinity.modelo.Detallefactura;
import ec.com.infinity.modelo.Detallenotapedido;
import ec.com.infinity.modelo.Factura;
import ec.com.infinity.modelo.FacturaPK;
import ec.com.infinity.modelo.Numeracion;
import ec.com.infinity.modelo2.EnvioFacturaREST;
import ec.com.infinity.rest.seguridad.EjecucionMensaje;
import ec.com.infinity.rest.seguridad.ErrorMessage;
import ec.com.infinity.rest.seguridad.Secured;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.swing.text.NumberFormatter;
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
@Path("ec.com.infinity.modelo.factura")
public class FacturaFacadeREST extends AbstractFacade<Factura> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @EJB
    private NumeracionFacadeREST servicioNumeracion;

    @EJB
    private DetallefacturaFacadeREST servicioDetalleFact;
    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager bloqueo;

    private FacturaPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;codigoabastecedora=codigoabastecedoraValue;codigocomercializadora=codigocomercializadoraValue;numeronotapedido=numeronotapedidoValue;numero=numeroValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        ec.com.infinity.modelo.FacturaPK key = new ec.com.infinity.modelo.FacturaPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> codigoabastecedora = map.get("codigoabastecedora");
        if (codigoabastecedora != null && !codigoabastecedora.isEmpty()) {
            key.setCodigoabastecedora(codigoabastecedora.get(0));
        }
        java.util.List<String> codigocomercializadora = map.get("codigocomercializadora");
        if (codigocomercializadora != null && !codigocomercializadora.isEmpty()) {
            key.setCodigocomercializadora(codigocomercializadora.get(0));
        }
        java.util.List<String> numeronotapedido = map.get("numeronotapedido");
        if (numeronotapedido != null && !numeronotapedido.isEmpty()) {
            key.setNumeronotapedido(numeronotapedido.get(0));
        }
        java.util.List<String> numero = map.get("numero");
        if (numero != null && !numero.isEmpty()) {
            key.setNumero(numero.get(0));
        }
        return key;
    }

    public FacturaFacadeREST() {
        super(Factura.class);
    }

    @Override
    public Factura create(Factura entity) {
        return super.create(entity);
    }

    @Override
    public List<Factura> findAll() {
        return super.findAll();
    }

    @Override
    public Factura edit(Factura entity) {
        super.edit(entity);
        return entity;
    }

    @POST
    @Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response create1(EnvioFacturaREST entity) {
     
        String tipodocumento = "fct";
        try {
            
                        
            Numeracion respuestaNumeracion = getServicioNumeracion().consulta(tipodocumento, entity.getFactura().getFacturaPK().getCodigocomercializadora());
            
            bloqueo.lock(respuestaNumeracion, LockModeType.PESSIMISTIC_WRITE);
            int numeracion = respuestaNumeracion.getUltimonumero() + 1;
             
            DecimalFormat df = new DecimalFormat("000000000");
            String numeroFactura = (df.format(new BigDecimal(numeracion)));
            entity.getFactura().getFacturaPK().setNumero( entity.getFactura().getSeriesri()+ numeroFactura);
            
            entity.getFactura().setClaveacceso(GeneradorClaveAccesoSRI.crearClaveAcceso(
                    entity.getFactura().getFechaventa(), 
                    entity.getFactura().getFacturaPK().getNumero().substring(0, 3),
                    entity.getFactura().getFacturaPK().getNumero().substring(3, 3),
                    entity.getFactura().getFacturaPK().getNumero().substring(6, 9),
                    entity.getFactura().getRuccomercializadora(),
                    String.valueOf(entity.getFactura().getAmbientesri()),
                    String.valueOf(entity.getFactura().getTipoemision()))); 
                    
            
                    //entity.getFactura().getRucComercializadora
                    //entity.getFactura().getAmbienteSri()
                    //entity.getFactura().getCodigoDocumento()
            super.createS(entity.getFactura());

            // iterar la lista y grabar lista de DETALLES DE FACTURA
            
            List<Detallefactura> listafacturaDetalle = new ArrayList<>();
            Detallefactura facturaDetalle = new Detallefactura();
            listafacturaDetalle = entity.getDetalle();
            for(int i = 0; i < listafacturaDetalle.size(); i++){
                listafacturaDetalle.get(i).getDetallefacturaPK().setCodigoabastecedora(entity.getFactura().getFacturaPK().getCodigoabastecedora());
                listafacturaDetalle.get(i).getDetallefacturaPK().setCodigocomercializadora(entity.getFactura().getFacturaPK().getCodigocomercializadora());
                listafacturaDetalle.get(i).getDetallefacturaPK().setNumero(entity.getFactura().getFacturaPK().getNumero());
                listafacturaDetalle.get(i).getDetallefacturaPK().setNumeronotapedido(entity.getFactura().getFacturaPK().getNumeronotapedido());
            }
            for(Detallefactura det: listafacturaDetalle){
                 servicioDetalleFact.createS(det);
            }
            /*facturaDetalle = entity.getDetalle();
            facturaDetalle.getDetallefacturaPK().setCodigoabastecedora(entity.getFactura().getFacturaPK().getCodigoabastecedora());
            facturaDetalle.getDetallefacturaPK().setCodigocomercializadora(entity.getFactura().getFacturaPK().getCodigocomercializadora());
            facturaDetalle.getDetallefacturaPK().setNumero(entity.getFactura().getFacturaPK().getNumero());
            facturaDetalle.getDetallefacturaPK().setNumeronotapedido(entity.getFactura().getFacturaPK().getNumeronotapedido());
            servicioDetalleFact.createS(facturaDetalle);*/            
            //listafacturaDetalle.add(facturaDetalle);
            /*for(Detallefactura det: listafacturaDetalle){
                 servicioDetalleFact.createS(det);
            }*/
            // iterar la lista y grabar lista de DETALLES DE FACTURA
            
            
            respuestaNumeracion.setUltimonumero(numeracion);
            getServicioNumeracion().edit(respuestaNumeracion);
            //bloqueo.getTransaction().commit();
            //bloqueo.close();

            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("Fac: "+entity.getFactura().getFacturaPK().getNumero());
            

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
    public Response remove(@QueryParam("codigoabastecedora") String codigoabastecedora, 
            @QueryParam("codigocomercializadora") String codigocomercializadora,
            @QueryParam("numeronotapedido") String numeronotapedido,
            @QueryParam("numero") String numero) {
        try {
            
            FacturaPK  entity = new FacturaPK();
            entity.setCodigoabastecedora(codigoabastecedora);
            entity.setCodigocomercializadora(codigocomercializadora);
            entity.setNumeronotapedido(numeronotapedido);
            entity.setNumero(numero);
                        
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
    @Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response edit1(Factura entity) {
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
    public Response find(@QueryParam("codigoabastecedora") String codigoabastecedora, 
            @QueryParam("codigocomercializadora") String codigocomercializadora,
            @QueryParam("numeronotapedido") String numeronotapedido,
            @QueryParam("numero") String numero) {
        try {

            FacturaPK  entity = new FacturaPK();
            entity.setCodigoabastecedora(codigoabastecedora);
            entity.setCodigocomercializadora(codigocomercializadora);
            entity.setNumeronotapedido(numeronotapedido);
            entity.setNumero(numero);
            
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");
            List<Factura> lst = new ArrayList<>();
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
            List<Factura> lst = this.findAll();
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

    /**
     * @return the servicioNumeracion
     */
    public NumeracionFacadeREST getServicioNumeracion() {
        return servicioNumeracion;
    }

    /**
     * @param servicioNumeracion the servicioNumeracion to set
     */
    public void setServicioNumeracion(NumeracionFacadeREST servicioNumeracion) {
        this.servicioNumeracion = servicioNumeracion;
    }

    /**
     * @return the servicioDetalleFact
     */
    public DetallefacturaFacadeREST getServicioDetalleFact() {
        return servicioDetalleFact;
    }

    /**
     * @param servicioDetalleFact the servicioDetalleFact to set
     */
    public void setServicioDetalleFact(DetallefacturaFacadeREST servicioDetalleFact) {
        this.servicioDetalleFact = servicioDetalleFact;
    }

}
