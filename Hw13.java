import java.util.*;
public class Hw13 {

	public static void main(String args[]){
		boolean read = true;
		Map<Integer, Integer> map = new HashMap<>();
		Scanner in = new Scanner(System.in);
		while(read){
			int temp = in.nextInt();
			if(temp == 0)
				read = false;
			else{
				if(map.containsKey(temp))
					map.put(temp, map.get(temp) + 1);
				else
					map.put(temp, 1);
			}
		}
		int max = 0;
		for(Integer key: map.keySet()){
			if (map.get(key) > max) max = map.get(key);
		}
		System.out.println("Max: ");
		for(Integer key: map.keySet()){
			if (map.get(key) == max)
				System.out.println(key + " ");
			
		}
		in.close();
	}
}
