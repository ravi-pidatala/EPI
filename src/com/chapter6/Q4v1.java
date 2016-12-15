package com.chapter6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q4v1 {

	public static void main(String[] args) {
		int [] a = {3, 3, 1, 0, 2, 1, 3, 0, 2, 0, 1};
		Q4v1 q = new Q4v1();
		System.out.println(q.getMinimumSteps(a));
	}
	
	public int getMinimumSteps(int [] a) {
		List<Integer> stepList = new ArrayList<>();
		int steps =  getSteps(a, 0, new HashSet<Integer>(), stepList);
		
		for (Integer index: stepList) {
			System.out.print(index + ",");
		}
		System.out.println();
		return steps;
	}
	
	/*
	 * expected: 4, 1, 0
	 */
	private int getSteps(int [] a, int s, Set<Integer> na, List<Integer> stepList) {
		
		// base case . reached end
		if (s >= a.length - 1) {
			return 0;
		}
		
		if (na.contains(s)) {
			return -1;
		}
		int temp = 0;
		for (int i = s + a[s]; i > s; i--) {
			temp = getSteps(a, i, na, stepList);
			if (temp >= 0) {
				stepList.add(s);
				return temp + 1;
			} else {
				na.add(i);
			}
		}
		na.add(s);
		return -1;
		
	}

}
