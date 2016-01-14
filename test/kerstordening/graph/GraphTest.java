/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kerstordening.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thomas De Praetere
 */
public class GraphTest {

    private Map<String, ArrayList<String>> map;
    private ArrayList<String> st;

    public GraphTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        map = new HashMap<>();

        map.put("A", new ArrayList<>(Arrays.asList("B", "C")));
        map.put("B", new ArrayList<>(Arrays.asList("G", "H", "F", "C")));
        map.put("C", new ArrayList<>(Arrays.asList("A", "B", "F", "D")));
        map.put("D", new ArrayList<>(Arrays.asList("F", "E", "C")));
        map.put("E", new ArrayList<>(Arrays.asList("D", "F")));
        map.put("F", new ArrayList<>(Arrays.asList("G", "B", "C", "D", "A")));
        map.put("G", new ArrayList<>(Arrays.asList("H", "E", "B", "F")));
        map.put("H", new ArrayList<>(Arrays.asList("A", "D", "C")));

        st = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H"));
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of isInitialized method, of class Graph.
     */
    @Test
    public void testIsInitialized() {
        System.out.println("isInitialized");
        Graph g = new Graph();
        assertFalse(g.isInitialized());
        st.stream().forEach((n) -> {
            g.addNode(n);
        });
        g.initialize(map);
        assertTrue(g.isInitialized());
        try {
            g.addNode("B");
        } catch (Exception e) {

        }
    }

    /**
     * Test of findLoop method, of class Graph.
     */
    @Test
    public void testFindLoop() throws Exception {
        System.out.println("findLoop");
        Graph g = new Graph();
        ArrayList<Node> l;

        for (String s : st) {
            g.addNode(s);
        }

        g.initialize(map);

        l = g.findLoop();

        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i).getName() + " buys for: " + l.get((i + 1) % l.size()).getName());
        }

    }

    /**
     * Test of addNode method, of class Graph.
     */
    @Test
    public void testAddNode() {
        System.out.println("addNode");
        Graph g = new Graph();
        st.stream().forEach((n) -> {
            g.addNode(n);
        });
        assertEquals(st.size(), g.size());
    }

    /**
     * Test of deinitialize method, of class Graph.
     */
    @Test
    public void testDeinitialize() {
        System.out.println("deinitialize");
        Graph g = new Graph();
        g.deinitialize();
        assertFalse(g.isInitialized());
        st.stream().forEach((n) -> {
            g.addNode(n);
        });
        g.initialize(map);
        assertTrue(g.isInitialized());
        g.deinitialize();
        assertFalse(g.isInitialized());
    }

    /**
     * Test of reset method, of class Graph.
     */
    @Test
    public void testReset() {
        System.out.println("reset");
        Graph g = new Graph();
        st.stream().forEach((n) -> {
            g.addNode(n);
        });
        g.initialize(map);
        g.reset();
        assertFalse(g.isInitialized());
        assertEquals(0, g.size());

    }

}
