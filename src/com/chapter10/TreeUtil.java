package com.chapter10;

public class TreeUtil {
	
//								a
//							  /   \
//							 b     
//							/
//						   c
//						  / \
//						 d   e
						 
						  

	public static TreeNode getTree() {
		TreeNode a = new TreeNode("a", 314);
		TreeNode b = new TreeNode("b", 6);
		TreeNode c = new TreeNode("c", 271);
		TreeNode d = new TreeNode("d", 28);
		TreeNode e = new TreeNode("e", 0);
		TreeNode f = new TreeNode("f", 561);
		TreeNode g = new TreeNode("g", 3);
		TreeNode h = new TreeNode("h", 17);
		TreeNode i = new TreeNode("i", 6);
		TreeNode j = new TreeNode("j", 2);
		TreeNode k = new TreeNode("k", 1);
		TreeNode l = new TreeNode("l", 401);
		TreeNode m = new TreeNode("m", 641);
		TreeNode n = new TreeNode("n", 257);
		TreeNode o = new TreeNode("o", 271);
		TreeNode p = new TreeNode("p", 28);
		
		a.left = b;  b.parent = a;
		b.left = c;  c.parent = b;
		c.left = d;	 d.parent = c;
		c.right = e; e.parent = c;
		b.right = f; f.parent = b;
		f.right = g; g.parent = f;
		g.left = h; h.parent = g;
		a.right = i; i.parent = a;
		i.left = j; j.parent = i;
		i.right = o; o.parent = i;
		j.right = k; k.parent = j;
		o.right = p; p.parent = o;
		k.right = n; n.parent = k;
		k.left = l; l.parent = k;
		l.right = m; m.parent = l;
		
		d.childrenCount = 0;
		e.childrenCount = 0;
		c.childrenCount = 2;
		b.childrenCount = 6;
		f.childrenCount = 2;
		g.childrenCount = 1;
		h.childrenCount = 0;
		l.childrenCount = 1;
		m.childrenCount = 0;
		n.childrenCount = 0;
		k.childrenCount = 3;
		j.childrenCount = 4;
		o.childrenCount = 1;
		p.childrenCount = 0;
		i.childrenCount = 7;
		a.childrenCount = 15;
		
		return a;
	}
	
	
	public static TreeNode getSymmetricTree() {
		TreeNode a = new TreeNode("a", 314);
		TreeNode b = new TreeNode("b", 6);
		TreeNode c = new TreeNode("c", 2);
		TreeNode d = new TreeNode("d", 3);
		TreeNode e = new TreeNode("e", 6);
		TreeNode f = new TreeNode("f", 2);
		TreeNode g = new TreeNode("g", 3);
		
		a.left = b;
		a.right = e;
		b.right = c;
		e.left = f;
		c.right = d;
		f.left = g;
		return a;
	}
	
	public static TreeNode getBinaryTree() {
		TreeNode a = new TreeNode("a", 1);
		TreeNode b = new TreeNode("b", 0);
		TreeNode c = new TreeNode("c", 0);
		TreeNode d = new TreeNode("d", 0);
		TreeNode e = new TreeNode("e", 1);
		TreeNode f = new TreeNode("f", 1);
		TreeNode g = new TreeNode("g", 1);
		TreeNode h = new TreeNode("h", 1);
		TreeNode i = new TreeNode("i", 1);
		TreeNode j = new TreeNode("j", 0);
		TreeNode k = new TreeNode("k", 0);
		TreeNode l = new TreeNode("l", 1);
		TreeNode m = new TreeNode("m", 1);
		TreeNode n = new TreeNode("n", 0);
		TreeNode o = new TreeNode("o", 0);
		TreeNode p = new TreeNode("p", 0);
		
		a.left = b;  b.parent = a;
		b.left = c;  c.parent = b;
		c.left = d;	 d.parent = c;
		c.right = e; e.parent = c;
		b.right = f; f.parent = b;
		f.right = g; g.parent = f;
		g.left = h; h.parent = g;
		a.right = i; i.parent = a;
		i.left = j; j.parent = i;
		i.right = o; o.parent = i;
		j.right = k; k.parent = j;
		o.right = p; p.parent = o;
		k.right = n; n.parent = k;
		k.left = l; l.parent = k;
		l.right = m; m.parent = l;
		
		return a;
	}
}
