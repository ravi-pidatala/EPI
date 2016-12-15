package com.chapter7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q7 {

	public static void main(String[] args) {
		Map<Integer, List<Character>> map = new HashMap<>();
		map.put(2, Arrays.asList(new Character [] {'A', 'B', 'C'}));
		map.put(3, Arrays.asList(new Character [] {'D', 'E', 'F'}));
		map.put(4, Arrays.asList(new Character [] {'G', 'H', 'I'}));
		map.put(5, Arrays.asList(new Character [] {'J', 'K', 'L'}));
		map.put(6, Arrays.asList(new Character [] {'M', 'N', 'O'}));
		map.put(7, Arrays.asList(new Character [] {'P', 'Q', 'R'}));
		map.put(8, Arrays.asList(new Character [] {'T', 'U', 'V'}));
		map.put(9, Arrays.asList(new Character [] {'W', 'X', 'Y'}));
		
		List<String> result = new ArrayList<>();
		Q7 q = new Q7();
		String s = "2276696";
		q.getResult(s, 0, new String(""), result, map);
		int i = 0;
		for (String x: result) {
			System.out.print(i++ + ":" + x + ",");
		}
		
		System.out.println();
		i = 0;
		for(String x: q.getResultWithOutRecursion(s, map)) {
			System.out.print(i++ + ":" + x + ",");
		}
	}
	
	private void getResult(String s, int index, String lr, List<String> r, Map<Integer, List<Character>> map) {
		// base case
		if (index == s.length()) {
			r.add(lr);
			return;
		}
		
		int x = Character.getNumericValue(s.charAt(index));
		
		for(Character c: map.get(x)) {
			getResult(s, index + 1, lr + c, r, map);
		}
	}
	
	/*
	 * Solve without recursion.
	 * Here we know that we need to iterate 7 levels. 
	 * If we do not know how many levels to recurse, its best to use recursion
	 * time complexity for recursive and non recursive is o[n * 4 ^ n] where n is length of string.
	 */
	 public List<String> getResultWithOutRecursion(String s, Map<Integer, List<Character>> map) {
		 if (s.length() != 7) {
			 System.out.println("error");
			 return null;
		 }
		 List<String> result = new ArrayList<String>();
		 
		 for (Character a0: map.get(Character.getNumericValue(s.charAt(0)))) {
			 for (Character a1: map.get(Character.getNumericValue(s.charAt(1)))) {
				 for (Character a2: map.get(Character.getNumericValue(s.charAt(2)))) {
					 for (Character a3: map.get(Character.getNumericValue(s.charAt(3)))) {
						 for (Character a4: map.get(Character.getNumericValue(s.charAt(4)))) {
							 for (Character a5: map.get(Character.getNumericValue(s.charAt(5)))) {
								 for (Character a6: map.get(Character.getNumericValue(s.charAt(6)))) {
									 result.add("" + a0 + a1 + a2 + a3 + a4 + a5 + a6);
								 }
							 }
						 }
					 }
				 }
			 }
		 }
		 return result;
	 }
}
