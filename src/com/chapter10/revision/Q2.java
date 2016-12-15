package com.chapter10.revision;

import javax.xml.crypto.Data;

import com.chapter10.TreeNode;
import com.chapter10.TreeUtil;

public class Q2 {

	public static void main(String[] args) {
		TreeNode root = TreeUtil.getSymmetricTree();
		Q2 q = new Q2();
		
		if (q.isymmetric(root)) {
			System.out.println("it is symmetric");
		} else {
			System.out.println("it is not symmetric");
		}
	}

//	/*
//	 * program to check if binary tree is symmetric.
//	 * Tree is symmetric if both the sides are mirror images to each other.
//	 * if for a node, if left and right values are same the node is symmetric in the tree.
//	 * Start from the root and cover all the nodes. 
//	 */
//	boolean isSymmetric(TreeNode node) {
//		if (node == null || (node.left == null && node.right == null)) {
//			return true;
//		}
//		
//		if (node.left != null && node.right != null) {
//			 return node.left.data == node.right.data && isSymmetric(node.left) && isSymmetric(node.right);
//		}
//		
//		// one of them empty
//		return false;
//		
//	}
	
	
	/*
	 * right subtree root value and left subtree root value should be same.
	 * left node of left subtree should be same as right node of the right subtree
	 * right node of the left subtree should be same left node of the right subtree.
	 */
	boolean isymmetric(TreeNode root) {
		return root == null || isSymmetric(root.left, root.right);
	}
	
	boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if (left != null && right != null) {
			return left.data == right.data && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
		}
		return false;
		
		
	}
}
