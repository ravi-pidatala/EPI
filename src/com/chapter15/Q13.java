package com.chapter15;

public class Q13 {

	public static void main(String[] args) {
		
	}
	
	/*
	 * 1. Each client is identified by name and it has a credit which is non negative integer.
	 * 2. HashMap <String, Integer> ... since i will be able to replace existing ones.
	 * 3. Delete => o[1] .
	 * 4. return number of credits associated => o[1]
	 * 5. Add to all => o[n]
	 * 6. Max => o[n]
	 * 
	 * Step 5 can be done in o[1] time.
	 * For add to All, have a global variable. Just add  to it. While returning add the globale variable to the 
	 * value retrieved from map => o[1]. for adding new clients, subtract the client count from the globale variable count and put it into hashmap.
	 * 
	 * With o[n] extra space and o[log n] time for insertion and deletion, I can return max in o[log n] time using binary search tree. I can use cache 
	 * to return max in o[1] time. 
	 * 
	 * Use BST and hashmap for this implementation.
	 */
	

}
