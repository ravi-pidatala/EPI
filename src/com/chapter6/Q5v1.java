package com.chapter6;

public class Q5v1 {
	
	public static void main(String[] args) {
		Q5v1 q = new Q5v1();
		
		int [] a = {-1, 10, 1, 10, 9, 8, 6, 9, 10};
		System.out.println(q.remove(a, 100));
		
	}
	
	int remove(int [] a, int x) {
		int r = 0, w = 0;
		
		while (r < a.length) {
			if (a[r] == x) {
				r++;
			} else {
				a[w++] = a[r++];
			}
		}
		return w;
	}
}
