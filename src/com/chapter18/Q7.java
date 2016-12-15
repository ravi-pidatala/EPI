package com.chapter18;

import java.util.List;

public class Q7 {

	public static void main(String[] args) {
		
		
		
		
		
	}
	
	/*
	 * An array of integers is input. 
	 * Return pair of entries that trap maximum amount of water.
	 * 
	 * Use invariant analysis.
	 * 
	 */
	public Pair getMaximumWaterPair(List<Integer> a) {
		int left = 0;
		int right = a.size() - 1;
		int maxWater = Math.abs(a.get(left) - a.get(right)) * (right - left + 1);
		int currentLeft = 0;
		int currentRight = a.size() - 1;
		
		while (currentLeft < currentRight) {
			int currentMax = Math.abs(a.get(currentLeft) - a.get(currentRight)) * (currentRight - currentLeft + 1);
			
			if (currentMax > maxWater) {
				left = currentLeft;
				right = currentRight;
				maxWater = currentMax;
			}
			
			if (a.get(currentLeft) < a.get(currentRight)) {
				currentLeft++;
			} else if (a.get(currentLeft) > a.get(currentRight)) {
				currentRight--;
			} else {
				currentLeft++;
				currentRight--;
			}
		}
		
		return new Pair(left, right);
	}
}

class Pair {
	int left;
	int right;
	
	Pair(int left, int right) {
		this.left = left;
		this.right = right;
	}
	
}
