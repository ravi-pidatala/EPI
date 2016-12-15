package com.chapter6;


public class Q6 {

	public static void main(String[] args) {
		int [] a = {310, 310, 275, 295, 260, 270, 290, 230, 255, 250};
		Q6 q = new Q6();
		
		System.out.println(q.geMaxProfit(a));
	}
	
	int geMaxProfit(int [] a) {
		// validate negatives not allowed
		if (a.length == 0 || a.length == 1) {
			return 0;
		}
		
		int buy = a[0];
		int maxProfit = 0;
		int temp = 0;
		
		for (int i = 1; i < a.length; i++) {
			temp = a[i] - buy;
			maxProfit = Math.max(temp, maxProfit);
			if (temp < 0) {
				// found a less buying price. buy today and check
				buy = a[i];
			}
		}
		return maxProfit;
	}

}
