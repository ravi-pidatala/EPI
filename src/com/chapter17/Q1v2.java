package com.chapter17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1v2 {

	public static void main(String[] args) {
		
		
		
		
		
		
	}
	
	/*
	 * program returns the permutations of the scores. 
	 * it can be done with recursion. 
	 * 
	 */
	List<List<Integer>> getAllCombinations(int finalScore, List<Integer> individualPlays) {
		List<List<Integer>> result = new ArrayList<>();
		
		
		
		
	}
	
	
	
	/*
	 * program takes final score and scores for individual plays, 
	 * Return the number of sequences that result in final score.
	 * 
	 * Instead of saving the number of ways to get a result, save the results as List of integer.
	 * In order to save space, make row i - 1 as row i once row i is processed. 
	 * 
	 * 
	 * Not understanding
	 */
	List<List<Integer>> getCombinations(int finalScore, List<Integer> individualPlays) {
		List<List<List<Integer>>> cache = new ArrayList<>();
		cache.add(new ArrayList<>());
		
		/*
		 * number of rows is 2.
		 * number of columns is finalScore + 1.
		 * each value has list of integer.
		 */
		// first fill the row zero.
		List<List<List<Integer>>> row1 = new ArrayList<>();
		List<List<List<Integer>>> row2 = new ArrayList<>();
		
		for (int j = 0; j < finalScore + 1; j++) {
			List<List<Integer>> gridResult = new ArrayList<>();
			
			if (j == 0) {
				gridResult.add(Arrays.asList(0));
			} else if (j >= individualPlays.get(j)) {
				gridResult.addAll(row1.get(j - individualPlays.get(j)));
				for (List<Integer> list: gridResult) {
					list.add(individualPlays.get(j));
				}
			}
			row1.add(gridResult);
		}
		
		// for row 1, check the list from without list and withList
		for (int j = 0; j < finalScore + 1; j++) {
			List<List<Integer>> withoutList = new ArrayList<>();
			List<List<Integer>> withList = new ArrayList<>();
			withoutList.addAll(row1.get(j));
			
			if (j >= individualPlays.get(j)) {
				withList.addAll(row2.get(j - individualPlays.get(j)));
				for (List<Integer> list: withList) {
					list.add(individualPlays.get(j));
				}
			}
			
			row2.add(j, withoutList);
			
			row1.clear();
			row1.addAll(row2);
			row2.clear();
		}
		return row1.get(row1.size() - 1);
	}

}
