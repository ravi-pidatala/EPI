package com.chapter15;

import com.chapter10.TreeNode;

public class Q2 {

	public static void main(String[] args) {
		
	}
	
	/*
	 * Find first key greator than a given value in a bst.
	 * 
	 * Program takes input as BST and a value. return first key that would appear in in order traversal which is greator than input value.
	 * 
	 * if node value is > input, save the node value in temp. and go left. 
	 * if node value < input, go right and check.
	 * o[h] time and o[1] space.
	 * 
	 */
	TreeNode getKey(TreeNode root, int value) {
		
		TreeNode temp = null;
		
		TreeNode node = root;
		
		while (node != null) {
			if (node.data > value) {
				temp = node;
				node = node.left;
			} else {
				// gp right
				node = node.right;
			}
		}
		return temp;
	}
	

}
