package com.chapter18;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q8 {

	public static void main(String[] args) {
		
	}
	
	/*
	 * Given a sequence of adjacent buildngs. Each has unit width and and integer height.
	 * Compute area of the largest rectangle contained in this skyline.
	 * 
	 * 
	 * if current building height is greator than the one in stack peek , add the index to the stack.
	 * else, go on removing buildings from the stack calculating 
	 * 
	 * 
	 * 
	 * 
	 */
	public int computeLargestRectangleArea(List<Integer> heightList) {
		Deque<Integer> pillarIndices = new LinkedList<>();
		
		int maxArea = 0;
		
		for (int i = 0; i <= heightList.size(); i++) {
			
			if (!pillarIndices.isEmpty() && i < heightList.size() && heightList.get(i) == heightList.get(pillarIndices.peekFirst())) {
				pillarIndices.removeFirst();
				pillarIndices.addFirst(i);
			}
			
			
		}
		
		
		
	}
	
	private boolean isNewPillarOrReachEnd(List<Integer> heightList, int x, List<Integer> pillarIndices, int lastPillarIndex) {
		if (x >= heightList.size()) {
			return true;// end of pillars
		}
		
		if (heightList.get(x) < heightList.get(lastPillarIndex)) {
			return true;
		}
		return false;
	}

}
