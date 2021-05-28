/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.error.handling;

import ec.com.infinity.error.handling.entities.DefaultErrorEntityFactory;
import ec.com.infinity.error.handling.entities.ErrorEntity;
import ec.com.infinity.error.handling.entities.ErrorEntityFactory;

/**
 *
 * @author Paul
 */
public class Errors {

    private static ErrorEntityFactory entityFactory;

    static {
        resetCustomisation();
    }

    public static void customise(ErrorEntityFactory factory) {
        entityFactory = factory;
    }

    public static void resetCustomisation() {
        entityFactory = new DefaultErrorEntityFactory();
    }

    public static ErrorEntity buildEntity(String message, Object context) {
        return entityFactory.entity(message, context);
    }
}
