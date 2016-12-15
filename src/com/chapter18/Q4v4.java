package com.chapter18;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q4v4 {

	public static void main(String[] args) {
		
		List<Integer> a = Arrays.asList(new Integer[] {5, 2, 3, 4, 3});// 2, 3, 3, 4, 5
		Q4v4 q = new Q4v4();
		
		System.out.println(q.get3Tuples(a, 9));//(2, 3, 3) , (2,3, 4) 
	}
	
	/*
	 * return the number of 3 tuples such that 
	 * a[p]  a[q] + a[r] <= t. 	p, q, r are all distinct.
	 * 
	 * 
	 */
	int get3Tuples(List<Integer> a, int t) {
		int threeTuples = 0;
		Collections.sort(a);
		
		for (int i = 0; i < a.size(); i++) {
			int count = getCount(a, t - a.get(i), i + 1);
			threeTuples += count;
			if (count == 0) {
				// no need to check for the rest.
				break;
			}
		}
		return threeTuples;
	}
	
	private int getCount(List<Integer> a, int twoSum, int start) {
		int count = 0;
		for (int i = start; i < a.size() - 1; i++) {
			for (int j = i + 1; i + j < a.size(); j++) {
				if (a.get(i) + a.get(j) <= twoSum) {
					count++;
				} else {
					break;
				}
			}
			
		}
		return count;
	}

}
