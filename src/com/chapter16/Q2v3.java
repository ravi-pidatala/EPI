package com.chapter16;

import java.util.ArrayList;
import java.util.List;

/*
 * compute placement of 32 knoghts on 8*8 chessboard.
 */
public class Q2v3 {
	public static void main(String[] args) {
		
		
		
		
		
		
		
		
		
		
	}
	
	/*
	 *Compute placement of 32 knights on 8*8 chessboard .
	 *
	 */
	void computePlacement(boolean [][] restriced, List<ChessSquare> current, int knightCount, List<List<ChessSquare>> result, int row, int column)  {
		// base case
		if (knightCount == 32) {
			result.add(new ArrayList<>(current));
			return;
		}
		
		// place knight into current if no conflict.
		while (row <= 8 && column <= 8) {
			if (row )
		}
	}
}

class ChessSquare {
	int row;
	int column;
	
	ChessSquare(int row, int column) {
		this.row = row;
		this.column = column;
	}
}
