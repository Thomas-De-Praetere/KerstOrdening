/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kerstordening.IO.input;

import kerstordening.Person.Person;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Thomas De Praetere
 */
public class InputReaderTest {

    public InputReaderTest() {
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

    @Test
    public void test() {

    }

    /**
     * Test of readFile method, of class InputReader.
     */
    @Test
    public void testReadFile() throws Exception {
        System.out.println("readFile");
        InputReader ir = new InputReader("C:\\Users\\Thomas De Praetere\\Documents\\Private\\Familie\\Ewout.txt");
        Person p = ir.readFile();

        System.out.println(p.toString());
    }

}
