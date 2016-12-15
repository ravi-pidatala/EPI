package com.chapter13;

import java.util.HashSet;
import java.util.Set;

public class Q10 {

	public static void main(String[] args) {
		
	}
	
	/*
	 * Find length of longest contained interval.
	 * Return size of largest subset of integers in the array
	 * 
	 * If two integers are in the input then so all integers are there.
	 * 
	 * brute force. sort the array. n log n
	 * Check the length for each starting point. O[n]
	 * 
	 * Do you need total ordering???? 
	 * 
	 * Find the first and last elements . From first go on increasing one by one. if not exists. 
	 * Find the next biggest element. it will need heap and similar time complexity as above.
	 * 
	 * Store all elements into hashtable o[n]
	 * iterate through the map. check left and right removing the entires that we already saw.
	 * save the length
	 * no need of ordering at all. 
	 * o[n] time and o[n] space.
	 * each element is only processed once. 
	 * Here sequence is not considered. 
	 * 
	 * 10 elements 0 to 9
	 * 
	 * left = -1, right = 10
	 * 
	 */
	public int getLongestContainedInterval(int [] a) {
		Set<Integer> set = new HashSet<>();
		
		for (int i = 0; i < a.length; i++) {
			set.add(a[i]);
		}
		
		int longestLength = 0;
		
		// need to check if there comes an exception. 
		while (!set.isEmpty()) {
			int x = set.iterator().next();
			int left = x - 1;
			int right = x + 1;
			set.remove(x);
			
			// check in the left.
			while (left >= 0) {
				if (set.contains(left)) {
					set.remove(left);
					left--;
				} else {
					break;
				}
			}
			
			while (right < set.size()) {
				if (set.contains(right)) {
					set.remove(right);
					right++;
				} else {
					break;
				}
			}
			
			longestLength = Math.max(longestLength, right - left - 1);
		}
		return longestLength;
	}
	

}
