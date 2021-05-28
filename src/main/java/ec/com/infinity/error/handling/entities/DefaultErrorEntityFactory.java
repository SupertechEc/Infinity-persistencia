/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.infinity.error.handling.entities;

/**
 *
 * @author Paul
 */
public class DefaultErrorEntityFactory implements ErrorEntityFactory {

    @Override
    public ErrorEntity entity(String message, Object context) {
        return new ErrorEntity(message);
    }
}
