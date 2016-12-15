package com.chapter16;

import java.util.ArrayList;
import java.util.List;

public class Q6 {

	public static void main(String[] args) {
		List<List<String>> matchedParenthesis = new ArrayList<>();
		List<String> tempMatched = new ArrayList<>();
		int n = 5;
		
		Q6 q = new Q6();
		q.generateMatchedParenthesis(0, 0, n, tempMatched, matchedParenthesis);
	
		for (List<String> temp: matchedParenthesis) {
			System.out.println("");
			
			for (String s: temp) {
				System.out.print(s);
			}
		}
	}
	
	/*
	 * Generate strings of matched parenthesis.
	 * 
	 * Empty string parenthesis are matched.
	 * 
	 * input is number. Return all the possible strings with x pairs of matched parenthesis.
	 *  Recursion.
	 *  
	 *  Suppose i have completed this for n - 1. Can i add one pair of parenthesis and check ==> seems tough.
	 *  
	 *  Start building the strings. As long as leftCount >= right count, left Parenthesis can be added, else only add right parenthesis.
	 *  
	 */
	// leftCount is number of times ( occurs in temp.Right count is number of times ) occurs.  
	void generateMatchedParenthesis(int leftCount, int rightCount, int n, List<String> tempMatched, List<List<String>> matchedParenthesis) {
		if (rightCount == n && leftCount == n) {
			matchedParenthesis.add(new ArrayList<>(tempMatched));
			return;
		}
		
		// check if left parenthesis can be added.
		if (leftCount < n) {
			tempMatched.add("(");
			generateMatchedParenthesis(leftCount + 1, rightCount, n, tempMatched, matchedParenthesis);
			tempMatched.remove(tempMatched.size() - 1);
		}
		
		// can add right
		if (rightCount < leftCount) {
			tempMatched.add(")");
			generateMatchedParenthesis(leftCount, rightCount + 1, n, tempMatched, matchedParenthesis);
			tempMatched.remove(tempMatched.size() - 1);
		}
		
	}
	

}
