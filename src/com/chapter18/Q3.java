package com.chapter18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q3 {

	public static void main(String[] args) {
		
	}
	
	/*
	 * Given a set of closed intervals. Find minimum sized set of numbers that cover all the intervals.
	 * Minimize the number of visits a foreman makes.
	 * [0, 3], [2, 6], [3, 4], [6, 9]
	 * 
	 * sort them by start interval=> times to visit is 3, 6
	 * sort by end interval => [0, 3], [3, 4], [2, 6], [6, 9]
	 * 
	 * [0, 9], [2, 6], [3, 4], [6, 10] => 
	 * 
	 * Sort by end interval. Add the end points to the result . Check if the end point exist in the next interval.
	 * [3, 4], [2, 6] , [0, 9], [6, 10] => 4, 6, 
	 * 
	 */
	List<Integer> getPoints(List<Interval> intervalList) {
		List<Integer> pointToVist = new ArrayList<>();
		
		Collections.sort(intervalList, (i1, i2) -> {
			return i1.end - i2.end;
		});
		
		pointToVist.add(intervalList.get(0).end);
		
		for (int i = 1; i < intervalList.size(); i++) {
			int p = pointToVist.get(pointToVist.size() - 1);
			
			// check if the last end point, covers the current interval, if yes, do not add the current end to the list. if no add to list.
			if (p < intervalList.get(i).start) {
				pointToVist.add(intervalList.get(i).end);// current interval need to be covered.
			}
		}
		return pointToVist;
	}
}

class Interval {
	public int start;
	public int end;
	
	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}
