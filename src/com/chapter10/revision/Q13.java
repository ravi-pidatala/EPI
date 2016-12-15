package com.chapter10.revision;

import java.util.Arrays;
import java.util.List;

import com.chapter10.TreeNode;
import com.chapter10.TreeTraversal;
import com.chapter10.TreeUtil;

public class Q13 {

	static int keyIndex = 0;
	
	public static void main(String[] args) {
		
		Q13 q = new Q13();
		List<String> preOrder = Arrays.asList(new String [] {"H", "b", "f", null, null, "e", "a", null, null, null, "c", null, "d", null, "g", "i", null, null, null});
		
		TreeNode root = q.constructTree(preOrder);
		
		TreeTraversal.preOrder(root);
		
	}
	
	/*
	 * Reconstruct binary tree from pre order traversal with markers.
	 */
	TreeNode constructTree(List<String> preOrder) {
		// invalid input
		if (keyIndex < preOrder.size()){
			return null;
		}
		
		String subTreeKey = preOrder.get(keyIndex);
		keyIndex++;

		if (subTreeKey == null) {
			return null;
		}
		
		TreeNode left = constructTree(preOrder);
		TreeNode right = constructTree(preOrder);
		
		TreeNode current = new TreeNode(subTreeKey);
		
		current.left = left;
		current.right = right;
		return current;
		
	}
	
	

}
