package com.chapter10.revision;

import java.util.HashSet;
import java.util.Set;

import com.chapter10.TreeNode;

public class Q4 {

	public static void main(String[] args) {
		
		
		
	}
	
	/*
	 * Compute LCA . nodes have parent pointers.
	 * From one node go to root , saving each node in the path to hashmap.
	 * From second node, go towards root , checking if the node exists in hashmap. if yes, 
	 * The found node found in the hashmap is LCA.
	 * 
	 * Above approach takes o[log n] even though both nodes are from a single parent.
	 * 
	 * So try adding into the hashmap alternately.
	 * 
	 * Add first node to hashmap.Go to its parent.  Check if second node , exists in hashmap. Go to parent.
	 * 
	 * 
	 */
	TreeNode getLCA(TreeNode a, TreeNode b) {
		if (a == null || b == null) {
			return null;
		}
		
		Set<TreeNode> parentSet = new HashSet<>();
		TreeNode aTemp = a;
		TreeNode bTemp = b;
		
		// from a go till the root, adding all the nodes to the hashmap. o[log n] time and space
		while (aTemp != null) {
			parentSet.add(aTemp);
			if (aTemp == aTemp.parent) {// invalid parent
				return null;
			}
			aTemp = aTemp.parent;
		}
		
		//o[log n] time. keep checking if the parent is in hashmap.
		while (bTemp != null) {
			if (parentSet.contains(bTemp)) {
				return bTemp;
			}
			bTemp = bTemp.parent;
		}
		
		// did not find parent . no LCA . 
		return null;
		
	}
	
	
	
	/*
	 * sapce complexity => o[log n] , time complexity => o[log n]
	 * Works better than before one if two nodes are near by
	 * takes more space than before one. 
	 * Will take more time if nodes are apart. how ever , time and space complexity is same as previous one.
	 */
	
	
	TreeNode getLca2(TreeNode a, TreeNode b) {
		if (a == null || b == null) {
			return null;
		}
		
		Set<TreeNode> parentSet = new HashSet<>();
		int i = 0;
		TreeNode aTemp = a;
		TreeNode bTemp = b;
		
		while (aTemp != null || bTemp != null) {
			if (i % 2 == 0 && aTemp != null) {
				if (parentSet.contains(aTemp)) {
					return aTemp;
				}
				parentSet.add(aTemp);
			} else if (i % 2 == 1 && bTemp != null) {
				if (parentSet.contains(bTemp)) {
					return bTemp;
				}
				parentSet.add(bTemp);
			}
			i++;
		}
		return null;
	}
	
	/*
	 * find the depth of both nodes from root. 
	 * get the difference in depth. 
	 * from depper node, go up the diff number of times. 
	 * 
	 * now check if a and b are same. 
	 * if not, go up on both , check if they are same. 
	 * Continue till you go to the root. 
	 * if no lca(invalid input), one of them will become null
	 * 
	 * time is o[h]. space is o[1]
	 */
	TreeNode getLca3(TreeNode a, TreeNode b) {
		if (a == null || b == null) {
			return null;
		}
		
		// check the depth of a node.
		int aDepth = getDepth(a);
		int bDepth = getDepth(b);
		
		int diff = aDepth > bDepth ? aDepth - bDepth: bDepth - aDepth;
		
		if (aDepth > bDepth) {
			// make a to go up till the depth becomes 0
			for (int i = diff; i > 0; i--) {
				a = a.parent;
			}
		} else {
			for (int i = diff; i > 0; i--) {
				b = b.parent;
			}
		}
		
		while (a != null && b != null) {
			if (a == b) {
				return a;// found lcs
			}
			a = a.parent;
			b = b.parent;
		}
		return null;
	}
	
	/*
	 * TODO check for validations
	 */
	int getDepth(TreeNode node) {
		if(node == null) {
			return 0;
		}
		int depth = 1;
		
		while (node.parent != null) {
			depth++;
			node = node.parent;
		}
		return depth;
	}
}
