package com.chapter15;

import com.chapter10.TreeNode;

public class Q4 {

	public static void main(String[] args) {
		
	}
	
	/*
	 * Compute LCA in binray search tree.
	 * keys are distinct.
	 * Input takes a BST and two nodes. no parent references.
	 * o[h] time.
	 */
	TreeNode getLCA(TreeNode node, TreeNode a, TreeNode b) {
		
		if (node == null) {
			return null;
		}
		/*
		 * Assume that both nodes are present in the tree. Or else, 
		 * before starting for the search, search for the nodes , takes o[h] time to verify both nodes are present.
		 * if both nodes are greator than node value, check in rght
		 * if both nodes less than node check in left.
		 * Other cases return current.
		 */
		if(a.data > node.data && b.data > node.data) {
			return getLCA(node.right, a, b);
		}
		
		if (a.data < node.data && b.data < node.data) {
			return getLCA(node.left, a, b);
		}
		
		return node;
	}
	
	
	// s is small and b is big.
	TreeNode iterativeLCA(TreeNode root, TreeNode s, TreeNode b) {
		//validation
		
		TreeNode node = root;
		while (node != null && (node.data < s.data || node.data > b.data)) {
			while (node != null && node.data < s.data) {
				node = node.right;
			}
			
			while (node != null && node.data > b.data) {
				node = node.left;
			}
		}
		return node;
	}

}
