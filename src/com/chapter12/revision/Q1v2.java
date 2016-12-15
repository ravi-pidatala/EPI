package com.chapter12.revision;

public class Q1v2 {

	public static void main(String[] args) {
		
	}
	
	/*
	 * a is unsorted array of integers.
	 * a[0] >= a[1] and a[n - 2] <= a[n - 1]
	 * i is local minimum if a[i] <= a[i + 1] and a[i] <= a[i - 1]
	 * 
	 * 
	 *  \       /
	 *   \     /
	 *    \   /
	 *     \ /
	 * 
	 *     assume no repetitions.
	 *     
	 * 
	 */
	int getLocalMinimum(int [] a) {
		//validations
		// length should be atleast 3.
		
		int start = 1;
		int end = a.length - 2;
		
		if (start <= end) {
			int middle = start + (end - start) / 2;
			
			if (a[middle] < a[middle - 1] && a[middle] < a[middle + 1]) {
				return middle;
			}
			
			if (a[middle] > a[middle + 1]) {
				// go right
				start = middle + 1;
			} else if (a[middle] > a[middle - 1]) {
				// go left
				end = middle - 1;
			}
			
			
		}
		return -1;
	}
	
	/*
	 * With repetitions
	 * 
	 */
	int getLocalMinimum2(int [] a) {
		//validations
		// length should be atleast 3.
		
		int start = 1;
		int end = a.length - 2;
		
		if (start <= end) {
			int middle = start + (end - start) / 2;
			
			if (a[middle] <= a[middle - 1] && a[middle] <= a[middle + 1]) {
				return middle;
			}
			
			if (a[middle] > a[middle + 1]) {
				// go right
				start = middle + 1;
			} else if (a[middle] > a[middle - 1]) {
				// go left
				end = middle - 1;
			}
			
			
		}
		return -1;
	}
	

}
