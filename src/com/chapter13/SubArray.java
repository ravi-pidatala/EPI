package com.chapter13;

public class SubArray {

	int start;
	int end;
	
	SubArray(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	int getSize() {
		return end - start + 1;
	}
	
	@Override
	public String toString() {
		return "(" + start + ", " + end + ")";
	}
}
