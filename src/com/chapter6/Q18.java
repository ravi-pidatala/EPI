package com.chapter6;

public class Q18 {

	public static void main(String[] args) {
		
		Q18 q = new Q18();
		int [][] a = new int [4][4];
		a[0] = new int [] {1, 2, 3, 4};
		a[1] = new int [] {5, 6, 7, 8};
		a[2] = new int [] {9, 10, 11, 12};
		a[3] = new int [] {13, 14, 15, 16};
		
		q.rotate(a);
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + ",");
			}
			System.out.println();
		}
		




	}

	public void rotate(int [][] a) {
		//val

		int n = a.length;
		for (int layer = 0; layer < n / 2; layer++) {
			int length = n - 2 * layer;

			for (int i = 0; i < length - 1; i++) {

				// save left
				int temp = a[n - 1 - layer - i][layer];

				// left from bottom
				a[n - 1 - layer - i][layer] = a[n - 1 - layer][n - 1 - layer - i];

				// bottom from right
				a[n - 1 - layer][n - 1 - layer - i] = a[layer + i][n - 1 - layer];

				// right from top
				a[layer + i] [n - 1 - layer] = a[layer][layer + i];

				// top from left
				a[layer][layer + i] = temp;
			}
		}
	}

}
