package com.chapter9;

import java.util.Stack;

public class Q5 {

	public static void main(String[] args) {

	}
	
	/*
	 * Jump first order
	 */
	public void jumpFirstProcess(Node head) {
		Stack<Node> s = new Stack<>();
		s.push(head);
		Node n = null;
		int order = 1;
		while (!s.isEmpty()) {
			n = s.pop();
			if (n != null && n.order == -1) {
				n.order = order++;
				s.push(n.next);
				s.push(n.jump);// jump node will be processed first
			}
		}
	}
	
	
	
	
}
