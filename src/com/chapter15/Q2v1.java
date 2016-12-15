package com.chapter15;

import com.chapter10.TreeNode;

public class Q2v1 {

	public static void main(String[] args) {
		
	}
	
	/*
	 * Given BST and value.. key's value should be equal to input value and appear first in in order walk.
	 */
	TreeNode getKey(TreeNode root, int value) {
		
		TreeNode temp = null;
		TreeNode node = root;
		
		while (node != null) {
			if (node.data == value) {
				temp = node;
				// check in left.no nned to check in right
				node = node.left;
			} else if (node.data > value) {
				// check in left. no need in right.
				node = node.left;
			} else {
				node = node.right;
			}
		}
		return node;
	}

}
