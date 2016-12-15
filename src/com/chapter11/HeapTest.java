package com.chapter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeapTest {

	public static void main(String [] args) {
		BinaryHeap<Integer> heap = new BinaryHeap<>();
		
		
		List<Integer> elements = new ArrayList<>();
		elements.add(15);
		elements.add(10);
		elements.add(9);
		elements.add(8);
		elements.add(9);
		elements.add(6);
		elements.add(3);
		elements.add(4);
		elements.add(2);
		
		heap.elementList = elements;
		heap.items = elements.size();
		System.out.println(heap);
		
		heap.insert(12);
		System.out.println(heap);
		
		List<Integer> e = new ArrayList<>();
		e.add(18);
		e.add(10);
		e.add(15);
		e.add(9);
		e.add(10);
		e.add(6);
		e.add(8);
		e.add(5);
		e.add(2);
		e.add(9);
		e.add(7);
		
		e.add(3);
		e.add(2);
		e.add(4);
		e.add(3);
		
		BinaryHeap<Integer> h = new BinaryHeap<>();
		h.elementList = e;
		h.items = h.elementList.size();
		
		System.out.println(h);
		h.delete();
		System.out.println(h);
	}
	
}
