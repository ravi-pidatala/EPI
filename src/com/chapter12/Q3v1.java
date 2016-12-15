package com.chapter12;

/*
 * Strictly ascending and descending sequences.
 * find maximum element in a.
 * brute force is o[n] time complexity and o[1] space
 * 
 * get the middle element. check if it is greator than the element to its right . if yes, check in left half including current
 * if middle element is lesser than the right element, check in the right half excluding current element.
 * 
 * 1, 2, 1
 */
public class Q3v1 {

	public static void main(String[] args) {
		
		int [] a = {10, 11, 13, 15, 1, -10};
		Q3v1 q = new Q3v1();
		
		System.out.println(q.getPivot(a));
	}
	
	/*
	 * use iteration
	 * if there are two elements, just returns the first element.
	 */
	int getPivot(int [] a) {
		int start = 0;
		int end = a.length - 1;
		
		while (end > start) {
			int middle = start + (end - start) / 2;
			
			// there are atleast two elements.
			if (a[middle] > a[middle + 1]) {
				end = middle;
			} else if (a[middle] < a[middle + 1]) {
				start = middle + 1;
			} else {
				System.out.println("invalid input");
				break;
			}
		}
		return start;
		
	}
	
	

	
	
}
