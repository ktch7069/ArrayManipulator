package arraymanipulator;
import java.util.Random;
/**
 * ArrayShuffler Class
 * Concrete class for abstract ArrayManipulator class
 * Object of this class randomly shuffle a given char array
 * @author tchungk
 */
public class ArrayShuffler extends ArrayManipulator {
    
    /**
     * Constructor
     */
    public ArrayShuffler(){}
    
    /**
     * ArrayShuffler algorithm
     * Runtime - O(n)
     * @param none
     */
    public void runAlgorithm(){
       
        Random randGen = new Random();    
        char temp;
        
        for(int i=0; i<this.size; i++){
            
            temp =this.data[i];
            
            //getting a random number between 0 - (size-1)
            //ensuring that rand != i
            int rand = randGen.nextInt(this.size);
            while(rand ==i){  
               rand = randGen.nextInt(this.size);
            }
            
            //simple swap
            data[i]=data[rand];
            data[rand]=temp;       
        }
        
    }
   
}
