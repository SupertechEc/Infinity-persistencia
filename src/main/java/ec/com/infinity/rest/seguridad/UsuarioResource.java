/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.rest.seguridad;

import io.jsonwebtoken.Jwts;
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

/**
 *
 * @author Paul
 */
@Path("usuario")
public class UsuarioResource {

    @GET
    @Path("/login")
    @Produces({MediaType.APPLICATION_JSON})
    public Response authenticateUser(@QueryParam("user") String user,
            @QueryParam("password") String password) {
        try {

            // Aquí iría el código de validación del usuario y contraseñas proporcionados,
            // por ejemplo validándolo contra una base de datos...
            //authenticate(login, password);
            // Si todo es correcto, generamos el token
            String token = issueToken(user);

            // Devolvemos el token en la cabecera "Authorization". 
            // Se podría devolver también en la respuesta directamente.
            return Response.ok("Infinity " + token).build();

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
}
