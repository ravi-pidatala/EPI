package com.chapter12;

import java.util.Random;

public class QuickSort {
	
	Random random = new Random();
	public static void main(String[] args) {
		
		int [] a = {5 , 4};
		
		QuickSort pivot = new QuickSort();
		pivot.pivot(a, 0, a.length - 1);
		
	}
	
	/*
	 * Randomize quick sort
	 */
	int pivot(int [] a, int start, int end) {
		
		if (start >= end) {
			return start;
		}
		
		int middle = start + random.nextInt(end - start);
		//int middle = start + (end - start) / 2;
		
		// put middle element to end
		swap(a, middle, end);
		
		
		int left = start;
		int right = end - 1;
		
		while (right >= left) {
			while (right >= left && a[left] < a[end]) {
				left++;
			}
			while (right >= left && a[right] > a[end]) {
				right--;
			}
			if (right >= left) {
				swap(a, left++, right--);
			}
		}
		swap(a, left, end);
		return left;
	}
	
	void swap(int [] a, int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	
}
