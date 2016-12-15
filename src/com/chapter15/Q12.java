package com.chapter15;

import java.util.ArrayList;
import java.util.List;

import com.chapter10.TreeNode;

public class Q12 {

	public static void main(String[] args) {
		
	}
	
	/*
	 * Write program that takes input as a BST and an interval.
	 * return the BST keys that lie in the interval.
	 * if root > start, no need to search in the left subtree.
	 * if root < end, no need to search in the right subtree.
	 * if none of above, add root to the result, continue searching in the left and right.
	 * 
	 * 
	 */
	public List<Integer> getKeysInInterval(TreeNode root, int start, int end) {
		List<Integer> keys = new ArrayList<>();
		
		if (start > end) {
			// invalid input.
			getKeysInIntervalForBst(root, end, start, keys);
		} else {
			getKeysInIntervalForBst(root, start, end, keys);
		}
		
		return keys;
	}
	
	
	/*
	 * o[n] complexity
	 */
	private void getKeysInIntervalForBst(TreeNode node, int start, int end, List<Integer> keys) {
		if (node == null) {
			return;
		}
		if (node.data < start) {
			// go right. no need to search on left since node is already less than start.
			 getKeysInIntervalForBst(node.right, start, end, keys);
			 return;
		} 
		if (node.data > end) {
			// go left.no need to search on right since node is already > end value.
		    getKeysInIntervalForBst(node.left, start, end, keys);
			return;
		} 
		
		// add current node to the result. search both sides.
		getKeysInIntervalForBst(node.left, start, end, keys);
		keys.add(node.data);
		getKeysInIntervalForBst(node.right, start, end, keys);
	}
}
