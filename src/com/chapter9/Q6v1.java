package com.chapter9;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Q6v1 {
	
	/*
	 * buildings in West to east order.
	 */

	
	public static void main(String[] args) {

		Building b0 = new Building(0, 0);
		Building b1 = new Building(1, 1);
		Building b2 = new Building(2, 2);
		Building b3 = new Building(3, 3);
		Building b4 = new Building(4, 4);
		Building b5 = new Building(5, 5);
		Building b6 = new Building(6, 4);
		Building b7 = new Building(7, 3);
		Building b8 = new Building(8, 2);
		Building b9 = new Building(9, 5);
		
		Q6v1 q = new Q6v1();
		List<Building> bList = Arrays.asList(b0, b1, b2, b3, b4, b5, b6, b7, b8, b9);
	
		Stack<Building> result = q.getSunsetView(bList);

		
		
		for (Building b: result) { //
			System.out.print(b.index + ",");
		}
	}
	
	public Stack<Building> getSunsetView(List<Building> bList) {
		Stack<Building> result = new Stack<>();
		
		for(Building b: bList) {
			if (result.isEmpty() || b.height > result.peek().height) {
				result.push(b);
			}
		}
		return result;
	}
	
	

}
