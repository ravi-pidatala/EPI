package com.chapter17;

import java.util.HashMap;
import java.util.Map;

public class Fibonocci {

	private Map<Integer, Integer> fibMap = new HashMap<>();
	
	public static void main(String[] args) {
		
	}

	
	int fibonocci (int n) {
		if (n <= 0) {
			return 0;
		}
		if (n == 1) {
			return n;
		}
		if (!fibMap.containsKey(n)) {
			fibMap.put(n, fibonocci(n - 1) + fibonocci(n - 2));
		}
		
		return fibMap.get(n);
	}
}
