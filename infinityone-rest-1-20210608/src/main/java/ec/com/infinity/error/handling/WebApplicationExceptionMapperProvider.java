/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.error.handling;

/**
 *
 * @author Paul
 */
import ec.com.infinity.rest.seguridad.ErrorMessage;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class WebApplicationExceptionMapperProvider implements ExceptionMapper<WebApplicationException> {

    public Response toResponse(WebApplicationException ex) {
        Response exResponse = ex.getResponse();
        ErrorMessage errorMessage = new ErrorMessage(exResponse.getStatus(), ex.getMessage());
        //return JAXRSUtils.fromResponse(ex.getResponse()).entity(errorMessage).build();
        return Response.status(ex.getResponse().getStatus())
				.entity(errorMessage)
				.type(MediaType.APPLICATION_JSON).
				build();
    }

}
