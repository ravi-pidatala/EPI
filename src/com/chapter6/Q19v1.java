package com.chapter6;

import java.util.ArrayList;
import java.util.List;

public class Q19v1 {
	
	public static void main(String [] args) {
		Q19v1 q = new Q19v1();
		
		List<Integer> a = q.getRow(10);
		
		for (int x: a) {
			System.out.print(x + ",");
		}
	}
	
	/*
	 * Compute nth row of pascal triangle using o[n] space
	 */
	List<Integer> getRow(int n) {
		List<Integer> prev = new ArrayList<>();
		prev.add(1);
		
		List<Integer> curr = new ArrayList<>();
		
		while (prev.size() < n) {
			curr.add(1);
			
			for (int i = 1; i < prev.size(); i++) {
				curr.add(prev.get(i) + prev.get(i - 1));
			}
			curr.add(1);
			prev.clear();
			prev.addAll(curr);
			curr.clear();
		}
		return prev;
	}
	
	
}
