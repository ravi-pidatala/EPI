package com.chapter13;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Q8 {

	public static void main(String[] args) {
		Q8 q = new Q8();
		
		String [] paragraph = {"apple", "banana", "cat", "apple"};
		Set<String> search = new LinkedHashSet<>();
		search.add("banana");
		search.add("apple");
		
		System.out.println(q.getSequentialArray(paragraph, search));//(1, 3)
	}
	
	/*
	 * Find the smallest sub array sequentially covering all the values.
	 * 
	 * Program takes two arrays of strings, return the indices of starting index and ending index of shortest sub array of 
	 * first array that sequentially covers i.e. contains all strings in the second array in order in which they appear in the 
	 * keywords array.
	 * 
	 * 
	 * 
	 * Brute Force approach: 
	 * 
	 * get all the sub arrays of the paragraph. For each sub array check if the set occurs sequentially 
	 * o[n 2] . checking takes o[n] worst case. time complexity o[n 3]
	 * 
	 * o[n 2] checking if a sub array exists for each starting point. 
	 * 
	 * 
	 * 
	 * Find the first element from the set. then find the second element, then third so on gives a result.
	 * Check if the first element occurs before second element again. 
	 * 
	 * Then start from the end element again.Do the search again.
	 * o[n] time .
	 * no additional space complexity
	 * 
	 * 
	 * 
	 * 
	 */
	SubArray getSequentialArray(String [] paragraph, Set<String> search) {
		
		int start = -1;
		int end = -1;
		String lastString = null;
		SubArray result = new SubArray(0, Integer.MAX_VALUE - 1);// check for overflow.
		
		for (int current = 0; current < paragraph.length; current++) {
			Iterator<String> it = search.iterator();
			while (it.hasNext()) {
				String toSearch = it.next();

				// search in the array starting from current + 1 to get the
				// toSearch string.

				for (int i = current; i < paragraph.length; i++) {
					if (toSearch.equals(paragraph[i])) {
						// found a string in sequence .
						current = i;

						if (start == -1) {
							start = current;
						}
						break;
					}
				}
				if (!it.hasNext()) {
					lastString = toSearch;
				}

			}
			if (lastString.equals(paragraph[current])) {
				end = current;
				if (result.getSize() > end - start + 1) {
					result = new SubArray(start, end);
				}

			}
		}
		return result;
	}
	

}
