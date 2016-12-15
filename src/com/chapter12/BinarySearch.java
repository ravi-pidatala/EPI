package com.chapter12;

public class BinarySearch {

	public static void main(String[] args) {
		int [] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		BinarySearch bs = new BinarySearch();
		System.out.println(bs.binarySearch(a, 8));// expecting 7 as index
	}
	
	/*
	 * find if x is present in sorted array a
	 */
	int binarySearch(int [] a, int x) {
		int start = 0;
		int end = a.length - 1;
		int middle = 0;
		
		while (end >= start) {
			middle = start + (end - start) / 2;
			if (x == a[middle]) {
				return middle;
			}
			if (x > a[middle]) {
				// x may be in the right half
				start = middle + 1;
			} else {
				end = middle - 1;
			}
		}
		return -1;
	}
	
	int binarySearch(int [] a, int x, int start, int end) {
		int middle = 0;
		
		while (end >= start) {
			middle = start + (end - start) / 2;
			if (x == a[middle]) {
				return middle;
			}
			if (x > a[middle]) {
				// x may be in the right half
				start = middle + 1;
			} else {
				end = middle - 1;
			}
		}
		return -1;
	}

}
