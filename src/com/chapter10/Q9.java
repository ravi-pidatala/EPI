package com.chapter10;

public class Q9 {
	int i = 1;
	public static void main(String[] args) {
		TreeNode root = TreeUtil.getTree();
		Q9 q = new Q9();
		q.printInOrder(root);
		System.out.println("3-->" + q.getKNode(root, 3));
		System.out.println("5-->" + q.getKNode(root, 5));
		System.out.println("1-->" + q.getKNode(root, 1));
		System.out.println("6-->" + q.getKNode(root, 6));
		System.out.println("8-->" + q.getKNode(root, 8));
		System.out.println("19-->" + q.getKNode(root, 19));
		System.out.println("-1-->" + q.getKNode(root, -1));
		System.out.println("16-->" + q.getKNode(root, 16));
	}
	
	/*
	 * in order traversal
	 */
	public void printInOrder(TreeNode root) {
		if (root != null) {
			printInOrder(root.left);
			System.out.println(i++ + "-->" + root);
			printInOrder(root.right);
		}
	}
	
	
	/*
	 * Find kth node in in order traversal. given that each node stores count of nodes in its subtrees
	 */
	public TreeNode getKNode(TreeNode n, int k) {
		//val
		if (k < 1 || n == null || n.childrenCount + 1 < k) {
			return null;
		}
		//return getNode(n, k);
		return getNodeIter(n, k);
	}
	
	private TreeNode getNode(TreeNode n, int k) {
		// check if current node is the kth node
		int leftCount = n.left == null ? -1: n.left.childrenCount;
		
		if (k == leftCount + 2) {
			return n;
		}
		
		// check if in left branch
		if (k < leftCount + 2) {
			return getNode(n.left, k);
		}
		return getNode(n.right, k - leftCount - 2);
	}
	
	private TreeNode getNodeIter(TreeNode n, int k) {
		
		while (true) {
			int leftCount = n.left == null ? -1: n.left.childrenCount;
			
			if (k == leftCount + 2) {
				return n;
			}
			
			if (k < leftCount + 2) {
				n = n.left;
			} else {
				n = n.right;
				k = k - leftCount - 2;
			}
			
		}
		
		
	}

}
