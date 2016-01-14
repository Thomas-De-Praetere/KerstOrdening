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
public class GraphControllerTest {

    public GraphControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of findCycle method, of class GraphController.
     */
    @Test
    public void testFindCycle() throws Exception {
        System.out.println("findCycle");
        Map<String, ArrayList<String>> map = new HashMap<>();
        map.put("A", new ArrayList<>(Arrays.asList("C")));
        map.put("B", new ArrayList<>(Arrays.asList("A")));
        map.put("C", new ArrayList<>(Arrays.asList("B")));

        GraphController cont = new GraphController();
        ArrayList<String> findCycle = cont.findCycle(map);

        int i = findCycle.indexOf("A");

        assertEquals("A", findCycle.get(i % findCycle.size()));
        assertEquals("B", findCycle.get((i + 1) % findCycle.size()));
        assertEquals("C", findCycle.get((i + 2) % findCycle.size()));

    }

}
