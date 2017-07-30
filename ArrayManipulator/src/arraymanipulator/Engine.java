package arraymanipulator;
import java.util.Scanner;

/**
 * Engine class: A class reads input, create
 * necessary object and provides user interaction
 * @author tchungk
 */
public class Engine {

    private String input;
    //Setting constant variables for selections
    private final String exit ="0";
    private final String selectReverse ="1";
    private final String selectShuffle="2";
    
    private boolean selectionDone=false;
    private boolean terminate=false;
    private String selection;
   
    //Reverse/Shuffle Objects
    private ArrayReverser reverse;
    private ArrayShuffler shuffler;
    
    //for displaying debugging messages only
    private boolean debug =false;
    
    public Engine(){
        
        reverse = new ArrayReverser();
        shuffler = new ArrayShuffler();
        
    }

    public void run(){
        
        System.out.println("****Welcome to Kai's String Manipulator!****");
        Scanner in = new Scanner(System.in);
        
        //Loop over to get a line of input
        while(terminate==false){
            //restting this flag back to false so we can enter 
            //algorithm choice menu
            selectionDone=false;
            
            System.out.print("Please enter a line of string and press enter (enter 0 to quit): ");
            this.input = in.nextLine();
           
            //Debugging message
            if(debug==true){
                System.out.println("DEBUG:Input is: "+input);
            }
            //when user wants to go home....
            if (input.equals(exit)){
                terminate=true;
                break;
            }
            //now we loop over prompting user to choose reverse or shuffle
            else{
                while(selectionDone == false){
                    
                    System.out.print("Enter 1 to reverse this string, 2 to shuffle string (enter 0 to quit): ");
                    this.selection=in.nextLine();
                    
                    if(selection.equals(selectReverse)){
                        reverse.setData(input);
                        reverse.runAlgorithm();
                        this.printResult(selection);
                        selectionDone=true;
                    }
                    else if(selection.equals(selectShuffle)){
                        shuffler.setData(input);
                        shuffler.runAlgorithm();;
                        this.printResult(selection);
                        selectionDone=true;
                        
                    }else if (selection.equals(exit)){
                        terminate=true;
                        selectionDone=true;
                    }    
                }
            }  
        }
        
        reverse=null;
        shuffler=null;
        System.out.println(" ");
        System.out.println("***Good Bye!****");
        System.exit(0);
    }
    
    
    private void printResult(String aSelect){
        
        if(aSelect.equals(selectReverse)){
            
            System.out.println("");
            System.out.println("**************RESULT*******************");
            System.out.println("You've selected to reverse the string.");
            System.out.println("The string you enter is: "+input);
            System.out.println("The reversed string is: "+ reverse.getData());
            System.out.println("***************************************");
            System.out.println("");
        }
        else if(aSelect.equals(selectShuffle)){
            
            System.out.println("");
            System.out.println("**************RESULT******************");
            System.out.println("You've selected to shuffle the string.");
            System.out.println("The string you enter is: "+input);
            System.out.println("The shuffled string is: "+shuffler.getData());
            System.out.println("**************************************");
            System.out.println("");
            
        }
        else{
            
            System.out.println("We should have never come here !!!!");
        }
        
    }
}