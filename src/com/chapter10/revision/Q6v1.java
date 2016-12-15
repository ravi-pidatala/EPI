package com.chapter10.revision;

import java.util.ArrayList;
import java.util.List;

import com.chapter10.TreeNode;
import com.chapter10.TreeUtil;

public class Q6v1 {

	public static void main(String[] args) {
		TreeNode root = TreeUtil.getBinaryTree();
		
		Q6v1 q = new Q6v1();
		List<ArrayList<TreeNode>> result = new ArrayList<>();
		q.getAllPaths(root, 12, new ArrayList<TreeNode>(), 0L, result);
		
		
		for (ArrayList<TreeNode> path: result) {
			System.out.println();
			
			for (TreeNode node: path) {
				System.out.print(node.s + ",");
			}
		}
	}
	
	/*
	 * Get all the path to leaf which has specified sum. 
	 * Use recursion. 
	 */
	private void getAllPaths(TreeNode node, long sum, List<TreeNode> path, Long partialSum, List<ArrayList<TreeNode>> result) {
		// add to path. add to sum
		path.add(node);
		partialSum = partialSum * 2 + node.data;
		
		//check if node is leaf.
		if (node.left == null && node.right == null) {
			if (sum == partialSum) {
				// found a path
				result.add(new ArrayList<>(path));
			}
		}
		
		if (node.left != null) {
			getAllPaths(node.left, sum, path, partialSum, result);
		}
		
		if (node.right != null) {
			getAllPaths(node.right, sum, path, partialSum, result);
		}
		
		path.remove(path.size() - 1);// remove the node from the path
		partialSum = (partialSum - node.data) / 2;// update the partial sum
	}

}
