package com.chapter10.revision;

import java.util.Stack;

import com.chapter10.TreeNode;
import com.chapter10.TreeUtil;

public class Q9 {

	public static void main(String[] args) {
		TreeNode root = TreeUtil.getTree();
		Q9 q = new Q9();
		System.out.println(q.getkInOrder(root, 10).s);// o[h] space.
		
		System.out.println(q.getkthNode(root, 10));// L
		
		System.out.println(q.getNodex(root, 10));
		
	}
	
	/*
	 * Compute kth node in inorder traversal.
	 * in order--> left, current, right. 
	 * 
	 * to get kth node ,i can do it in o[n] time.
	 * 
	 *  Each node stores number of nodes sub rooted at it. 
	 *  
	 *  Perform iterative in order. 
	 *  
	 */
	
	public TreeNode getkthNode(TreeNode root, int k) {
		//validation
		if (root == null) {
			return null;
		}
		
		if (root.childrenCount + 1 < k) {
			System.out.println( k + " exeed node count.");
		}
		return getxNode(root, k);
	}
	
	public TreeNode getNodex(TreeNode node, int x) {
		
		while (node != null) {
			int leftChildren = node.left != null ? node.left.childrenCount + 1: 0;
			
			if (leftChildren >= x) {
				node = node.left;
			} else if (leftChildren == x - 1) {
				return node;
			} else {
				node = node.right;
				x = x - leftChildren - 1;
			}
		}
		return null;
	}
	
	
	private TreeNode getxNode(TreeNode node, int x) {
		int leftChildren = node.left != null ? node.left.childrenCount + 1: 0;// including the left child
		
		if (leftChildren >= x) {
			// node is on left only.
			return getxNode(node.left, x);
		} 
		if (leftChildren == x - 1) {
			return node;// node is xth child
		} 
		return getxNode(node.right, x - leftChildren - 1);
	}
	
	private void inOrder(TreeNode node) {
		if (node != null) {
			inOrder(node.left);
			System.out.println(node.s);
			inOrder(node.right);
		}
	}
	
	private void iterativeInOrder(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode current = root;
		
		while(current != null || !stack.isEmpty()) {
			if (current != null) {
				stack.push(current);
				current = current.left;
			} else {
				// go up
				current = stack.pop();
				System.out.println(current.s + ",");
				current = current.right;
			}
		}
	}
	
	private TreeNode getkInOrder(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode current = root;
		int index = 1;
		
		while(current != null || !stack.isEmpty()) {
			if (current != null) {
				stack.push(current);
				current = current.left;
			} else {
				// go up
				current = stack.pop();
				if (index++ == k) {
					System.out.println(current.s + ",");
					return current;
				}
				current = current.right;
			}
		}
		return null;
	}
	
}
