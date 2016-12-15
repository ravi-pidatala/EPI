package com.chapter16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.chapter6.Q10revise;

/*
 * use recursion for this. 
 * 
 */
public class Q3 {

	public static void main(String[] args) {
		List<Integer> input = Arrays.asList(new Integer [] {2, 3, 5, 7});
		Q10revise q10 = new Q10revise();
		Q3 q = new Q3();
		//q.generatePermutations(input, 0);
		
		int index = 1;
		
		while (q10.nextPermutation(input)) {
			System.out.println();
			System.out.print(index++ + ": ");
			for (int x: input) {
				System.out.print(x + ",");
			}
		}
	}
	
	/*
	 * Input is array of distinct integers.
	 * Generate all permutations of array.
	 * 
	 */
	public void generatePermutations(List<Integer> a, int start) {
		List<List<Integer>> permutations = new ArrayList<>();
		
		generatePermutations(start, a, permutations);
		
		for (List<Integer> result: permutations) {
			for (int x: result) {
				System.out.print(x + ",");
			}
			System.out.println();
		}
	}
	
	/*
	 * Get all permutations starting with start index.
	 */
	void generatePermutations( int start, List<Integer> input, List<List<Integer>> permutations) {
		// base case
		if (start == input.size() - 1) {
			permutations.add(new ArrayList<>(input));
			return;
		}
		
		for (int index = start; index < input.size(); index++) {
			Collections.swap(input, start, index);
			generatePermutations(start + 1, input, permutations);
			Collections.swap(input, start, index);
		}
	}
}
