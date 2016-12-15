package com.chapter16temp;

import java.util.ArrayList;
import java.util.List;

/*
	Compute all permutations of an integer List
*/
public class Q3 {

	public static void main(String [] args) {


	}


	static List<ArrayList<Integer>> getPermutations(List<Integer> a) {
		//validation
		List<ArrayList<Integer>> result = new ArrayList<>();
		computePermutations(0, a, result);
		return result;
	}

	static void computePermutations(int i, List<Integer> a , List<ArrayList<Integer>> result) {
		if (i == a.size() - 1) {
			result.add(new ArrayList<Integer>(a));
			return;
		}

		for (int j = i; j < a.size(); j++) {
			swap(a, i, j);
			computePermutations(i + 1, a , result);
			swap(a, i, j);
		}
	}
	
	static void swap (List<Integer> list, int x, int y) {
		
		
		
		
	}
}
