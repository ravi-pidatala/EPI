package com.chapter8;

public class Q11 {

	public static void main(String[] args) {
		
		/*
		 * check for odd length and even length list
		 */
		Node a0 = new Node(0, null);
		Node a1 = new Node(1, null);
		Node a2 = new Node(2, null);
		Node a3 = new Node(3, null);
		Node a4 = new Node(4, null);
		Node a5 = new Node(3, null);
		Node a6 = new Node(2, null);
		Node a7 = new Node(1, null);
		Node a8 = new Node(0, null);
		
		a0.next = a1;
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = a6;
		a6.next = a7;
		a7.next = a8;
		
		Q11 q = new Q11();
		
		if (q.isPallindrome(a0)) {
			System.out.println("pallindrome");
		} else {
			System.out.println("NOT pallindrome");
		}
		
		Node n = a0;
		while (n != null) {
			System.out.print(n.data + "->");
			n = n.next;
		}
		
		
	}
	
	/*
	 * check whether sll is pallindrome in o[n] tme and o[1] space.
	 */
	public boolean isPallindrome(Node head) {
		if (head == null) {
			return false; // depends on req.
		}
		
		Node slow = head;
		Node fast = head;
		
		while (fast != null && fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		// slow is on last node in the half.
		Node reverseHead = reverse(slow.next);
		
		Node q = reverseHead;
		Node p = head;
		boolean pallindrome = true;
		while (q != null) {
			if (q.data != p.data) {
				pallindrome = false;
				break;
			}
			p = p.next;
			q = q.next;
		}
		
		Node middle = reverse(reverseHead);
		slow.next = middle;
		return pallindrome;
	}
	
	/*
	 * reverse linkedlist and return reverse head
	 */
	private Node reverse(Node head) {
		// for logging purpose
		Node t = head;
		System.out.println("original list");
		while (t != null) {
			System.out.print(t.data + "->");
			t = t.next;
		}
		
		Node fh = new Node(-1, null);
		Node p = head;
		Node temp = null;
		
		while (p != null) {
			temp = fh.next;
			fh.next = p;
			p = p.next;
			fh.next.next = temp;
		}
		System.out.println();
		System.out.println("reverse list");
		t = fh.next;
		while (t != null) {
			System.out.print(t.data + "->");
			t = t.next;
		}
		
		return fh.next;
	}
	
}
