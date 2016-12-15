package com.chapter6;

import java.util.ArrayList;
import java.util.List;

public class Q17 {

	public static void main(String[] args) {
		int [][] a = new int [4][4];
		a[0] = new int [] {1, 2, 3, 4};
		a[1] = new int [] {5, 6, 7, 8};
		a[2] = new int [] {9, 10, 11, 12};
		a[3] = new int [] {13, 14, 15, 16};
		
		int [][] b = new int [5][3];
		b[0] = new int [] {1, 2, 3};
		b[1] = new int [] {4, 5, 6};
		b[2] = new int [] {7, 8, 9};
		b[3] = new int [] {10, 11, 12};
		b[4] = new int [] {13, 14, 15};
		Q17 q = new Q17();
		List<Integer> spiral = q.getSpiralOrder(a);

		for (int x: spiral) { //1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10
			System.out.print(x + ",");
		}
		System.out.println();
		spiral = q.getSpiral(a);
		
		for (int x : spiral) {
			System.out.print(x + ",");
		}
		System.out.println();
		
		spiral = q.getSpiral(b);
		
		for (int x : spiral) {
			System.out.print(x + ",");
		}
		

	}

	/*
		print spiral ordering of the two D square array.
		process layer by layer
		right, down, left, up
	*/
	public List<Integer> getSpiralOrder(int [][] a) {
		// validations
		List<Integer> result = new ArrayList<>();
		int n = a.length;

		for (int layer = 0; layer < Math.ceil(n / 2); layer++) {

			if (layer == n - layer - 1) {
				// n is odd. only 1 element in this layer.
				result.add(a[layer][layer]);
				return result;
			}

			// go right
			for (int i = layer; i < n - layer - 1; i++) {
				result.add(a[layer][i]);
			}

			//down
			for (int i = layer; i < n - layer - 1; i++) {
				result.add(a[i][n - layer - 1]);
			}

			// left
			for (int i = n - layer - 1; i > layer; i--) {
				result.add(a[n - layer - 1][i]);
			}

			//UP
			for (int i = n - layer - 1; i > layer; i--) {
				result.add(a[i][layer]);
			}

		}

		return result;
	}
	
	public List<Integer> getSpiral(int [][] a) {
		List<Integer> spiral = new ArrayList<>();
		final int [][] shift = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		
		int dir = 0, x = 0, y = 0, nextx = 0, nexty = 0;
		
		while (a[x][y] != 0) {
			spiral.add(a[x][y]);
			a[x][y] = 0;
			nextx = x + shift[dir][0];
			nexty = y + shift[dir][1];

			if (nextx < 0 || nexty < 0 || nextx >= a.length || nexty >= a[0].length || a[nextx][nexty] == 0) {
				dir = (dir + 1) % 4;
				nextx = x + shift[dir][0];
				nexty = y + shift[dir][1];

			}
			x = nextx;
			y = nexty;
		}
		return spiral;
	}
	
	
}
