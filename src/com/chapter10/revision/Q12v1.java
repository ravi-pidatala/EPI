package com.chapter10.revision;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chapter10.TreeNode;
import com.chapter10.TreeTraversal;

public class Q12v1 {

	public static void main(String[] args) {
		
		Q12v1 q = new Q12v1();
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
		List<TreeNode> postOrder = Arrays.asList(new TreeNode [] {f, a, e, b, i, g, d, c, h});
		
		TreeNode root = q.constructTree(inOrder, postOrder);
		
		TreeTraversal.inOrder(root);
		System.out.println("");
		TreeTraversal.postOrder(root);
		
	}
	
	/*
	 * Given an in order traversal sequence and post order traversal sequence, 
	 * Construct binary tree. 
	 */
	public TreeNode constructTree(List<TreeNode> inorder, List<TreeNode> postOrder) {
		// make map for the in order indices
		
		Map<TreeNode, Integer> inOrderMap = new HashMap<>();
		
		for (int i = 0; i < inorder.size(); i++) {
			inOrderMap.put(inorder.get(i), i);
		}
		
		return getSubTreeRoot(postOrder, 0, postOrder.size() - 1, inOrderMap, 0, inorder.size() - 1);
	}
	
	private TreeNode getSubTreeRoot(List<TreeNode> postOrder, int postOrderStart, int postOrderEnd, Map<TreeNode, Integer> inOrderMap, int inOrderStart, int inOrderEnd) {
		
		if (postOrderStart > postOrderEnd || inOrderStart >inOrderEnd) {
			return null;
		}
		TreeNode subTreeRoot = postOrder.get(postOrderEnd);
		
		int inOrderIndex = inOrderMap.get(subTreeRoot);
		int leftSize = inOrderIndex - inOrderStart;
		
		subTreeRoot.left = getSubTreeRoot(postOrder, postOrderStart, postOrderStart + leftSize -1, inOrderMap, inOrderStart, inOrderIndex - 1);
		subTreeRoot.right = getSubTreeRoot(postOrder, postOrderStart + leftSize, postOrderEnd - 1, inOrderMap, inOrderIndex + 1, inOrderEnd);
		return subTreeRoot;
	}
	
	
	
	

}
