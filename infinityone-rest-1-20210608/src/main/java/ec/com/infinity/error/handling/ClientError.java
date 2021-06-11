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
import com.google.common.base.Preconditions;
import javax.ws.rs.core.Response;

import static com.google.common.base.Preconditions.checkNotNull;

import org.apache.log4j.Logger;

public class ClientError {

    public static ClientErrorBuilder status(int code) {
        return new ClientErrorBuilder(code);
    }

    /**
     * Provides a standardised way of translating business layer exceptions into
     * web layer exceptions compatible with the JAX-RS standard.
     *
     * @author Simon.Gibbs
     */
    public static class ClientErrorBuilder extends
            AbstractErrorBuilder<WebApplicationClientException, ClientErrorBuilder> {

        static Logger log = Logger.getLogger(GenericExceptionMapperProvider.class.getName());

        public ClientErrorBuilder(int statusCode) {
            super(statusCode);
        }

        @Override
        protected void checkStatusCode(int code) {
            Preconditions.checkArgument(code <= 499, "max client code is 499");
            Preconditions.checkArgument(code >= 400, "min client code is 400");
        }

        @Override
        public WebApplicationClientException exception(Throwable cause) {
            checkNotNull(cause, "optional argument \"cause\" was unexpectedly null."); // surely null is impossible in a catch block!
            if (getStatusCode() != Response.Status.NOT_FOUND.getStatusCode()) {
            }
            return new WebApplicationClientException(cause.toString(), cause, response());
        }

        @Override
        public WebApplicationClientException exception() {
            return new WebApplicationClientException(response());
        }

    }
}
