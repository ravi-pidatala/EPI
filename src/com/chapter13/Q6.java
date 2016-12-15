package com.chapter13;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Program takes input as an array and finds distance between closest
	 * pair of equal entries.
	 * 
	 *  
	 * Have hashmap of string as key and integer as value.
	 * for each entry that replaces in the hashmap, get the previous entry index.
	 * if the difference is smaller than the smallest index, record the string current index and previous index
	 * 
	 *  o[m] space for saving hashap
	 *  
	 *  
	 *  o[n] time
	 *  
	 *  while building the hashmap , we save the closest entries. 
	 *  So even if one entry repeats, we get the result.
	 */
	int findNearestRepetition(List<String> paragraph) {
		
		Map<String, Integer> repetitionMap = new HashMap<>();
		int smallest = Integer.MAX_VALUE;
		
		for (int i = 0; i < paragraph.size(); i++) {
			String s = paragraph.get(i);
			Integer prev = repetitionMap.put(s, i);
			
			if (prev != null && smallest > i - prev) {
				smallest = i - prev;
			}
		}
		return smallest;
	}
}
