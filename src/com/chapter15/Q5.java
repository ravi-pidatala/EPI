package com.chapter15;


import java.util.List;

import com.chapter10.TreeNode;
import com.chapter10.TreeTraversal;

public class Q5 {

	static int rootIndex = 0;
	static int postOrderIndex = 0;
	
	public static void main(String[] args) {
		Q5 q = new Q5();
		
		List<TreeNode> preOrder = TreeTraversal.getPreOrderforBST();
		TreeNode root = q.constructBSTBruteForce(preOrder, 0, preOrder.size() - 1);
		TreeTraversal.preOrder(root);
		System.out.println("");
		
		preOrder = TreeTraversal.getPreOrderforBST();
		root = q.constructBst(preOrder, Integer.MIN_VALUE, Integer.MAX_VALUE);
		TreeTraversal.preOrder(root);
	
		System.out.println("");

		List<TreeNode> postOrder = TreeTraversal.getPostOrderForBst();
		postOrderIndex = postOrder.size() - 1;
		root = q.contructBstFromPostOrder(postOrder, Integer.MIN_VALUE, Integer.MAX_VALUE);
		TreeTraversal.preOrder(root);
		
		System.out.println("");
		
		List<TreeNode> invalidPreOrder = TreeTraversal.getInvalidPreOrderforBST();
		rootIndex = 0;
		root = q.constructBst(invalidPreOrder, Integer.MIN_VALUE, Integer.MAX_VALUE);
		TreeTraversal.preOrder(root);
		
		System.out.println("");
		List<TreeNode> invalidPreOrderBf = TreeTraversal.getInvalidPreOrderforBST();
		root = q.constructBSTBruteForce(invalidPreOrderBf, 0, invalidPreOrderBf.size() - 1);
		TreeTraversal.preOrder(root);
		
	}
	
	/*
	 * reconstruct BST from pre order traversal data. all keys are distinct
	 */
	TreeNode constructBSTBruteForce(List<TreeNode> preOrder, int startIndex, int endIndex) {
		
		if (startIndex < 0 || endIndex < 0 || startIndex > endIndex) {
			return null;
		}
		
		TreeNode localRoot = preOrder.get(startIndex);

		int transition = startIndex + 1;
		
		while (transition <= endIndex && preOrder.get(transition).data < localRoot.data) {
			transition++;
		}
		
		localRoot.left = constructBSTBruteForce(preOrder, startIndex + 1, transition - 1);
		localRoot.right = constructBSTBruteForce(preOrder, transition, endIndex);
		
		
		return localRoot;
	}
	
	TreeNode constructBst(List<TreeNode> preOrder, int lowerBound, int upperBound) {
		
		if (rootIndex >= preOrder.size()) {// base case
			return null;
		}
		int subRootValue = preOrder.get(rootIndex).data;
		String subRootString = preOrder.get(rootIndex).s;
		
		/*
		 * // can not be put in this side of this node.
		 *  current is right side, go up till current is left child and put it onto right child to its parent.
		 *  The right would not have children because left side should be filled before right side.
		 *  
		 */
		if (subRootValue < lowerBound || subRootValue > upperBound) {
			return null;
		}
		rootIndex++;
		
		TreeNode subRoot = new TreeNode(subRootString, subRootValue);
		
		subRoot.left = constructBst(preOrder, lowerBound, subRootValue);
		subRoot.right = constructBst(preOrder, subRootValue, upperBound);
		
		return subRoot;
		
	}
	
	TreeNode contructBstFromPostOrder(List<TreeNode> postOrder, int lowerBound, int upperBound) {
		
		// base case.
		if (postOrderIndex < 0) {
			return null;
		}
		
		TreeNode subTreeRoot = postOrder.get(postOrderIndex);
		
		if (subTreeRoot.data < lowerBound || subTreeRoot.data > upperBound) {
			return null;
		}
		postOrderIndex--;
	
		subTreeRoot.right = contructBstFromPostOrder(postOrder, subTreeRoot.data, upperBound);
		subTreeRoot.left = contructBstFromPostOrder(postOrder, lowerBound, subTreeRoot.data);
		return subTreeRoot;
	}

}
