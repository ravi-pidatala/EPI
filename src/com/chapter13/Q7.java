package com.chapter13;

import java.util.HashSet;
import java.util.Set;

/*
 * program takes array of string and set of string
 * return the indices of starting and ending of the shortest sub array of the given array that 
 * Covers the set 
 * 
 */
public class Q7 {

	public static void main(String[] args) {
		Q7 q = new Q7();
																						   //7     //8       //9      //10  //11   ==> 8, 10 
		String [] paragraph = {"apple", "banana", "apple", "apple", "dog", "cat", "apple", "dog", "banana", "apple", "cat", "dog"};
		Set<String> search = new HashSet<>();
		search.add("banana");
		search.add("cat");
		
		System.out.println(q.getSubArray(paragraph, search));
		
	}

	/*
	 * Brute Force:
	 * 1. Get all the sub arrays of the paragraph. => number is o[n 2] i.e. choose a starting point in n ways . ending point in n - start ways. 
	 * 2. Check which sub array covers the set. Suppose set has m words. 
	 * 3. time is o[m] * o[n 2], space is o[n 2]
	 * 
	 * Better implementation. 
	 * 1. have indices left and right initialized to 0.
	 * 2. take the right index to right till the sub array covers the set.Record the result. 
	 * 3. Now move the left index till the subarray covers the set replacing recorded results when necessary.
	 * 4. if left is at a point where set is not covered, move right till the set is covered. 
	 * 5. Then move left till set is not covered. 
	 * 6. Repeat the above process till right gets to end and left is at a point where set is not covered.
	 * 7. above will give subarray which is smallest. 
	 * 8. We are using the concept that subarray means we need to give adjacent words .i.e.we need start and end index. 
	 * 
	 * 
	 * 
	 */
	SubArray getSubArray(String [] paragraph, Set<String> search) {
  		SubArray result = new SubArray(1, Integer.MAX_VALUE);
		Set<String> covered = new HashSet<>();
		
		int left = 0;
		for (int right = 0; right< paragraph.length; ) {
		
			while (right < paragraph.length) {
				if (search.contains(paragraph[right])) {
					covered.add(paragraph[right]);
				}
				
				if (search.size() == covered.size()) {
					// found a sub array. from left to right.left is present and right is present in the result
					if (right - left + 1 < result.getSize()) {
						result = new SubArray(left, right);
					}
					right++;
					break; // search increasing the left
				}
				
				right++;
			}
	
			while (left <= right - 1) {// right got incremented by 1 at end of prev while loop
				if (search.size() == covered.size()) {
					// found a sub array
					if (right - left < result.getSize()) {
						result = new SubArray(left, right - 1);
					}
					// remove the left. check if set is still covered. if yes, left ++.
					// if set is not covered, increase right and check.
					covered.remove(paragraph[left++]);
				} else {
					break;
				}
				
			}
		}
		return result;
	}
	
}

