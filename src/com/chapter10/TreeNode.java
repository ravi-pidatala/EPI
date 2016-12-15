package com.chapter10;

public class TreeNode {

	public int data;
	public TreeNode left;
	public TreeNode right;
	public TreeNode next;
	public String s;
	public int height;
	public boolean unbalanced;
	public TreeNode parent;
	boolean visited;
	public int childrenCount;
	public boolean locked;
	public int lockedDescendants;
	
	public TreeNode(int data) {
		this.data = data;
	}
	
	public TreeNode(String s) {
		this.s = s;
	}
	
	public TreeNode(String s, int data) {
		this(s);
		this.data = data;
	}
	
	TreeNode(int data, int height) {
		this(data);
		this.height = height;
	}
	
	

	public String toString() {
		if (next == null) {
			return ("(" + s + ", "  + this.data + ")") ;
		} else {
			return ("(" + s + ", "  + this.data + "," + next.data + ")");
		}
		
	}

	@Override
	public int hashCode() {
		return s.hashCode() + data;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj == this;
	}
}

