package com.chapter6;

public class Q17v1 {

	public static void main(String[] args) {
		Q17v1 q = new Q17v1();

		int [][] a = q.getArray(4);

		for (int i = 0; i < a.length; i++) {

			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + ",");
			}
			System.out.println();
		}
		
		int [][] b = q.getArray(new int [] {1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10});
		
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				System.out.print(b[i][j] + ",");
			}
			System.out.println();
		}
	}
	
	int [][] getArray(int d) {
		final int [][] shift = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		int [][] a = new int [d][d];
		int x = 0, y = 0, nextx = 0, nexty = 0, dir = 0;
		
		for (int i = 1; i <= d * d; i++) {
			a[x][y] = i;
			
			nextx = x + shift[dir][0];
			nexty = y + shift[dir][1];
			
			if (nextx < 0 || nexty < 0 || nextx >= d || nexty >= d || a[nextx][nexty] != 0) {
				dir = (dir + 1) % 4;
				nextx = x + shift[dir][0];
				nexty = y + shift[dir][1];
			}
			x = nextx;
			y = nexty;
		}
		return a;
	}
	
	
	/*
	 * given a sequence of integers P , Compute 2D array whose spiral order is P. Assume length of p is n square
	 */
	public int [][] getArray(int [] p) {
		//validations

		final int [][] shift = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		int d = (int)Math.sqrt(p.length);
		
		int [][] a = new int [d][d];
		int x = 0, y = 0, nextx = 0, nexty = 0, dir = 0;

		for (int i = 0; i < p.length; i++) {
			a[x][y] = p[i];
			nextx = x + shift[dir][0];
			nexty = y + shift[dir][1];

			if (nextx < 0 || nexty < 0 || nextx >= d || nexty >= d || a[nextx][nexty] != 0) {
				dir = (dir + 1) % 4;
				nextx = x + shift[dir][0];
				nexty = y + shift[dir][1];
			}
			x = nextx;
			y = nexty;

		}

		return a;


	}


}
