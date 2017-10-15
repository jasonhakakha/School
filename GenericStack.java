import java.util.*;
public class GenericStack<E> {
	private ArrayList<E> arr = new ArrayList<E>();
	private int top = 0;
	
	public int getSize(){
		return top;
	}
	
	public void push(E x){
		top++;
		arr.add(x);
	}
	
	public E pop() {
		if(top == 0)
			return null;
		return arr.remove(--top);
	}
	
	public E peek(){
		if(top == 0) 
			return null;
		//I dont know why it wont let me return arr.get(top)
		return arr.get(arr.size() - 1);
	}
	public String toString(){
		return arr.toString();
	}
	
	public static void main (String args[]){
		 GenericStack<String> stack1 = new GenericStack<>();
		 
         System.out.println("Stack1 size before adding elements: " + stack1.getSize());
         stack1.push("london");
         stack1.push("Paris");
         stack1.push("la");
         System.out.println(stack1);
         System.out.println("Stack1 size after adding elements: " + stack1.getSize());

         GenericStack<Integer> stack2 = new GenericStack<>();

         stack2.push(2);
         stack2.push(-9);
         System.out.println("\n"+ stack2.peek());
         stack2.push(21);
         //System.out.println(stack2.getSize());
         System.out.println(stack2.pop());
         stack2.push(29);
         System.out.println(stack2);
         System.out.println("Stack2 size: " + stack2.getSize());
	}
}
