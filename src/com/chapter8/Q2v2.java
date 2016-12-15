package com.chapter8;

public class Q2v2 {

	public static void main(String[] args) {
		Q2v2 q = new Q2v2();
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
		
		Node n = a0;
		
		while (n != null) {
			System.out.print(n.data + "->");
			n = n.next;
		}
		Node head = q.getkReverse(a0, 2);
		System.out.println();
		n = head;
		
		while (n != null) {
			System.out.print(n.data + "->");
			n = n.next;
		}
	}

	public Node getkReverse(Node head, int k) {
		Node kNode = getKNode(head, k);
		
		if (kNode == null) {
			return head;
		}

		Node start = head;
		Node nextStart = null;
		do {
			nextStart = reversekonly(start, k, null);
			start = getKNode(nextStart, k);
		} while (start != null);
		
		return kNode;
	}
	
	private Node getKNode(Node head, int k) {
		Node n = head;
		
		int i = 1;
		
		while (n != null && i++ < k) {
			n = n.next;
		}
		return n;
	}

/*
	reverses k nodes from node n and returns the next start Node.
	if k nodes are not present from n, returns null.
*/
	private Node reversekonly(Node n, int k, Node prevEnd) {
		Node last = n;
		Node reverseEnd = n;
		int i = 1;

		while (i < k && last != null) {
			last = last.next;
			i++;
		}
		if (last == null) {
			return null;
		}

		Node nextStart = last.next;
		Node fh = new Node(-1, null);
		Node temp = null;
		Node nextNode = null;

		while (n != nextStart) {
			temp = fh.next;
			nextNode = n.next;
			fh.next = n;
			n.next = temp;
			n = nextNode;
		}
		reverseEnd.next = nextStart;
		fh = null;
		return nextStart;
	}

}
