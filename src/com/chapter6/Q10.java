package com.chapter6;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q10 {

	public static void main(String[] args) {
		Q10 q = new Q10();
		
		List<Integer> perm = Arrays.asList(1, 0, 3, 2, 1);
		q.populateNextPermutation(perm);

		for(Integer x: perm) {
			System.out.print(x + ",");// 1, 1, 0, 2, 3
		}
		
		perm = Arrays.asList(1, 1, 1, 1, 1);
		q.populateNextPermutation(perm);
	}
	
	/* k and l are indices.
	 * 1. start from last. ind k such that p [k] < p[k + 1]
	 * 2. start from last. find l such that p[l] > [k]. there must  exist l because at the worst , p[k + 1] > p[k].
	 * 3. swap k and l
	 * 4. Reverse the array after k till end.
	 */
	void populateNextPermutation(List<Integer> perm) {
		int k = -1;
		int l = -1;
		
		for (int i = perm.size() - 2; i >= 0; i--) {
			if (perm.get(i) < perm.get(i + 1)) {
				k = i;
				for (int j = perm.size() - 1; j > k; j--) {
					if (perm.get(j) > perm.get(k)) {
						l = j;
						break;
					}
				}
				break;
			}
		}
		
		if (k == -1) {
			System.out.println("Next permutation is not present");
			return;
		}
		
		Collections.swap(perm, k, l);
		int left = k + 1;
		int right = perm.size() - 1;
		
		// reverse the list from k + 1 till end
		while (left < right) {
			Collections.swap(perm, left++, right--);
		}
	}
}
