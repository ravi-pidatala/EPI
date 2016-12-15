package com.chapter10;

public class Q5 {

	public static void main(String[] args) {
		TreeNode a = new TreeNode("A", 1);
		TreeNode b = new TreeNode("B", 0);
		TreeNode c = new TreeNode("C", 0);
		TreeNode d = new TreeNode("D", 0);
		TreeNode e = new TreeNode("E");
		TreeNode f = new TreeNode("F", 1);
		TreeNode g = new TreeNode("G");
		TreeNode h = new TreeNode("H");
		
		TreeNode i = new TreeNode("I", 1);
		TreeNode j = new TreeNode("J");
		TreeNode k = new TreeNode("K");
		TreeNode l = new TreeNode("L");
		TreeNode m = new TreeNode("M");
		TreeNode n = new TreeNode("N");
		TreeNode o = new TreeNode("O");
		TreeNode p = new TreeNode("P");
		
		a.left = b;
		a.right = i;
		b.left = c;
		b.right = f;
		c.left = d;
//		c.right = e;
//		f.right = g;
//		g.left = h;
//		i.left = j;
//		i.right = o;
//		o.right = p;
//		j.right = k;
//		k.left = l;
//		k.right = n;
//		l.right = m;
		
		Q5 q = new Q5();
		
		System.out.println(q.getSum(a, 0));

		
	}
	
	/*
	 * Sum the nodes from root to leaf.
	 */
	public long getSum(TreeNode node, long sum) {
		if (node == null) {
			return 0;
		}
		sum = sum * 2 + node.data;
		
		//base case. leaf node
		if (node.left == null && node.right == null) {
			return sum;
		}
		return getSum(node.left, sum) + getSum(node.right, sum);
	}	

}
