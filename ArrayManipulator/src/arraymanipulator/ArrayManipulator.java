package arraymanipulator;
import java.lang.String.*;

/**
 * ArrayManipulatro class : An abstract class to collect
 * ArrayReverser and ArrayReshuffler, and run polymorphic methods
 * @author tchungk
 */
public abstract class ArrayManipulator {

    int size;
    char data[];
    
    /**
     * Constructor to initialize a char array
     * @param none
     */
    public ArrayManipulator(){}
    
    //setData method
    //@param string from user
    public void setData(String aString){
        
         size= aString.length();
         data = aString.toCharArray();
    }
   
    //getSize method
    //@param none
    public int getSize(){
        return size;
    }
    
    //getData method
    //convert data array into string and return
    //@param none
    public String getData(){
        
        String dataString = new String(data);
        return dataString;
    }
    
    //Abstract method force the subclass to
    //implement runAlgorithm method
    abstract void runAlgorithm();
   
}
