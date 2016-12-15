package com.chapter6;

public class Q19 {

	public static void main(String[] args) {
		

		Q19 q = new Q19();
		int [][] pascalRows = q.getPascalRows(10);
		int rows = 1;
		for (int i = 0; i < pascalRows.length; i++) {
			for (int j = 0; j < rows; j++) {
				System.out.print(pascalRows[i][j] + ",");
			}
			System.out.println();
			rows++;
		}
	}

	public int [][] getPascalRows(int n) {
		int [][] a = new int [n][n];

		a[0][0] = 1;
		a[1][0] = 1;
		a[1][1] = 1;

		for (int i = 2; i < n; i++) {
			for(int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					a[i][j] = 1;
					continue;
				}
				a[i][j] = a[i - 1][j] + a[i - 1][j - 1];
			}
		}
		return a;
	}
	
	
	
	

}
