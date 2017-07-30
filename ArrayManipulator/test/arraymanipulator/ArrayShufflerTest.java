package arraymanipulator;

import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tester for ArrayShuffler class
 * @author tchungk
 */
public class ArrayShufflerTest {
   
    /**
     * Test of runAlgorithm method, of class ArrayShuffler.
     * The  should be different from input
     * @param none
     */
    @Test
    public void testRunAlgorithm() {
        
        System.out.println("Arry shuffler Test case 1 : Normal case - array length >1.");
        
        String testString ="Kai 1";
            
        ArrayShuffler shuffle=new ArrayShuffler();
        shuffle.setData(testString);
        shuffle.runAlgorithm();
        String result =shuffle.getData();
        
        //convertResult to char array
        char[] resultArray = result.toCharArray();
        char[] testStringToArray = testString.toCharArray();
        
        System.out.println("The original string is : "+testString);
        System.out.println("The shuffled string is : "+result);
        
        //The two results are supposed to be different after shuffled
        assertFalse(Arrays.equals(resultArray, testStringToArray));
       
    }
     
}
