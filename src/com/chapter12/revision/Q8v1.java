package com.chapter12.revision;

import java.util.Random;

public class Q8v1 {

	Random random = new Random();
	Q8 q8 = new Q8();
	
	public static void main(String[] args) {
		Q8v1 q = new Q8v1();
		int [] a = {0, 3, 43, 32, 50, 52, 9, 56}; // 0, 3, 9, 32, 43, 50, 52, 56 . 75/2 = 37
		System.out.println(q.fetchMedian(a));
		
	}
	
	int fetchMedian(int [] a) {
		if (a.length % 2 == 1) { // odd
			return getMedian(a, 0, a.length - 1, a.length / 2);
		} else {
			// 0, 1, 2, 3
			
			int middle1 = a.length / 2;
			int middle2 = middle1 - 1;
			
			int mid1Pivot = getMedian(a, 0, a.length - 1, middle1);
			int mid2Pivot = getMedian(a, 0, a.length - 1, middle2);
			
			return (mid1Pivot + mid2Pivot) / 2;
		}
	}
	
	/*
	 * Design algorithm for finding median of array
	 * 
	 * n is odd. sort the array such that n / 2 elements are on left and n / 2 are on right
	 * middle element is median
	 * 
	 * n is even. Sort the array such that , two elements in the middle are pivot sorted.
	 * the average of the two elements is the median.
	 * 
	 * 
	 */
	
	int getMedian(int [] a, int start, int end, int middle) {
		// assume n is odd.
		// randomly select an element, pivot sort it. 
		// check if it is in the middle.Once , array is pivot sorted with middle element
		// return the element in the middle. it is the median
		int index = start + random.nextInt(end - start + 1);
		
		int pivotIndex = q8.partitionAroundPivot(a, start, end, index);
		
		if (pivotIndex == middle) {
			return a[pivotIndex];
		} else if (pivotIndex > middle) {
			return getMedian(a, start, pivotIndex - 1, middle);
		} else { // pivotIndex < middle
			return getMedian(a, pivotIndex + 1, end, middle);
		}
	}

}
