package com.chapter9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q7v1 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		TreeNode a1 = new TreeNode(1);
		TreeNode a2 = new TreeNode(2);
		TreeNode a3 = new TreeNode(3);
		TreeNode a4 = new TreeNode(4);
		TreeNode a5 = new TreeNode(5);
		TreeNode a6 = new TreeNode(6);
		TreeNode a7 = new TreeNode(7);
		TreeNode a8 = new TreeNode(8);
		TreeNode a9 = new TreeNode(9);
		TreeNode a10 = new TreeNode(10);
		
		root.left = a1;
		root.right = a2;
		a1.left = a3;
		a1.right = a4;
		a2.left = a5;
		a2.right = a6;
		
		a3.left = a7;
		a5.right = a8;
		
		a7.right = a9;
		a9.left = a10;
		
		Q7v1 q = new Q7v1();
		
		 List<ArrayList<TreeNode>> result = q.getLevelOrder(root);
		
		 for (ArrayList<TreeNode> local: result) {
				System.out.println();
				for(TreeNode x: local) {
					System.out.print(x.data + ",");
				}
			}
	}
	
	// have boolean to  tell whether the current should be stack or queue.
	public List<ArrayList<TreeNode>> getLevelOrder(TreeNode root) {
		Deque<TreeNode> q1 = new LinkedList<>();
		q1.offer(root);
		
		ArrayList<TreeNode> localResult = new ArrayList<>();
		List<ArrayList<TreeNode>> result = new ArrayList<>();
		int nodeCount = 1;
		boolean isQ = true;
		TreeNode n = null;
		
		while (!q1.isEmpty()) {
			nodeCount--;
			n = q1.removeFirst();
			
			if (n != null) {
				localResult.add(n);
				q1.addLast(n.left);
				q1.addLast(n.right);
			}
			
			if (nodeCount == 0) {
				nodeCount = q1.size();
				if (isQ) {
					result.add(new ArrayList<>(localResult));
				} else {
					Collections.reverse(localResult);
					result.add(new ArrayList<>(localResult));
				}
				localResult.clear();
				isQ = !isQ;
			}
		}
		return result;
	}
}
