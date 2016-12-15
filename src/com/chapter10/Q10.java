package com.chapter10;

public class Q10 {

	public static void main(String[] args) {
		Q10 q = new Q10();
		Q9 q9 = new Q9();
		
		TreeNode root = TreeUtil.getTree();
		
		q9.printInOrder(root);

		System.out.println(q.getInOrderSuccessor(root, root));
		System.out.println(q.getInOrderSuccessor(root, root.left.left));// in order for Node C
		System.out.println(q.getInOrderSuccessor(root, root.left.right.right));// in order for Node G
		
	}
	
	public TreeNode getInOrderSuccessor(TreeNode root, TreeNode n) {
		if (n == null || root == null) {
			return null;
		}
		
		if (n.right != null) {
			n = n.right;
			while (n.left != null) {
				n = n.left;
			}
			return n;
		}
		
		while (n.parent != null && n == n.parent.right) {
			n = n.parent;
		}
		return n.parent;
	}
	
}
