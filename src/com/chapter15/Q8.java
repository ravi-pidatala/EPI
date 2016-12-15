package com.chapter15;

public class Q8 {

	public static void main(String[] args) {
		
	}
	
	/*
	 * Given a server log file containing billions of lines. Each line contains number of feilds.
	 * id denoting page that was accessed.
	 * find the k most visited pages, 
	 * 
	 * Save entried into min heap.size should be k, the root is kth kth largest. 
	 * 
	 * n log k. time and o[m + k] space for hashmap and binary heap for reading an entry
	 * log k time to add entry.
	 * o[1] time to find the kth largest one. from min heap.
	 * 
	 * if it is random, o[1] time to read, 
	 *  o[m] time and o[m] space for hashmap each time the get kth is called.
	 *  
	 * 
	 * function to read log file line
	 * function to find k most visited pages.
	 * 
	 * Set of distinct pages is small enough to fit in RAM.
	 * 
	 * Use a min heap to record k most visited pages.  Implement comparable with the page count.
	 * n log k time.
	 * 
	 * When functions are interleaved, instead of having n log k again, 
	 * Add 1 to the count which occured. if the added one count is grator than the min one from heap, remove the minimum one from heap and add the one into heap 
	 * at the leaf and trickle up o[log n] time.
	 * 
	 * We have hashmap of id of page and count as value.
	 * 
	 */
	
	
	
}
