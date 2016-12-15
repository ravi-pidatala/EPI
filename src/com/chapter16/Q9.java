package com.chapter16;

import java.util.List;

public class Q9 {

	public static void main(String[] args) {
		
	}
	
	public boolean solveSudoku(List<List<Integer>> partialAssignment) {
		return solveSudoku(partialAssignment, 0, 0);
	}
	
	/*
	 * Implement a sudoku solver.
	 * Sudoku has 9 * 9
	 * Try all available values for a square. continue till , for a square there is no acceptable value. 
	 * If no square present like that , sudoku is solved.
	 */
	boolean solveSudoku(List<List<Integer>> partialAssignment, int i, int j) {
		
		/*
		 * construct a 3d array with all allowable values.
		 */
		if (++i == partialAssignment.size()) {
			return true;
		}
		if (++j == partialAssignment.get(i).size()) {
			j = 0;// reset the column count.
		}
		
		
		
		
	}
	
	
	boolean validToAddValue(List<List<Integer>> partialAssignment, int i, int j, int val) { // i is row, j is column
		
		// validate for the row .i.e. all columns
		for (int col = 0; col < partialAssignment.get(i).size(); col++) {
			if (partialAssignment.get(i).get(col) == val) {
				return false;
			}
 		}
		
		// validate for the columns .i.e. all the rows for a particular column 
		for (int row = 0; row < partialAssignment.size(); row++) {
			if (partialAssignment.get(row).get(j) == val) {
				return false;
			}
		}
		
		// check region constraints.
		int regionSize = (int) Math.sqrt(partialAssignment.size());
		
		int rowBlock = (i / regionSize);
		int colBlock = (j / regionSize);
		
		for (int a = 0; a < regionSize; a++) {
			for (int b = 0; b < regionSize; b++) {
				if (partialAssignment.get(a + regionSize * rowBlock).get(b + regionSize * colBlock) == val) {
					return false;
				}
			}
		}
		return true;
		
	}
	
	
	
	
	
}
