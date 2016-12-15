package com.chapter8;

public class Q9 {

	public static void main(String[] args) {
		Node a1 = new Node(1, null);
		Node a2 = new Node(2, null);
		Node a3 = new Node(3, null);
		Node a4 = new Node(4, null);
		Node a5 = new Node(5, null);
		Node a6 = new Node(6, null);
		Node a7 = new Node(0, null);
		Node a8 = new Node(100, null);
		
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = a6;
		a6.next = a7;
		a7.next = a8;
		
		Q9 q = new Q9();
		Node n = a1;
		while (n != null) {
			System.out.print(n.data + "->");
			n = n.next;
		}
		System.out.println();
		
		n = q.rightShift(a1, 9);
		
		while (n != null) {
			System.out.print(n.data + "->");
			n = n.next;
		}
		System.out.println();
		
	}
	
	/*
	 * Right shift linked list in cycle by k.
	 */
	
	public Node rightShift(Node head, int k) {
		if (head == null || k <= 0) {
			return head;
		}
		
		// loop through whole linked list and check if k > size of linked list. 
		int size = 0;
		Node n = head;
		while (n != null) {
			size++;
			n = n.next;
		}
		
		if (size <= k) {
			k = k % size;
		}
		
		if (k == 0) {
			System.out.println("no need to riht shift since k is multiple of size of linked list");
			return head;
		}
		
		//two poiter approach. get k+ 1 from last .
		Node p = head;
		Node q = head;
		int index = 1;
		
		while (p != null && index <= k) {
			p = p.next;
			index++;
		}
		
		if (p == null) {
			System.out.println("can not shift to right");
			return head;
		}
		
		while (p.next != null) {
			q = q.next;
			p = p.next;
		}
		
		// q is on tail of desired linked list.
		Node nH = q.next;
		 n = nH;
		
		while (n.next != null) {
			n = n.next;
		}
		n.next = head;
		q.next = null;
		return nH;
	}

}
