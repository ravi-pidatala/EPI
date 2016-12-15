package com.chapter15;

import java.util.LinkedList;
import java.util.Queue;

import com.chapter10.TreeNode;

public class Q1 {

	public static void main(String[] args) {
		
	}
	
	
	/*
	 * test if binary tree satisfies bst property. 
	 * Use recursion. 
	 * Check for global property not just local.
	 * o[n] time and o[h] space for the stack since it uses recursion. 
	 */
	boolean isBinarySearchTree(TreeNode node, int min, int max) {
		if (node == null) {
			return true;
		}
		if (node.data < min || node.data > max) {
			return false;
		}
		
		// check for left node.
		return isBinarySearchTree(node.left, min, node.data) && isBinarySearchTree(node.right, node.data, max);
	}
	
	/*
	 * in order traversal visits nodes . left, current, right
	 * in order should be in sorted order. 
	 * check if the next node is greator than equal to the current. 
	 * if not return false. o[n] time and o[1] space.
	 * 
	 */

	
	
	
	/*
	 * with o[h] space we can do a breadth first search 
	 */
	boolean isBST(TreeNode root) {
		Queue<QueueEntry> q = new LinkedList<>();
		
		q.add(new QueueEntry(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		
		
		while (!q.isEmpty()) {
			QueueEntry qEntry = q.poll();
				TreeNode node = qEntry.node;
				
				if (node.data < qEntry.minimum || node.data > qEntry.maximum) {
					return false;
				}
				
				if (node.left != null) {
					q.add(new QueueEntry(node.left, qEntry.minimum, node.data));
				}
			if (node.right != null) {
				q.add(new QueueEntry(node.right, node.data, qEntry.maximum));
			}
		}
		return true;
	}

}

class QueueEntry {
	TreeNode node;
	int minimum;
	int maximum;
	
	QueueEntry(TreeNode node, int minimum, int maximum) {
		this.node = node;
		this.minimum = minimum;
		this.maximum = maximum;
	}
}
