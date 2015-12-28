/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kerstordening.graph.comparator;

/**
 *
 * @author Thomas De Praetere
 * @param <T>
 */
public interface Equator<T> {
    /**
     * Compares two objects to see if they are the same.
     * @param o1 The first object.
     * @param o2 The second object.
     * @return true is o1 equals o2. Else false.
     */
    public boolean equals(T o1, T o2);
}
