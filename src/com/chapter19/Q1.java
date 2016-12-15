package com.chapter19;

import java.util.List;
import java.util.Set;

public class Q1 {

	/*
	 * Find if there is path from start to end in a maze.
	 * We can represent maze with graph. Map<String, Set<String>>
	 * Or row and column. 
	 * 
	 * Maze can be represented by 2 D array. List<List<Color>>
	 * Start point and end point is co-ordinate.
	 * row and column is implicitly represented by maze.
	 */

	public static void main(String[] args) {
		
		
		
		
	}
	
	/*
	 * Depth first search.
	 * One option to avoid space complexity is make the color of visited nodes to black.
	 * 
	 */
	boolean findPath(Coordinate start, Coordinate end, List<List<Color>> maze, Set<Coordinate> visited, List<Coordinate> path) {
		
		// already checked . no path from start to end
		if (visited.contains(start)) {
			return false;
		}
		visited.add(start);
		if (start.x < 0 || start.y < 0 || start.x >= maze.get(0).size() || start.y >= maze.size() || maze.get(start.y).get(start.x) == Color.BLACK) {
			return false;
		}

		//Go right
		Coordinate next = new Coordinate(start.x + 1, start.y);
		path.add(next);
		if (findPath(next, end, maze, visited, path)) {
			return true;
		} 
		path.remove(path.size() - 1);
		
		
		// go up
		next = new Coordinate(start.x, start.y + 1);
		if (findPath(next, end, maze, visited, path)) {
			return true;
		}
		path.remove(path.size() - 1);
		
		// go left
		next = new Coordinate(start.x - 1, start.y);
		if (findPath(new Coordinate(start.x - 1, start.y), end, maze, visited, path)) {
			return true;
		}
		path.remove(path.size() - 1);
		
		// go down
		next = new Coordinate(start.x , start.y - 1);
		if (findPath(next, end, maze, visited, path)) {
			return false;
		}
		path.remove(path.size() - 1);
		return false;
	}
}


class Coordinate {
	int x;
	int y;
	
	Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
}


enum Color {
	BLACK, WHITE;
}