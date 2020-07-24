/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taschenrechner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author RaoUmar
 */
public class ExpressionIT {
    
    public ExpressionIT() {
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
     * Test of set method, of class Expression.
     */
    @Test
    public void testSet() {
        System.out.println("set");
        String s = "";
        Expression instance = new Expression();
        instance.set(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class Expression.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        Expression instance = new Expression();
        String expResult = "";
        String result = instance.get();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of evaluate method, of class Expression.
     */
    @Test
    public void testEvaluate_0args() {
        System.out.println("evaluate");
        Expression instance = new Expression();
        String expResult = "";
        String result = instance.evaluate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of evaluate method, of class Expression.
     */
    @Test
    public void testEvaluate_String() {
        System.out.println("evaluate");
        String expr = "";
        Expression instance = new Expression();
        String expResult = "";
        String result = instance.evaluate(expr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMode method, of class Expression.
     */
    @Test
    public void testSetMode() {
        System.out.println("setMode");
        char m = ' ';
        Expression instance = new Expression();
        instance.setMode(m);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMode method, of class Expression.
     */
    @Test
    public void testGetMode() {
        System.out.println("getMode");
        Expression instance = new Expression();
        char expResult = ' ';
        char result = instance.getMode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of round method, of class Expression.
     */
    @Test
    public void testRound() {
        System.out.println("round");
        double value = 0.0;
        int scale = 0;
        Expression instance = new Expression();
        double expResult = 0.0;
        double result = instance.round(value, scale);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isGood method, of class Expression.
     */
    @Test
    public void testIsGood() {
        System.out.println("isGood");
        Expression instance = new Expression();
        boolean expResult = false;
        boolean result = instance.isGood();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
