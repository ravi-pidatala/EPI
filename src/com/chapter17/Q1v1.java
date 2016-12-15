package com.chapter17;

import java.util.Arrays;
import java.util.List;

public class Q1v1 {

	public static void main(String[] args) {
		Q1v1 q = new Q1v1();
		
		List<Integer> individualPlay = Arrays.asList(new Integer [] {2, 3, 7});
		
		System.out.println(q.getCombinations(12, individualPlay));
		
	}
	
	/*
	 * Solve the same problem using o[s] space. 
	 * Have three rows with s + 1 columns, where s is final score.
	 * once done with row 2, copy the contents of row 1 to row 0 and row 2 to row 1.
	 * This is done using iteration.
	 */
	public int getCombinations(int finalScore, List<Integer> individualPlay) {
		
		// make the row i - 1 as row i once i is processed.  
		//Copy the next row result to row i.
		
		/*
		 * For this process the row 0 first.
		 */
		int [][] combinations = new int [2][finalScore + 1];// only two rows
		
		for (int column = 0; column < finalScore + 1; column++) {// fill the first row.
			combinations[0][column] = (column == 0) ? 1: (column - individualPlay.get(0) < 0) ? 0: combinations[0][column - individualPlay.get(0)];
		}
		
		int index = 0;
		for (int i = 1; i < individualPlay.size(); i++) {
			for (int j = 0; j < finalScore + 1; j++) {
				int withoutCurrentPlay = combinations[i - index - 1][j];
				int withCurrentPlay = j >= individualPlay.get(i) ? combinations[i - index][j - individualPlay.get(i)] : 0;
				combinations[i - index][j] = withoutCurrentPlay + withCurrentPlay;
			}
			
			// 0 and 1 is filled.
			// make 0th row as first row.
			// index is 1
			combinations[i - index - 1] = combinations[i - index];
			index++;
		}
		return combinations[1][finalScore];// last box
	}
	
}
