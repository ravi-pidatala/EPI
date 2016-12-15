package com.chapter16;

public class Q2v1 {

	public static void main(String[] args) {
		Q2v1 q = new Q2v1();
		
		Integer x = new Integer(1);
		q.addOne(x);
		System.out.println(x);
	}
	
	void addOne(Integer x) {
		x++;
	}

}
