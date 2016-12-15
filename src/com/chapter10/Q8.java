package com.chapter10;

import java.util.Stack;

public class Q8 {

	public static void main(String[] args) {
		TreeNode root = TreeUtil.getTree();
		
		Q8 q = new Q8();
		q.preOrderITer(root);
	}
	
	/* current, left, right
	 *  iterative pre order traversal.
	 */
	public void preOrderITer(TreeNode root) {
		if (root == null) {
			return;
		}
		
		Stack<TreeNode> s = new Stack<>();
		s.push(root);
		TreeNode n = null;
		
		while (!s.isEmpty()) {
			n = s.pop();
			if (n != null) {
				System.out.print(n + ",");
				s.push(n.right);
				s.push(n.left);// left will be the next node to get processed
			}
		}
		
	}

}
