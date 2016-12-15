package com.chapter13;

import java.util.HashSet;
import java.util.Set;

/*
 * Find the longest sub array with distinct entries.
 * 
 * Input is array . out put should be the longest subarray with distinct entries.
 */
public class Q9 {

	public static void main(String[] args) {
		char [] a  = {'a', 'b', 'c', 'b', 'c', 'd', 'a', 'd'};
		char [] b  = {'a', 'a'};
		
		Q9 q = new Q9();
		System.out.println(q.getLongestDistinct(b));
	}
	
	
	/*
	 * BF: o[n 3] time complexity. get all subarrays in o[n 2]. check if they are distinct in o[n] 
	 * O[n 2] get the longest subarray starting with the current element. Do it for all the elements.
	 * 
	 * 
	 * o[n]
	 * left is 0, right is 1. Do like a sliding window.
	 * Use a hashmap for checking the distinct entries.
	 * 
	 * 
	 * Case 1: all elements distinct.Should give length of array as result.
	 * Case 2: last and first are same chars.
	 * 
	 * 
	 */
	SubArray getLongestDistinct(char [] a) {
		int left = 0;
		int right = 0;
		Set<Character> charSet = new HashSet<>();
		SubArray result = new SubArray(0, 0);
		while (right < a.length) {
			
			if (charSet.add(a[right])) {
				right++;
			} else {
				if (result.getSize() < right - left) {// since the subarray is till right-1 only
					result = new SubArray(left, right - 1);
				}
			//without increasing the right, try removing the left indices.
				charSet.remove(a[left++]);
			}
		}
		
		// now check if the left and right is the result.
		if (result.getSize() < right - left) { // now right index is included.
			result = new SubArray(left, right - 1);
		}
		return result;
	}

}
