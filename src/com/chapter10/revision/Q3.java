package com.chapter10.revision;

import com.chapter10.TreeNode;

public class Q3 {

	public static void main(String[] args) {
		
	}
	
	/*
	 * compute LCA.
	 * it is similar to post order traversal.
	 * left, right, current.
	 */
	Status getLCA(TreeNode node, TreeNode a, TreeNode b) {
		if (node == null || a == null || b == null) {
			return null;
		}
		
		Status result = getLCA(node.left, a, b);
		if (result.x == 2) {
			return result;
		}
		Status rightResult = getLCA(node.right, a, b);
		
		if (rightResult.x == 2) {
			return rightResult;
		}
		
		int targeNodes = result.x + rightResult.x + (node == a ? 1:0) + (node == b ? 1:0);
		return new Status(targeNodes == 2 ? node:null, targeNodes);
	}

}

class Status {
	TreeNode node;
	int x;
	
	Status(TreeNode node, int x) {
		this.node = node;
		this.x = x;
	}
}
