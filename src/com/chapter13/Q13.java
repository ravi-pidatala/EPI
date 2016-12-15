package com.chapter13;

import java.util.HashSet;
import java.util.Set;

/*
 * Test collatz conjucture
 */
public class Q13 {

	public static void main(String[] args) {
		Q13 q = new Q13();
		int n = 1000_000_0;
		if (q.testConjucture(n)) {
			System.out.println("conjucture is tested for first " + n);
		}
	}
	
	/*
	 * from 1 to n . for all integers.
	 * 
	 * if n is even, collatz is same as collatz of n / 2.
	 * if n is odd, collatz of n is collatz of 3 n + 1
	 * 
	 * Every number stops at 1.
	 * 
	 * When will verification fail? In two cases. 
	 * overflow, sequence cycle.
	 * 
	 *  To check for overflow have a flag.
	 *  To check for sequence cycle , save the sequence in hashmap.
	 *  save k, which is the maximum number for which collatz is verified.
	 * 
	 */
	boolean testConjucture(int n) {
		long k = 2;
		boolean stopTest = false;
		
		for (int i = 3; i <= n; i += 2) {
			Set<Long> sequence = new HashSet<>();
			long testi = i;
			
			while (testi != 1) {
				if (testi <= k) {
					break;
				}
				if (!sequence.add(testi)) {
					// cycle found .collatz conjucture is dis proved.
					System.out.println("Collatz conjucture does not hold good for " + i);
					stopTest = true;
					break;
				}
				
				if (testi % 2 == 0) {
					testi = testi / 2;
				} else {
					
					long nextTesti = 3 * testi + 1;
					
					if (nextTesti <= testi) { // overflow
						System.out.println("overflow while checking for " + i);
						stopTest = true;
						break;
					}
					testi = nextTesti;
				}
			}
			if (!stopTest) {
				k = i;
			} else {
				System.out.println("stopping test at " + i);
				return false;
			}
			
		}
		return true;
	}

}
