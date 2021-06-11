/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.rest.seguridad;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.crypto.MacProvider;
import java.io.IOException;
import java.security.Key;

import javax.annotation.Priority;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Paul
 */
@Provider
@Secured
@Priority(Priorities.AUTHENTICATION)
public class RestSecurityFilter implements ContainerRequestFilter {

    public static final Key KEY = MacProvider.generateKey();

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        //try {
            // Recupera la cabecera HTTP Authorization de la petición
            String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

            // Extrae el token de la cabecera
            String token = authorizationHeader.substring("Infinity".length()).trim();

            // Valida el token utilizando la cadena secreta
            Jwts.parser().setSigningKey(KEY).parseClaimsJws(token);

        //} catch (Exception e) {
        //    throw new NotAuthorizedException("You Don't Have Permission");
        //}
        //requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        //throw new NotAuthorizedException("You Don't Have Permission");
    }
}
