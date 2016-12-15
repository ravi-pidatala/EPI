package com.chapter8;

public class Q2v1 {

	public static void main(String[] args) {
		Node a0 = new Node(0, null);
		Node a1 = new Node(1, null);	
		Node a2 = new Node(2, null);	
		Node a3 = new Node(3, null);	
		Node a4 = new Node(4, null);	
		Node a5 = new Node(5, null);	
		Node a6 = new Node(6, null);	
		Node a7 = new Node(7, null);	
		Node a8 = new Node(8, null);	
		Node a9 = new Node(9, null);	

		a0.next = a1;
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = a6;
		a6.next = a7;
		a7.next = a8;
		a8.next = a9;
		
		Q2v1 q = new Q2v1();
		Node reverseHead = q.reverse(a0);
		
		Node n = reverseHead;
		while (n != null) {
			System.out.print(n.data + "->");
			n = n.next;
		}
	}

	public Node reverse(Node head) {
		Node fh = new Node(-1, null);

		Node n = head;
		Node temp = null;
		Node nextNode = null;
		
		while (n != null) {
			temp = fh.next;
			nextNode = n.next;
			fh.next = n;
			n.next = temp;
			n = nextNode;
		}

		return fh.next;
	}
	
	
	
}
