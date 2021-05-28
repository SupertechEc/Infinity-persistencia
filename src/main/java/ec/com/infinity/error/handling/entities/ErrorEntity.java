/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.error.handling.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

/**
 *
 * @author Paul
 */
public class ErrorEntity {

    private final String message;

    public ErrorEntity(@JsonProperty("message") String message) {
        this.message = message;
    }

    protected MoreObjects.ToStringHelper toStringHelper() {
        return MoreObjects
                .toStringHelper(this)
                .add("message", message);
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return toStringHelper().toString();
    }
}