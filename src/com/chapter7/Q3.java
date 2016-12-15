package com.chapter7;
/*
 * corresponding to 0 and 1.
 */
public class Q3 {

	public static void main(String [] args) {
		Q3 q = new Q3();
		System.out.println(q.getEncoding("ZA"));
	}
	
	long getEncoding(String s) {
		// val
		long result = 0;
		for (int i = 0; i < s.length(); i++) {
			result = result * 26 + s.charAt(i) - 'A';
		}
		return result;
	}
}
