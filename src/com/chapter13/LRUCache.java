package com.chapter13;

import java.util.HashMap;
import java.util.Map;

/*
 * it uses hashmap for o[1] acces time
 * uses Double LinkedList for recoring the accessorder.
 */
public class LRUCache {

	private int capacity;
	Map<Integer, LruNode> cache = new HashMap<>();
	LruNode head = null;
	LruNode tail = null;
	
	public static void main(String[] args) {
		
		
		
		
		
	}
	
	LRUCache(int capacity) {
		this.capacity = capacity;
	}
	
	void add(String key, String value) {
		LruNode node = new LruNode(key, value);
		
		if (head == null) {
			head = node;
			tail = node;
		} else {
			// add to head
			head.previous = node;
			node.next = head;
			head = node;
		}
	}
	
	

}


class LruNode {
	String key;
	String value;
	
	LruNode previous;
	LruNode next;
	
	LruNode(String key, String value) {
		this.key = key;
		this.value = value;
	}
}
