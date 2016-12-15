package com.chapter8;

public class Q12 {

	public static void main(String[] args) {
		int i = 1;
		Node a0 = new Node(3, null, i++);
		Node a1 = new Node(2, null, i++);
		Node a2 = new Node(2, null, i++);
		Node a3 = new Node(11, null, i++);
		Node a4 = new Node(7, null, i++);
		Node a5 = new Node(5, null, i++);
		Node a6 = new Node(11, null, i++);
		Node a7 = new Node(1, null, i++);
		Node a8 = new Node(2, null, i++);
		
		a0.next = a1;
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = a6;
		a6.next = a7;
		a7.next = a8;
		
		
		Q12 q = new Q12();
		
		Node n = a0;
		while (n != null) {
			System.out.print("(" + n.data + "," + n.priority + ") ->");
			n = n.next;
		}
		
		n = q.pivotList(a0, 2);
		System.out.println(); 
		while (n != null) {
			System.out.print("(" + n.data + "," + n.priority + ") ->");
			n = n.next;
		}
	}

	public Node pivotList(Node head, int k) {
		Node lh = new Node (-1, null);
		Node eh = new Node (-1, null);
		Node gh = new Node (-1, null);

		Node l = lh;
		Node e = eh;
		Node g = gh;

		Node n = head;

		while (n != null) {
			if (n.data < k) {
				l.next = n;
				l = l.next;
			} else if(n.data == k) {
				e.next = n;
				e = e.next;
			} else {
				g.next = n;
				g = g.next;
			}
			n = n.next;
		}

		Node h1 = lh.next;
		l.next = eh.next;
		e.next = gh.next;
		g.next = null;
		return h1;
	}


}
