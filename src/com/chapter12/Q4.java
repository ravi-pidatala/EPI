package com.chapter12;
/*
 * program takes non negative integer.
 * gives largest integer whose square is less than or equal to the given integer
 * 16 => 4
 * 17 => 4
 * 
 * brute force approach ==> check for each sqaure and check if it is the number. time complexity is too high
 * 
 * 1. Get the square root of integer.MAX.i.e. x
 * 2. From 1 to x . 
 * 3. Square the middle element. check if the square is less than the integer
 * 4. 
 * 5. 
 * 6.
 * 
 * 
 * 
 */
public class Q4 {

	public static void main(String[] args) {
		Q4 q = new Q4();
		
		System.out.println(q.getResult(1000));
		
	}
	
	int getResult(int a) {
		int end = (int) Math.sqrt(Integer.MAX_VALUE);
		int start = 1;
		
		while (end > start) {
			int middle = start + (end - start) / 2;
			long middleSquare = middle * middle;
			if (middleSquare <= a) {
				// check right including the middle
				start = middle + 1;
			} else if (middleSquare > a) {
				// check left excluding middle
				end = middle - 1;
			} 
		}
		return start - 1;
	}
	
	

}
