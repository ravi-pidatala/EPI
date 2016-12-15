package com.chapter12;

import java.util.Collections;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q8 {

	public static void main(String[] args) {
		Q8 q = new Q8();
		int [] a = {4, 5, 1, 2, 3};
		int k = 2;
		Optional<Integer> result = q.getkthLargest(a, k); // 2nd largest is 4
		
		result.ifPresent(x -> System.out.println(x));
		
		System.out.println(q.getkLargest(a, k, 0, a.length - 1));
	}
	
	/*
	 * Design algorithm for computing kth largest element in an array
	 * all elements are distinct.
	 * 
	 * 
	 * Brute force: sorth the array o[n log n]
	 * o[1] to find the kth largest.
	 * space complexity o[1]
	 * 
	 * 
	 * Use pivot sort . Pick first element .
	 * Rearrange such that all elements < it are in left and > it are in right.
	 * find number of elements to its left. => l
	 * if k == l + 1, current element is kth largest.
	 * if k > l + 1, select an element to the righit of it and continue the process.
	 * 
	 * if k < l + 1 , perform the process in the left half.
	 * 
	 * 
	 * Max heap of size k. put the elements. 
	 * n log k. heap gets full. now get the kth largest element. 
	 * 
	 * if k is greator than n / 2 , instead of finding the kth largest element, find the n - k + 1 smallest element. 
	 * 
	 * space complexity o[k] or o[n - k] which ever is small. 
	 * time complexity o[n log k] or o[n log (n - k)] which ever is smaller.
	 * 
	 *      4, 5, 1, 2, 3
	 */
	
	Optional<Integer> getkthLargest(int [] a, int k) {
		boolean useMaxHeap = false;
		
		//validation
		if (a.length < k) {
			return null;
		}
		
		if (k > a.length / 2) {
			useMaxHeap = true;
			k = a.length - k + 1;
		}
		
		Queue<Integer> q = null;
		
		if (useMaxHeap) {
			q = new PriorityQueue<>(Collections.reverseOrder());
		} else {
			q = new PriorityQueue<>();
		}
		
		/*
		 * min heap deletes minimum elements on poll.
		 * So it has the largest elements in the array, not the minimum elements. 
		 * 
		 */
		for (int i = 0; i < a.length; i++) {
			q.add(a[i]);
			if (q.size() > k) {
				q.poll();
			}
		}
		
		return Optional.of(q.peek());
	}
	
	/*
	 *  Select the middle element and do pivot sort in ascending order. 
	 *  suppose there are x elements to the right of the pivot
	 *  if x is k - 1, pivot is the kth largest element
	 *     if x is > k - 1, check to the right of pivot
	 *     if x is < k - 1, conitnue looking to the left of pivot.
	 *     worst case time complexity is o[n 2]
	 *     no extra space required.
	 */
	
	Integer getkLargest(int [] a, int k, int start, int end) {
		int pivotIndex = pivotArray(a, start, end);
		int x = a.length - 1 - pivotIndex;
		
		if (x == k - 1) {
			return a[pivotIndex];
		}
		
		if (x > k - 1) {
			return getkLargest(a, k, pivotIndex + 1, end);
		} else {
			return getkLargest(a, k, start, pivotIndex - 1);
		}
	}
	
	private int pivotArray(int [] a, int start, int end) {
		
		//  select middle element
		int middle = start + (end - start) / 2;
		
		// put the middle element to the end
		swap(a, middle, end);
		
		int left = start;
		int right = end - 1;
		
		while (right >= left) {
			while (left <= right && a[left] < a[end]) {
				left++;
			}
			while (left <= right && a[right] > a[end]) {
				right--;
			}
			if (left <= right) {
				swap(a, left++, right--);
			}
		}
		swap(a, left, end);
		return left;
	}
	
	void swap(int [] a, int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
}
