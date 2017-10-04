class Stack<E>{

	private int size, top;
	private E[] arr;
	public Stack(){
		this(1);
	}
	
	public Stack(int x){
	if (x < 1)
		throw new EmptyStackException();
	size = x;
	top = -1;
	arr = (E[]) new Object[size];
	}		
	
	public E pop(){
		if(top == -1)
			throw new EmptyStackException("Cannot pop empty stack");
		return arr[top--];
	}
	public void push(E x){
		arr[++top] = x;
	}
}
class EmptyStackException extends RuntimeException{
	public EmptyStackException(){
		this("Empty stack exception");
	}
	public EmptyStackException(String exception){
		super(exception);
	}
}
class NegativeStackException extends RuntimeException{
	public NegativeStackException(){
		this("Stack is negative");
	}
	public NegativeStackException(String exception){
		super(exception);
	}
}

	
