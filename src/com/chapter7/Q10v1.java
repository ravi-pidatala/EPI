package com.chapter7;

import java.util.List;

public class Q10v1 {

	public static void main(String[] args) {
		
		
		
		
	}
	
	private void print(String s, List<Integer> posList, int k) {
		
		if (k == 0) {
			if (isValid(s, posList)) {
				print(s, posList);
			};
			return;
		}
		
		int lastPosition = posList.get(posList.size() - 1);
		
		for (int i = lastPosition + 1; i < s.length(); i++) {
			posList.add(i);
			print(s, posList, k - 1);
			posList.remove(posList.size() - 1);
		}
	}
	
	boolean isValid(String s, List<Integer> posList) {
		int prev = 0;
		
		for(int x: posList) {
			if(s.substring(prev, x).length() <= 3 && Integer.valueOf(s.substring(prev, x)) < 256) {
				prev = x;
			} else {
				return false;
			}
		}
		
		if (s.substring(prev, s.length()).length() <= 3 && Integer.valueOf(s.substring(prev, s.length())) < 256){
			return true;
		}
		return false;
	}
	
	void print(String s, List<Integer> posList) {
		
		StringBuilder sb = new StringBuilder();
		int prev = 0;
		for(int x: posList) {
			sb.append(s.substring(prev, x) + ".");
			prev = x;
		}
		
		sb.append(s.substring(posList.get(posList.size() - 1), s.length()));
		System.out.println(sb.toString());
		
	}

}
