/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.rest.seguridad;

import io.jsonwebtoken.Jwts;
import ec.com.infinity.rest.seguridad.EjecucionMensaje;
import ec.com.infinity.rest.seguridad.ErrorMessage;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Calendar;
import java.util.Date;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ec.com.infinity.modelo.Usuario;
import ec.com.infinityone.rest.servicios.service.UsuarioFacadeREST;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Paul
 */
@Path("usuario")
public class UsuarioResource {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;
     
    @GET
    @Path("/login")
    @Produces({MediaType.APPLICATION_JSON})
    public Response authenticateUser(@QueryParam("user") String user,
            @QueryParam("password") String password) {
        
        //UsuarioFacadeREST serUsuario = new UsuarioFacadeREST();
        try {

            // Aquí iría el código de validación del usuario y contraseñas proporcionados,
            // por ejemplo validándolo contra una base de datos...
            //authenticate(login, password);
            // Si todo es correcto, generamos el token
            System.out.println("entrando a login: "+user + " " + password);
            Usuario entity = validarUsuario(user, password);
           // Usuario entity1 = new Usuario(); 
            Gson gson = new Gson();
            String json = "";
            System.out.println("LUEGO DE validarUsuario: "+entity.getCodigo());
            if (entity.getCodigo()!= null && entity.getCodigo()!= ""){
                            
            String token = "Infinity " + issueToken(user);
            String clave = gson.toJson("token");
              json = "{"+clave + ':' +'"'+ token + '"' +"}";
              entity.setHash(token);
              //entity1= serUsuario.edit(entity);
              //entity1.setHash(json);
            // Devolvemos el token en la cabecera "Authorization". 
            // Se podría devolver también en la respuesta directamente.
            
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");
            List<Usuario> lst = new ArrayList<>();
            lst.add(entity);
            succesMessage.setRetorno(lst);
            return Response.status(200)
                    .entity(succesMessage)
                    .type(MediaType.APPLICATION_JSON).
                    build();
              
            }else{
               json = "ERROR: Usuario y/o clave incorrectos!";
            }
            return Response.ok(json).build();    
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    private String issueToken(String user) {
        //Calculamos la fecha de expiración del token
        Date issueDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(issueDate);
        calendar.add(Calendar.MINUTE, 60);
        Date expireDate = calendar.getTime();

        //Creamos el token
        String jwtToken = Jwts.builder()
                .setSubject(user)
                .setIssuer("ec.com.infinityone")
                .setIssuedAt(issueDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, RestSecurityFilter.KEY)
                .compact();
//        System.out.println("imprimir token "+jwtToken);
        return jwtToken;
    }
    private Usuario validarUsuario(String usuario, String clave){
            Usuario entity = new Usuario();
            
            //entity.setCodigocliente(codigocliente);
            System.out.println("entrando a validarUsuario: "+usuario + " " + clave);
            
        try {
 
            TypedQuery<Usuario> consultaAcceso = em.createNamedQuery("Usuario.findAcceso", Usuario.class);
            consultaAcceso.setParameter("codigo", usuario);
            consultaAcceso.setParameter("clave", clave);
            EjecucionMensaje succesMessage = new EjecucionMensaje();
            succesMessage.setStatusCode(200);
            succesMessage.setDeveloperMessage("ejecución correcta");
            List<Usuario> lst = new ArrayList<>();
            lst = consultaAcceso.getResultList();
            entity = (Usuario)lst.get(0);
            System.out.println("luego de findAcceso: "+entity.getCodigo());
           
            return entity;
            //lst.add(super.find(entity));
            //lst.add(clip.)
            /*
            succesMessage.setRetorno(lst);
            Response.status(200)
                    .entity(succesMessage)
                    .type(MediaType.APPLICATION_JSON).
                    build();
            */
            //return JAXRSUtils.fromResponse(ex.getResponse()).entity(errorMessage).build();
        } catch (Throwable ex) {
          /*
            Response exResponse = ex.getResponse();
            ErrorMessage errorMessage = new ErrorMessage(exResponse.getStatus(), ex.getMessage());
            //return JAXRSUtils.fromResponse(ex.getResponse()).entity(errorMessage).build();
            return Response.status(ex.getResponse().getStatus())
                    .entity(errorMessage)
                    .type(MediaType.APPLICATION_JSON).
                    build();
                  */
             return entity;
        }
    }
}
