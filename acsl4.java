package alg;
import java.util.ArrayList;
import java.util.Scanner;

//binary
public class Tree {
	private static node root;

	public static void main(String[] args) {
//		Tree<String> t2 = new Tree<>();
//		t2.root = new node<>("aaa");
//		t2.root.right = new node<>("bbb");
//		t2.root.right.left = new node<>("ccc");;
		Scanner in = new Scanner(System.in);

		for(int i = 0; i < 5; i++) {
			Tree temp = new Tree();
			System.out.println("Input: ");
			String tstr = in.nextLine().toUpperCase();
			char[] arr = tstr.toCharArray();
			temp.root = new node(arr[0], 1);
			for(int j = 1; j < arr.length; j++) {
				add(arr[j]);
			}
			System.out.println(count(temp.root));
		}

	}
	public static int count(node c) {
		if(c == null || c.right == null) return 0;
		return c.count + count(c.right);
	}
	
	
	public static void add(char x) {add(root,  x);}
	private static void add(node c, char x) {
		if(c.data == x)
			c.count++;
		else if(c.right == null) {
			c.right = new node(x, 1);
		}
		else {
			add(c.right, x);
		}
	}
	
	static class node {
		char data;
		int count;
		node right;
		node(char data, int count) {
			this.data = data;
			this.count = count;
		}
	}

}
