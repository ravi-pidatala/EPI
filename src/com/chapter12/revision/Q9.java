//package com.chapter12.revision;
//
//import java.util.BitSet;
//import java.util.Iterator;
//
//public class Q9 {
//	
//	private final int bucket = 1 << 16;
//
//	public static void main(String[] args) {
//		
//	}
//	
//	/*
//	 * file contain 1 billion ip address.
//	 * each is 32 bit
//	 * find ip address that is not in file
//	 * 
//	 * sort the ip address. go through the file and get it. o[n log n] + o[n] complexity
//	 * 
//	 * 
//	 * initialize 2 ^ 32 integers.
//	 * 
//	 * add to hashtable and start iterating from first. 
//	 * 
//	 * initialize boolean array of size 4 billion. Which ever ip address is present, mark its index as true.
//	 * Iterate through the array and get the first false index. space => 0.5 GB.
//	 * 
//	 * 
//	 * 2 Power 16
//	 * Have bitSet Vector of 2 bytes.
//	 * have int array. increase thecounter of 16 bits.
//	 * 
//	 * Take an integer whose count < 2 power 16.
//	 * 
//	 * go though the sequence. 
//	 * Build bitSetArray whose first 16 bits are the ones found.boolean array.
//	 * Go from 1 to 2 power 16. check if the bitVector is present.  
//	 * 
//	 * 
//	 * find the one that is not present.  
//	 * 
//	 */
//	
//	public int getIpAddress(Iterator<Integer> sequence) {
//		BitSet bitArray = new BitSet(bucket);
//		int [] array = new int[bucket];
//		
//		while (sequence.hasNext()) {
//			Integer x = sequence.next();
//			
//			array[x]++;
//		}
//		
//		for (int x: array) {
//			if (array[x] < bucket) {
//				// consider this 16 bits
//				
//			}
//		}
//		
//		
//	}
//	
//	
//}
