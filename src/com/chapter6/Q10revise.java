package com.chapter6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q10revise {

	public static void main(String[] args) {
		
		
		
		
		
	}
	
	/*
	 * Go through the list from back.
	 * Find an index k , where a[k] where a[k] < a[k + 1].
	 * 
	 * From last, go left till k + 1 searching for number greator than a[k]. suppose its index is l
	 * swap k and l . 
	 * Reverse the numbers from indices k + 1 to l.
	 * return .
	 * 
	 * 
	 */
	public boolean nextPermutation(List<Integer> a) {
		
		if (a == null || a.size() <= 1) {
			return false;
		}
		int k = -1;
		
		for (int i = a.size() - 2; i >= 0; i--) {
			if (a.get(i) < a.get(i + 1)) {
				k = i;
				break;
			}
		}
		
		if (k == -1) {
			return false;
		}
		// for end till k + 1, search for value greator than a[k]. Swap k and the index
		
		for (int i = a.size() - 1; i >= k + 1; i--) {
			if (a.get(k) < a.get(i)) {
				Collections.swap(a, k, i);
				break;
			}
		}
		
		// reverse the list from k + 1 till end
		int left = k + 1;
		int right = a.size() - 1;
		
		while(left < right) {
			Collections.swap(a, left++, right--);
		}
		return true;
		
	}

}
