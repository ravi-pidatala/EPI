package com.chapter6;

public class Q5 {

	public static void main(String[] args) {
		Q5 q = new Q5();
		int [] a = {1, 1, 1, 2, 2, 2, 3, 4, 5, 6, 7, 7, 100, 100, 101};
		q.deleteDup(a);
		for (int x: a) {
			System.out.print(x + ",");
		}
	}
	
	void deleteDup(int [] a) {
		if (a.length == 1 || a.length == 0) {
			return;
		}
		
		int r = 1, w = 0;
		
		while (r <= a.length - 1) {
			if (a[w] == a[r]) {
				r++;
			} else {
				a[++w] = a[r++];
			}
		}
		System.out.println("length of unduplicate array is " +  (w + 1));
	}

}
