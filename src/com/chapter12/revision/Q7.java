package com.chapter12.revision;

public class Q7 {

	public static void main(String[] args) {
		
	}
	
	/*
	 * Have an object MinAndMAx
suppose n is even.

make n / 2 - 1 comparisons. 
n / 2 comparisons 
n / 2 comparisons 

3n /2 - 1 comparisons. 


compared to 2n - 2 comparisons. 


How to do it in place????

For two elements, 3 comparisons with minAndMAx. 

compare both elements and have one minMax
compare min of existing with the min now
Compare max of existing with the max now. 

Take the result minMax and continue;

if n is odd, Compare it with min and then max . 

Maximum number of comparisons. 

1. For first object i.e. 2 elements => 1.
2. for every two elements, 3 comparisons. 
3. if n is odd, 2 more comparisons. 


suppose n is odd. 

1 + 3 (n - 2 / 2) + 2 

3n /2 + 3 - 1 = 3n /2 + 2. 

if n is even, 
3 (n -2) / 2 + 1.
3n / 2





	 */
	MinAndMax getMinAndMax(int [] a) {
		if (a.length < 2) {
			return null;
		}
		MinAndMax result = new MinAndMax();
		result.arrange(a[0], a[1]);
		
		MinAndMax temp = new MinAndMax();
		for (int i = 2; i + 1 < a.length; i = i + 2) {
			temp.arrange(a[i], a[i + 2]);
			result.min = temp.min < result.min ? temp.min: result.min;
			result.max = temp.max > result.max ? temp.max: result.max;
		}
		
		if (a.length % 2 == 1) {
			result.min = a[a.length - 1] < result.min ? a[a.length - 1] : result.min;
			result.max = a[a.length - 1] > result.max ? a[a.length - 1] : result.max;
		}
		return result;
	}
	

}

class MinAndMax {
	int min;
	int max;
	
	void arrange(int x, int y) {
		if (x < y) {
			min = x;
			max = y;
		} else {
			min = y;
			max = x;
		}
	}
}