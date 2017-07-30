package arraymanipulator;

/**
 * ArrayReverser Class
 * Concrete class for abstract ArrayManipulator class
 * Object of this class reverse a given char array
 * @author tchungk
 */
public class ArrayReverser extends ArrayManipulator {

    /**
     * Constructor
     */
    public ArrayReverser(){}

    
    /**
     * Reverse data array with O(n/2) runtime
     * @param none
     */
    public void runAlgorithm(){
        
        //setting up 2 pointers point to the 
        //start and end of data char array
        int startPtr=0;
        int endPtr=data.length-1;
        
        char temp;
        
        //swapping elements pointed to by
        //endPtr and startPtr
        while(startPtr< endPtr ){
           
            temp = data[startPtr]; 
            data[startPtr]=data[endPtr];
            data[endPtr]=temp;
            startPtr++;
            endPtr--;
        }
    
    
    }
}
