package com.chapter12.revision;

public class Q4 {

	public static void main(String[] args) {
		
	}
	
	/*
	 * Compute the integer square root 
	 * program takes non negative integer, return largest integer whose square is less than equal to given integer
	 * 
	 * Get largest integer whose square is integer. end
	 * start is 0
	 * 
	 *  get square of middle element. and go onto side. 
	 *  
	 *  if only two elements, start and middle would be same and it goes into infinite loop
	 *  
	 *  
	 */
	int getSquareRoot(int k) {
		int start = 0;
		int end = (int) Math.sqrt(Integer.MAX_VALUE);
		
		while (end > start) {
			int middle = start + (end - start) / 2;
			
			int midSq = middle * middle;
			
			if (midSq > k) {
				// search on left excluding current.
				end = middle - 1;
			} else if (midSq < k) {
				//search on right including current
				start = middle + 1;
			} else {
				return middle;
			}
		}
		return start - 1;
	}
	
}
