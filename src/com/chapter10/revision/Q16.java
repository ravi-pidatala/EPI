package com.chapter10.revision;

import java.util.LinkedList;
import java.util.Queue;

import com.chapter10.TreeNode;

public class Q16 {

	public static void main(String[] args) {
		
	}
	
	/*
	 * Input is perfect binary tree.
	 * set each node's level next field to the node on its right if one exists.
	 */
	public void levelNext(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
				if (node.left != null) {
					queue.add(node.left);
					node.left.next = node.right;
				}
				if (node.right != null) {
					queue.add(node.right);
					node.right.next = node.next != null ? node.next.left:null;
				}
			}
		}
	
	
	/*
	 *  Given that input is a perfect binary tree. 
	 *  
	 */
	void levelNextNodes() {
		
	}
}
