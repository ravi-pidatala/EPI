package com.chapter16;

public class GCD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GCD q = new GCD();
		System.out.println(q.getGCD(366, 60));
		System.out.println(q.getGCD(60, 366));
		
		System.out.println(q.iterativeGcd(366, 60));
		System.out.println(q.iterativeGcd(60, 366));
	}

	long getGCD(long x, long y) {
		if (y == 0) {
			return x;
		}
		return getGCD(y, x % y);
	}
	
	/*
	 * to reduce the space, recursive implementation can be made to iterative implementation.
	 */
	long iterativeGcd(long x, long y) {
		long temp = 0;
		while (y != 0) {
			temp = y;
			y = x % y;
			x = temp;
		}
		return x;
	}
}
