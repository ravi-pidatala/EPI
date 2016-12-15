package com.chapter12;

public class Q6 {

	public static void main(String[] args) {
		
		
		
	}
	
	
	/*
	 * given a 2D sorted array, (rows and columns non decreasing)
	 * Check whether number appears in the array
	 * 
	 * start from right and top.
	 * if the element is greator than the grid element go down
	 * if the element is lesser than the grid element go left.
	 * Each comparison will exclude one row or column
	 * 
	 * 
	 * Time complexity : o[n] where number of rows is n and columns is n. number of elements is n square.
	 * 
	 * o[m + n] where m is rows and columns is n.
	 * 
	 */
	
	boolean matrixSearch(int [][] a, int x) {
		int row = 0;
		int column = a[0].length - 1;
		
		while (row <= a.length - 1  && column >= 0) {
			
			int gridData = a[row][column];
			if (x == gridData) {
				return true;
			}
			if (x > gridData) {
				// go down
				row++;
			} else {
				column--;
			}
			
		}
		
		return false;
		
		
		
	}
	
}
