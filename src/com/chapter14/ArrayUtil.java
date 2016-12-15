package com.chapter14;

public class ArrayUtil {

	static void swap (int [] a, int x, int y) {
		// TODO validation. 
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
}
