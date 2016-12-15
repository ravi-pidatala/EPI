package com.chapter8;

public class Q8 {
	public static void main(String [] args) {
		Node a1 = new Node(1, null);
		Node a2 = new Node(2, null);
		Node a3 = new Node(3, null);
		Node a4 = new Node(4, null);
		Node a5 = new Node(5, null);
		Node a6 = new Node(5, null);
		Node a7 = new Node(5, null);
		Node a8 = new Node(100, null);
		
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = a6;
		a6.next = a7;
		a7.next = a8;
		
		Q8 q = new Q8();
		Node n = a1;
		while (n != null) {
			System.out.print(n.data + "->");
			n = n.next;
		}
		System.out.println();
		q.removeDuplicates(a1);
		n = a1;
		while (n != null) {
			System.out.print(n.data + "->");
			n = n.next;
		}
	}
	
	void removeDuplicates(Node head) {
		if (head == null) {
			return;
		}
		Node current = head;
		Node next = current.next;
		
		while (next != null) {
			if (next.data == current.data) {
				current.next = next.next;// delete next node.
				next = current.next;
			} else {
				current = current.next;
				next = current == null ? null: current.next;
			}
		}
	}
	
		
}
