package com.chapter13;

import java.util.HashSet;
import java.util.Set;

/*
 * Compute LCA optimizing for close ancestors. Nodes have parent pointers.
 * 
 * Time complexity should depend only on the distance of the nodes from LCA.
 * 
 * 
 */
public class Q4 {

	public static void main(String[] args) {
		
	}
	
	/*
	 * Cae 1: both are same nodes.
	 * Case 2: both nodes are from same parent. 
	 * Case 3: both nodes descend from same parent.
	 * Case 4: nodes are from different graph. 
	 */
	
	public GraphNode getLca(GraphNode a, GraphNode b) {
		/*
		 * Go on putting nodes parents to the hashSet alternately.
		 * 
		 */
		
		Set<GraphNode> nodeSet = new HashSet<>();
		GraphNode tempA = a;
		GraphNode tempB = b;
		
		
		while (tempA != null || tempB != null) {
			if (tempA != null) {
				if (!nodeSet.add(tempA)) {
					return tempA;
				}
				tempA = tempA.parent;
			}
			
			if (tempB != null) {
				if (!nodeSet.add(tempB)) {
					return tempB;
				}
				tempB = tempB.parent;
			}
		}
		
		return null;// no LCA.Both nodes are from different graph.
		
		
	}
	

}
