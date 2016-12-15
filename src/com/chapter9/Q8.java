package com.chapter9;

import java.util.NoSuchElementException;

/*
 * Implement a circular queue.
 */
public class Q8 {

	public static void main(String[] args) {
		
		
		
		
		
	}
}

class Queue {
	int maxSize;
	Integer [] a;
	final int SCALE_FACTOR  = 2;
	int count = 0;
	
	Queue (int maxSize, int scaleFactor) {
		this.maxSize = maxSize;
		a = new Integer[maxSize];
	}
	// head is the index to read from.
	// tail is the index to write to . 
	// head should point to index where element present, tail should point to index to write to.
	int head = 0, tail = 0;
	 
	public void enqueue(Integer x) {// scales up the array if queue is full
		if (count == maxSize) {
			maxSize = count * SCALE_FACTOR;
			Integer [] temp = new Integer [maxSize];
			
			// copy into b elements from a
			int index = 0;
			for(int i = head; i < a.length; i++) {
				temp[index++] = a[i];
			}
			
			for(int i = 0; i < tail; i++) {
				temp[index++] = a[i];
			}
			
			a = temp;
			head = 0;
			tail = count;
		}
		
		a[tail] = x;
		tail = (tail + 1) % a.length;
		count++;
	}
	
	
	public void forceEnqueue(Integer x) {// replaces the element at tail if the queue is full
		//insert at tail and move tail forwards.
		a[tail] = x;
		tail = (tail + 1) % maxSize;
		count++;
		
		if (count > maxSize) {
			count = maxSize;
		}
	}
	
	public Integer dequeue() throws NoSuchElementException {
		if (count != 0) {
			//read from head. and move head forward.
			Integer ret = a[head];
			head = (head + 1) % maxSize;
			count--;
			return ret;
		}
		throw new NoSuchElementException("queue is empty");
	}
}
