package com.chapter9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q7 {

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
		
		Q7 q = new Q7();
		List<ArrayList<Integer>> result = q.printLevelOrder(root);
		
		System.out.println();;
		
		for (ArrayList<Integer> local: result) {
			System.out.println();
			for(Integer x: local) {
				System.out.print(x + ",");
			}
		}
		
		System.out.println();;
		
		List<ArrayList<TreeNode>> r = q.getLevelOrder(root);
		
		for (ArrayList<TreeNode> local: r) {
			System.out.println();
			for(TreeNode x: local) {
				System.out.print(x.data + ",");
			}
		}
		
		
	}
	
	public List<ArrayList<TreeNode>> getLevelOrder(TreeNode root) {
		//val
		Queue<TreeNode> q1 = new LinkedList<>();
		q1.offer(root);
		
		ArrayList<TreeNode> localResult = new ArrayList<>();
		List<ArrayList<TreeNode>> result = new ArrayList<>();
		int nodeCount = 1;
		while (!q1.isEmpty()) {
			TreeNode n = q1.remove();
			nodeCount--;
			if (n != null) {
				localResult.add(n);
				q1.add(n.left);
				q1.add(n.right);
			}
			
			if (nodeCount == 0) {
				result.add(localResult);
				localResult = new ArrayList<>();
				nodeCount = q1.size();
			}
			
		}
		return result;
		
	}
	
	/*
	 * Level order traversal of binary tree.
	 */
	public List<ArrayList<Integer>> printLevelOrder(TreeNode root) {
		Queue<TreeNode> q1 = new LinkedList<>();
		Queue<TreeNode> q2 = new LinkedList<>();
		
		q1.offer(root);
		ArrayList<Integer> localResult = new ArrayList<>();
		List<ArrayList<Integer>> result = new ArrayList<>();
		
		while (!q1.isEmpty()) {
			TreeNode n = q1.remove();
			
			if (n != null) {
				localResult.add(n.data);
				System.out.print(n.data + ",");
				q2.add(n.left);
				q2.add(n.right);
			}
			if (q1.isEmpty()) {
				// level completed
				q1.addAll(q2);
				q2.clear();
				System.out.println();
				result.add(localResult);
				localResult = new ArrayList<>();
			}
		}
		return result;
	}
}

class TreeNode {
	int data;
	
	TreeNode left;
	TreeNode right;
	
	TreeNode(int data) {
		this.data = data;
	}
	
}