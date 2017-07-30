/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraymanipulator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tchungk
 */
public class ArrayReverserTest {
    
    public ArrayReverserTest() {
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
     * ArrayReverser class
     * Test of runAlgorithm method- normal case
     * String.length() >1
     */
    @Test
    public void testRunAlgorithm() {
        System.out.println("Arry Reverser Test case 1 : Normal case - array length >1.");
        
        String testString ="Kai 1";
        String expectedResult=new String("1 iaK");
        
        ArrayReverser reverse=new ArrayReverser();
        reverse.setData(testString);
        reverse.runAlgorithm();
        char[] result =reverse.getData();
        
        //converting char[] to string
        String resultString= new String(result);
        System.out.println("The original string is : "+testString);
        System.out.println("The reversed string is : "+resultString);
        assertEquals(expectedResult,resultString);
    }
    
    
    /**
     * ArrayReverser Class
     * Test of runAlgorithm method- boundary case
     * String.length()==1
     */
    @Test
    public void testRunAlgorithm1() {
        System.out.println("Array Reverser Test case 2 : Boundary - 1 char only.");
        
        String testString ="K";
        String expectedResult=new String("K");
        
        ArrayReverser reverse=new ArrayReverser();
        reverse.setData(testString);
        reverse.runAlgorithm();
        String result =reverse.getData();
        
        //converting char[] back to string
        String resultString= new String(result);
        System.out.println("The original string is : "+testString);
        System.out.println("The reversed string is : "+resultString);
        assertEquals(expectedResult,resultString);
    }
    
}
