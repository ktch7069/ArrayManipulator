package arraymanipulator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tester for ArrayReverser class
 * @author tchungk
 */
public class ArrayReverserTest {
    
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
        String result = reverse.getData();
        
        //convert resuts,testString to array
        char[] resultArray =result.toCharArray();
        char[] testStringToArray =testString.toCharArray();
        
        //converting char[] to string
        String resultString= new String(result);
        System.out.println("The original string is : "+testString);
        System.out.println("The reversed string is : "+resultString);
        assertEquals(result,expectedResult);
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
