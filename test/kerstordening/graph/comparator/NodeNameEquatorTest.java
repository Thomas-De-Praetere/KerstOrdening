/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kerstordening.graph.comparator;

import kerstordening.graph.Node;
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
public class NodeNameEquatorTest {

    public NodeNameEquatorTest() {
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
     * Test of equals method, of class NodeNameEquator.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        NodeNameEquator noid = new NodeNameEquator();
        Node n1 = new Node(1, "1");
        Node n2 = new Node(1, "2");
        Node n3 = new Node(3, "2");

        assertTrue(noid.equals(n3, n2));
        assertFalse(noid.equals(n2, n1));
    }

}
