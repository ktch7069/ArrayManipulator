/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emaildatacapture;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


/**
 *
 * @author Trump-PC
 */


public class DataReader {
    
    private String dataPath="inputDataPath";
    Properties props;
    
    public DataReader(String settingPath){
      
        FileInputStream in =null;
        props= new Properties();
        
        try{    
            in = new FileInputStream(settingPath);
            props.load(in);
        }catch(IOException e){
            
            System.out.println("Config file is missing!");
            e.printStackTrace();
        }
        
        this.dataPath = props.getProperty(dataPath);
        System.out.println(dataPath);
        
    }
    
    
    
    
    
    
    
}
