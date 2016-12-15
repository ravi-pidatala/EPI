package com.chapter14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * o[n] time complexity.
 * o[n] space complexity.
 * 
 * 1. Iterate through intervals which appear before start of new interval. Add them to the result.
 * 2. Compute union with the interval to be added. Union is itself an interval.Iterate through
 * 	  subsequenct intervals as long as they intersect with union they are forming. single union is 
 * 		added to result.
 * 3. iterate through remaining intervals. None of these intersect with the intervals to be added. Add them to the result.
 */
public class Q5 {

	public static void main(String[] args) {
		Q5 q = new Q5();
		
		Interval i1 = new Interval(-4, -1);
		Interval i2 = new Interval(0, 2);
		Interval i3 = new Interval(3, 6);
		Interval i4 = new Interval(7, 9);
		Interval i5 = new Interval(11, 12);
		Interval i6 = new Interval(14, 17);
		
		Interval newInterval = new Interval(1, 8);
		
		
		List<Interval> merged = q.mergeInterval(Arrays.asList(new Interval [] {i1, i2, i3, i4, i5, i6}), newInterval);
		
		for (Interval interval: merged) {
			System.out.print(interval + ",");
		}
		
	}
	
	/*
	 * Merging intervals.
	 * given are disjoint intervals.
	 * if the current one can merge with the interval, update the merging. 
	 * from check if the next one is mergeable. if not add the rest and continue;
	 * 
	 * 
	 * 
	 * 
	 */
	List<Interval> mergeInterval(List<Interval> intervalList, Interval newInterval) {
		/*
		 * go through the intervals . stop when merge can be done. 
		 * if no merge can e done, just add the new interval
		 */
		List<Interval> result = new ArrayList<>();

		int i = 0;
		// new interval started after interval ended.
		while (i < intervalList.size() && intervalList.get(i).end < newInterval.start) {
			result.add(intervalList.get(i));
			i++;
		}
		
		/*
		 *  new interval started before the interval ended and 
		 *  new interval did not end before the interval started.
		 *  new interval 
		 *  merging intervals
		 *  to merge [a, b] and [c, d] 
		 *  Math.min(a, b) , Math.max(c, d)
		 */
		while (i < intervalList.size() && newInterval.end >= intervalList.get(i).start) {
			newInterval = new Interval(Math.min(newInterval.start, intervalList.get(i).start), Math.max(newInterval.end, intervalList.get(i).end));
			i++;
		}
		result.add(newInterval);
		
		// add all remaining.
		if (i < intervalList.size()) {
			result.addAll(intervalList.subList(i, intervalList.size()));
		}
		return result;
	}

}

class Interval {
	int start;
	int end;
	
	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public String toString() {
		return "[" + start + "," + end + "]";
	}
}
