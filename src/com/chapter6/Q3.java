package com.chapter6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q3 {

	public static void main(String[] args) {
		List<Integer> a = Arrays.asList(8, 9);
		List<Integer> b = Arrays.asList(1, 2, 9);
		Q3 q = new Q3();
		
		for (int x : q.multiply(a, b)) {
			System.out.print(x + ",");
		}
		
	}
	
	// TODO negative
	private List<Integer> multiply(List<Integer> a, List<Integer> b) {
		List<Integer> r = new ArrayList<>();
		List<Integer> lr = new ArrayList<>();
		
		for (int j = b.size() - 1; j >= 0; j--) {
			int c = 0;
			
			for (int i = a.size() - 1; i >= 0; i--) {
				int result = a.get(i) * b.get(j) + c;
				lr.add(result % 10);
				c = result / 10;
			}
			lr.add(c);
			reverse(lr);
			for (int k = b.size() - 1 - j; k > 0; k--) {
				lr.add(0);
			}
			r = addLists(r, lr);
		}
		
		return r;
	}
	
	private List<Integer> addLists(List<Integer> x, List<Integer> y) {
		List<Integer> result = new ArrayList<>();
		int c = 0;
		int i = x.size() - 1;
		int j = y.size() - 1;
		
		while (i >= 0 && j >= 0) {
			int r = x.get(i--) + y.get(j--) + c;
			result.add(r % 10);
			c = r / 10;
		}
		while (i >= 0) {
			int r = c + x.get(i--);
			result.add(r % 10);
			c = r / 10;
		}
		
		while (j >= 0) {
			int r = c + y.get(j--);
			result.add(r % 10);
			c = r / 10;
		}
		result.add(c);
		reverse(result);
		x.clear();
		y.clear();
		return result;
	}
	
	private void reverse(List<Integer> x) {
		int left = 0, right = x.size() - 1;
		
		while (left < right) {
			swap(x, left++, right--);
		}
	}
	
	private void swap(List<Integer> x, int l, int r) {
		int temp = x.get(l);
		x.set(l,  x.get(r));
		x.set(r, temp);
	}

}
