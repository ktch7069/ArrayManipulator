/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraymanipulator;

import java.util.Arrays;
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
public class ArrayShufflerTest {
    
    public ArrayShufflerTest() {
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
     * Test of runAlgorithm method, of class ArrayShuffler.
     * The  should be different from input
     */
    @Test
    public void testRunAlgorithm() {
        
        System.out.println("Arry shuffler Test case 1 : Normal case - array length >1.");
        
        String testString ="Kai 1";
            
        ArrayShuffler shuffle=new ArrayShuffler();
        shuffle.setData(testString);
        shuffle.runAlgorithm();
        String result =shuffle.getData();
         
        String resultString = new String(result);
        char[] testStringToArray = testString.toCharArray();
        
        System.out.println("The original string is : "+testString);
        System.out.println("The shuffled string is : "+resultString);
        
        //The two results are supposed to be different after shuffled
        assertFalse(Arrays.equals(result, testStringToArray));
       
    }
     
}
