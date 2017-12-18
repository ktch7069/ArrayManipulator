/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emaildatacapture;

//import org.apache.log4j.Logger;

/**
 *Engine Class
 *To instantiate other class and run program
 *Use Singleton Pattern to ensure only 1 object is created
 * @author Trump-PC
 */
public class Engine {

    /**
     * @return the engineInstance
     */
    public static Engine getEngineInstance() {
        return engineInstance;
    }

    /**
     * @param aEngineInstance the engineInstance to set
     */
    public static void setEngineInstance(Engine aEngineInstance) {
        engineInstance = aEngineInstance;
    }
    
    private static Engine engineInstance;
    
   /**
    * Constructor to make complier happy
    *Instantiate other classes 
    */
   private Engine(){}
    
    private final String propertyFilePath ="src/emaildatacapture/setting.txt";
    public static Engine getObject(){
        
        if(getEngineInstance() ==null){
            
            setEngineInstance(new Engine());        
        }
            
         return getEngineInstance();   
    }
    
    
    public void run(){
        
      DataReader reader = new DataReader(propertyFilePath);
        
      System.out.println("hooray, I am running da project");    
    }
    
}  
    
    
    
