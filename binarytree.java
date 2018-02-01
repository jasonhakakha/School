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
	

	public static void main(String[] args) {
		Tree<String> t2 = new Tree<>();
		t2.root = new node<>("aaa");
		t2.root.right = new node<>("bbb");
		t2.root.right.left = new node<>("ccc");;
		System.out.println(t2.countLeftNodes());

	}
	public int countLeftNodes(){
		return countLeftNodes(root);
	}
	private int countLeftNodes(node<E> c){
		int count = 0;
		if(c.right != null)
			 count += countLeftNodes(c.right);
		if(c.left != null)
			count += 1 + countLeftNodes(c.left); 
		return count;
	}
	static class node<E> {
		E data;
		node<E> left, right;
		node(E data) {this.data = data;}


	}

}
