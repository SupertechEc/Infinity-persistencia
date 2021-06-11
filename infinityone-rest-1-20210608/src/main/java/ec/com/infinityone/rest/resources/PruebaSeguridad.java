/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinityone.rest.resources;

import ec.com.infinity.rest.seguridad.Secured;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Paul
 */
@Path("pruebaseguridad")
public class PruebaSeguridad {

    @GET
    @Secured
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    public Response ping() throws Exception {
        return Response
                .ok("ping")
                .build();
    }
}
