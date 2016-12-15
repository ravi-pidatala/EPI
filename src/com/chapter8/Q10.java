package com.chapter8;

public class Q10 {

	public static void main(String[] args) {
		Node a0 = new Node(0, null);
		Node a1 = new Node(1, null);
		Node a2 = new Node(2, null);
		Node a3 = new Node(3, null);
		Node a4 = new Node(4, null);
//		Node a5 = new Node(5, null);
//		Node a6 = new Node(6, null);
//		Node a7 = new Node(7, null);
//		Node a8 = new Node(8, null);
		
		a0.next = a1;
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
//		a4.next = a5;
//		a5.next = a6;
//		a6.next = a7;
//		a7.next = a8;
		
		Q10 q = new Q10();
		Node n = a0;
		while (n != null) {
			System.out.print(n.data + "->");
			n = n.next;
		}
		System.out.println();
		
		q.evenOddMerge(a0);
		n = a0;
		while (n != null) {
			System.out.print(n.data + "->");
			n = n.next;
		}
	}
	
	// head remains same.
	public void evenOddMerge(Node head) {
		if (head == null || head.next == null) {
			return;
		}
		
		Node p = head;
		Node q = head.next;
		Node oddHead = q;
		
		while (q != null) {
			p.next = q.next;
			if (p.next == null) {
				p.next = oddHead;
				break;
			}
			p = p.next;
			q.next = p.next;
			q = q.next;
		}
		if (p.next == null) {
			p.next = oddHead;
		}
	}
}
