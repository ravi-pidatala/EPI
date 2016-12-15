package com.chapter18;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q4 {

	public static void main(String[] args) {
		List<Integer> a = Arrays.asList(new Integer[] {11, 2, 5, 7, 3});
		
		Q4 q = new Q4();
		
		System.out.println(q.checkThreeSum(a, 22));
	}
	
	
	/*
	 * input is array and a number. Determine if there are 3 entries in the array that add up to specified number.
	 * Note that the elements are not necessarily distinct.
	 * 
	 * Sort the array.
	 * 
	 * 
	 * 
	 * 
	 */
	boolean checkThreeSum(List<Integer> a, int threeSum) {
		Collections.sort(a); // n log n
		
		for (int index = 0; index <= a.size() - 1; index++) {// o [n square]
			int current = a.get(index);
			if (checkTwoSum(a, threeSum - current, index)) {
				return true;
			}
		}
		return false;
	}
	
	// a is sorted arrayList. o[n] rumtime
	private boolean checkTwoSum(List<Integer> a, int twoSum, int start) {
		
		for (int i = start, j = a.size() - 1; i <=j;) {
			if (a.get(i) + a.get(i) == twoSum || 
				a.get(j) + a.get(j) == twoSum ||
				a.get(i) + a.get(j) == twoSum) {
					return true;
				}
			
				if (a.get(i) + a.get(j) > twoSum) {
					j--;
				} else if (a.get(i) + a.get(j) < twoSum) {
					i++;
				}
		}
		return false;
	}
}
