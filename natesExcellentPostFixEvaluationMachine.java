import java.util.*;
public class natesExcellentPostFixEvaluationMachine {
	public static void main (String args[]) {
		System.out.println(evalPostFix("99^"));
	}
	static int evalPostFix(String x) throws NatesMostExcellentMissingIntegerForOperationException {
		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i < x.length(); i++) {
			char ch = x.charAt(i);
			if (ch >= '0' && ch <= '9')
				st.push(ch - '0');
			else {
				int a = st.pop();
				if(st.isEmpty()) throw new NatesMostExcellentMissingIntegerForOperationException();
				else {
					int b = st.pop();
				switch(ch) {
				case '+': st.push(a + b); break;
				case '-': st.push(a - b); break;
				case '*': st.push(a * b); break;
				case '/': st.push(a / b); break;
				case '^': st.push((int)Math.pow(a, b)); break;
				}
			}
			}
		}
		return st.pop();
	}
}
 class NatesMostExcellentMissingIntegerForOperationException extends Exception{
		public NatesMostExcellentMissingIntegerForOperationException() {
			super("Insufficent integers for expression");
		}
		public NatesMostExcellentMissingIntegerForOperationException(String message) {
			super(message);
		} 
}
