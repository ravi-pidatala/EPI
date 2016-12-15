package com.chapter16;

import java.util.List;

public class Q11 {

	public static void main(String[] args) {
		
	}
	
	/*
	 * Compute the diameter of a tree.
	 * If the path does not pass through the root, it must be entirely within one of the subtrees.So the path is maximum of the diameters of the 
	 * subtrees.
	 * 
	 * If the path passes through the root, it must be between the diameter is hi + li where hi is the height of node i and 
	 * li is the distance of node from root.
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	private HeightAndDiameter computeHeightAndDiameter(GraphNode node) {
		
		Double [] heights = {0.0, 0.0};
		Double diameter = Double.MIN_VALUE;
		
		
		for (Edge e: node.edges) {
			HeightAndDiameter heightAndDiameter = computeHeightAndDiameter(e.node);
			
			if (heightAndDiameter.height + e.length > heights[0]) {
				heights[1] = heights[0];
				heights[0] = heightAndDiameter.height + e.length;
			} else if (heightAndDiameter.height + e.length > heights[1]) {
				heights[1] = heightAndDiameter.height + e.length;
			}
			diameter = Math.max(diameter, heightAndDiameter.diameter);
		}
		return new HeightAndDiameter(heights[0], Math.max(diameter, heights[0] + heights[1]));
		
	}

}


class GraphNode {
	List<Edge> edges;
}

class Edge {
	public GraphNode node;
	public Double length;
	
	Edge(GraphNode node, Double length) {
		this.node = node;
		this.length = length;
	}
	
	
}

class HeightAndDiameter {
	public Double height;
	public Double diameter;
	
	HeightAndDiameter(Double height, Double diameter) {
		this.height = height;
		this.diameter = diameter;
	}
}