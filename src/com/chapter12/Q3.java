package com.chapter12;

public class Q3 {

	public static void main(String[] args) {
		
	}
	
	/*
	 * brute force o[n]. iterate through the arrar recording the minimum. minimum is the least .
	 * find the least element in cyclically sorted array(distinct integers)
	 * i.e. find the pivot point.
	 * 
	 * get the middle element. 
	 * if middle element is greator than end element, pivot is in right half excluding the current element.
	 * if middle element is lesser than end element, pivot is in the left half including the current element.
	 * Check if there is a chance of infinte loop for improper input.
	 * 
	 * 
	 */
	int getLeastIndex(int [] a) {// 1, 0.     0, 1
		// need validations.
		
		
		int start = 0;
		int end = a.length - 1;
		
		/*
		 * if there are only two elements.
		*/
		while (end > start) {
			int middle = start + (end - start) / 2;
			
			if (a[middle] > a[end]) {
				// search in right half from middle + 1 to end
				start = middle + 1;
			} else if (a[middle] < a[end]) {
				// search in the left half including current element 
				end = middle;
			}
		}
		return start;
	}
	
	
	/*
	 * Get least index cyclic sorted array with repetitions.
	 * Worst case is o[n]
	 * when more distinct elements are present it tends to o[log n].
	 * Use recursion for doing this because we have to calculate the left and right seperately.
	 * 
	 *       1, 1, 0, 0, 0, 0, 0// start = 0, end = 6, mid = 3. pivot is 2
	 *       1, 1, 1, 2, 2, 1, 2// start = 0, end = 6, mid = 3. pivot is 5
	 *       
	 */
	int getLeastIndexCyclic(int [] a) {
		
		return getLeastIndexRep(a, 0, a.length - 1);
	}
	
	private int getLeastIndexRep(int[] a, int start, int end) {
		
		if (start == end) {
			return start;
		}
		
		/*
		 * if there are only two elements.
		 */
		int middle = start + (end - start) / 2;

		if (a[middle] > a[end]) {
			// no need to search in the left.
			return getLeastIndexRep(a, middle + 1, end);
		} else if (a[middle] < a[end]) {
			// no need to search in the right. current element need to be
			// searched
			return getLeastIndexRep(a, start, middle);
		} else {
			// search in left and right

			int leftResult = getLeastIndexRep(a, start, middle);
			int rightResult = getLeastIndexRep(a, middle + 1, end);

			return a[leftResult] < a[rightResult] ? leftResult : rightResult;
		}
	}

}
