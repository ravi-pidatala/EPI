package com.chapter16;

public class Q1 {

	public static void main(String[] args) {
		Q1 q = new Q1();
		q.computeTowersOfHanoi(5, 'a', 'c', 'b');
	}
	
	void computeTowersOfHanoi(int n, char start, char middle, char end) {
		// base case.
		if (n == 0) {
			return;
		}
		computeTowersOfHanoi(n - 1, start, end, middle);
		System.out.println("transferring " + n + " from start to end");
		computeTowersOfHanoi(n - 1, middle, start, end);
	}

}
