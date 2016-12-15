package com.chapter10.revision;

import java.util.ArrayList;
import java.util.List;

import com.chapter10.TreeNode;
import com.chapter10.TreeUtil;

public class Q14 {

	public static void main(String[] args) {
		TreeNode root = TreeUtil.getTree();
		
		List<TreeNode> leafList = new ArrayList<>();
		
		Q14 q = new Q14();
		q.getLeaves(root, leafList);
		
		for (TreeNode node: leafList) {
			System.out.print(node + ",");
		}
		
		
	}
	
	/*
	 * Form a linked list from leaves of binary tree.
	 * The leaves should appearr in left to right order.
	 * Post order traversal .  
	 */
	void getLeaves(TreeNode node, List<TreeNode> leafList) {
		if (node == null) {
			return;
		}
		getLeaves(node.left, leafList);
		getLeaves(node.right, leafList);
		
		if (node.left == null && node.right == null) {
			leafList.add(node);
		}
	}
	
	

}
