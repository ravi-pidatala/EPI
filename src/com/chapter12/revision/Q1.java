package com.chapter12.revision;

/*
 * Method takes sorted array as key and 
 * return the first occurrence of that key in the array.
 * 
 * 
 * So in binary search , if element found, check in the left
 */
public class Q1 {

	public static void main(String[] args) {
		int [] a = {1, 3, 4, 5, 10, 20, 20, 20, 20, 20, 35, 37, 39 , 40};
		
		Q1 q = new Q1();
		System.out.println(q.binarySearchFirstOccurance(a, 20));
		
	}
	
	/*
	 * 
	 * 
	 * 
	 */
	int binarySearchFirstOccurance(int [] a, int k) {
		//vali
		
		
		int start = 0;
		int end = a.length - 1;
		int result = -1;
		
		while (end >= start) {
			int middle = start + (end - start) / 2;
			
			if (a[middle] > k) {
				//search in left.
				
				end = middle - 1;
			} else if (a[middle] == k) {
				result = middle;
				// continue searching in the left.
				end = middle - 1;
			} else {
				//search in right
				
				start = middle + 1;
			}
		}
		
		return result;
	}
	

}
