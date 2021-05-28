/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.error.handling;

import com.google.common.base.Preconditions;
import org.apache.log4j.Logger;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 *
 * @author Paul
 */
public class ServerError {

    public static ServerErrorBuilder status(int code) {
        return new ServerErrorBuilder(code);
    }

    /**
     * Provides a standardised way of translating business layer exceptions into
     * web layer exceptions compatible with the JAX-RS standard.
     *
     * @author Simon.Gibbs
     */
    public static class ServerErrorBuilder extends AbstractErrorBuilder<WebApplicationServerException, ServerErrorBuilder> {

        private static final Logger LOGGER = Logger.getLogger(ServerErrorBuilder.class);

        public ServerErrorBuilder(int statusCode) {
            super(statusCode);
        }

        @Override
        protected void checkStatusCode(int code) {
            Preconditions.checkArgument(code <= 599, "max server code is 599");
            Preconditions.checkArgument(code >= 500, "min server code is 500");
        }

        @Override
        public WebApplicationServerException exception(Throwable cause) {
            checkNotNull(cause, "optional argument \"cause\" was unexpectedly null."); // surely null is impossible in a catch block!
            return new WebApplicationServerException(cause, response());
        }

        @Override
        public WebApplicationServerException exception() {
            return new WebApplicationServerException(null, response());
        }

    }
}
