package com.chapter10.revision;

import java.util.ArrayList;
import java.util.List;

import com.chapter10.TreeNode;
import com.chapter10.TreeUtil;

public class Q6 {

	public static void main(String[] args) {
		TreeNode root = TreeUtil.getBinaryTree();
		
		Q6 q = new Q6();
		
		List<TreeNode> path = new ArrayList<>();
		if (q.getPath(root, path, 51, 0L)) {
			System.out.println("path exists");
		} else {
			System.out.println("no path");
		}
		
		for (TreeNode node: path) {
			System.out.print(node.s + ",");
		}
	}	

	/*
	 * find root to leaf path with specified sum.
	 * Go through the paths in order traversal, when a leaf is reached , check if the sum is the given sum. 
	 * If yes, return the path. else keep searching. 
	 * Once all leaves done, can return null.
	 */

	boolean getPath(TreeNode node, List<TreeNode> path, long sum, Long pathSum) {
		pathSum = pathSum * 2 + node.data;
		path.add(node);
		if (node.left == null && node.right == null) {
			// got into leaf.
			if (pathSum == sum) {
				return true;
			} else {
				// remove the leaf node.
				path.remove(path.size() - 1);
			}
			return false;
		}
		
		if (node.left != null) {
			if (getPath(node.left, path, sum, pathSum)) {
				return true;// short circuit end
			}
		}
		
		if (node.right != null) {
			if (getPath(node.right, path, sum, pathSum)) {
				return true;
			}
		}
		path.remove(path.size() - 1);
		pathSum = (pathSum - node.data) / 2;
		return false;
		
	}

}
