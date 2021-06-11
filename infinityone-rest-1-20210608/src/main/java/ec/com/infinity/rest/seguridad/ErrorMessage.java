/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.rest.seguridad;

import ec.com.infinity.rest.errorhandling.AppException;
import java.lang.reflect.InvocationTargetException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author Paul
 */
public class ErrorMessage {
    /*
     MISSING_REQUIRED_FIELD("Missing required field. Please check documentation for required fields"),
     COULD_NOT_CREATE_USER_PROFILE("Could not create user profile"),
     COULD_NOT_UPDATE_USER_PROFILE("Could not update user profile"),
     COULD_NOT_DELETE_USER_PROFILE("Could not delete user profile"),
     NO_RECORD_FOUND("No record found for provided id"),
     RECORD_ALREADY_EXISTS("Record already exists"),
     INTERNAL_SERVER_ERROR("Something went wrong. Please repeat this operation later.");
    
     */

    int status;
    int code;
    String link;
    String message;
    String developerMessage;

    public ErrorMessage(int status, String message) {
        this.status = status;
        String[] messages = message.split("\\|");
        this.message = messages[0];
        if (messages.length > 1) {
            this.developerMessage = messages[1];
        }
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public ErrorMessage(AppException ex) {
        try {
            BeanUtils.copyProperties(this, ex);
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public ErrorMessage(NotFoundException ex) {
        this.status = Response.Status.NOT_FOUND.getStatusCode();
        this.message = ex.getMessage();
        this.link = "https://jersey.java.net/apidocs/2.8/jersey/javax/ws/rs/NotFoundException.html";
    }

    public ErrorMessage() {
    }

}
