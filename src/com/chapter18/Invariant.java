package com.chapter18;

import java.util.List;

public class Invariant {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * Given a sorted array and a value.
	 * Find if there are two entries that add up to the value.
	 * 
	 * suppose a is is value. b and c are arbitrary number in array.
	 * 
	 *   b + c = a; => a - b = c.
	 *   for each value in array , calculate a - b. check if the value is present in rest of the array.
	 *   o[n log n] . log n for searching . If all elements are searched, n log n will be the time.
	 *   
	 * 	 There is a better approach. take i as first index and j as last index
	 * 	 arr[i] + arr[j] > a => i++
	 * 	 arr[i] + arr=[j] < a => i--
	 *   if equal found answer.
	 * 	  	
	 *   Maintain a sub array that is guaranteed to hold solution. shrink it from one side or the other. 
	 *   if Sum of leftMost and rightMost element is less than target, then leftmost element can never be combned with some element to obtain target.
	 *   if sum greator than target, then rightmost can never be combined with any element to obtain target.
	 *   Sub array is initialized to the entire array, and iteratively shrunk from one side or the other.
	 *   
	 *   
	 *   
	 */
	boolean hasTwoSum(List<Integer> a, int sumOfTwo) {
		int currentSum = 0;
		for (int i = 0, j = a.size() - 1; i < j; ) {
			currentSum = a.get(i) + a.get(j);
			if (currentSum == sumOfTwo) {
				return true;
			} else if (currentSum > sumOfTwo) {
				j--;
			} else {
				i++;
			}
		}
		return false;
	}
		
}
