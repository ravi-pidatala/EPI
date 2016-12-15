package com.chapter19;

import java.util.Iterator;
import java.util.Set;

public class Q3 {

	public static void main(String[] args) {
		
		
		
	}
	
	/*
	 * a is 2D array whose Entries are either W or B
	 * Input is a.
	 * Replace all W which can not reach boundary with B
	 * W- true
	 * B - false
	 * 
	 * 			boundary W - no need to consider.
	 * 			if all boundary elements are B, make all the rest elements also as B.
	 * 			if none of the adjacent elements is W, make it as B.
	 * 
	 * 
	 * 			B B B B
	 * 			W B W B
	 * 			B W W B
	 * 			B B B B
	 * 
	 * 			Use Depth first search . if all the ways gives as false, convert current element and proceed.
	 * 
	 * 
	 * 			Find W's that can reach boundary.
	 */
	

//	boolean isBoundaryW(boolean [][] a, int row, int column) {
//		if ( (row == a.length - 1 || row == 0) && (column == 0 || column == a[0].length - 1) && a[row][column]) {
//			return true;
//		}
//		return false;
//	}
	
	boolean isValidW(boolean [][] a, int row, int column) {
		if (row > 0 && row < a.length - 1 && column > 0 && column < a[0].length - 1 && a[row][column] == true) {
			return true;
		}
		return false;
	}
	
	/*
	 * Find all the W's that are in the boundary add them to set. 
	 * Go on adding all the W's that are reachable from this set. Each time a W is found that is not in boundary, add it to the set. 
	 * BFS does a good job for it. Use iterator to iterate through the sets.
	 */
	void process(boolean [][] a, Set<Cell> validW) {
		
		Iterator<Cell> iter = validW.iterator();
		 int [][] shift = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};// up, down, right, left
		
		while (iter.hasNext()) {
			Cell cell = iter.next();
			
			// check all the adjacent ones
			for (int [] direction: shift) {
				Cell adj = new Cell(cell.x + direction[0], cell.y + direction[1]);
				
				if (isValidW(a, adj.x, adj.y)) { // x is row and y is column
					// found a W that is not  boundary. Add it to the set
					validW.add(adj);
				}
			}
		}
		
		// now except the validW, all should be B
		for (int row = 0; row < a.length; row++) {
			for (int column = 0; column < a[0].length; column++) {
				Cell cell = new Cell(row, column);
				
				if (!validW.contains(cell)) {
					a[row][column] = false;
				}
			}
		}
	}
}
