/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kerstordening.graph.error;

/**
 *
 * @author Thomas De Praetere
 */
public class AlreadyInitializedError extends RuntimeException{

    public AlreadyInitializedError(String message) {
        super(message);
    }
    
}
