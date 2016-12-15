package com.chapter8;

public class Q8v1 {

	public static void main(String[] args) {
		Node a1 = new Node(1, null);
		Node a2 = new Node(2, null);
		Node a3 = new Node(3, null);
		Node a4 = new Node(4, null);
		Node a5 = new Node(5, null);
		Node a6 = new Node(5, null);
		Node a7 = new Node(5, null);
		//Node a8 = new Node(100, null);
		
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = a6;
		a6.next = a7;
		//a7.next = a8;
		
		Q8v1 q = new Q8v1();
		Node n = a1;
		while (n != null) {
			System.out.print(n.data + "->");
			n = n.next;
		}
		System.out.println();
		
		n = q.process(a1, 3);
		while (n != null) {
			System.out.print(n.data + "->");
			n = n.next;
		}
	}
	
	public Node process(Node head, int k) {
		// validations
		Node fh = new Node(-1, null);
		fh.next = head;
		Node n = fh.next;
		Node prev = fh;
		int count = 1;
		
		while (n != null && n.next != null) {
			if (n.data == n.next.data) {
				count++;
			} else if(count <= k) {
				prev = n;
				count = 1;
			} else{
				//count > m
				prev.next = n.next;
			}
			n = n.next;
		}

		if(count > k) {
			prev.next = null;
		}
		return fh.next;
	}
}
