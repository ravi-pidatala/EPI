package com.chapter7;

import java.util.HashMap;
import java.util.Map;

public class Q9v2 {

	public static void main(String[] args) {
		Q9v2 q = new Q9v2();
		System.out.println(q.getValidString(59));
	}

	public String getValidString(int n) {
		if (n <= 0) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		Map<Integer, String> romanMap = getRomanMap();
		if (n >= 1000) {
			append(sb, n / 1000, 'M');
			n = n % 1000;
		}
		if (n >= 500) {
			if (fetchFromMap(sb, n, romanMap)) {
				return sb.toString();
			}
			append(sb, n / 500, 'D');
			n = n % 500;
		}		
		if (n >= 100) {
			if (fetchFromMap(sb, n, romanMap)) {
				return sb.toString();
			}
			append(sb, n / 100, 'C');
			n = n % 100;
		}
		
		if (n >= 50) {
			if (fetchFromMap(sb, n, romanMap)) {
				return sb.toString();
			}
			append(sb, n / 50, 'L');
			n = n % 50;
		}
		if (n >= 10) {
			if (fetchFromMap(sb, n, romanMap)) {
				return sb.toString();
			}
			append(sb, n / 10, 'X');
			n = n % 10;
		}
		if (n >= 5) {
			if (fetchFromMap(sb, n, romanMap)) {
				return sb.toString();
			}
			append(sb, n / 5, 'V');
			n = n % 5;
		}

		if (n >= 1) {
			if (fetchFromMap(sb, n, romanMap)) {
				return sb.toString();
			}
			append(sb, n / 1, 'I');
		}

		return sb.toString();
	}
	
	private Boolean fetchFromMap(StringBuilder sb, int n, Map<Integer, String> romanMap) {
		if (romanMap.containsKey(n)) {
			sb.append(romanMap.get(n));
			return true;
		}
		return false;
	}
	
	private Map<Integer, String> getRomanMap() {
		Map<Integer, String> romanMap = new HashMap<>();
		
		romanMap.put(4, "IV");
		romanMap.put(9, "IX");
		romanMap.put(49, "IL");
		romanMap.put(99, "IC");
		romanMap.put(499, "ID");
		romanMap.put(999, "IM");
		romanMap.put(45, "VL");
		romanMap.put(95, "VC");
		romanMap.put(495, "VD");
		romanMap.put(995, "VM");
		romanMap.put(40, "XL");
		romanMap.put(90, "XC");
				
		romanMap.put(490, "XD");
		romanMap.put(990, "XM");
		romanMap.put(450, "LD");
		romanMap.put(950, "LM");
			
		romanMap.put(400, "CD");
		romanMap.put(900, "CM");
		
		return romanMap;
	}
	
	private void append(StringBuilder sb, int x, char c) {
		for (int i = 0; i < x; i++) {
			sb.append(c);
		}
	}

}
