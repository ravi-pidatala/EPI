package com.chapter10.revision;

import com.chapter10.TreeNode;
import com.chapter10.TreeUtil;

public class Q1v2 {

	public static void main(String [] args) {
		TreeNode root = TreeUtil.getTree();
		
		Q1v2 q = new Q1v2();
		System.out.println(q.getnonKBalanced(root, 1));
	}
	
	/*
	 * input is binary tree and positive int k. 
	 * return node in the binary tree such that the node is not k balanced but all of its descendants are. 
	 * Use recursion. As soon as we found a node which s not k balanced return it.
	 * 
	 * For root node, height is 0.
	 * go to left branch.
	 * 
	 * 
	 */
	public TreeNode getnonKBalanced(TreeNode node, int k) {
		if (node == null) {
			return null;
		}
		
		TreeNode temp = getnonKBalanced(node.left, k);
		if (temp != null) {
			return temp;
		 }
		
		temp = getnonKBalanced(node.right, k);
		if (temp != null) {
			return temp;
		}
		
		int leftHeight = node.left == null ? 0: node.left.height;
		int rightHeight = node.right == null ? 0:node.right.height;
		
		node.height = leftHeight + rightHeight + 1;
		return (Math.abs(leftHeight - rightHeight) <= k) ?  null: node;
	}
	
	
	
	
	
}
