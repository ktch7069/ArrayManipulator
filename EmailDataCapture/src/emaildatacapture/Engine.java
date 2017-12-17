/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emaildatacapture;

import org.apache.log4j.Logger;

/**
 *Engine Class
 *To instantiate other class and run program
 *Use Singleton Pattern to ensure only 1 object is created
 * @author Trump-PC
 */
public class Engine {
    
    private static Engine engineInstance;
    
   /**
    * Constructor to make complier happy
    *Instantiate other classes 
    */
   private Engine(){}
    
    public static Engine getObject(){
        
        if(engineInstance ==null){
            
         engineInstance= new Engine();        
        }
            
         return engineInstance;   
            
           
    }
    
    
    public void run(){
        
      System.out.println("hooray, I am running da project");    
    }
    
}  
    
    
    
