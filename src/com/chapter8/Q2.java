package com.chapter8;

/*
	reverse linked list nodes from b to c.
*/

public class Q2 {

	public static void main(String[] args) {
		Q2 q = new Q2();
		
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
		while(n != null) {
			System.out.print(n.data + "==>");
			n = n.next;
		}
		System.out.println();
		q.reverseSubList(a0, 3, 6);//a0->a1->a2->a5->a4->a3->a6->a7->a8->a9
		
		n = a0;
		while(n != null) {
			System.out.print(n.data + "==>");
			n = n.next;
		}
		
		
	}

	void reverseSubList(Node a, int start, int end) {
		// check if b and c comes in the iterations from a
		if (start == end) {
			return;
		}

		Node n = a;
		int index = 0;
		Node prev = null;
		Node fh = new Node(-1, null);

		while (n != null && index < start) {
			index++;
			prev = n;
			n = n.next;
		}
		Node reverseEndNode = n;

		while (n != null && index < end) {
			Node nextNode = n.next;
			Node temp = fh.next;
			fh.next = n;
			n.next = temp;
			n = nextNode;
			index++;
		}
		prev.next = fh.next;
		reverseEndNode.next = n;
	}	
}


