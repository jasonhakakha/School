import java.util.ArrayList;

//binary
public class Tree<E> {
	private node<E> root;



	public int size() {return size(root);}
	public int size(node<E> c) {
		if (c == null) return 0;
		return 1 + size(c.left) + size(c.right);
	}
	public int empty() {return empty(root);}
	private int empty(node<E> c) {
		if(c == null) return 1;
		return empty(c.left) + empty(c.right);
	}
	public int leaf() {return leaf(root);}
	private int leaf(node<E> c) {
		if(c == null) return 0;
		if(c.left == null && c.right == null) return 1;
		return leaf(c.left) + leaf(c.right);
	}
	public int countleft() {return countleft(root);}
	private int countleft(node<E> c) {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree<Integer> t1 = new Tree();
		t1.root = new node(1);
		t1.root.left = new node(2);
		t1.root.right = new node(3);
		Tree<Character> t2 = new Tree();
		System.out.println(t2.leaf());

	}
	static class node<E> {
		E data;
		node<E> left, right;
		node(E data) {this.data = data;}


	}

}
