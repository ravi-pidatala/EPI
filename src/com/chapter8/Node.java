package com.chapter8;

class Node {
	int data;
	Node next;
	int priority;

	Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
	
	Node(int data, Node next, int priority) {
		this.data = data;
		this.next = next;
		this.priority = priority;
	}
}
