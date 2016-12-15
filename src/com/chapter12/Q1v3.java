package com.chapter12;
/*
 * using binary search find k.
 * find k to the left , if found compare with already present min and max index and update
 * find k to the right half. if found comapre with already present min and max index and update
 * return the min and max
 * 
 * 
 */
public class Q1v3 {

	/*
	 * o[log n] complexity
	 */
	public static void main(String[] args) {
		int [] a = {1, 2, 3, 4, 4, 4, 4, 5, 100};// 0 to 8
		a = new int [] {1, 2, 4};
		BinarySearch bs = new BinarySearch();
		int k = 4;
		int index = bs.binarySearch(a, k, 0, a.length - 1);//4
		
		int minIndex = index;
		int temp = minIndex;
		while (true) {
			temp = bs.binarySearch(a, k, 0, minIndex - 1);
			if (temp >= 0) {
				minIndex = temp;
			} else {
				break;
			}
		}
		
		int maxIndex = index;
		temp = maxIndex;
		
		while (true) {
			temp = bs.binarySearch(a, k, maxIndex + 1, a.length - 1);
			if (temp >= 0) {
				maxIndex = temp;
			} else {
				break;
			}
		}
		System.out.println("[" + minIndex + "," + maxIndex + "]");
	}

}
