public int getDepth(E dest) {
		return getDepth(root, dest, 0);
	}
	
	private int getDepth(BSTNode<E> root, E dest, int depth) {
		if(root == null) return -1;
		if(dest.compareTo(root.data) == 0) return depth;
		if(dest.compareTo(root.data) < 0) 	return getDepth(root.left, dest, depth + 1);
		return getDepth(root.right, dest, depth + 1);
	}
