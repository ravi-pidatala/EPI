package com.chapter19;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Paint boolean 
 */
public class Q2 {

	public static void main(String[] args) {
		
		
		
		
		
	}
	
	
	/*
	 * Take boolean matrix as input. 
	 * 0 is black and 1 is white. 
	 * Find all the regions associated with the point.
	 * Both work fine. Breadth first search and Depth first search.
	 * No need of visited feild here since we change the color as we find cell.
	 * Number of rows is a.length
	 * number of columns is a[0].length
	 */
	
	private void paintMatrixBfs(boolean [][] a, int row, int column) {
		boolean color = a[row][column];
		
		Queue<Cell> queue = new LinkedList<>();
		queue.add(new Cell(row, column));
		int [][] shift = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};// up, down , right, left ;
		
		while (!queue.isEmpty()) {
			Cell cell = queue.poll();
			a[cell.x][cell.y] = !color;
			
			// add the adjacent cells which are of same color into queue.
			for (int [] direction: shift) {
				if (isCellValid(a, row + direction[0], column + direction[1], color)) {
					queue.add(new Cell(row + direction[0], column + direction[1]));
				}
			}
		}
	}
	
	private void paintMatrixDfs(boolean [][] a, int row, int column, boolean color) {
		/*
		 * If the next row is of same color, change the color of 
		 * 
		 */
		int [][] shift = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};// up, down , right, left ;
		// flip the current color. So from next we will not come to current again avoiding infnite loop.
		a[row][column] = !color;
		
		for (int [] direction : shift) {
			if (isCellValid(a, row + direction[0], column + direction[1], color)) {
				paintMatrixDfs(a, row + direction[0], column + direction[1], color);
			}
		}
		
	}
	
	boolean isCellValid(boolean [][] a, int x, int y, boolean color) {
		if (x >= a.length || y >= a[0].length || x < 0 || y < 0 || a[x][y] != color) {
			return false;
		}
		return true;
	}
	
}

class Cell {
	
	Cell(int x, int y ) {
		this.x = x;
		this.y = y;
	}
	
	int x;
	int y;
	
	
	@Override
	public boolean equals(Object o) {
		if ( o == null || !(o instanceof Cell)) {
			return false;
		}
		Cell other = (Cell)o;
		
		if (other.x == x && other.y == y ) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Integer.hashCode(x) + Integer.hashCode(y);
	}
	
}
