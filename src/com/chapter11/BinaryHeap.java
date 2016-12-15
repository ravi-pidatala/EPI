package com.chapter11;

import java.util.ArrayList;
import java.util.List;

/*
 * implement max - binary heap 
 */
public class BinaryHeap<T extends Comparable<T>> {
	int items;
	//int maxSize = Integer.MAX_VALUE;
	
	//private Comparator<T> comparator;
	public List<T> elementList = new ArrayList<>();
	
//	BinaryHeap(Comparator<T> comparator) {
//		this.comparator = comparator;
//	}
	
	public T peek() {
		if (items > 0) {
			return elementList.get(items - 1);
		}
		return null;
	}
	
	// insert the element into the heap
	public void insert(T t) {
		if (items < elementList.size()) {
			elementList.set(items, t);
		} else {
			elementList.add(t);
		}
		items++;
		shiftUp();
	}
	
	/*
	 * Take the last element and shift up
	 * this is max Binary Heap
	 */
	private void shiftUp() {
		int current = items - 1;
		
		int parent = -1;
		
		while (true) {
			parent = (current - 1) / 2;
			if (parent < 0 || current < 0) {
				break;
			}
			if (elementList.get(current).compareTo(elementList.get(parent)) > 0) {
				//swap parent and current
				swap(elementList, current, parent);
				current = parent;
			} else {
				break;
			}
		}
	}
	
	/*
	 * Remove the first element
	 */
	public T delete() {
		T deleted = elementList.get(0);
		elementList.set(0, elementList.get(items - 1));
		elementList.set(items - 1, null);
		items--;
		shiftDown();
		return deleted;
	}
	
	/*
	 * place the first element at correct position
	 */
	private void shiftDown() {
		
		int current = 0, leftChild, rightChild;
		while (true) {
			int replacement = -1;
			leftChild = 2 * current + 1;
			rightChild = 2 * current + 2;
			
			/* 	compare left and right child
				check which is greator
				
			*/
			if (leftChild < items && rightChild < items) {
				if (elementList.get(leftChild).compareTo(elementList.get(rightChild)) > 0) {
					replacement = leftChild;
				} else {
					replacement = rightChild;
				}
				if (elementList.get(current).compareTo(elementList.get(replacement)) > 0) {
					break;
				} else {
					swap(elementList, current, replacement);
					current = replacement;
				}
			} else if (leftChild < items && elementList.get(leftChild).compareTo(elementList.get(current)) > 0) {
				swap(elementList, leftChild, current);
				current = leftChild;
			} else {
				break;
			}
		}
	}
	
	private void swap(List<T> elementList, int current, int replacement) {
		T temp = elementList.get(current);
		elementList.set(current, elementList.get(replacement));
		elementList.set(replacement, temp);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < items; i++) {
			sb.append(elementList.get(i) + ", ");
		}
		return sb.toString();
	}
	
}
