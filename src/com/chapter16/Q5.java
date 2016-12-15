package com.chapter16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Generate all subsets of size k from {1, 2, 3, ..., n}
 * 
 * 
 */
public class Q5 {

	public static void main(String[] args) {
		Q5 q = new Q5();
		List<Integer> input = Arrays.asList(new Integer[] {1, 2, 3, 4, 5, 6, 7}); // Should have 35 lines.
		int k = 4;
		
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> tempResult = new ArrayList<>();
		
		q.generateSubsets(input, k, result, tempResult, 0);
		
		for (int i = 0; i < result.size(); i++) {
			System.out.print(i + ": ");
			for (Integer x : result.get(i)) {
				System.out.print(x + ",");
			}
			System.out.println("");
		}
	}
	
	/*
	 * Think of right function signature. With binary approach, do not know if possible. 
	 * select an element. get k - 1 elements from the right.
	 * 
	 * current element can be present. 
	 * current element need not be present.
	 * 
	 */
	void generateSubsets(List<Integer> input, int k, List<List<Integer>> result, List<Integer> partialCombination, int index) {
		// base case.
		if (partialCombination.size() == k) {
			result.add(new ArrayList<>(partialCombination));
			return;
		}
		
		if (index == input.size()) {
			return;
		}
		
		// check all the subsets including current element.
		partialCombination.add(input.get(index));
		generateSubsets(input, k, result, partialCombination, index + 1);
			
		partialCombination.remove(partialCombination.size() - 1);
		generateSubsets(input, k, result, partialCombination, index + 1);
		
	}

}
