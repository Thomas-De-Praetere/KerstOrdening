/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kerstordening.graph;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Stack;
import kerstordening.graph.comparator.NodeNameEquator;
import kerstordening.graph.error.AlreadyInitializedError;
import kerstordening.graph.error.NoSolutionExistsError;
import kerstordening.graph.error.NodeMissingError;
import kerstordening.graph.error.NotInitializedError;

/**
 *
 * @author Thomas De Praetere
 */
public class Graph {

    private boolean initialized = false;
    private final ArrayList<Node> nodes;
    
    public boolean isInitialized() {
        return initialized;
    }

    public Graph() {
        nodes = new ArrayList<>();
    }

    public int size(){
        return nodes.size();
    }
    
    public void addNode(String name) {
        if (!initialized) {
            nodes.add(new Node(nodes.size(), name));
        } else {
            throw new AlreadyInitializedError("The edges in the graph are already calculated, please deinitialize the graph first.");
        }
    }

    public void deinitialize() {
        initialized = false;
    }

    /**
     * Initializes the edges of the graph using a map that links names of people
     * with the people they need to buy for.
     *
     * @param map
     */
    public void initialize(Map<String, ArrayList<String>> map) {
        if (!map.keySet().stream().allMatch((st) -> Container.<Node>contains(new Node(0, st), new NodeNameEquator(), nodes) != -1)) {
            throw new NodeMissingError("A name from the map had no node in the graph.");
        }

        for (String st : map.keySet()) {
            Node n = nodes.get(Container.<Node>contains(new Node(0, st), new NodeNameEquator(), nodes));
            ArrayList<Node> nl = new ArrayList<>();
            for (String s : map.get(st)) {
                nl.add(nodes.get(Container.<Node>contains(new Node(0, s), new NodeNameEquator(), nodes)));
            }
            n.setBuyFor(nl);
        }
        initialized = true;
    }

    private boolean strongConnect(Node v, int index, Stack<Node> s) {
        v.setIndex(index);
        v.setLowlink(index);
        index++;
        s.push(v);
        v.setOnStack(true);

        boolean ret = false;

        for (Node w : v.getBuyFor()) {
            if (w.getIndex() == -1) {
                ret = strongConnect(w, index, s);
                v.setLowlink(Math.min(v.getLowlink(), w.getLowlink()));
            } else {
                if (w.isOnStack()) {
                    v.setLowlink(Math.min(v.getLowlink(), w.getIndex()));
                }
            }
        }

        if (v.getLowlink() == v.getIndex()) {
            return s.size() == nodes.size();
        } else {
            return ret;
        }

    }

    private boolean isStronglyConnected() {
        if (initialized) {
            int index = 0;
            Stack<Node> s = new Stack<>();
            if (nodes.isEmpty()) {
                return false;
            } else {
                Node v = nodes.get(0);
                return strongConnect(v, index, s);
            }

        } else {
            throw new NotInitializedError("The graph was not initialized.");
        }
    }

    private boolean findLoop(Node v, ArrayList<Node> loop) {
        boolean nonExists = true;
        boolean found;

        for (Node w : v.getBuyFor()) {
            if (!w.isChosen()) {
                nonExists = false;
                w.setChosen(true);
                loop.add(w);
                found = findLoop(w, loop);
                if (!found) {
                    w.setChosen(false);
                    loop.remove(loop.size() - 1);
                } else {
                    return true;
                }
            }
        }
        //Stop criterium.

        return nonExists && (loop.size() == nodes.size()) && v.canBuyFor(loop.get(0).getId());
    }

    public ArrayList<Node> findLoop() throws NoSolutionExistsError {
        if (initialized) {
            if (!isStronglyConnected()) {
                throw new NoSolutionExistsError("No solution exists due to unreachable nodes.");
            }
            ArrayList<Node> loop = new ArrayList<>();

            nodes.stream().forEach((v) -> {
                v.shuffle();
            });

            Random r = new Random();
            Node v = nodes.get(r.nextInt(nodes.size()));
            loop.add(v);
            v.setChosen(true);
            boolean ret = findLoop(v, loop);

            if (ret) {
                return loop;
            } else {
                throw new NoSolutionExistsError("No solution exists due to bad list configurations.");
            }
        } else {
            throw new NotInitializedError("The graph was not initialized.");
        }
    }

    public void reset() {
        this.initialized = false;
        nodes.clear();
    }
}
