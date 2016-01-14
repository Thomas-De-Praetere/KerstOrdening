/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kerstordening.graph;

import java.util.ArrayList;
import java.util.Collections;
import kerstordening.graph.comparator.NodeIdEquator;
import kerstordening.graph.comparator.NodeNameEquator;

/**
 *
 * @author Thomas De Praetere
 */
public class Node {

    private final int id;
    private final String name;
    private ArrayList<Node> buyFor;
    private boolean chosen;

    private int index;
    private int lowlink;
    private boolean onStack;

    public Node(int id, String name) {
        this.id = id;
        this.name = name;
        chosen = false;
        index = -1;
        lowlink = -1;
        onStack = false;
    }

    public boolean isOnStack() {
        return onStack;
    }

    public void setOnStack(boolean onStack) {
        this.onStack = onStack;
    }

    public int getId() {
        return id;
    }

    public boolean isChosen() {
        return chosen;
    }

    public void setChosen(boolean chosen) {
        this.chosen = chosen;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Node> getBuyFor() {
        return buyFor;
    }

    public void setBuyFor(ArrayList<Node> buyFor) {
        this.buyFor = buyFor;
    }

    public boolean canBuyFor(int id) {
        return Container.<Node>contains(new Node(id, name), new NodeIdEquator(), buyFor) != -1;
    }

    public int getPos(int id) {
        return Container.<Node>contains(new Node(id, name), new NodeIdEquator(), buyFor);
    }

    public void shuffle() {
        Collections.shuffle(buyFor);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getLowlink() {
        return lowlink;
    }

    public void setLowlink(int lowlink) {
        this.lowlink = lowlink;
    }

}
