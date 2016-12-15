package com.chapter11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Compute k largest elements in max heap
 */
public class Q6 {

	public static void main(String[] args) {
		
	}
	
	static List<Integer> getKLargest(List<ArrayEntry> a, int k) {
		if (k == 0 || k > a.size()) {
			return Collections.EMPTY_LIST;
		}
		List<Integer> result = new ArrayList<>();
		
		PriorityQueue<ArrayEntry> candidateHeap = new PriorityQueue<>();
		candidateHeap.add(a.get(0));
		for (int i = 0; i < k; i++) {
			int candidateIndex = candidateHeap.peek().index;
			result.add(candidateHeap.remove().value);
			
			int leftChildIndex = 2 * candidateIndex + 1;
			
			if (leftChildIndex < a.size()) {
				candidateHeap.add(a.get(leftChildIndex));
			}
			
			int rightChildIndex = 2 * candidateIndex + 2;
			if (rightChildIndex < a.size()) {
				candidateHeap.add(a.get(rightChildIndex));
			}
		}
		return result;
	}
	
	
}


