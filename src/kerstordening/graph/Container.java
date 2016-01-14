/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kerstordening.graph;

import java.util.List;
import kerstordening.graph.comparator.Equator;

/**
 *
 * @author Thomas De Praetere
 */
public class Container {

    /**
     * Checks whether a List contains something according to some form of
     * equality.
     *
     * @param <T> The type of the items in the list.
     * @param t This is the element for which it is checked if it is contained
     * in the list.
     * @param eq An object that says whether two objects are equal.
     * @param l A list.
     * @return The position of the first occurrence of the element.
     */
    public static <T> int contains(T t, Equator<T> eq, List<T> l) {
        for (int i = 0; i < l.size(); i++) {
            if (eq.equals(t, l.get(i))) {
                return i;
            }
        }
        return -1;
    }
}
