package com.chapter10.revision;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chapter10.TreeNode;
import com.chapter10.TreeTraversal;

public class Q12 {

	public static void main(String[] args) {
		Q12 q = new Q12();
		
		TreeNode a = new TreeNode("a");
		TreeNode b = new TreeNode("b");
		TreeNode c = new TreeNode("c");
		TreeNode d = new TreeNode("d");
		TreeNode e = new TreeNode("e");
		TreeNode f = new TreeNode("f");
		TreeNode g = new TreeNode("g");
		TreeNode h = new TreeNode("h");
		TreeNode i = new TreeNode("i");
		
		List<TreeNode> inOrder = Arrays.asList(new TreeNode [] {f, b, a, e, h, c, d, i, g});
		List<TreeNode> preOrder = Arrays.asList(new TreeNode [] {h, b, f, e, a, c, d, g, i});
		
		TreeNode root = q.constructBinaryTree(preOrder, inOrder);
		
		TreeTraversal.inOrder(root);
		System.out.println("");
		TreeTraversal.preOrder(root);
	}
	
	/*
	 * Given an in order traversal and pre order traversal , write program to reconstruct binary tree.
	 * 
	 * 
	 * in order => left, current, right
	 * pre     => current, left, right
	 * 
	 * First node in pre order traversal is root.
	 * 
	 */
	public TreeNode constructBinaryTree(List<TreeNode> preOrder, List<TreeNode> inOrder) {
		Map<TreeNode, Integer> inOderMap = new HashMap<>();
		
		for (int i = 0; i < inOrder.size(); i++) {
			inOderMap.put(inOrder.get(i), i);
		}
		
		return getRoot(preOrder, 0, preOrder.size() - 1, 0, inOrder.size() - 1, inOderMap);
	}
	
	private TreeNode getRoot(List<TreeNode> preOrder, int preOrderStart, int preOrderEnd, int inOrderStart, int inOrderEnd, Map<TreeNode, Integer> inOderMap) {
		if (preOrderStart > preOrderEnd || inOrderStart > inOrderEnd) {
			return null;
		}
		
		TreeNode subRoot = preOrder.get(preOrderStart);
		int inOrderIndex = inOderMap.get(preOrder.get(preOrderStart));
		int leftSize = inOrderIndex - inOrderStart;
		
		subRoot.left = getRoot(preOrder, preOrderStart + 1, preOrderStart + leftSize, inOrderStart, inOrderIndex - 1, inOderMap);
		subRoot.right = getRoot(preOrder, preOrderStart + 1 + leftSize, preOrderEnd, inOrderIndex + 1, inOrderEnd, inOderMap);
		
		return subRoot;
	}
}
