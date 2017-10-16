import java.util.*;
import java.io.*;
public class NatesMostExcellentProgramWhichRecievesATextFileAndPrintsTheAmountOfTimesEachCharacterOccured {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file = new File("Unicode.txt");
		Scanner in = new Scanner(file);
		Map<Character, Integer> map = new HashMap<>();
		while(in.hasNext()) {
			String temp = in.next();
			for(char c: temp.toCharArray()) {
				if(map.containsKey(c))
					map.put(c, map.get(c) + 1);
				else
					map.put(c, 1);
					
			}
			
		}
		for(char x: map.keySet()) {
			System.out.println(x + ": " + map.get(x));
		}
	}

}
