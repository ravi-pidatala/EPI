package com.chapter19;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class GraphBootCamp {

	public static void main(String[] args) {
		
		
		
		
	}

	/*
	 * Construct graph with winning team as key and set of loosing team as value.
	 */
	Map<String, Set<String>> buildGraph(List<MatchResult> matchList) {
		Map<String, Set<String>> graph = new HashMap<>();
		
		for (MatchResult result: matchList) {
			if (graph.containsKey(result.winningTeam)) {
				graph.get(result.winningTeam).add(result.loosingTeam);
			} else {
				Set<String> loosingSet = new HashSet<>();
				graph.put(result.winningTeam, loosingSet);
				loosingSet.add(result.loosingTeam);
			}
		}
		
		return graph;
	}
	
	/*
	 * Depth first search. 
	 * Save the visited nodes to avoid infinite looping. 
	 * 
	 */
	private boolean isReacheableDfs(Map<String, Set<String>> graph, String current, String destination, Set<String> visited) {
		// base case
		if (current.equals(destination)) {
			return true;
		}
		
		if (graph.get(current) == null || visited.contains(current)) {
			return false;
		}
		
		Set<String> looserSet = graph.get(current);
		visited.add(current);
		
		for (String looser: looserSet) {
			if (isReacheableDfs(graph, looser, destination, visited)) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * Breadth first search uses Queue.
	 * Add node to queue. once all the adjacent nodes are searched, proceed to next node from queue.
	 * 
	 * 
	 */
	private boolean isReacheableBFS(Map<String, Set<String>> graph, String current, String dest, Queue<String> searchQueue, 
													Set<String> visited) {
		// bfs uses Queue.
		Queue<String> queue = new LinkedList<>();
		queue.add(current);
		
		while (!queue.isEmpty()) {
			String cur = queue.poll();
			
			if (cur.equals(dest)) {
				return true;
			}
			if (visited.contains(cur)) {
				queue.poll();
				continue;
			}
			
			visited.add(cur);
			queue.poll();
			if (graph.get(cur) != null) {
				for (String s: graph.get(cur)) {
					queue.add(s);
				}
			}
		}
		return false;
	}
	
}

class MatchResult {
	String winningTeam;
	String loosingTeam;
	
	MatchResult(String winningTeam, String loosingTeam) {
		this.winningTeam = winningTeam;
		this.loosingTeam = loosingTeam;
	}
}
