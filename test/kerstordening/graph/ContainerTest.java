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
public class ContainerTest {

    public ContainerTest() {
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
     * Test of contains method, of class Container.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        int[] arr = new int[]{1, 3, 5, 6, 98, 54, 12, 2, 3, 5, 78, 45, 9, 3, 454, 5, 3, 215, 4, 9, 3, 8, 3, 4, 564, 5, 64, 4, 1, 1, 31, 321, 546};
        for (int i = 0; i < arr.length; i++) {
            assertEquals(list.contains(arr[i]), -1 != Container.<Integer>contains(arr[i], (a, b) -> {
                return a.equals(b);
            }, list));
        }

    }

}
