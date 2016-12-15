package com.chapter17;

import java.util.Arrays;
import java.util.List;

public class SubArraySum {

	public static void main(String[] args) {
		List<Integer> a  = Arrays.asList(new Integer [] {10, -9, 1, 23, 30});
		SubArraySum q = new  SubArraySum();
		System.out.println(q.findMaximumSubArray(a));
		System.out.println(q.getMaxSubArraySum(a));
	}
	
	/*
	 * Find the maximum sum over all sub arrays of a given array of integer.
	 * 
	 * there are n * (n + 1) / 2 subarrays. o[n] for each sum, so o[n 3] time
	 * by using o[n] space, o[n 2 ] time.
	 * 
	 */
	
	int findMaximumSubArray(List<Integer> a) {
		int minSum = 0, sum = 0, maxSum = 0;
		
		for (int i = 0; i < a.size(); i++) {
			sum += a.get(i);
			if (sum < minSum) {
				minSum = sum;
			}
			if (sum - minSum > maxSum) {
				maxSum = sum - minSum;
			}
		}
		return maxSum;
	}
	
	int getMaxSubArraySum(List<Integer> a) {
		int maxSum = 0;
		int maxEndingSum = 0;
		
		for (int i = 0; i < a.size(); i++) {
			maxEndingSum = maxEndingSum + a.get(i);
			
			if (maxEndingSum < 0) {
				maxEndingSum = 0;
			}
			maxSum = Math.max(maxEndingSum, maxSum);
		}
		return maxSum;
	}
	
	
}
