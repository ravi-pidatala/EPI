package com.chapter10;

public class BSTUtil {

	public static TreeNode getBinarySearchTree() {
		TreeNode a = new TreeNode(19);
		TreeNode b = new TreeNode(7);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(2);
		TreeNode e = new TreeNode(5);
		TreeNode f = new TreeNode(11);
		TreeNode g = new TreeNode(17);
		TreeNode h = new TreeNode(13);
		
		
		TreeNode i = new TreeNode(43);
		TreeNode j = new TreeNode(23);
		TreeNode k = new TreeNode(37);
		TreeNode l = new TreeNode(29);
		TreeNode m = new TreeNode(31);
		TreeNode n = new TreeNode(41);
		TreeNode o = new TreeNode(47);
		TreeNode p = new TreeNode(53);
		
		a.left = b;
		b.left = c;
		c.left = d;
		c.right = e;
		b.right = f;
		f.right = g;
		g.left = h;
		
		a.right = i;
		i.left = j;
		j.right = k;
		k.left = l;
		l.right = m;
		k.right = n;
		i.right = o;
		o.right = p;
		
		return a;
		
	}
}
