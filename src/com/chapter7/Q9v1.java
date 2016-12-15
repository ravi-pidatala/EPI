package com.chapter7;

import java.util.HashMap;
import java.util.Map;

public class Q9v1 {

	public static void main(String[] args) {
		Q9v1 q = new Q9v1();
		String s = "IVIX";
		Map<Character, Integer> romanMap = new HashMap<>();
		romanMap.put('I', 1);
		romanMap.put('V', 5);
		romanMap.put('X', 10);
		romanMap.put('L', 50);
		romanMap.put('C', 100);
		romanMap.put('D', 500);
		romanMap.put('M', 1000);
		
		if (q.checkValidity(s, romanMap)) {
			System.out.println( s + " is valid");
		} else {
			System.out.println( s + " is invalid");
		}
		
		
	}
	
	/*
	 * 1.if in non -increasing order, exception did not occur in current. continue;
	 * 2. if increased, check if it is valid exception. if not return false;
	 * 3. check if exception occured just before this. if yes return false. if no, set exception to true for immediate next consideration to check
	 * 
	 */
	boolean checkValidity(String s, Map<Character, Integer> romanMap) {
		// valid
		
		char prev = s.charAt(0);
		boolean exception = false;
		
		for (int i = 1; i < s.length(); i++) {
			char curr = s.charAt(i);
			
			if (romanMap.get(curr) <= romanMap.get(prev)) {
				exception = false;
				continue;
			}
			
			// increasing. check if current one is acceptable exception.
			if (!isException(prev, curr)) {
				return false;
			}
			
			// check if exception occured immediate previously 
			if (exception) {
				return false;
			} else {
				exception = true;
			}
		}
		
		return true;
		
	}
	
	
	boolean isException (char prev, char curr) {
		if (prev == 'I' && (curr == 'V' || curr == 'X') ||
			prev == 'X' && (curr == 'L' || curr == 'C') ||
			prev == 'C' && (curr == 'D' || curr == 'M')	) {
			return true;
		}
		return false;
	}
	

}
