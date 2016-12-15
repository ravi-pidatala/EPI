package com.chapter16;

import java.util.ArrayList;
import java.util.List;

public class Q2 {

	public static void main(String[] args) {
		
	}
	
	/*
	 * Generate all the non attacking placements of n queens on n * n chessboard.
	 * no two queens are in same row, column or diagnol.
	 * Each row and column should have exactly one queen. 
	 */
	void solveNQueens(int n, int row, List<Integer> colPalcement, List<ArrayList<Integer>> result) {
		if (row == n) {
			result.add(new ArrayList<>(colPalcement));
			return;
		}
		
		for (int col = 0; col < n; col++) {
			colPalcement.add(col);
			if (isColPlacementValid(colPalcement)) {
				solveNQueens(n, row + 1, colPalcement, result);
			}
			colPalcement.remove(colPalcement.size() - 1);
		}
		
	}
	
	boolean isColPlacementValid(List<Integer> colPlacement) {
		// check if there is column conflict or diagnol conflict.
		int lastRowIndex = colPlacement.size() - 1;
		
		for (int i = 0; i < colPlacement.size() - 1; i++) {
			if (colPlacement.get(i) == colPlacement.get(lastRowIndex) || 
					Math.abs(colPlacement.get(lastRowIndex) - colPlacement.get(i)) == lastRowIndex - i) {
				return false;
			}
		}
		return true;
	}
	
}
