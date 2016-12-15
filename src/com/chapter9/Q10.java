package com.chapter9;

import java.util.Deque;
import java.util.LinkedList;

public class Q10 {

	public static void main(String[] args) {
		QueueWithMax q = new QueueWithMax();
		
		Node a1 = new Node(5);
		Node a2 = new Node(7);
		Node a3 = new Node(21);
		Node a4 = new Node(19);
		Node a5 = new Node(18);
		
		q.enqueue(a1);
		q.enqueue(a2);
		System.out.println(q.getMax().data);//7
		q.dequeue();
		System.out.println(q.getMax().data);//7
		
		q.enqueue(a3);
		q.enqueue(a4);
		q.dequeue();
		System.out.println(q.getMax().data);//21
		q.enqueue(a5);
		System.out.println(q.getMax().data);//21
		
		q.dequeue();
		System.out.println(q.getMax().data);//19
		
		q.dequeue();
		System.out.println(q.getMax().data);//18
		
		
		
		
	}

	

}

//add first, removeFromLast
/*
 * the last element in the queue must be the first element in the maxList.
 * maxList is dll where adding is from first and removing is from last.
 * 
 */
class QueueWithMax {
	Deque<Node> q = new LinkedList<>();
	Deque<Node> maxList = new LinkedList<>();
	
	int size() {
		return q.size();
	}
	
	void enqueue(Node n) {
		q.addFirst(n);
		while (!maxList.isEmpty() && n.data > maxList.getFirst().data) {
			maxList.removeFirst();
		}
		maxList.addFirst(n);
	}
	
	Node dequeue() {
		if (!q.isEmpty()) {
			if (maxList.getLast().data == q.getLast().data) {
				maxList.removeLast();// max one is being removed
			}
			return q.removeLast();
		}
		return null;
	}
	
	Node getMax() {
		return maxList.getLast();
	}
}