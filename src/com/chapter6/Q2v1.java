package com.chapter6;

public class Q2v1 {

	public static void main(String[] args) {
		Q2v1 q = new Q2v1();
		String s = "101111";
		String t = "001011";
		
		System.out.println(q.add(s, t));//    111010
	}
	
	//s and t are binary strings.
	String add(String s, String t) {
		// validate
		
		int i = s.length() - 1, j = t.length() - 1, c = 0;
		StringBuilder r = new StringBuilder();
		
		while ( i >= 0 && j >= 0) {
			int sum = s.charAt(i) - '0' + t.charAt(j) - '0' + c;
			
			if (sum == 0 || sum == 2) {
				r.append("0");
			} else if (sum == 1 || sum == 3) {
				r.append("1");
			}
			
			if (sum == 3 || sum == 2) {
				c = 1;
			} else {
				c = 0;
			}
			i--;
			j--;
		}
		
		while (i >= 0) {
			int sum = s.charAt(i) - '0' + c;
			
			if ( sum == 0) {
				r.append("0");
			} else if (sum == 1) {
				c = 0;
				r.append("1");
			} else if (sum == 2) {
				r.append("0");
				c = 1;
			}
			i --;
 		}
		
		while (j >= 0) {
			int sum = t.charAt(j) - '0' + c;
			
			if ( sum == 0) {
				r.append("0");
			} else if (sum == 1) {
				c = 0;
				r.append("1");
			} else if (sum == 2) {
				r.append("0");
				c = 1;
			}
			j--;
 		}
		r.append("" + c);
		
		return r.reverse().toString();
	}
	


}
