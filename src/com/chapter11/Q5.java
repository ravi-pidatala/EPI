package com.chapter11;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class Q5 {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 0, 3, 5, 2, 0 , 1);
		
		onlineMedian(list.iterator());
	}
	
	static void onlineMedian(Iterator<Integer> sequence) {
		/*
		 * have two heaps. maxHeap for the smaller half
		 * min heap for the bigger half.
		 * if elements is even, maxHeap and min heap will have same number of elements
		 * else , minHeap will have more elements
		 */
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		
		while (sequence.hasNext()) {
			int x = sequence.next();
			if (minHeap.isEmpty()) {
				minHeap.add(x);
			} else {
				if (x >= minHeap.peek()) {
					minHeap.add(x);
				} else {
					maxHeap.add(x);
				}
			}
			if (minHeap.size() > maxHeap.size() + 1) {
				maxHeap.add(minHeap.remove());
			} else if (maxHeap.size() > minHeap.size()) {
				minHeap.add(maxHeap.remove());
			}
			
			//print the median
			System.out.println(minHeap.size() == maxHeap.size() ? 0.5 * (minHeap.peek() + maxHeap.peek()) : minHeap.peek());
		}
		
	}

}
