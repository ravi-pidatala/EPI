package com.chapter11;

import java.util.ArrayList;
import java.util.List;

/*
 * merge k sorted Files
 */
public class Q1 {

	public static void main(String[] args) {
		BinaryHeap<ArrayEntry> heap = new BinaryHeap<>();
		
		ArrayEntry a0 = new ArrayEntry(0, 7);
		ArrayEntry a1 = new ArrayEntry(0, 5);
		ArrayEntry a2 = new ArrayEntry(0, 3);
		a0.next = a1;
		a1.next = a2;
		
		ArrayEntry b0 = new ArrayEntry(1, 6);
		ArrayEntry b1 = new ArrayEntry(1, 0);
		b0.next = b1;
		
		ArrayEntry c0 = new ArrayEntry(2, 28);
		ArrayEntry c1 = new ArrayEntry(2, 6);
		ArrayEntry c2 = new ArrayEntry(2, 0);
		c0.next = c1;
		c1.next = c2;
		
		
		heap.insert(a0);
		heap.insert(b0);
		heap.insert(c0);
		
		//print the result by deleting 
		List<ArrayEntry> result = new ArrayList<>();
		while (heap.peek() != null) {
			ArrayEntry deleted = heap.delete();
			result.add(deleted);
			if (deleted.next != null) {
				heap.insert(deleted.next);
			}
		}
		
		for (ArrayEntry e: result) {
			System.out.print(e);
		}
	}
	
	
}

class ArrayEntry implements Comparable<ArrayEntry> {
	
	int index;
	int value;
	ArrayEntry next;
	
	ArrayEntry(int index, int value) {
		this.index = index;
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "(" + this.index + "," + this.value + ")";
	}
	
	@Override
	public int compareTo(ArrayEntry o) {
		ArrayEntry other = (ArrayEntry) o;
		if (this.value > other.value) {
			return 1;
		} else if (this.value == other.value) {
			return 0;
		} else {
			return -1;
		}
	}
}
