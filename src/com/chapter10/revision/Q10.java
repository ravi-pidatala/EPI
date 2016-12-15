package com.chapter10.revision;

import com.chapter10.TreeNode;

public class Q10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * Compute in order successor.
	 * 
	 *  1. If node contains right child, return leftmost node of the right child. If right child does not have any left node, return the right child
	 *  2. If node is left child of its parent, return its parent. Else go up till a node is found that is left child to its parent. return the parent.
	 *  	If no such node found, return null.
	 */
	public TreeNode getInOrderSuccessor(TreeNode node) {
		
		if (node.right != null) {
			TreeNode result = node.right;
			
			while (result.left != null) {
				result = result.left;
			}
			return result;
		}
		
		/*
		 *  Iterate as long as node is right child of parent.
		 *  We will find node that is left child to parent or root node. 
		 *  In either case node.parent is the answer.
		 */
		
		while (node.parent != null && node.parent.right == node) {
			node = node.parent;
		}
		return node.parent;
		
	}
}
