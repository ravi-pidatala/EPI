package com.chapter10.revision;

import java.util.ArrayList;
import java.util.List;

import com.chapter10.TreeNode;
import com.chapter10.TreeUtil;

public class Q15 {

	public static void main(String[] args) {
		TreeNode root = TreeUtil.getTree();
		
		Q15 q = new Q15();
		
		List<TreeNode> exteriorList = q.computeExternalTree(root);
		
		for (TreeNode node: exteriorList) {
			System.out.print(node + ",");
		}
		
	}
	
	/*
	 * Compute the exterior of binary tree
	 * root to leftmost leaf, leaves in left to right order, nodes from rightmost leaf to root.
	 * 
	 * 
	 * root to leftmost leaf. 
	 * all the leaves left to right
	 * Rightmost leaf to root.
	 * 
	 * Leftmost means the node that appears first in in order traversal.
	 * 
	 * 
	 * 
	 */
	List<TreeNode> computeExternalTree(TreeNode root) {
		
		List<TreeNode> exterior = new ArrayList<>();
		if (root != null) {
			exterior.add(root);
			addLeftSubTree(root.left, true, exterior);
			addRightSubTree(root.right, true, exterior);
		}
		return exterior;
	}
	
	void addLeftSubTree(TreeNode node, boolean isBoundary, List<TreeNode> exterior) {
		
		if (node != null) {
			if (isBoundary || isLeaf(node)) {
				exterior.add(node);
			}
			
			addLeftSubTree(node.left, isBoundary, exterior);
			addRightSubTree(node.right, isBoundary && node.left == null, exterior);
		}
	}
	
	void addRightSubTree(TreeNode node, boolean isBoundary, List<TreeNode> exterior) {
		if (node != null) {
			addLeftSubTree(node.left, isBoundary && node.right == null, exterior);
			addRightSubTree(node.right, isBoundary, exterior);
			if (isBoundary || isLeaf(node)) {
				exterior.add(node);
			}
		}
	}
	
	private boolean isLeaf(TreeNode node) {
		if (node.left == null && node.right == null) {
			return true;
		}
		return false;
 	}
	
}
