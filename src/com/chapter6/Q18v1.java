package com.chapter6;

public class Q18v1 {

	public static void main(String[] args) {
		

		Q18v1 q = new Q18v1();
		int [][] a = new int [4][4];
		a[0] = new int [] {1, 2, 3, 4};
		a[1] = new int [] {5, 6, 7, 8};
		a[2] = new int [] {9, 10, 11, 12};
		a[3] = new int [] {13, 14, 15, 16};
		
		q.reflectDiagnol(a);

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + ",");
			}
			System.out.println();
		}
	}

	void reflectDiagnol(int [][] a) {
		// validate for square matrix.

		for (int i = 1; i < a.length; i++) {
			for(int j = 0; j < i; j++) {
				swap(a, i , j);
			}
		}
	}

	void swap(int [][] a, int i, int j) {
		int temp = a[i][j];
		a[i][j] = a[j][i];
		a[j][i] = temp;
	}
	

}
