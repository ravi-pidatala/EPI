package com.chapter15;

import com.chapter10.BSTUtil;
import com.chapter10.TreeNode;
import com.chapter10.TreeUtil;

public class Q11 {
	
	public static void main(String [] args) {
		TreeNode root = BSTUtil.getBinarySearchTree();
		Q11 q = new Q11();
		
		// check nodes l and k
		TreeNode l = root.right.left.right.left;
		TreeNode i = root.right;
		TreeNode k = root.right.left.right;
		
		if (q.checkTotalOrdering(l, i, k)) {
			System.out.println("found k between l and i");
		}
		
		
		root = TreeUtil.getBinaryTree();
		// check nodes l and k
		 l = root.right.left.right.left;
		 i = root.right;
		 k = root.right.left.right;

		if (q.checkTotalOrdering(l, i, k)) {
			System.out.println("found k between l and i for binary tree");
		}
				
				
		root = BSTUtil.getBinarySearchTree();
		 l = root.right.left.right.left;
		 i = root.right;
		 k = root.right.left.right;
		 
		if (q.checkTotalOrderingOptmized(l, i, k)) {
			System.out.println("found k between l and i");
		}
		
		
		
	}

	/*
	 * program takes two nodes in a BST, and a third node.
	 * 
	 * 
	 * Check if one of the nodes, is proper ancestor and other node is proper descendant.
	 * 
	 * No parent nodes. 
	 * 
	 * Check which one can be ancestor and which one can be descendant. 
	 * Go from ancestor checking for the node. if the node found , go from the node checking for the other node. 
	 * If other node is also found return true. 
	 * 
	 * else return false.
	 * 
	 * o[h] compexity where h is diff in heights of ancestor and dependent  if node present.
	 * else o[h] worst case where h is height of tree.
	 * 
	 * 
	 * 
	 * From node, go till you find one of the nodes. Start from other than the found nodes and go till you find the node. 
	 * 
	 */
	
	boolean checkTotalOrdering(TreeNode node1, TreeNode node2, TreeNode node) {
		
		if (node1.data == node2.data || node.data == node1.data || node.data == node2.data) {
			return false;
		}
		/*
		 * from node, find node1
		 * from node, find node2
		 * 
		 * if both found or both not found return false.
		 * 
		 * if one found. from the one not found, 
		 * Recurse and find node. if found return true, else return false. 
		 */
		boolean isNode1PorperDesc = isNodeDescendant(node, node1);
		if (isNode1PorperDesc) {
			// check if node 2 is proper ancestor.
			return isNodeDescendant(node2, node);
		}
		
		boolean isNode2ProperDesc = isNodeDescendant(node, node2);
		
		if (isNode2ProperDesc) {
			return isNodeDescendant(node, node1);
		}
		return false;
	}
	
	private boolean isNodeDescendant(TreeNode from, TreeNode target) {
		TreeNode temp = from;

		while (temp != null) {
			if (temp.data == target.data) {
				return true;
			} else if (from.data > temp.data) {
				// go right
				temp = temp.right;
			} else {
				temp = temp.left;
			}
		}
		return false;
	}
	
	boolean checkTotalOrderingOptmized(TreeNode possibleAncestorOrDesc1, TreeNode possibleAncestorOrDesc2, TreeNode middle) {
		// null validation and equality validation.
		
		
		TreeNode search1 = possibleAncestorOrDesc1;
		TreeNode search2 = possibleAncestorOrDesc2;
		
		/*
		 * Stop loop if another node if found from one of the nodes before middle node.
		 * Stop loop if middle is found from one of the nodes
		 * stop loop if both search1 and search2 become null. Do not stop searching if one of them (i.e. desc) becomes null 
		 */
		while (search1 != possibleAncestorOrDesc2 && search2 != possibleAncestorOrDesc1 && search1 != middle && search2 != middle && 
				(search1 != null || search2 != null)) {
			if (search1 != null) {
				search1 = search1.data > middle.data ? search1.left: search1.right;
			}
			if (search2 != null) {
				search2 = search2.data > middle.data ? search2.left: search2.right;
			}
		}
		
		if (search1 == possibleAncestorOrDesc2 || search2 == possibleAncestorOrDesc1 || (search1 != middle  && search2 != middle)) {
			return false;
		}
		return isNodeDescendant(middle, search1 == middle ? possibleAncestorOrDesc2: possibleAncestorOrDesc1);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
