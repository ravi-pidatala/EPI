package com.chapter12.revision;

public class Q3 {

	public static void main(String[] args) {
		Q3 q = new Q3();
	}

	
	/*
	 * Array is cyclically sorted.
	 * i.e. entries can be shifted cyclically so it becomes sorted.
	 * Find position of smallest element in cyclically sorted array,
	 * Assume elements are distinct
	 * 
	 * o[n] time and o[1] space brute force.
	 * 
	 * if middle element > end element, search from middle + 1 to end
	 * if middle element is < end element, search from start to middle
	 * No repetition.
	 * 
	 *        /       
	 *       /     
	 *      /
	 *              /
	 *             /
	 *           /
	 *        Check if the program works if only two elements
	 *        5, 4 => middle is 0.ok.
	 *        10, 13, 15, 1, 6 =>  ok
	 *        10, 13, 15, 16, 6, 9 =>  ok
	 *         1 => ok.
	 *
	 */
	int getPivot(int [] a) {
		int start = 0;
		int end = a.length - 1;
		
		while (end > start) {
			int middle = start + (end - start) / 2;
			
			if (a[middle] > a[end]) {
				start = middle + 1;
			} else if (a[middle] < a[end]) {
				end = middle;
			}
		}
		return start;
	}
	
	
	/*
	 *  Repetitions allowed.
	 *  Brute force o[n] time and o[1] space
	 *  
	 *  if a[middle] > a[end] => check in the right i.e. middle + 1 to end
	 *  if a[middle] < a[end] => check in the left i.e. start to middle
	 *  if a[middle] = a[end] => check on both sides for the pivot.
	 *  				Check from start to middle.. if pivot present 
	 *     				Check from middle + 1 to right. 
	 *     				pivot is the point which ever value at the correcponding index is lesser
	 *   Use recursion at this point. 
	 *             
	 *             /   
	 *  		/ /   / / / /
	 *  
	 *  
	 *  
	 */
	int getPivotRep(int [] a, int left, int right) {
		
		if (left == right) {
			return left;
		}
		
		while (left < right) {
			int middle = left + (right - left) / 2;
			
			if (a[middle] > a[right]) {
				left = middle + 1;
			} else if (a[middle] < a[right]) {
				right = middle;
			} else {
				// check both sides
				int leftResult = getPivotRep(a, left, middle);
				int rightResult = getPivotRep(a, middle + 1, right);
				
				return a[leftResult] < a[rightResult] ?  leftResult: rightResult;
			}
		}
		return left;
	}
}
