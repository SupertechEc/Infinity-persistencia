/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.rest.seguridad;

import ec.com.infinity.modelo.Terminal_1;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.GenericEntity;

/**
 *
 * @author Paul
 */
public class EjecucionMensaje<E> extends Object {

    private int statusCode;
    private String statusDescription;
    private String errorMessage;
    private String developerMessage;
    private List<E> retorno;

    /* public EjecucionMensaje(int status, String message) {
     this.statusCode = status;
     String[] messages = message.split("\\|");
     this.statusDescription = messages[0];
     if (messages.length > 1) {
     this.developerMessage = messages[1];
     }
     }*/
    /**
     * @return the statusCode
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * @param statusCode the statusCode to set
     */
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * @return the statusDescription
     */
    public String getStatusDescription() {
        return statusDescription;
    }

    /**
     * @param statusDescription the statusDescription to set
     */
    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    /**
     * @return the developerMessage
     */
    public String getDeveloperMessage() {
        return developerMessage;
    }

    /**
     * @param developerMessage the developerMessage to set
     */
    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }

    /**
     * @return the retorno
     */
    public List<E> getRetorno() {
        return retorno;
    }

    /**
     * @param retorno the retorno to set
     */
    public void setRetorno(List<E> retorno) {
        this.retorno = retorno;
    }

    /**
     * @return the errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param errorMessage the errorMessage to set
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
