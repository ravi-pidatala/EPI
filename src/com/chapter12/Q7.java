package com.chapter12;

public class Q7 {

	/*
	 * algorithm to find min and max elements in an array.
	 * 
	 */
	public static void main(String [] args) {
		int [] a = {10 ,2 ,34, 4, 5,  6 ,7, 89, 111, -100, -203, -39 , 34};
		
		Q7 q = new Q7();
		MinMax result = q.findMinMax2(a);
		
		System.out.println("min is " + result.min);
		System.out.println("max is " + result.max);
	}
	
	/*
	 * worst case for this algorithm is if a is in ascending order/ non descreasing order. or the minimum element is in the first..  2n comparisons.
	 * Best case : descending order.
	 * 
	 *  
	 *  BETTER ALGO required.
	 *  
	 *  
	 */
	MinMax findMinMax(int [] a) {
		MinMax result = new MinMax();
		if (a.length == 0) {
			return result;
		}
		
		int min = a[0];
		int max = a[0];
		
		for (int i = 1; i < a.length; i++) {
			if (a[i] < min) {
				min = a[i];
			} else if (a[i] > max) {
				max = a[i];
			}
		}
		result.max = max;
		result.min = min;
		return result;
	}
	
	/*
	 * Brute force algo. 
	 * find min by n - 1 comparisons
	 * find max by n - 1 comparisons
	 * 2n -2 comparisons. 
	 * 
	 * divide the elements into two groups :
	 * SUPPOSE n is even
	 * n /2 comparisons divides the elements into two groups. 
	 * 
	 * 
	 */
	MinMax findMinMax2(int [] a) {
		MinMax result = new MinMax();
		MinMax local = new MinMax();
		if (a.length == 0 || a.length == 1) {
			return result;
		}
		
		result.arrange(a[0], a[1]);
		
		for (int i = 2; i + 1 < a.length; i = i + 2) {
			local.arrange(a[i], a[i + 1]);
			
			result.arrange(Math.min(local.min,  result.min), Math.max(local.max, result.max));
		}
		
		if (a.length % 2 == 1) {
			result.arrange(Math.min(a[a.length - 1],  result.min), Math.max(a[a.length - 1], result.max));
		}
		return result;
	}
	
}

class MinMax {
	int min;
	int max;
	
	void arrange(int x, int y) {
		if (x < y) {
			min = x;
			max = y;
		} else {
			min = y;
			max = x;
		}
	}
}
