import java.io.*;
import java.util.*;
public class NatesMostExcellenetBracketBalanceConformationMachine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(bb("{{}"));
		System.out.println(bb("[[]"));
		System.out.println(bb("({}[])"));
	}
	static boolean bb(String sst){
		Stack<Character> st = new Stack<Character>();
		for(char x: sst.toCharArray()){	
			if(x  == '(' || x == '[' || x == '{')
				st.push(x);
			else if (st.empty()) return false;
			else{
				char before = (char)st.pop();
				if((before == '(' && x != ')')||(before == '[' && x != ']')||(before == '{' && x != '}'))
					return false;
			}
			
		}
		if(st.isEmpty())
			return true;
		return false;
	}

}
