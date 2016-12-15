package com.chapter6;

public class Q5v2 {

	public static void main(String[] args) {
		Q5v2 q = new Q5v2();
		
		int [] a = {1, 1, 1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4};
		
		int length = q.process(a, 3);
		
		// 1, 1, 2, 2, 3, 3, 3, 3, 4, 4
		for (int i = 0; i < length; i++) {
			System.out.print(a[i] + ",");
		}
	}
	
	
	int process(int [] a, int m) {
		int r = 1, w = 0, rep = 1;
		
		while (r < a.length) {
			if (a[r] == a[r - 1]) {
				rep++;
			} else {
				for (int i = 0; i < (rep == m ? 2 : rep); i++) {
					a[w++] = a[r - 1];
				}
				rep = 1;
			}
			r++;
		}
		
		for (int i = 0; i < (rep == m ? 2 : rep) ; i++) {
			a[w++] = a[r - 1];
		}
		return w;
	}

}
