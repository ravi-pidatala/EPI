package com.chapter6;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q9 {

	public static void main(String[] args) {
		List<Integer> perm = Arrays.asList(3, 2, 1, 0);
		List<Character> a = Arrays.asList('a', 'b', 'c', 'd');
		
		applyPerm(perm, a);
		
		for (Character x: a) {
			System.out.print(x + ",");
		}
	}

	static void applyPerm(List<Integer> perm, List<Character> a) {
		
		for (int i = 0; i< a.size(); i++) {
			int next = i;
			
			while (perm.get(next) >= 0) {
				Collections.swap(a, i, perm.get(next));
				int temp = perm.get(next);
				perm.set(next, perm.get(next) - perm.size());
				next = temp;
			}
		}
	}
		
}
