package com.chapter9;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q1 {

	public static void main(String [] args) {
		Q1 q = new Q1();
		
		q.push(1);
		q.push(2);
		q.push(5);
		q.push(3);
		q.push(5);
		q.push(5);
		q.push(4);

		System.out.println(q.getMax());
		q.pop();
		q.pop();
		System.out.println(q.getMax());
		System.out.println(q.peek());
		
		q.pop();
		q.pop();
		System.out.println(q.getMax());
		System.out.println(q.peek());
		q.pop();
		System.out.println(q.getMax());
		System.out.println(q.peek());
	}
	
	List<Integer> data = new ArrayList<>();
	Stack<Integer> maxStack = new Stack<>();

	public Integer peek() {
		if (data.size() > 0) {
			return data.get(data.size() - 1);
		} 
		return null;
	}

	public void push(int x) {
		data.add(x);
		if(maxStack.size() == 0 || maxStack.peek() <= x) {
			maxStack.push(x);
		}
	}

	public Integer pop() {
		if (data.size() > 0) {
			int x = data.remove(data.size() - 1);
			if (maxStack.peek() == x) {
				maxStack.pop();
			}
			return x;
		}
		return null;
	}

	public Integer getMax() {
		if (!maxStack.isEmpty()) {
			return maxStack.peek();
		}
		return null;
	}



}
