

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
public class test {
	static Set<String> ps = new HashSet<>();

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		File file = new File("src/dictionary.txt");
		Scanner scan = new Scanner(file);
		Scanner in = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<>();
		ArrayList<String> valid = new ArrayList<>();

                System.out.println("test");
		while(scan.hasNextLine()) {
                    String temp = scan.nextLine();
                  	if(temp.length() < 7) list.add(temp);
                    //System.out.println(temp);
			
		}
		String s = "CATS";
		permute(s);
		for(String x: ps) {
			//System.out.println(x);
			for(int i = 1; i <= x.length(); i++) {
				String temp = x.substring(0, i);
				if(list.contains(temp) && temp.length() > 1)
					//System.out.println(temp);
					valid.add(temp);
			}
		}
		System.out.println(valid.size());
		boolean won = false;
		while(!won){
			String temp = in.nextLine();
			if(valid.contains(temp)){
				valid.remove(temp);
				System.out.println("Remaining: " + valid.size());
			}
			else System.out.println("WRONG YA IDIOT");
		}
	}
	static void permute(String s) {
		permute(s, "");
	}
	static void permute(String s, String built) {
		if (s.length() == 0) {
			ps.add(built);
		}
		for (int i = 0; i < s.length(); i++) {
			permute(s.substring(0, i) + s.substring(i + 1), 
					built + s.charAt(i));
		}
	}

}

