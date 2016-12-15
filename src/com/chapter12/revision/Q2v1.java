package com.chapter12.revision;

public class Q2v1 {

	public static void main(String[] args) {
		Q2v1 q = new Q2v1();
		
		int [] a = {1, 1, 4, 6, 6, 6, 7, 7, 7, 7, 8};
		
		System.out.println(q.getElement(a, 0, a.length - 1));
	}

	/*
	 * sorted array with duplicates. find an element i where i = a[i]
	 * 
	 * brute force . o[n] time and o[1] space. just iterate through the
	 * elements. Do this by using recursion.
	 * 
	 */
	int getElement(int[] a, int left, int right) {

		// if left == right ??
		if (left > right) {
			return -1;
		}

		int middle = left + (right - left) / 2;

		if (a[middle] == middle) {
			return middle;
		}

		if (a[middle] > middle) {
			// element not present from middle to a[middle]
			//search from start to middle - 1.
			// search from indices a[middle] to end.
			int x = -1;
			x = getElement(a, left, middle - 1);
			
			if (x != -1) {
				return x;
			}
			
			if (a[middle] <= right) {
				x = getElement(a, a[middle], right);
				if (x != -1) {
					return x;
				}
			}

		} else { // a[middle] < middle
			// Element not present in start to a[middle].
			// search from a[middle] to middle - 1
			// search from middle + 1 to end
			int x = -1;
			if (a[middle] <= middle - 1) {
				x = getElement(a, left, a[middle]);
				if (x != -1) {
					return x;
				}
			}

			return getElement(a, middle + 1, right);

		}
		return -1;
	}

}
