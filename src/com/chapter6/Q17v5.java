package com.chapter6;

public class Q17v5 {

	public static void main(String[] args) {
		Q17v5 q = new Q17v5();
		
		// 4 * 4 array. last is 10
		int [][] a = new int [4][4];
		a[0] = new int [] {1, 2, 3, 4};
		a[1] = new int [] {5, 6, 7, 8};
		a[2] = new int [] {9, 10, 11, 12};
		a[3] = new int [] {13, 14, 15, 16};
		
		System.out.println(q.getLastSpiral(a));
		
		// // 4 *  6 
		int [][] b = new int [4][6];
		b[0] = new int [] {1, 2, 3, 4, 5, 6};
		b[1] = new int [] {7, 8, 9, 10, 11, 12};
		b[2] = new int [] {13, 14, 15, 16, 17, 18};
		b[3] = new int [] {19, 20, 21, 22, 23, 24};
		
		System.out.println(q.getLastSpiral(b));
		
		// // 7 *  9 
		int [][] c = new int [4][9];
		c[0] = new int [] {1, 2, 3, 4, 5, 6, 7, 8, 9};
		c[1] = new int [] {10, 11, 12, 13, 14, 15, 16, 17, 18};
		c[2] = new int [] {19, 20, 21, 22, 23, 24, 25, 26, 27};
		c[3] = new int [] {28, 29, 30, 31, 32, 33, 34, 35, 36};
		
		System.out.println(q.getLastSpiral(c));
		
		
	}

	// compute last element in spiral order of m * n array.
	public int getLastSpiral(int [][] a) {
		// validation

		int rows = a.length;
		int columns = a[0].length;
		int x = Math.min(rows, columns);

		if ((x & 1) == 1) {
			x = x / 2;
		}  else {
			x = x / 2 - 1;
		}

		rows = rows - 2 * x;
		columns = columns - 2 * x;

		if (rows == 1) {
			return a[x][x + columns - 1];
		} else if (columns == 1) {
			return (a[x + rows - 1][x]);
		} else if (rows == 2) {
			return a[x + 1][x];
		} else if (columns == 2) {
			return a[x + rows - 1][x];
		}
		return -1;
	}


}
