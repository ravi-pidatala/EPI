package com.chapter16;

import java.util.ArrayList;
import java.util.List;

import com.chapter10.TreeNode;

public class Q8 {

	public static void main(String[] args) {
		
	}
	
	/*
	 * Write program which returns all distinct binary trees with a specified number of nodes. 
	 * Count of left subtree. start from 0 to max.
	 */
	List<TreeNode> generateAllBinaryTrees(int n) {
		
		List<TreeNode> subRootList = new ArrayList<>();
		if (n == 0) {
			subRootList.add(null);
		}
		
		for (int leftNodes = 0; leftNodes < n; leftNodes++) {
			int rightNodes = n - leftNodes - 1;
			
			List<TreeNode> leftSubTreeList = generateAllBinaryTrees(leftNodes);
			List<TreeNode>  rightSubTreeList = generateAllBinaryTrees(rightNodes);
			
			for (TreeNode left: leftSubTreeList) {
				for (TreeNode right: rightSubTreeList) {
					TreeNode subroot = new TreeNode("a");
					subroot.left = left;
					subroot.right = right;
					subRootList.add(subroot);
				}
			}
		}
		return subRootList;
	}
	
	
	
	
	

}
