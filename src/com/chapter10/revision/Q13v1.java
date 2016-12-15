package com.chapter10.revision;

import java.util.Arrays;
import java.util.List;

import com.chapter10.TreeNode;
import com.chapter10.TreeTraversal;

public class Q13v1 {

	static int keyIndex = 0;
	
	public static void main(String[] args) {
		Q13v1 q = new Q13v1();
		List<String> postOrder = Arrays.asList(new String [] {null, null, "f",null, null, "a", null, "e", "b", null, null, "i", null, "g", "d", "c", "h"});
		
		
		keyIndex = postOrder.size() - 1;
		TreeNode root = q.constructTreeFromPostOrder(postOrder);
		
		TreeTraversal.postOrder(root);
	}
	
	TreeNode constructTreeFromPostOrder(List<String> postOrder) {
		
		if (keyIndex == 0) {
			return null;
		}
		String currentString = postOrder.get(keyIndex--);
		if (currentString == null) {
			return null;
		}
		
		TreeNode right = constructTreeFromPostOrder(postOrder);
		TreeNode left = constructTreeFromPostOrder(postOrder);
		
		
		
		TreeNode current = new TreeNode(currentString);
		current.left = left;
		current.right = right;
		return current;
	}

}
