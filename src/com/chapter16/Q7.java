package com.chapter16;

import java.util.ArrayList;
import java.util.List;

public class Q7 {

	public static void main(String[] args) {

		String s = "0204451881";
		Q7 q = new Q7();

		List<String> partialPartition = new ArrayList<>();
		List<List<String>> result = new ArrayList<>();

		q.generatePallindromicDecompostion(s, 0, partialPartition, result);

		for (List<String> list : result) {

			for (String x : list) {
				System.out.print(x + ",");
			}
			System.out.println("");
		}

	}

	/*
	 * Generate pallindromic decompositions. Pallindrome reads same backwards
	 * and forwards.
	 * 
	 * 
	 * 
	 */
	void generatePallindromicDecompostion(String s, int startIndex, List<String> partialPartition,
			List<List<String>> result) {
		if (startIndex == s.length()) {
			result.add(new ArrayList<>(partialPartition));
			return;
		}

		for (int i = startIndex; i < s.length(); i++) {
			if (isPallindrome(s.substring(startIndex, i + 1))) {
				partialPartition.add(s.substring(startIndex, i + 1));
				generatePallindromicDecompostion(s, i + 1, partialPartition, result);
				partialPartition.remove(partialPartition.size() - 1);
			}
		}
	}

	boolean isPallindrome(String s) {
		int left = 0;
		int right = s.length() - 1;

		while (left < right) {
			if (s.charAt(left++) != s.charAt(right--)) {
				return false;
			}
		}
		return true;
	}
}