package com.chapter6;

import java.util.HashSet;
import java.util.Set;

public class Q16 {

	public static void main(String[] args) {
		Q16 q = new Q16();
		
		int [][] a = new int [9][9];
		
		a[0] = new int [] {5, 3, 0, 0, 7, 0, 0, 0, 0};
		a[1] = new int [] {6, 0, 0, 1, 9, 5, 0, 0, 0};
		a[2] = new int [] {0, 9, 8, 0, 0, 0, 0, 6, 0};
		a[3] = new int [] {8, 0, 0, 0, 6, 0, 0, 0, 3};
		a[4] = new int [] {4, 0, 0, 8, 0, 3, 0, 0, 1};
		a[5] = new int [] {7, 0, 0, 0, 2, 0, 0, 0, 6};
		a[6] = new int [] {0, 6, 0, 0, 0, 0, 2, 8, 0};
		a[7] = new int [] {0, 0, 0, 4, 1, 9, 0, 0, 5};
		a[8] = new int [] {0, 0, 0, 0, 8, 0, 0, 7, 9};
		
		if (q.isSudokuValid(a)) {
			System.out.println("sudoku is valid");
		} else {
			System.out.println("sudoku is invalid");
		}
	}
	
	/*
	 * Sudoku checker. Check whether 9 * 9 2D array implementing partially completed sudoku is valid.
	 * Specifically check whether no row, column or 3*3 subarray contains duplicates.
 	 */
	boolean isSudokuValid(int [][] a) {
		return  isSudokuValidForRows(a) && isSudokuValidForColumns(a) && isSudokuValidForBlocks(a);
	}
	
	// space is o[n] for hashset.
	boolean isSudokuValidForRows(int [][] a) {
		Set<Integer> columnValueSet = null;
		
		for (int i = 0; i < a.length - 1; i++) {
			columnValueSet = new HashSet<>();
			for (int column = 0; column < a[i].length;column++) {
				// go through all the columns
				if (a[i][column] != 0 && !columnValueSet.add(a[i][column])) {
					return false;
				}
			}
		}
		return true;
	}
	
	boolean isSudokuValidForColumns(int [][] a) {
		Set<Integer> rowValueSet = null;
		
		for (int i = 0; i < a[0].length; i++) {
			rowValueSet = new HashSet<>();
			
			for (int row = 0; row < a.length; row++) {
				if (a[row][i] != 0 &&  !rowValueSet.add(a[row][i])) {
					return false;
				}
			}
		}
		return true;
	}

	boolean isSudokuValidForBlocks(int [][] a) {
		int blocks = (a.length / 3) ;
		
		for (int row = 0; row < blocks; row+=3) {
			Set<Integer> cacheSet = new HashSet<>();
			
			for (int col = 0; col < blocks; col+=3) {
				// go right and go down 3 times.
				
				for (int i = row; i < row + 3; i++) {
					for (int j = col; j < col + 3; j++) {
						if (a[i][j] != 0 && !cacheSet.add(a[i][j])) {
							return false;
						}
					}
				}
				
			}
		}
		return true;
	}
}
