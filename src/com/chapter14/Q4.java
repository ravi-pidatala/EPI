package com.chapter14;

public class Q4 {

	public static void main(String[] args) {
		
		
		
	}
	
	

}

class Event {
	int start;
	int end;
	
}

class Endpoint implements Comparable<Endpoint> {
	boolean isStart;
	int time;
	
	Endpoint(boolean isStart, int time) {
		this.time = time;
		this.isStart = isStart;
	}
	
	@Override
	public int compareTo(Endpoint that) {
		if (time != that.time) {
			return Integer.compare(time, that.time);
		}
		
		if (isStart && !that.isStart) {
			// current one comes first
			return -1;
		}
		if (!isStart && that.isStart) {
			return 1;
		}
		return 0;// both are same
	}
	
}
