package com.chapter10.revision;

import java.util.ArrayList;
import java.util.List;

import com.chapter10.TreeNode;
import com.chapter10.TreeUtil;

public class Q11 {

	public static void main(String[] args) {
		Q11 q = new Q11();
		
		TreeNode root = TreeUtil.getBinaryTree();
		
		List<TreeNode> result = new ArrayList<>();
		q.inOrderTraversal(root, result);
		
		for (TreeNode node: result) {
			System.out.print(node.s + ",");
		}
	}

	
	/*
	 * Direct implementation of in order traversal using recursion has o[h] space where h is height of tree.
	 * Non recursive program for computing the in order traversal sequence of a binary tree.Assume nodes have parent feilds.
	 * o[1] space
	 */
	public void inOrderTraversal(TreeNode root, List<TreeNode> path) {
		// left, current, right
		
		TreeNode prev = null;
		TreeNode next = null;
		TreeNode current = root;
		
		while (current != null) {
			
			if (prev == current.parent) {
				// got down towards left from parent.Parent i.e. prev did not get processed.
				if (current.left != null) {
					next = current.left;
				} else {
					path.add(current);
					next = (current.right != null) ? current.right: current.parent;
				}
			} else if (current.left == prev) {
				path.add(current);
				next = (current.right != null) ? current.right: current.parent;
			} else { // done with both children
				next = current.parent;
			}
			
			prev = current;
			current = next;
		}
	}
	
}
