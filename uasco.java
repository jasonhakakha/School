
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        File file = new File(cowsignal.in);
        Scanner in = new Scanner(file);
        
        PrintStream o = new PrintStream(new File("cowout.in"));
 
       
        PrintStream console = System.out;
 
        System.setOut(o);
        
        int lines = in.nextInt();
        int length = in.nextInt();
        int mag = in.nextInt();
        
        for(int i = 0; i <= lines; i++){
            String temp = in.nextLine();
            for(int j = 0; j < mag; j++){
                for(int k = 0; k < temp.length(); k++){
                    int tem = 0;
                    while(tem < mag){
                        System.out.print(temp.charAt(k));
                        tem++;
                    }
                }
                System.out.println();
            }
        }
    }
    
}
