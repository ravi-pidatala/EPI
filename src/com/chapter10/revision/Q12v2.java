package com.chapter10.revision;

import java.util.Arrays;
import java.util.List;

import com.chapter10.TreeNode;
import com.chapter10.TreeTraversal;


/*
 * Consider array is 1, 10, 9, 6, 5, 12, 19, 3
 * 
 * 							19
 * 						   /  \
 * 						 12    3
 * 						 /
 * 					    10
 * 					    / \
 * 					   1   9
 *   						\
 *   						 6
 *   						  \
 *   							5
 *   
 *   pre => 19, 12, 10, 1, 9, 6, 5, 3
 *   in => 1, 10, 9, 6, 5, 12, 19, 3
 * 
 */
public class Q12v2 {

	public static void main(String[] args) {
		Q12v2 q = new Q12v2();
		List<Integer> a = Arrays.asList(new Integer [] {1, 10, 9, 6, 5, 12, 19, 3});
		
		TreeNode root = q.constructMaxTree(a, 6, 0, a.size() - 1);
		

		TreeTraversal.preOrder(root);
		System.out.println("");
		TreeTraversal.inOrder(root);

		
	}
	
	/*
	 * a is distince array of n integers. 
	 * o[n log n] time
	 */
	TreeNode constructMaxTree(List<Integer> a, int k, int start, int end) {
		TreeNode subRoot = new TreeNode(a.get(k));
		
		// find max int from start to k -1.
		int leftIndex = getMax(a, start, k - 1);
		
		// find max int from k + 1 to end.
		int rightIndex = getMax(a, k+ 1, end);
		
		if (leftIndex != -1) {
			subRoot.left = constructMaxTree(a, leftIndex, start, k - 1);
		}
		if (rightIndex != -1) {
			subRoot.right = constructMaxTree(a, rightIndex, k + 1, end);
		}
		return subRoot;
		
	}
	
	int getMax(List<Integer> a, int start, int end) {
		if (start > end) {
			return -1;
		}
		int maxIndex = start;
		
		for (int i = start + 1; i <= end; i++) {
			 if (a.get(i) > a.get(maxIndex)) {
				 maxIndex = i;
			 }
		}
		return maxIndex;
	}
	
	

}
