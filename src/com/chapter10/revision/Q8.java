package com.chapter10.revision;

import java.util.Stack;

import com.chapter10.TreeNode;
import com.chapter10.TreeUtil;

public class Q8 {

	public static void main(String[] args) {
		TreeNode root = TreeUtil.getBinaryTree();
		
		Q8 q = new Q8();
		q.preOrderRecursion(root);
		System.out.println("");
		q.preOrder(root);
	}
	
	/*
	 * pre order traversal without recursion.
	 * 
	 * current , left, right.
	 * 
	 * process current. 
	 * add right, add left.
	 * 
	 * 
	 */
	void preOrder(TreeNode root) {
		
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		
		while (!stack.isEmpty()) {
			TreeNode current = stack.pop();
			
			System.out.print(current.s + ",");
			if (current.right != null) {
				stack.push(current.right);
			}
			
			if (current.left != null) {
				stack.push(current.left);
			}
  		}
		
	}
	
	void preOrderRecursion(TreeNode node) {
		//current, left, right
		if (node != null) {
			System.out.print(node.s + ",");
			preOrderRecursion(node.left);
			preOrderRecursion(node.right);
		}
	}
	
	

}
