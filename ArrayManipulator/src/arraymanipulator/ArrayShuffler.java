/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraymanipulator;
import java.util.Random;
/**
 *
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
