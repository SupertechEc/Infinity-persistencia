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
import com.google.common.base.MoreObjects;
import ec.com.infinity.rest.seguridad.ErrorMessage;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.SocketTimeoutException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.apache.log4j.Logger;

@Provider
//public class GenericExceptionMapperProvider implements ExceptionMapper<Throwable> {
//static Logger log = Logger.getLogger(GenericExceptionMapperProvider.class.getName());
//    
//    
//    @Override
//    public Response toResponse(Throwable ex) {
//
//        ErrorMessage errorMessage = new ErrorMessage();
//        setHttpStatus(ex, errorMessage);
//        errorMessage.setCode(401);
//        errorMessage.setMessage(ex.getMessage());
//        StringWriter errorStackTrace = new StringWriter();
//        ex.printStackTrace(new PrintWriter(errorStackTrace));
//        errorMessage.setDeveloperMessage(errorStackTrace.toString());
//        errorMessage.setLink("55");
//
//        return Response.status(errorMessage.getStatus())
//                .entity(errorMessage)
//                .type(MediaType.APPLICATION_JSON)
//                .build();
//    }
//
//    private void setHttpStatus(Throwable ex, ErrorMessage errorMessage) {
//        if (ex instanceof WebApplicationException) {
//            errorMessage.setStatus(((WebApplicationException) ex).getResponse().getStatus());
//        } else {
//            errorMessage.setStatus(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()); //defaults to internal server error 500
//        }
//    }

//public class GenericExceptionMapperProvider implements ExceptionMapper<RuntimeException> {
//
//    static Logger log = Logger.getLogger(GenericExceptionMapperProvider.class.getName());
//
//    @Override
//    public Response toResponse(RuntimeException ex) {
//        String message = "";
//        ErrorMessage errorMessage = new ErrorMessage();
//
//        if (ex instanceof NotFoundException) {
//            message = "404 Not Found";
//            log.debug(message);
//            setHttpStatus(ex, errorMessage);
//            errorMessage.setCode(404);
//            errorMessage.setMessage(ex.getMessage());
//            StringWriter errorStackTrace = new StringWriter();
//            ex.printStackTrace(new PrintWriter(errorStackTrace));
//            errorMessage.setDeveloperMessage(errorStackTrace.toString());
//            errorMessage.setLink("55");
//        } else {
//            message = "500 Internal Server Error";
//            log.debug(message);
//            setHttpStatus(ex, errorMessage);
//            errorMessage.setCode(500);
//            errorMessage.setMessage(ex.getMessage());
//            StringWriter errorStackTrace = new StringWriter();
//            ex.printStackTrace(new PrintWriter(errorStackTrace));
//            errorMessage.setDeveloperMessage(errorStackTrace.toString());
//            errorMessage.setLink("55");
//        }
//
//        return Response.status(errorMessage.getStatus())
//                .entity(errorMessage)
//                .type(MediaType.APPLICATION_JSON)
//                .build();
//    }
//
//    private void setHttpStatus(RuntimeException ex, ErrorMessage errorMessage) {
//        if (ex instanceof NotFoundException) {
//            errorMessage.setStatus(Response.Status.NOT_FOUND.getStatusCode()); //defaults to internal server error 500
//        } else if (ex instanceof WebApplicationException) {
//            Response response = ((WebApplicationException) ex).getResponse();
//            errorMessage.setStatus(((WebApplicationException) ex).getResponse().getStatus());
//        } else {
//            errorMessage.setStatus(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()); //defaults to internal server error 500
//        }
//    }
//public class GenericExceptionMapperProvider implements ExceptionMapper<RuntimeException> {
//static Logger log = Logger.getLogger(GenericExceptionMapperProvider.class.getName());
//public static final String GENERIC_MESSAGE = "server error";
//
//    @Override
//    public Response toResponse(RuntimeException exception) {
//
//        if (exception instanceof NotFoundException) {
//            String message = "404 Not Found";
//            log.debug(message);
//            return ClientError.status(404).error(message).response();
//        }
//
//        if (exception instanceof WebApplicationException) {
//            Response response = ((WebApplicationException) exception).getResponse();
//
//            // skip processing of responses that are already present.
//            if (response.getEntity() != null) {
//                return response;
//            }
//
//            // fill out null responses
//            String message = MoreObjects.firstNonNull(exception.getMessage(), GENERIC_MESSAGE);
//
//            if (!GENERIC_MESSAGE.equals(message)) {
//                // Don't turn this off. You should be using ServerError and ClientError builders.
//                log.warn("Surfaced exception message from unknown tier. Expected ErrorEntity from web tier.");
//            }
//            AbstractErrorBuilder<?, ?> responseBuilder;
//            if (response.getStatus() < 500) {
//                if (GENERIC_MESSAGE.equals(message)) { // if we didn't get a specific message from the exception
//                    message = "client error";
//                }
//                responseBuilder = ClientError.status(response.getStatus());
//            } else {
//                responseBuilder = ServerError.status(response.getStatus());
//
//                // ensure server error exceptions are logged!
//                log.error("Server error: ", exception);
//            }
//
//            return responseBuilder.error(message).response();
//        } else if (exception.getCause() instanceof SocketTimeoutException) {
//            return ServerError.status(504).exception(exception).getResponse();
//        }
//
//        /* Force a standard response for unexpected error types.
//         * This should always be logged as ERROR (because unexpected)
//         */
//        log.error("Server error, unexpected exception: ", exception);
//        return ServerError.status(500).error(GENERIC_MESSAGE).response();
//    }
public class GenericExceptionMapperProvider implements ExceptionMapper<Throwable> {

    static Logger log = Logger.getLogger(GenericExceptionMapperProvider.class.getName());

    @Override
    public Response toResponse(Throwable ex) {
        Response.StatusType type = getStatusType(ex);

        Error error = new Error(
                type.getStatusCode(),
                type.getReasonPhrase(),
                ex.getLocalizedMessage());

        return Response.status(error.getStatusCode())
                .entity(error)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    private Response.StatusType getStatusType(Throwable ex) {
        if (ex instanceof WebApplicationException) {
            return ((WebApplicationException) ex).getResponse().getStatusInfo();
        } else {
            return Response.Status.INTERNAL_SERVER_ERROR;
        }
    }
}
