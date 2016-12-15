package com.chapter16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Time complexity is 2 power n
 */
public class Q10 {

	public static void main(String[] args) {
		Q10 q = new Q10();
		int n = 2;
		List<Integer> localResult = new ArrayList<>();
		Set<Integer> localSet = new HashSet<>();
		localResult.add(0);
		localSet.add(0);
		List<List<Integer>> result = new ArrayList<>();
		
		q.computeAllGreyCodes(n, localResult, localSet, result);
		
		for (List<Integer> list: result) {
			for (int x : list) {
				System.out.print(x + ",");
			}
			System.out.println("");
		}
	}
	
	/*
	 * Compute Grey Code.
	 * It is permutation of 0, 1, 2, 3, 4, ...., 2 power n - 1 so that the successive number bits differ at a position by 1. 
	 * Also the first and last number bits should differ at a position by 1.
	 *    10000, 10100 i.e.  
	 *    a = 8, b = 10.
	 *    c = a ^ b
	 *    // c should have only one 1 in its bit code. c should not be 0 and c & c - 1 should be 0 . 
	 */
	
	void computeAllGreyCodes(int n, List<Integer> localResult, Set<Integer> history, List<List<Integer>> result) {
		if (localResult.size() == (1 << n)) {
			if (differInOneBit(localResult.get(0), localResult.get(localResult.size() - 1))) {
				result.add(new ArrayList<>(localResult));
			}
			return;
		}
		
		for (int i = 0; i < n; i++) {
			int previousCode = localResult.get(localResult.size() - 1);
			int nextCode = previousCode ^ (1 << i);
			
			if (differInOneBit(previousCode, nextCode) && !history.contains(nextCode)) {
				localResult.add(nextCode);
				history.add(nextCode);
				computeAllGreyCodes(n, localResult, history, result);
				
				history.remove(nextCode);
				localResult.remove(localResult.size() - 1);
			}
		}
	}
	
	boolean differInOneBit(int a, int b) {
		int c = a ^ b;
		return c != 0 && ((c & c - 1) == 0);
	}

	/*
	 * get grey code for n - 1.
	 */
	List<Integer> computeGreyCode(int n) {
		
		if (n == 0) {
			return Arrays.asList(0);
		}
		if ( n == 1) {
			return Arrays.asList(0, 1);
		}
		
		List<Integer> greyCodeMinusOne = computeGreyCode(n - 1);
		
		int leadingGrey = 1 << n -1;
		
		// prepend 0 to it.
		List<Integer> result = new ArrayList<>(greyCodeMinusOne);
		List<Integer> reflection = new ArrayList<>();
		
		for (int i = greyCodeMinusOne.size() - 1; i >= 0; i--) {
			reflection.add(greyCodeMinusOne.get(i) | leadingGrey);
		}
		result.addAll(reflection);
		return result;
		
	}
	
	
	
}
