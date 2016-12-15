package com.chapter18;

import java.util.Arrays;
import java.util.List;

public class Q4v1 {

	public static void main(String[] args) {
		List<Integer> a = Arrays.asList(new Integer[] {5, 2, 3, 4, 3});
		
		Q4v1 q = new Q4v1();
		System.out.println(q.checkThreeSum(a, 9));
		
	}
	
	/*
	 * the three elements need to be distinct.
	 * Array has distince elements
	 */
	boolean checkThreeSum(List<Integer> a, int threeSum) {
		
		for (int i = 0; i < a.size(); i++) {
			int twoSum = threeSum - a.get(i) ;
			if (checkTwoSum(a, twoSum, i + 1)) {
				System.out.println(i);
				return true;
			}
		}
		
		return false;
	}
	
	
	private boolean checkTwoSum(List<Integer> a, int twoSum, int start) {
		
		for (int i = start, j = a.size() - 1; i < j;) {
			if (a.get(i) + a.get(j) == twoSum) {
				System.out.println(i + ","  + j);
				return true;
			} else if (a.get(i) + a.get(j) > twoSum) {
				j--;
			} else {
				i++;
			}
		}
		return false;
		
		
		
	}

}
