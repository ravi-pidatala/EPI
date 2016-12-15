package com.chapter6;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Q11 {

	public static void main(String[] args) {
		Q11 q = new Q11();
		List<Integer> a = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		q.generateRandomSubset(a, 2);
		
		a.stream().forEach(x -> System.out.println(x));
		
	}
	
	public void generateRandomSubset(List<Integer> a, int k) {
		if (a == null || a.size() < k) {
			System.out.println("invalid input");
			return;
		}
		
		int start = 0;
		
		while (start < k) {
			Random rand = new Random();
			Collections.swap(a, start + rand.nextInt(a.size() - start), start++);
		}
	}

}
