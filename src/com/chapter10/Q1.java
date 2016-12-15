package com.chapter10;

public class Q1 {

	public static void main(String[] args) {
		TreeNode a = new TreeNode("A");
		TreeNode b = new TreeNode("B");
		TreeNode c = new TreeNode("C");
		TreeNode d = new TreeNode("D");
		TreeNode e = new TreeNode("E");
		TreeNode f = new TreeNode("F");
		TreeNode g = new TreeNode("G");
		TreeNode h = new TreeNode("H");
		
		TreeNode i = new TreeNode("I");
		TreeNode j = new TreeNode("J");
		TreeNode k = new TreeNode("K");
		TreeNode l = new TreeNode("L");
		TreeNode m = new TreeNode("M");
		TreeNode n = new TreeNode("N");
		TreeNode o = new TreeNode("O");
		TreeNode p = new TreeNode("P");
		
		a.left = b;
		a.right = k;
		b.left = c;
		b.right = h;
		c.left = d;
		c.right = g;
		d.left = e;
		d.right = f;
		k.left = l;
		k.right = o;
		l.left = m;
		l.right = n;
		h.left = i;
		h.right = j;
		
		o.right = p;
	
		Q1 q = new Q1();
		System.out.println(q.isheightBalanced(a));
	}
	
	
	int isheightBalanced(TreeNode node) {
		if (node == null) {
			return 0;
		}

		int leftHeight = isheightBalanced(node.left);
		if (leftHeight == -1) {
			return -1;
		}
		int rightHeight = isheightBalanced(node.right);
		if (rightHeight == -1) {
			return -1;
		}
		if (Math.abs(leftHeight - rightHeight) <= 1) {
			return Math.max(leftHeight, rightHeight) + 1;
		} else {
			return -1;
		}

	}
 
	
}
