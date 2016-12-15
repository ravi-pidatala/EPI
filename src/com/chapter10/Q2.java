package com.chapter10;

public class Q2 {

	public static void main(String[] args) {
		
	}
	
	/*
	 * Test if binary tree is symmetric.
	 * 1. node, left, right
	 	if left is symmetric and right is symmetric and left and right values are same node is smmetric.
	 */

	 boolean isSymmetric(TreeNode left, TreeNode right) {
		 if (left == null && right == null) {
		 		return true;
		 }
		 if (left == null || right == null) {
			 return false;
		 }
		 // now both non null.
	 	return left.data != right .data && !isSymmetric(left.left, right.right) && !isSymmetric(left.right, right.left);	 	
	 }
}
