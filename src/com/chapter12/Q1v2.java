package com.chapter12;
/*
 * a is unsorted array of n integers.
 * a[0] >= a[1]
 * a[n - 2] <= a[n - 1]
 * find local minima. Where a[i] is less than or equal to its neighbors if one exists
 *     2, 1, 0, 3, 4, 1, 4
 *     
 *      
 *      
 */
public class Q1v2 {

	public static void main(String[] args) {
		int [] a = {2, 1, 0, 3, 5, 1, 4};
		
		Q1v2 q = new Q1v2();
		System.out.println(q.getLocalMinima(a));
	}
	
	/*
	 * brute force approach o[n]. Go through all the elements and check if it is local minima.
	 * if the middle element is greator than start, it means 
	 * 
	 * ASSUME: array elements are distinct.
	 * a[0] > a[1]
	 * a[n - 2] < a[n - 1]
	 * 
	 * the array value decreased from 0 to 1 and it increased from last but one to last.
	 *  
	 * 2, 1, 10, 0, 9, 1, 4
	 * 
	 * This can be understood only pictorially. Draw graph
	 * 
	 * 				\		/
	 * 				 \	   /
	 * 				  \   /
	 * 				   \ /
	 * 
	 * first the array decreases . in the end array increases.(it can go through the increase and decrease many times. above happens atleast once)
	 * get the middle element. if middle is local minima return it.
	 * if not, one of its neighbours must be lesser than the current middle. search in the half where the lesser neighbour exists. Because in the end value has increased . So
	 * we can hope to find one local minima in this half
	 * There can be many local minimas, this approach will surely find one of them. Which one is found can not guaranteed.
	 * 
	 */
	int getLocalMinima(int [] a) {// length is atleast 3
		int start = 0;
		int end = a.length - 1;
		
		if (a.length < 3) {
			return -1;
		}
		
		while (end >= start) {
			int middle = start + (end - start) / 2;
			
			//middle is local minima
			if (middle + 1 < a.length && middle - 1 >= 0 && a[middle] < a[middle + 1] && a[middle] < a[middle - 1]) {
				return middle;
			}
			
			if (middle - 1 >= 0 && a[middle] > a[middle - 1]) {
				end = middle - 1;
			} else if (middle + 1 < a.length && a[middle] > a[middle + 1]) {
				start = middle + 1;
			}
		}
		return -1;
	}
	
	/*
	 * if repetitions allowed.
	 * if all are equal => all elements are local minimum
	 * if there are 3 repeating elements , local minimum is midddle element.
	 * 
	 * invariant is local minima always exists between start and end if one exist
	 * each cycle , end reduces by atleast 1 or start increases by atleast one. so there is no chance of infinite loop
	 */
	int localMinimaWithRep(int [] a) {
		int start = 0;
		int end = a.length - 1;
		
		if (a.length < 3) {
			return -1;
		}
		
		while (end >= start) {
			int middle = start + (end - start) / 2;
			
			//middle is local minima
			if (middle + 1 < a.length && middle - 1 >= 0 && a[middle] <= a[middle + 1] && a[middle] <= a[middle - 1]) {
				return middle;
			}
			if (middle - 1 >= 0 && a[middle] >= a[middle - 1]) {
				end = middle - 1;
			} else if (middle + 1 < a.length && a[middle] >= a[middle + 1]) {
				start = middle + 1;
			}
			
		}
		return -1;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
