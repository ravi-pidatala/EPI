package com.chapter18;

import java.util.HashMap;
import java.util.Map;

public class Q5 {

	public static void main(String[] args) {
		
		String [] a = {"a", "a", "a", "b", "a", "a", "a", "a", "a", "a",
				"b", "b", "b", "b", "b", "b", "b", "b", "b", "b"};
		
		Q5 q = new Q5();
		System.out.println(q.getMajorityElement(a));
	}
	
	/*
	 * find majority element. 
	 * One element occurs more than half number of times.
	 * make single pass over the sequence.
	 * 
	 * Straight forward to do with o[n] space using hashtable . o[n + m] time.
	 * 
	 * 
	 * Perform elimination based on invariant.
	 * 
	 * let n be size. one element occurs atleast n / 2 + 1 times.
	 * 
	 * It can be done with o[n / 2 ] space. Go till n/ 2 having element in hashmap , increasing its count. 
	 * After n / 2 , if element is new element, do not add to hashmap.
	 * 
	 * time is o[n + m]. space is o[n / 2]
	 * 
	 * Now there is algorithm using o[1] space. 
	 * 
	 * Group elements 
	 * 
	 * 
	 */
	public String getMajorityElement(String [] a) {
		String s = a[0];
		int sCount = 1;
		
		for (int i = 1; i < a.length;i++) {

			
			 if (s.equals(a[i])) {
				sCount++; 
			 } else if (sCount == 1) {
				 s = a[i];
			 } else {
				 sCount--;
			 }
		}
		return s;
	}

}
