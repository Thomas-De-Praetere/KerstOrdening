/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kerstordening.graph.comparator;

import kerstordening.graph.Node;

/**
 *
 * @author Thomas De Praetere
 */
public class NodeNameEquator implements Equator<Node> {

    @Override
    public boolean equals(Node o1, Node o2) {
        if (o1 == null || o2 == null) {
            return false;
        }
        return o1.getName().equals(o2.getName());
    }

}
