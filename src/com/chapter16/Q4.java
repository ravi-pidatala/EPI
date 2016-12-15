package com.chapter16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q4 {

	public static void main(String[] args) {
		List<Integer> input = Arrays.asList(new Integer[] { 0, 1, 2, 3, 4 });
		List<Integer> currentResult = new ArrayList<>();
		List<List<Integer>> powerSet = new ArrayList<>();

		Q4 q = new Q4();
		// q.generatePowerSet(0, input, currentResult, powerSet);
		// int index = 1;
		// for (List<Integer> resultSet: powerSet) {
		// System.out.print(index++ + ": ");
		// for (int x: resultSet) {
		// System.out.print(x + ",");
		// }
		// System.out.println("");
		// }

		q.generatePowerSets(input);
	}

	/*
	 * method takes a set and returns power set. {0, 1, 2}
	 * 
	 */
	public void generatePowerSet(int startIndex, List<Integer> input, List<Integer> currentResult,
			List<List<Integer>> powerSet) {
		if (startIndex == input.size()) {
			powerSet.add(new ArrayList<>(currentResult));
			return;
		}

		// get all subsets including the current one.
		currentResult.add(input.get(startIndex));
		generatePowerSet(startIndex + 1, input, currentResult, powerSet);

		// get all subsets without the current one.
		currentResult.remove(currentResult.size() - 1);
		generatePowerSet(startIndex + 1, input, currentResult, powerSet);
	}

	/*
	 * Iterate through all integers form 0 to 2 power n - 1. for each integer,
	 * get the one.for each one , get the element of the index.
	 */
	public void generatePowerSets(List<Integer> input) {
		// validation. 2 power n should be in integer range .
		if (input.size() >= 31) {
			return;
		}
		Integer maxLimit = 1 << input.size();

		List<Integer> result = new ArrayList<>();
		int index = 0;
		int count = 0;
		for (int i = 0; i < maxLimit; i++) {
			int j = i;
			result = new ArrayList<>();
			while (j > 0) {
				index = getBit(j & ~(j - 1));
				j = j & j - 1;
				result.add(input.get(index - 1));
			}
			// print arraylist and get it ready for gc.
			System.out.print(count++ + ": ");
			for (int x : result) {
				System.out.print(x + ",");
			}
			System.out.println("");
			result = null;
		}

	}
	
	int getBit(int x) {
		int index = 0;
		while (x != 0) {
			index++;
			x = x >>> 1;
		}
		return index;
	}

}
