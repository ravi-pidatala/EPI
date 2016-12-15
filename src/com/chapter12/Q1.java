package com.chapter12;

/*
 * takes sorted array and key 
 * returns index of first occurance of the key in the array.
 * Return negative number if the key is not present.
 */
public class Q1 {

	public static void main(String[] args) {
		Q1 q = new Q1();
		int [] a = {-14, -10, 2, 108, 108, 243, 285, 285, 285, 401};
		
		System.out.println(q.getFirstIndex(a, 285));
		System.out.println(q.getFirstIndex(a, 108));
		
		
	}
	
	/*
	 * binary search will give the index of element if present in the array
	 * if duplicates allowed, we can get any index. 
	 * Since we are interested in the left only, we can do another binary search from start to middle for the element , saving the currently found index.
	 * if we find anither element , just replace our result
	 */
	int getFirstIndex(int [] a, int key) {
		int start = 0;
		int end = a.length - 1;
		int result = -1;
		
		while (end >= start) {
			int middle = start + (end - start) / 2;
			
			if (a[middle] == key) {// record the result. continue searching on the left half to see whether there was repetition.
				result = middle;
				end = middle - 1;// start is the same
			} else if (a[middle] > key) { // key may be on the left
				end = middle - 1;
			} else { // key may be on the right
				start = middle + 1;
			}
		}
		return result;
	}

}
