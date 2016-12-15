package com.chapter15;

import java.util.ArrayList;
import java.util.List;

import com.chapter10.BSTUtil;
import com.chapter10.TreeNode;

public class Q3 {

	public static void main(String[] args) {
		TreeNode root = BSTUtil.getBinarySearchTree();
		
		List<TreeNode> result = new ArrayList<>();
		
		Q3 q = new Q3();
		q.xGreatest(root, 16, result);
		
		for (TreeNode node: result) {
			System.out.print(node + ",");
		}
	}
	
	/*
	 * find k largest elements in BSTin decreasing order. 
	 * 
	 * if right child present, go right.
	 * 
	 * Traversal order => right, current, left.i.e. reverse of in order traversal.
	 * 
	 */
	void xGreatest(TreeNode node, Integer x, List<TreeNode> list) {

		if (node.right != null) {
			xGreatest(node.right, x, list);
		}
		
		// check the size of list if need to resturn
		// this is base case.
		if (list.size() >= x) {
			return;
		}
		
		list.add(node);
		
		if (node.left != null) {
			xGreatest(node.left, x, list);
		}
	}
	
	

}
