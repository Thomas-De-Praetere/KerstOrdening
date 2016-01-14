/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kerstordening.graph;

import java.util.ArrayList;
import java.util.Arrays;
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
public class NodeTest {

    public NodeTest() {
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
     * Test of isOnStack method, of class Node.
     */
    @Test
    public void testIsOnStack() {
        System.out.println("isOnStack");
        Node n = new Node(1, "");
        assertFalse(n.isOnStack());
        n.setOnStack(true);
        assertTrue(n.isOnStack());
    }

    /**
     * Test of setOnStack method, of class Node.
     */
    @Test
    public void testSetOnStack() {
        System.out.println("setOnStack");
        Node n = new Node(1, "");
        assertFalse(n.isOnStack());
        n.setOnStack(true);
        assertTrue(n.isOnStack());
    }

    /**
     * Test of getId method, of class Node.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Node n = new Node(1, "");
        assertEquals(1, n.getId());
    }

    /**
     * Test of isChosen method, of class Node.
     */
    @Test
    public void testIsChosen() {
        System.out.println("isChosen");
        Node n = new Node(1, "");
        assertFalse(n.isChosen());
        n.setChosen(true);
        assertTrue(n.isChosen());
    }

    /**
     * Test of setChosen method, of class Node.
     */
    @Test
    public void testSetChosen() {
        System.out.println("setChosen");
        Node n = new Node(1, "");
        assertFalse(n.isChosen());
        n.setChosen(true);
        assertTrue(n.isChosen());
    }

    /**
     * Test of getName method, of class Node.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Node n = new Node(1, "");
        assertEquals("", n.getName());
    }

    /**
     * Test of getBuyFor method, of class Node.
     */
    @Test
    public void testGetBuyFor() {
        System.out.println("getBuyFor");
        Node n = new Node(1, "");
        n.setBuyFor(new ArrayList<>(Arrays.asList(new Node(2, ""))));
        assertEquals(1, n.getBuyFor().size());
    }

    /**
     * Test of setBuyFor method, of class Node.
     */
    @Test
    public void testSetBuyFor() {
        System.out.println("setBuyFor");
        Node n = new Node(1, "");
        n.setBuyFor(new ArrayList<>(Arrays.asList(new Node(2, ""))));
        assertEquals(1, n.getBuyFor().size());
    }

    /**
     * Test of canBuyFor method, of class Node.
     */
    @Test
    public void testCanBuyFor() {
        System.out.println("canBuyFor");
        Node n = new Node(1, "");
        n.setBuyFor(new ArrayList<>(Arrays.asList(new Node(2, ""))));
        assertTrue(n.canBuyFor(2));
    }

    /**
     * Test of getPos method, of class Node.
     */
    @Test
    public void testGetPos() {
        System.out.println("getPos");
        Node n = new Node(1, "");
        n.setBuyFor(new ArrayList<>(Arrays.asList(new Node(2, ""))));
        assertEquals(0, n.getPos(2));
    }

    /**
     * Test of getIndex method, of class Node.
     */
    @Test
    public void testGetIndex() {
        System.out.println("getIndex");
        Node n = new Node(1, "");
        n.setIndex(1);
        assertEquals(1, n.getIndex());
    }

    /**
     * Test of setIndex method, of class Node.
     */
    @Test
    public void testSetIndex() {
        System.out.println("setIndex");
        Node n = new Node(1, "");
        n.setIndex(1);
        assertEquals(1, n.getIndex());
    }

    /**
     * Test of getLowlink method, of class Node.
     */
    @Test
    public void testGetLowlink() {
        System.out.println("getLowlink");
        Node n = new Node(1, "");
        n.setLowlink(1);
        assertEquals(1, n.getLowlink());
    }

    /**
     * Test of setLowlink method, of class Node.
     */
    @Test
    public void testSetLowlink() {
        System.out.println("setLowlink");
        Node n = new Node(1, "");
        n.setLowlink(1);
        assertEquals(1, n.getLowlink());
    }

}
