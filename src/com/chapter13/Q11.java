package com.chapter13;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * Compute the average of top three scores.
 * 
 * Get student who has maximum score average across 3 tests.
 * 
 * test score : student id, integer between 0 and 100.
 * student ids will repeat. 
 * 
 * If student does not have atleast 3 scores , ignore the student.
 * 
 * 
 */
public class Q11 {

	public static void main(String[] args) {
		
		
		
		
		
	}
	
	/*
	 * have hash map .    
	 * key is string .
	 * value is min heap of size 3 .
	 * 
	 * after reading the whole file into hashmap 
	 * 
	 * iterate thorugh all the enetires in hashmap . record the student with highest avg.
	 * 
	 * 
	 * o[n] to read. 
	 * o[log 3] to put into hashmap
	 * 
	 * o[n] to read the hashmap, calculate the max average. 
	 * 
	 * o[n] time and o[n] space. 
	 * 
	 * 
	 * if it is top k scores, 
	 * 
	 * o[n] + o[n log k] => o[n log k] time 
	 * o[m] space where m is number of distinct students.
	 */
	
	int computeHighestAvg(Iterator<StudentScore> studentData) {
		
		Map<String, Queue<Integer>> scoreMap = new HashMap<>();
		int result = 0;
		
		/*
		 * write the data from input into the hashmap
		 * 
		 * 
		 */
		while (studentData.hasNext()) {
			StudentScore studentScore = studentData.next();
			
			if (scoreMap.containsKey(studentScore.studentid)) {
				scoreMap.get(studentScore.studentid).add(studentScore.score);
			} else {
				Queue<Integer> q = new PriorityQueue<>();
				q.add(studentScore.score);
				if (q.size() > 3) {
					q.poll();
				}
				scoreMap.put(studentScore.studentid, q);
			}
		}
		
		/*
		 * now go through the hashmap, 
		 * and calculate the max average
		 */
		for (String s : scoreMap.keySet()) {
			Queue<Integer> q = scoreMap.get(s);
			
			if (q.size() < 3) {
				continue;
			}
			result = Math.max(result, (q.remove() + q.remove() + q.remove()) / 3);
		}
		
		return result;
	}
	
	

}

class StudentScore {
	
	String studentid;
	int score;
	
	
	
}
