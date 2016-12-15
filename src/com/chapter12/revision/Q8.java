package com.chapter12.revision;

import java.util.Random;

public class Q8 {
	Random random = new Random();
	public static void main(String[] args) {
		
		Q8 q = new Q8();
		
		//Check for the partition workflow
		int [] a = {1, -100,  5, 6, 77, 20, 35, 23, 23, 23, 45, 1};
		//q.partitionAroundPivot(a, 0, a.length - 1, 2);
		q.pivotSort(a, 0, a.length - 1, 2);
		
		for (int x: a) {
			System.out.print(x + ",");
		}
		
	}
	
	/*
	 * find the kth largest element in the array
	 * brute force: sort o[n log n] . sort the array in descending order and get the kth element. or naturally 
	 * sort and get n - k - 1 element from first. 
	 * 
	 * 0, 1, 2, 3, 4, 
	 * n is 5.
	 * 
	 * heap : put the elements into min heap of size k. heap will hold k largest elements. (minimum element will be deleted)
	 * Since , minimum from the heap is deleted to accomodate a larger element. 
	 * the minimum among the k largest elements is the kth largest element.
	 * n log k time. o[k] space.
	 * 
	 * 
	 * 
	 * pivoting sort: randomly select an element . re arrange array such that elements greator than it come to left lesser than it to the right
	 * count from the last. if current is k from the first return current. 
	 * if index is > k , do the same for the left half
	 * if index < k, do it for the right half.
	 * Randomly select element for the pivot sort. 
	 * With randomized slection, o[n] running time is guranteed for very big input.
	 * 
	 * 
	 */
	
	Integer getkthLargest(int [] a, int k) {
		if (a.length - 1 >= k) {
			return getKLargestElement(a, 0, a.length - 1, k);
		}
		return null;
	}
	
	private int getKLargestElement(int [] a, int start, int end, int k) {
		/*
		 * perform pivot sort for random selected element . 
		 * 
		 */
		int index = start + random.nextInt(end - start + 1);
		
		int pivotIndex = pivotSort(a, start, end, index);
		
		if (pivotIndex == k) {
			return a[pivotIndex];
		} else if (pivotIndex > k) {
			return getKLargestElement(a, start, pivotIndex - 1, k);
		} else {
			// pivotIndex < k
			return getKLargestElement(a, pivotIndex + 1, end, k);
		}
	}
	
	/*
	 * performs a pivot sort around the element of index. 
	 * Returns the pivot index
	 */
	int pivotSort(int [] a, int start, int end, int index) {
		// start and end must not be same
		if (start == end) {
			return start;
		}
		
		// swap the index with the last element
		swap(a, end, index);
		
		int right = end - 1;
		int left = start;
		
		while (left < right) {
			while (left < right && a[left] > a[end]) {
				left++;
			}
			while (left < right && a[right] < a[end]) {
				right--;
			}
			swap(a, left++, right--);
		}
		swap(a, left, end);
		return left;
	}
	
	
	/*
	 * partition around the pivot.
	 * instead of having two pointers at both ends, 
	 * we can have a pointer at the right. 
	 * coming from the first to last, swap the current with the right, if the element is less than the pivot value. 
	 * This is for pivoting. elements to right are lesseer. 
	 * 
	 * elements to the left are higher. 
	 * 
	 */
	int partitionAroundPivot(int [] a, int start, int end, int index) {
		
		swap(a, index, end);
		int pivotIndex = start;
		
		for (int i = start; i < end; i++) {
			if (a[i] > a[end]) {
				swap(a, i, pivotIndex++);
			}
		}
		swap(a, pivotIndex, end);
		return pivotIndex;
	}
	
	void swap(int [] a, int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	
	
	
	

}
