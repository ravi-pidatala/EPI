package com.chapter15;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Q7 {

	public static void main(String[] args) {
		Q7 q = new Q7();
		int k  = 20;
		q.getFirstk(k);
		
		System.out.println("");
		q.getFirstkApproach2(k);
		
	}
	
	/*
	 * Efficiently compute k smallest numbers of the form a + b sqrt(2)
	 * for non negative integers a and b. 
	 * Brute force. 
	 *  a as 1 to k
	 *  b as 1 to k. 
	 *  
	 *  k^2 numbers. find smallest k numbers.
	 *  
	 *  o[k] space.. 
	 *  time is o[k log k] since we need to insert into treeSet.
	 *  
	 */
	List<AbSqrtTwo> getFirstk(int k) {
		SortedSet<AbSqrtTwo> temp = new TreeSet<>();
		AbSqrtTwo start = new AbSqrtTwo(0, 0);
		temp.add(start);
		List<AbSqrtTwo> result = new ArrayList<>();
		
		for(int i = 1; i <= k; i++) {
			AbSqrtTwo current = temp.first();
			result.add(current);
			
			AbSqrtTwo nextOne = new AbSqrtTwo(current.a + 1, current.b);
			temp.add(nextOne);
			
			AbSqrtTwo next = new AbSqrtTwo(current.a, current.b + 1);
			temp.add(next);
			
			temp.remove(current);
		}
		
		for (AbSqrtTwo abSqrtTwo: result) {
			System.out.print(abSqrtTwo);
		}
		return result;
	}
	
	List<AbSqrtTwo> getFirstkApproach2(int k) {
		List<AbSqrtTwo> result = new ArrayList<>();
		int i = 0, j = 0;
		result.add(new AbSqrtTwo(i, j));
		
		for (int a = 1; a < k; a++) {
			AbSqrtTwo plusOne = new AbSqrtTwo(result.get(i).a + 1, result.get(i).b);
			AbSqrtTwo plusTwo = new AbSqrtTwo(result.get(j).a, result.get(j).b + 1);
			
			if (plusOne.value < plusTwo.value) {
				i++;
				result.add(plusOne);
			} else if (plusOne.value > plusTwo.value) {
				j++;
				result.add(plusTwo);
			} else {
				i++;
				j++;
				result.add(plusOne);
			}
		}
		
		for (AbSqrtTwo abSqrtTwo: result) {
			System.out.print(abSqrtTwo);
		}
		return result;
	}
}

class AbSqrtTwo implements Comparable<AbSqrtTwo> {
	int a;
	int b;
	double value;
	
	public AbSqrtTwo(int a, int b) {
		this.a = a;
		this.b = b;
		value = a + b * Math.sqrt(2);
	}
	
	@Override
	public int compareTo(AbSqrtTwo other) {
		return Double.compare(this.value, other.value);
	}
	
	@Override
	public String toString() {
		return "(" + a + ", " + b + ")"; //, " + value +  ")" ;
	}
}
