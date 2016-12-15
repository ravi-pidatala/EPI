package com.chapter15;

import java.util.List;

import com.chapter10.TreeNode;

public class Q9 {

	public static void main(String[] args) {
		
	}
	
	/*
	 * Find minimum height BST from sorted array
	 */
	TreeNode getMinHeightBst(List<Integer> a, int start, int end) {

		if (start > end) {
			return null;
		}
		int middle = start + (end - start) / 2;
		
		TreeNode subRoot = new TreeNode(a.get(middle));
		subRoot.left = getMinHeightBst(a, start, middle - 1);
		subRoot.right = getMinHeightBst(a, middle + 1, end);
		return subRoot;
		
	}
	

}
