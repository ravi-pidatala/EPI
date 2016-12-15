package com.chapter15;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

public class Q6 {

	public static void main(String[] args) {
		
		
		
		
		
		
	}
	
	
	
	/*
	 * algorithm takes 3 sorted arrays and return one entry from each 
	 * such that minimum interval containing these entries is as small as possible
	 * 	
	 *  take an element from each array put into BST along with index of the array. 
	 *  check the minimum difference. save the minimum difference elements.
	 *  go on doing it till one of the arrays gets empty.
	 *   [5, 10, 15], {3, 6, 9, 12, 15}, {8, 16, 24}
	 *	
	 */
	List<ArrayElement> computeLeastIntervalElements(List<List<Integer>> sortedArrays) {
		List<Integer> heads = new ArrayList<>();
		
		for (List<Integer> list: sortedArrays) {
			heads.add(list.get(0));
		}
		
		NavigableSet<ArrayElement> currentHeads = new TreeSet<>();
		
		for (int i = 0; i < heads.size(); i++) {
			
			currentHeads.add(new ArrayElement(i , sortedArrays.get(i).get(heads.get(i))));
		}
		int result = 0;
		
		while (true) {
			result = Math.min(currentHeads.last().data - currentHeads.first().data, result);
			int minIndex = currentHeads.first().index;
			
			heads.set(minIndex, heads.get(minIndex) + 1);
			
		}
		
	}
	

}

class ArrayElement implements Comparable<ArrayElement>{
	public int index;
	public Integer data;
	
	ArrayElement(int index, Integer data) {
		this.index = index;
		this.data = data;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (! (obj instanceof ArrayElement) ) {
			return false;
		}
		ArrayElement other = (ArrayElement) obj;
		
		return other.data == this.data && other.index == this.index;
	}

	
	@Override
	public int hashCode() {
		return Integer.hashCode(data) + Integer.hashCode(index);
	}
	
	@Override
	public int compareTo(ArrayElement other) {
		int result = Integer.compare(this.data, other.data);
		
		
		if (result == 0) {
			result = Integer.compare(this.index, other.index);
		}
		return result;
	}
	
	
}
