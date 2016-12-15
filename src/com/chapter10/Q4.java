package com.chapter10;

public class Q4 {

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
		
		a.left = b;b.parent = a;
		a.right = k; k.parent = a;
		b.left = c; c.parent = b;
		b.right = h; h.parent = b;
		c.left = d; d.parent = c;
		c.right = g; g.parent = c;
		d.left = e;e.parent = d;
		d.right = f; f.parent = d;
		k.left = l; l.parent = k;
		k.right = o; o.parent = k;
		l.left = m; m.parent = l;
		l.right = n; n.parent = l;
		h.left = i; i.parent = h;
		h.right = j;j.parent = h;
		o.right = p;p.parent = o;

		Q4 q = new Q4();
		
		System.out.println(q.getLCA(a, n, f).s);
		
		
	}
	
	public TreeNode getLCA(TreeNode root, TreeNode a, TreeNode b) {
		if (a == null || b == null || root == null) {
			return null;
		}
		
		int aDepth = getDepth(root, a);
		System.out.println("depth of node a is " + aDepth);
		int bDepth = getDepth(root, b);
		System.out.println("depth of node b is " + bDepth);
		if (aDepth < 0 || bDepth < 0) {
			System.out.println("nodes not present in tree");
			return null;
		}
		int diff = Math.abs(aDepth - bDepth);
		
		if (aDepth > bDepth) {
			while (diff != 0) {
				System.out.println("a going up");
				a = a.parent;
				diff--;
			}
		}
		
		if (aDepth < bDepth ) {
			while (diff != 0) {
				
				b = b.parent;
				System.out.println("b going up to " + b.s);
				diff--;
			}
		}
		
		while (a != null && b != null && a != b) {
			a = a.parent;
			b = b.parent;
		}
		return (a == null || b == null) ? null: a;
	}
	
	private int getDepth(TreeNode root, TreeNode x) {
		int depth = 0;
		
		while (x != null && x != root) {
			x = x.parent;
			depth++;
		}
		if (x != null) {
			return depth;
		}
		return -1;
		
	}
	
}









