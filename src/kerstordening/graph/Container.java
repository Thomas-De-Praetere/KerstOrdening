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
 * @param <T>
 */
public class Container {

    public static <T> int contains(T t, Equator<T> eq, List<T> l) {
        for (int i = 0; i < l.size(); i++) {
            if (eq.equals(t, l.get(i))) {
                return i;
            }
        }
        return -1;
    }
}
