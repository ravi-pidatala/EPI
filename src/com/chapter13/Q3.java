//package com.chapter13;
//
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//public class Q3 {
//	
//	int capacity = 3;
//	Map<String, Double> isbnMap = new LinkedHashMap<>(capacity, 0.75f, true); // prices are in the double
//	
//	Map<String, Double> database = new HashMap<>();
//
//	void populateDataBase() {
//		database.put("1", 1d);
//		database.put("2", 2d);
//		database.put("3", 3d);
//		database.put("4", 4d);
//		database.put("5", 5d);
//		database.put("6", 6d);
//		database.put("7", 7d);
//	}
// 	
//	
//	
// 	public static void main(String[] args) {
//		
//	}
//	
//	/*
//	 * implement ISBN Cache
//	 * isbn string length is 10. 
//	 * 9 digits. last character is sum of 9 % 11. with 10 represented as X.
//	 * 
//	 * lookup, insert and remove
//	 * 
//	 *  for insert, update the entry to la
//	 *  lookup should update the entry to mostRecently used. 
//	 *  
//	 *  LinkedHashMap for LRU cache
//	 */
//	
//	boolean lookup(String isbn) {
//		if (isbnMap.containsKey(key))
//	}
//	
//	
//
//}
