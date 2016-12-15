package com.chapter12;

/*
 * Search a sorted array for an element whose value is equal to index.
 * o[n] => go through the elements 
 * o[log n] => binary search. no repetitions.
 */
public class Q2 {

	public static void main(String[] args) {

	}
	
	int getMagicIndex(int [] a) {
		int start = 0;
		int end = a.length - 1;
		
		
		while (end >= start) {
			int middle = start + (end - start) / 2;
			if (a[middle] == middle) {
				return middle;
			}
			if (a[middle] > middle) {
				// search left half
				end = middle - 1;
			} else {
				//right half
				start = middle + 1;
			}
			
			
		}
		return -1;
	}

}
