package com.chapter14;

public class HeapSort2 {

	public static void main(String[] args) {
		//int [] a = {3, 5, 19, 6};
		int [] a = {10, 2, 4, 5, 6, 11, 13, -10, 4343, 10};
		
		HeapSort2 q = new HeapSort2();
		q.heapSort(a);
		
		for (int x: a) {
			System.out.print(x + ",");
		}
	}
	
	void heapSort(int [] a) {
		// construct max heap.
		for (int i = a.length / 2; i >= 0; i--) {
			heapify(a, i, a.length - 1);
		}
		
		for (int i = a.length - 1; i > 0; i--) {
			ArrayUtil.swap(a, 0, i);
			heapify(a, 0, i - 1);
		}
		
		
		
		
	}
	
	void heapify(int [] a, int index, int endIndex) {
		
		int left = 2 * index + 1;
		int right = 2 * index + 2;
		int largestIndex = index;
		
		if (left <= endIndex && right <= endIndex) {
			if (a[left] > a[index]) {
				largestIndex = left;
			}
			if (a[right] > a[largestIndex]) {
				largestIndex = right;
			}
			if (largestIndex != index) {
				ArrayUtil.swap(a, largestIndex, index);
				heapify(a, largestIndex, endIndex);
			}
		} else if (left <= endIndex && a[left] > a[index]) {
			ArrayUtil.swap(a, left, index);
			heapify(a, left, endIndex);
		}
	}

}
