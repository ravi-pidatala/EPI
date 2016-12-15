package com.chapter12;
/*
 * Test if p is prefix of a string in an array of sorted strings
 */
public class Q1v4 {

	public static void main(String[] args) {
		
		String [] a = new String []{"how", "are", "you"};
		
		
		
	}
	
	
	int binarySearch(String [] a, String p) {
		int start = 0;
		int end = a.length - 1;
		
		while (end >= start) {
			int middle = start + (end - start) / 2;
			String midString = a[middle];
			
			if (midString.startsWith(p)) {
				return middle;
			}
			if (midString.compareTo(p) > 0) {
				// check left half
				end = middle - 1;
			} else {
				// check right half
				start = middle + 1;
			}
			
		}
		return -1;
	}
	
	
	
}
