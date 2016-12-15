package com.chapter6;

public class Q6v1 {

	public static void main(String[] args) {
		int [] a = {1, 1, 1, 2, 2, 2, 2, 3, 3, 3, -10, -10, -10, -10, -10, -10, 9, 9};
		
		Q6v1 q = new Q6v1();
		System.out.println(q.getSubArray(a));
	}
	
	int getSubArray(int [] a) {
		//vl
		
		int result = 1, max = 1, i = 1;
		int prev = a[0];
		
		
		while (i < a.length) {
			if (prev == a[i]) {
				result++;
			} else {
				max = Math.max(result, max);
				result = 1;
				prev = a[i];
			}
			i++;
		}
		return max;
	}

}
