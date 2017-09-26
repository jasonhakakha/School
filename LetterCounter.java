import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class eachletter{

	public static void main (String args[]){
		File file = new File(home/jason/compsci/words.txt);
		
		if(!file.exists()){
			System.err.println("File does not exits");
			System.exit(1);
		}
		int[] count = new int[26];
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			String temp = scan.nextLine();
			char[] chararray = temp.toCharArray();
			for (char x: chararray){
				char letter = Character.toUpperCase(x);
			if((int)letter > 64 && (int)letter < 91)
				count[letter - 65]++; 
			}

		}
		for(int i = 0; i < 26; i++)
			System.out.println("Number of " + (char)(i + 65)+ "'s: " + count[i]);
	


	}
}
