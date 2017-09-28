import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class replace{

	public static void main (String args[]){
		File file = new File(home/jason/compsci/words.txt);
		FileReader to = new FileReader(file);
		
		if(!file.exists()){
			System.err.println("File does not exits");
			System.exit(1);
		}
		String total = "";
		Scanner scan = new Scanner(file);
		while(scan.hasNext()){
			String temp = scan.nextLine().replaceAll("a","*");
			total += temp;
			}

		
		to.write(total);
		to.close();
		
	


	}
}
