/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.error.handling;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 *
 * @author Paul
 */
public class WebApplicationServerException extends WebApplicationException {

    public WebApplicationServerException(Response response) {
        super(response);
    }

    public WebApplicationServerException(Throwable cause, Response response) {
        super(cause, response);
    }

}
