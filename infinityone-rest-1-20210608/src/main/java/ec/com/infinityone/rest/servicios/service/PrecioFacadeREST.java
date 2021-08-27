/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinityone.rest.servicios.service;

import ec.com.infinity.modelo.Detalleprecio;
import ec.com.infinity.modelo.MaximoCodigoPrecio;
import ec.com.infinity.modelo.Precio;
import ec.com.infinity.modelo.PrecioPK;
import ec.com.infinity.rest.seguridad.EjecucionMensaje;
import ec.com.infinity.rest.seguridad.ErrorMessage;
import ec.com.infinity.rest.seguridad.Secured;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.application.ProjectStage;
import javax.management.openmbean.SimpleType;
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
@Path("ec.com.infinity.modelo.precio")
public class PrecioFacadeREST extends AbstractFacade<Precio> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

   
    public PrecioFacadeREST() {
        super(Precio.class);
    }

    @Override
    public Precio create(Precio entity) {
        return super.create(entity);
    }

    @Override
    public List<Precio> findAll() {
        return super.findAll();
    }

    @Override
    public Precio edit(Precio entity) {
        super.edit(entity);
        return entity;
    }

    @POST
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response create1(Precio entity) {
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
            @QueryParam("codigoterminal") String codigoterminal,
            @QueryParam("codigoproducto") String codigoproducto,
            @QueryParam("codigomedida") String codigomedida,
            @QueryParam("codigolistaprecio") String codigolistaprecio,
            @QueryParam("fechainicio") Date fechainicio,
            @QueryParam("secuencial") int secuencial,
            @QueryParam("codigoPrecio") long codigoPrecio) {
        try {
            
            PrecioPK  entity = new PrecioPK();
            entity.setCodigocomercializadora(codigocomercializadora);
            entity.setCodigoterminal(codigoterminal);
            entity.setCodigoproducto(codigoproducto);
            entity.setCodigomedida(codigomedida);
            entity.setCodigolistaprecio(codigolistaprecio);
            entity.setFechainicio(fechainicio);
            entity.setSecuencial(secuencial);
            entity.setCodigoPrecio(codigoPrecio);
            
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
    public Response edit1(Precio entity) {
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
            @QueryParam("codigoterminal") String codigoterminal,
            @QueryParam("codigoproducto") String codigoproducto,
            @QueryParam("codigomedida") String codigomedida,
            @QueryParam("codigolistaprecio") String codigolistaprecio,
            @QueryParam("fechainicio") Date fechainicio,
            @QueryParam("secuencial") int secuencial,
            @QueryParam("codigoPrecio") long codigoPrecio) {
        try {
            
            PrecioPK  entity = new PrecioPK();
            entity.setCodigocomercializadora(codigocomercializadora);
            entity.setCodigoterminal(codigoterminal);
            entity.setCodigoproducto(codigoproducto);
            entity.setCodigomedida(codigomedida);
            entity.setCodigolistaprecio(codigolistaprecio);
            entity.setFechainicio(fechainicio);
            entity.setSecuencial(secuencial);
            entity.setCodigoPrecio(codigoPrecio);
            
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");
            List<Precio> lst = new ArrayList<>();
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
    @Path("/paraFactura")
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response findparafactura(@QueryParam("codigocomercializadora") String codigocomercializadora, 
            @QueryParam("codigoterminal") String codigoterminal,
            @QueryParam("codigoproducto") String codigoproducto,
            @QueryParam("codigomedida") String codigomedida,
            @QueryParam("fechainicio") Date fechainicio,
            @QueryParam("codigolistaprecio") String codigolistaprecio) {
        try {
            
            PrecioPK  entity = new PrecioPK();
            entity.setCodigocomercializadora(codigocomercializadora);
            entity.setCodigoterminal(codigoterminal);
            entity.setCodigoproducto(codigoproducto);
            entity.setCodigomedida(codigomedida);
            entity.setCodigolistaprecio(codigolistaprecio);
            entity.setFechainicio(fechainicio);             
            TypedQuery<Precio> consultaPrecioParafacturar = em.createNamedQuery("Precio.findForFactura", Precio.class);
            consultaPrecioParafacturar.setParameter("codigocomercializadora", codigocomercializadora);
            consultaPrecioParafacturar.setParameter("codigoterminal", codigoterminal);
            consultaPrecioParafacturar.setParameter("codigoproducto", codigoproducto);
            consultaPrecioParafacturar.setParameter("codigomedida", codigomedida);
            consultaPrecioParafacturar.setParameter("codigolistaprecio", codigolistaprecio);
            consultaPrecioParafacturar.setParameter("fechainicio", fechainicio);
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");
            List<Precio> lst = new ArrayList<>();
            lst = consultaPrecioParafacturar.getResultList();
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
    @Path("/porComerEstado")
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response findComerEstado(@QueryParam("codigocomercializadora") String codigocomercializadora, 
            @QueryParam("activo") boolean activo) {
        try {
            
            PrecioPK  entity = new PrecioPK();
            Precio entityPrincipal = new Precio();
            entity.setCodigocomercializadora(codigocomercializadora);
            entityPrincipal.setActivo(activo);             
            TypedQuery<Precio> consultaPrecioParaConsulta = em.createNamedQuery("Precio.findByCodigocomercializadoraYEstado", Precio.class);
            consultaPrecioParaConsulta.setParameter("codigocomercializadora", codigocomercializadora);
            consultaPrecioParaConsulta.setParameter("activo", activo); 
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");
            List<Precio> lst = new ArrayList<>();
            lst = consultaPrecioParaConsulta.getResultList();
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
            List<Precio> lst = this.findAll();
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

     
    @POST
    @Path("/agregar")  
    //@Secured
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response crearAutonumerado(Precio entity) {
    //public Response crearAutonumerado(Precio entity) {
        
        StringBuilder sqlQuery = new StringBuilder();
        
        try {
        //entity.getRubroterceroPK().getCodigo()
        String auxCC = entity.getPrecioPK().getCodigocomercializadora().trim();
        String auxTer = entity.getPrecioPK().getCodigoterminal().trim();
        String auxProd = entity.getPrecioPK().getCodigoproducto().trim();
        String auxMed = entity.getPrecioPK().getCodigomedida().trim();
        String auxLisPre = entity.getPrecioPK().getCodigolistaprecio().trim();
        Date auxFeIni = entity.getPrecioPK().getFechainicio();
        int  auxSec = entity.getPrecioPK().getSecuencial();
        long auxCod = -1;
        boolean grabacionDetallesOK = false;
        MaximoCodigoPrecio codigoMax = calcularCodigoPrecio(entity);
        if (codigoMax.getCodigoPrecio() == -1){
            throw new WebApplicationException("El código de Precio NO ha podido ser calculado: " + codigoMax.getCodigoPrecio());
        }else {
            auxCod = codigoMax.getCodigoPrecio();    
        }
         
        Date auxFeFin = entity.getFechafin();
        boolean auxAct = entity.getActivo(); 
        String auxObs = entity.getObservacion().trim();
        BigDecimal auxPrePro = entity.getPrecioproducto();
        String auxUsu = entity.getUsuarioactual().trim();
        
        //codigo,
        //:pcodigo,
       sqlQuery.append("insert into public.precio "
               + "(codigocomercializadora, codigoterminal, codigoproducto, codigomedida, codigolistaprecio, "
               + " fechainicio, secuencial, codigo, fechafin, activo, observacion, precioproducto, usuarioactual)"
               + " values (:pcodigocomercializadora, :pcodigoterminal, :pcodigoproducto, :pcodigomedida, :pcodigolistaprecio, "
               + " :pfechainicio, :psecuencial,  :pcodigo, NULL, :pactivo, :pobservacion, :pprecioproducto, :pusuarioactual)"); 
       System.out.println("INSERTAR RUBRO TERCERO FT:: "+ sqlQuery.toString());
       
            Query qry = this.em.createNativeQuery(sqlQuery.toString());
            qry.setParameter("pcodigocomercializadora", auxCC);
            qry.setParameter("pcodigoterminal", auxTer);
            qry.setParameter("pcodigoproducto", auxProd);
            qry.setParameter("pcodigomedida", auxMed);
            qry.setParameter("pcodigolistaprecio", auxLisPre);
            qry.setParameter("pfechainicio", auxFeIni);
            qry.setParameter("psecuencial", auxSec);
             qry.setParameter("pcodigo", auxCod);
          //  qry.setParameter("pfechafin", auxFeIni);
            qry.setParameter("pactivo", auxAct);
            qry.setParameter("pobservacion", auxObs); 
            qry.setParameter("pprecioproducto", auxPrePro);
            qry.setParameter("pusuarioactual", auxUsu);
             qry.executeUpdate();

             // grabar DETALLES DE PRECIO
             
             //grabacionDetallesOK = grabarDetallePrecio(listaDetPrecio, auxCod);
            
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage(String.valueOf(auxCod));
            
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
    public MaximoCodigoPrecio calcularCodigoPrecio(Precio entity){
         
        StringBuilder sqlQuery = new StringBuilder();
       List<MaximoCodigoPrecio> lista = new ArrayList<>();
       BigInteger maximo = new BigInteger("-1");
       BigInteger siguienteCodigo = new BigInteger("-1");
       sqlQuery.append("select max(codigo) from precio"
//               + " where codigocomercializadora = :pcodigocomercializadora"
//               + " and codigoterminal = :pcodigoterminal"
//               + " and codigoproducto = :pcodigoproducto"
//               + " and codigomedida = :pcodigomedida"
//               + " and TRIM(codigolistaprecio) = :pcodigolistaprecio"
                ); 

        System.out.println("FT BUSCAR EL MAXIMO CODIGO:: "+ sqlQuery.toString());
        MaximoCodigoPrecio obj = new MaximoCodigoPrecio();
       try {
            Query qry = this.em.createNativeQuery(sqlQuery.toString());
//            qry.setParameter("pcodigocomercializadora", entity.getPrecioPK().getCodigocomercializadora());
//            qry.setParameter("pcodigoterminal", entity.getPrecioPK().getCodigoterminal());
//            qry.setParameter("pcodigoproducto", entity.getPrecioPK().getCodigoproducto());
//            qry.setParameter("pcodigomedida", entity.getPrecioPK().getCodigomedida());
//            qry.setParameter("pcodigolistaprecio", entity.getPrecioPK().getCodigolistaprecio().trim());
//            
            System.out.println("FT BUSCAR EL MAXIMO query completo:: "+ sqlQuery.toString());
           
            //objetosList = qry.getResultList();
            maximo = (BigInteger) qry.getSingleResult();
//            if(){
//                
//            }
            siguienteCodigo = maximo.add(new BigInteger("1"));
//            for (BigInteger[] o : objetosList) {  
                System.out.println("FT BUSCAR EL MAXIMO CODIGO for:: ");
                obj.setCodigoPrecio(siguienteCodigo.byteValueExact()); 
//            }
            
        } catch (Throwable ex) {
            System.out.println("FT:: error:: "+ ex.getMessage());
            ex.printStackTrace(System.out);
             obj.setCodigoPrecio(1); 
        } 
       System.out.println("FT BUSCAR EL MAXIMO RETORNO:: "+ obj.toString());
       return obj;
    }
    
    public boolean grabarDetallePrecio(List<Detalleprecio> listaDetPrecio, long auxCod){
        StringBuilder sqlQuery = new StringBuilder();
        Detalleprecio entity = new Detalleprecio();
        int resultadoIns = -1;
        boolean respuesta = false;
        try {
      
          sqlQuery.append("insert into public.detalleprecio "
               + "(codigocomercializadora, codigoterminal, codigoproducto, codigomedida, codigolistaprecio, "
               + " fechainicio, secuencial, codigo, codigogravamen, valor, usuarioactual)"
               + " values (:pcodigocomercializadora, :pcodigoterminal, :pcodigoproducto, :pcodigomedida, :pcodigolistaprecio, "
               + " :pfechainicio, :psecuencial,  :pcodigo, :pcodigogravamen, :pvalor, :pusuarioactual)"); 
       System.out.println("INSERTAR RUBRO TERCERO FT:: "+ sqlQuery.toString());
         for (int indice = 0; indice < listaDetPrecio.size(); indice++) {
            Query qry = this.em.createNativeQuery(sqlQuery.toString());
            qry.setParameter("pcodigocomercializadora", listaDetPrecio.get(indice).getDetalleprecioPK().getCodigocomercializadora());
            qry.setParameter("pcodigoterminal", listaDetPrecio.get(indice).getDetalleprecioPK().getCodigoterminal());
            qry.setParameter("pcodigoproducto", listaDetPrecio.get(indice).getDetalleprecioPK().getCodigoproducto());
            qry.setParameter("pcodigomedida", listaDetPrecio.get(indice).getDetalleprecioPK().getCodigomedida());
            qry.setParameter("pcodigolistaprecio", listaDetPrecio.get(indice).getDetalleprecioPK().getCodigolistaprecio());
            qry.setParameter("pfechainicio", listaDetPrecio.get(indice).getDetalleprecioPK().getFechainicio());
            qry.setParameter("psecuencial", listaDetPrecio.get(indice).getDetalleprecioPK().getSecuencial());
             qry.setParameter("pcodigo", auxCod);
          //  qry.setParameter("pfechafin", auxFeIni);
            qry.setParameter("pcodigogravamen", listaDetPrecio.get(indice).getDetalleprecioPK().getCodigogravamen());
            qry.setParameter("pvalor", listaDetPrecio.get(indice).getValor()); 
            qry.setParameter("pusuarioactual", listaDetPrecio.get(indice).getUsuarioactual());
            resultadoIns = qry.executeUpdate();
            
            if (resultadoIns == 1){
                respuesta = true;
            }else {
                respuesta = false;
            }
         }
            
        } catch (Throwable ex) {
            System.out.println("FT:: error en grabarDetallePrecio:: "+ ex.getMessage());
            ex.printStackTrace(System.out);
        }
        return respuesta;
    }
}
