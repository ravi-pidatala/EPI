package com.chapter14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q6 {

	public static void main(String[] args) {
		
		
		
		
		
		
	}

	List<Interval2> computeDisjointInterval(List<Interval2> input) {
		List<Interval2> result = new ArrayList<>();
		
		Collections.sort(input, (Interval2 left, Interval2 right) -> {
			if (left.start < right.start) {
				return -1;
			} else if (left.start > right.start) {
				return 1;
			} else {
				if (left.startClosed) {
					return -1;
				}
				return 1;
			}
		});
		
		/*
		 * current has start and end. 
		 * see if the next one extends after current. So check only for next end and there is no gap between current end and next start.If yes merge the intervals into new interval
		 * if merging not to be done, add current interval to result and proceed to next.
		 */
		
		Interval2 current = input.get(0);
		
		for (int i = 1; i < input.size(); i++) {
			
			// check if it needs to be merged.
			if (input.get(i).start < current.end || 
					 (input.get(i).start == current.end && (current.endClosed || input.get(i).startClosed)) ) {
				if (input.get(i).end > current.end || 
						(input.get(i).end) == current.end && input.get(i).endClosed) {
					current.end = input.get(i).end;
					current.endClosed = input.get(i).endClosed;
				}
			} else {
				result.add(current);
				current = input.get(i);
			}
		}
		result.add(current);
		return result;
		
	}
}

class Interval2 {
	int start;
	int end;
	boolean startClosed;
	boolean endClosed;
	
	Interval2(int start, boolean startClosed, int end, boolean endClosed) {
		this.start = start;
		this.end = end;
		this.startClosed =startClosed;
		this.endClosed = endClosed;
	}
}
