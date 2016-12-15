package com.chapter10.revision;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.chapter10.TreeNode;
import com.chapter10.TreeUtil;

public class Q5 {

	public static void main(String[] args) {
		TreeNode root = TreeUtil.getBinaryTree();
		List<StringBuilder> pathList = new ArrayList<>();
		
		Q5 q = new Q5();
		q.getSum(root, pathList, new StringBuilder());
		long sum = 0;
		for (StringBuilder path: pathList) {
			char [] a = path.toString().toCharArray();
			System.out.println(path.toString());
			
			
			for (int i = a.length - 1; i >= 0; i--) {
				sum += (int)a[i] * 1 << (a.length - 1 - i);
			}
			
		}
		System.out.println(sum);
		
		root = TreeUtil.getBinaryTree();
		sum = q.computeSum(root, 0);
		System.out.println(sum);
		
		root = TreeUtil.getBinaryTree();
		sum = q.getSum(root);
		System.out.println(sum);
		
	}
	
	/*
	 * sum of the binary numbers associated with root to leaf path
	 * root is MSB.
	 * 
	 * Get all the ways to iterate the binary tree. Calculate its sum. 
	 * Traverse the binary tree in order traversal.
	 * Should i use recursion??
	 * Should use recursion and build list of strings.
	 * This will be practice for recursion.
	 * 
	 * 
	 */
	private void getSum(TreeNode node, List<StringBuilder> pathList, StringBuilder path) {
		
		path.append(node.data);
		if (node.left != null) {
			getSum(node.left, pathList, path);
			path.deleteCharAt(path.length() - 1);
		}
		if (node.right != null) {
			getSum(node.right, pathList, path);
			path.deleteCharAt(path.length() - 1);
		}
		
		if (node.left == null && node.right == null) {// leaf node.
			pathList.add(new StringBuilder(path));
		}
	}
	
	
	
	private long computeSum(TreeNode node, long parentSum) {
		if (node == null) {
			return 0;
		}
		
		long currentSum = 2 * parentSum + node.data;
		
		if (node.left == null && node.right == null) {
			return currentSum;
		}
		
		return computeSum(node.left, currentSum) + computeSum(node.right, currentSum);
	}
	
	
/*
 * Create hashmap with Child as key and parent as value.
 * Create arraylist with all leaf nodes.
 * From each leaf node, go till root and sum it.
 * 
 */
	public long getSum(TreeNode root) {
		Map<TreeNode, TreeNode> childParentMap = new HashMap<>();
		Set<TreeNode> leafNodes = new HashSet<>();
		if (root != null) {
			getChildParentMap(root, childParentMap, leafNodes);
		}
		
		long sum = 0;
		
		for (TreeNode leaf: leafNodes) {
			/*
			 * from leaf node, go to the root. 
			 */
			
			long index = 1;
			
			while (leaf != null) {
				sum += index * leaf.data;
				leaf = leaf.parent;
				index = index << 1;
			}
		}
		
		return sum;
	}
	
	private void getChildParentMap(TreeNode node, Map<TreeNode, TreeNode> childParentMap, Set<TreeNode> leafNodes) {
		if (node.left == null && node.right == null) {
			leafNodes.add(node);
		}
			if (node.left != null) {
				childParentMap.put(node.left, node);
				getChildParentMap(node.left, childParentMap, leafNodes);
			}
			
			if (node.right != null) {
				childParentMap.put(node.right, node);
				getChildParentMap(node.right, childParentMap, leafNodes);
			}
			
			
	}
	
	
}
