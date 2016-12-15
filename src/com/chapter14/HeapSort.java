//package com.chapter14;
//
///*
// * heap sort is in place. it is not stable
// * time complexity is o[n log n]
// * 
// * For sorting elements of array in ascending order, use max heap, so that maximum element in heap deleted can be put in the array at the end of heap. head of heap
// * 	starts at 0
// * For sorting elements in descending order, use min heap.
// */
//public class HeapSort {
//
//	public static void main(String[] args) {
//		int [] a = {10, 2, 4, 5, 6, 11, 13, -10, 4343, 10};
//		HeapSort q = new HeapSort();
//		
//		q.heapSort(a);
//		
//		for (int x: a) {
//			System.out.print(x + ",");
//		}
//	}
//	
//	void heapSort(int [] a) {
//		maxHeapify(a);// o [log n]
//	}
//	
//	// o[log n] time complexity
//	void maxHeapify(int [] a, int index) {
//		// element added at index of max heap. heapify it .
//		while (index < a.length) {
//			int leftChild = 2 * index + 1;
//			int rightChild = 2 * index + 2;
//			if (leftChild < a.length && rightChild < a.length) {
//				int maxIndex = a[leftChild] > a[rightChild] ? leftChild: rightChild;
//				if (a[maxIndex] > a[index]) {
//					ArrayUtil.swap(a, index, maxIndex);
//					index = maxIndex;// go down.
//				} else {
//					break;
//				}
//				
//			} else if (leftChild < a.length) {
//				if (a[leftChild] > a[index]) {
//					ArrayUtil.swap(a, leftChild, index);
//					index = leftChild;
//				} else {
//					break;
//				}
//			} else { // no children .
//				break;
//			}
//		}
//	}
//	
//	// o[n log n] complexity since it is log n complexity for each element
//	void maxHeapify(int [] a) {
//		for (int i = 0; i < a.length; i++) {
//			maxHeapify(a, i);
//		}
//	}
//	
//	/*
//	 * Heap condition is parent is greator than children.
//	 * max heapify . do it from the end. 
//	 * 
//	 * The end child is a.length / 2
//	 * 
//	 * The leaf nodes are from n / 2 + 1 to n.
//	 * 
//	 * 
//	 * 
//	 * 
//	 * 2, 3, 4, 5,
//	 * Go down till the leaf always. No need to go up till the root . 
//	 * At each level , parent is greator than children in the whole path to the leaf. 
//	 * 
//	 * 
//	 * 
//	 */
//
//}
