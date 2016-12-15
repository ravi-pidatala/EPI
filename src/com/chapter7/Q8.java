package com.chapter7;

public class Q8 {

	public static void main(String[] args) {
		String s = "1";
		int n = 8;
		Q8 q = new Q8();
		System.out.println(q.getResult(s, 1, n));
		System.out.println(q.getResult(s, n));
		
//		StringBuilder x = new StringBuilder("5");
//		StringBuilder y = x;
//		x = new StringBuilder("6");
//		
//		System.out.println(y);
	}
	
	
	/*
	 * time complexity
	 * n. 2 ^ n
	 */
	private String getResult(String s, int n) {
		
		int i = 1;
		StringBuilder result = new StringBuilder();
		while (i < n) {
			int start = 0, end = 0;
			result = new StringBuilder("");
			while (start < s.length()) {
				while (end< s.length() && s.charAt(start) == s.charAt(end)) {
					end++;
				}
				result.append("" + (end - start));
				result.append(s.charAt(start));
				start = end;
			}
			i++;
			//s = result.toString() + "";
			s = result.toString();
		}
		return result.toString();
	}
	
	private String getResutIt(String s, int n) {
		
		int i = 1;
		String result = new String();
		while (i < n) {
			int start = 0, end = 0;
			result = "";
			while (start < s.length()) {
				while (end< s.length() && s.charAt(start) == s.charAt(end)) {
					end++;
				}
				result = result + (end - start) + s.charAt(start); 
				start = end;
			}
			i++;
			//s = result.toString() + "";
			s = result;
		}
		return result;
	}
	
	//Recursion
	private String getResult(String s, int x, int n) {
		//base case
		if (x == n) {
			return s;
		}
		
		String result = new String();
		int start = 0, end = 0;
		
		while (start < s.length()) {
			while (end < s.length() && s.charAt(start) == s.charAt(end)) {
				end++;
			}
			result = result + (end - start) + s.charAt(start);
			start = end;
		}
		s = null;
		return getResult(result, x + 1, n);
	}

}
