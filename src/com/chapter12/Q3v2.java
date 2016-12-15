package com.chapter12;

public class Q3v2 {

	public static void main(String[] args) {
		Q3v2 q = new Q3v2();
		
		int [] a = {10, 11, 12, 19, 1, 2, 3, 4, 5, 6};
		
		System.out.println(q.findKInCyclicSortedArray(a, 6));
		
	}
	
	/*
	 * find position of element k in cyclically sorted array of distinct elements.
	 * 
	 * Find the pivot point in o[log n]
	 * Perform binary search for k in both halves.
	 * return k if found.
	 * 
	 * one half can be excluded without binary search by checking the last element. 
	 */
	
	/*
	 * a[middle] > a[end] ==> search from middle + 1 to end.
	 * a[middle] < a[end] ==> search from start to middle
	 * a[middle] = a[end] ==> not possible if there are atleast two distinct elements
	 * 
	 * 
	 * 4, 2
	 * o[log n]
	 */
	int getLeastFromCyclicSortedArray(int [] a) {
		int start = 0;
		int end = a.length - 1;
		
		while (end > start) {
			int middle = start + (end - start) / 2;
			
			if (a[middle] > a[end]) {
				start = middle + 1;
			} else if (a[middle] < a[end]) {
				end = middle;
			} else {
				System.out.println("invalid input");
			}
		}
		System.out.println("pivot is " + start);
		return start;
	}
	
	
	int findKInCyclicSortedArray(int [] a, int k) {
		
		int pivot = getLeastFromCyclicSortedArray(a);
		BinarySearch bs = new BinarySearch();
		
		// check if k is greator than last element
		if (k > a[a.length - 1]) {
			// search to the left of pivot
			
			return bs.binarySearch(a, k, 0, pivot - 1);
		} else {
			//check from pivot to the right
			return bs.binarySearch(a, k, pivot, a.length - 1);
		}
	}

}
