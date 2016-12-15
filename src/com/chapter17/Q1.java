package com.chapter17;

import java.util.Arrays;
import java.util.List;

public class Q1 {

	public static void main(String [] args) {
		Q1 q = new Q1();
		List<Integer> individualPlay = Arrays.asList(new Integer [] {2, 3, 7});
		
		System.out.println(q.getNumberOfCombinations(12, individualPlay));
		
	}
	
//	int getResult(int total, int twoTotal, int threeTotal, int sevenTotal, int prevResult) {
//		
//		if (total == twoTotal + threeTotal + sevenTotal) {
//			return prevResult + 1;
//		}
//		
//		if (total > twoTotal + threeTotal + sevenTotal) {// not valid.
//			return prevResult;
//		}
//		
//		twoTotal = twoTotal + 2;
//		prevResult = getResult(total, twoTotal, threeTotal, sevenTotal, prevResult);
//		twoTotal = twoTotal - 2;
//		
//		
//		threeTotal = threeTotal + 3;
//		prevResult = getResult(total, twoTotal, threeTotal, sevenTotal, prevResult);
//		threeTotal = threeTotal - 3;
//		
//		
//		sevenTotal = sevenTotal + 7;
//		prevResult = getResult(total, twoTotal, threeTotal, sevenTotal, prevResult);
//		sevenTotal = sevenTotal - 7;
//		return prevResult;
//	}
	
	/*
	 * s2, s3, s7 be totals.
	 * Not using recursion.
	 * Dynamic Programming.
	 * 
	 */
	public int getNumberOfCombinations(int finalScore, List<Integer> individualPlayScore) {
		int [][] combinations = new int [individualPlayScore.size()][finalScore + 1];
		
		for (int i = 0; i < individualPlayScore.size(); i++) {
			for (int j = 0; j < finalScore + 1; j++) {
				
				int playWithoutCurrent = (j == 0) ? 1 : i >= 1 ? combinations[i - 1] [j]: 0;
				int playWithCurrent = j >= individualPlayScore.get(i) ? combinations[i][j - individualPlayScore.get(i)]: 0;
				
				combinations[i][j] = playWithoutCurrent + playWithCurrent;
			}
			
		}
		return combinations[individualPlayScore.size() - 1][finalScore];// last row last column 
	}
	
	
	
	
	
}
