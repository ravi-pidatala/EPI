package com.chapter12;

public class Q1v1 {

	/*
	 * take sorted array and key 
	 * find index of first occurance of element greator than the key
	 * 
	 */
	public static void main(String [] args) {
		Q1v1 q = new Q1v1();
		int [] a = {-14, -10, 2, 108, 108, 243, 285, 285, 285, 401};
		
		System.out.println(q.getFirstGreatorThanKey(a, 285));
		System.out.println(q.getFirstGreatorThanKey(a, -13));
	}
	
	int getFirstGreatorThanKey(int [] a, int key) {
		int start = 0;
		int end = a.length - 1;
		int result = -1;
		
		while (end >= start) {
			int middle = start + (end - start) / 2;
			
			if (a[middle] > key) {
				result = middle;
				end = middle - 1;// search on left 
			} else {// search on right half. since middle element is either equal to less than the key.
				start = middle + 1;
			}
			
		}
		return result;
	}
}
