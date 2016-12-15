package com.chapter11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Compute k closest stars, each star is given by co-ordinate
 * max heap is required , because we should delete star farthest from the earth
 * 
 */
public class Q4 {

	public static void main(String[] args) {
		
		
	}
	
	static List<Star> findKClosestStars(int k, Iterator<Star> iterator) {
		PriorityQueue<Star> maxHeap = new PriorityQueue<>(10, Collections.reverseOrder());
		
		
		while (iterator.hasNext()) {
			maxHeap.add(iterator.next());
			
			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		List<Star> starsList = new ArrayList<>(maxHeap);
		Collections.sort(starsList);
		return starsList;
	}
}

class Star implements Comparable<Star>{
	int x;
	int y;
	int z;
	
	@Override
	public int compareTo(Star star) {
		int distance = x * x + y * y + z * z;
		int otherDistance = star.x * star.x + star.y * star.y + star.z * star.z;
		
		if (distance < otherDistance) {
			return -1;
		} else if (distance == otherDistance) {
			return 0;
		} else {
			return 1;
		}
	}
	
	Star(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	
	
	
}
