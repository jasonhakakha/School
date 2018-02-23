package xcd;

public class Trie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	private TrieNode root = new TrieNode();
	
	public void add(String s) {
		TrieNode tmp = root;
		for(int i = 0; i < s.length(); i++) {
			int index = s.charAt(i) - 'a';
			if(tmp.alpha[index] == null) 
				tmp.alpha[index] = new TrieNode();
			tmp = tmp.alpha[index];
			
			
		}
		tmp.end = true;
	}
	
	public boolean contains(String s) {
		TrieNode tmp = root;
		for(int i = 0; i < s.length(); i++) {
			int index = s.charAt(i) - 'a';
			if(tmp.alpha[index] == null) 
				return false;
			tmp = tmp.alpha[index];
		}
		return tmp.end;
	}
	
	public void delete(String s) {
		delete(s, root, 0);
	}
	private boolean delete(String s, TrieNode curr, int index) {
		if(index == s.length()) {
			if(!curr.end)
				return false;
		curr.end = false;
		for(TrieNode tm: curr.alpha)
			if(tm != null) return false;
		return true;
		}
		
		int trieIndex = s.charAt(index) - 'a';
		if(curr.alpha[trieIndex] == null) return false;
		
		if(delete(s, curr.alpha[trieIndex],index + 1)) {
			curr.alpha[trieIndex] = null;
			for(TrieNode tm: curr.alpha)
				if(tm != null) return false;
			return true;
		}
		return false;
	}
	public void printAll() {
		print(root, "");
	}
	private void print(TrieNode curr, String s) {
		if(curr.end) System.out.println(s);
		for(int i = 0; i < curr.alpha.length; i++) {
			if(curr.alpha[i] != null)
				print(curr.alpha[i], s + curr.alpha[i]);
		}
		
	}
	
	private class TrieNode{
		TrieNode[] alpha = new TrieNode[26];
		boolean end;
	}

}
