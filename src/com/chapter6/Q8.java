package com.chapter6;

public class Q8 {

	public static void main(String[] args) {
		Q8 q = new Q8();
		q.printPrimes(18);
	}
	
	void printPrimes(int n) {
		boolean [] composite = new boolean[n + 1]; // 0  to n composite array
		
		for (int i = 2; i < composite.length; i++) {
			if (!composite[i]) {
				for (int j = i + i; j < composite.length; j += i) {
					composite[j] = true;
				}
			}
		}
		
		for(int i = 2; i < composite.length; i++) {
			if (!composite[i]) {
				System.out.print(i + ",");
			}
			
		}
		
	}

}
