/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kerstordening.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kerstordening.graph.error.NoSolutionExistsError;

/**
 * This class is made to take the input from the InputReader and put it in the
 * graph.
 *
 * @author Thomas De Praetere
 */
public class GraphController {

    private final Graph graph;

    public GraphController() {
        graph = new Graph();
    }

    /**
     * Finds a cycle given a map of names.
     *
     * @param map This map should contain a name followed by a list of names of
     * people who they do not want to buy for.
     * @return An ordered list in which position i buys for position
     * i+1%list.size().
     * @throws kerstordening.graph.error.NoSolutionExistsError
     */
    public ArrayList<String> findCycle(Map<String, ArrayList<String>> map) throws NoSolutionExistsError {
        graph.reset();
        Map<String, ArrayList<String>> invertedMap = invertMap(map);
        for (String key : invertedMap.keySet()) {
            graph.addNode(key);
        }
        graph.initialize(invertedMap);
        ArrayList<String> list = new ArrayList<>();
        graph.findLoop().stream().forEachOrdered((n) -> list.add(n.getName()));
        return list;
    }

    private Map<String, ArrayList<String>> invertMap(Map<String, ArrayList<String>> map) {
        Map<String, ArrayList<String>> invertedMap = new HashMap<>(map.size());
        Set<String> keySet = map.keySet();

        for (String key : keySet) {

            ArrayList<String> list = new ArrayList<>();

            for (String k : keySet) {

                if (!k.equals(key) && !map.get(key).contains(k)) {
                    list.add(k);
                }

            }
            invertedMap.put(key, list);
        }

        return invertedMap;
    }

}
