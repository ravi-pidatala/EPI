package com.chapter10;

import java.util.Stack;

public class Q7 {

	public static void main(String[] args) {
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
		
		a.left = b;
		b.left = c;
		c.left = d;
		c.right = e;
		b.right = f;
		f.right = g;
		g.left = h;
		a.right = i;
		i.left = j;
		i.right = o;
		j.right = k;
		o.right = p;
		k.right = n;
		k.left = l;
		l.right = m;
		
		Q7 q = new Q7();
		q.inOrder(a);// d, c, e, b, f, h, g, 
		
	}
	
	/*
	 * in order traversal without recursion
	 */
	private void inOrder(TreeNode root) {
		Stack<TreeNode> s = new Stack<>();
		s.push(root);
		TreeNode n = null;
		while (!s.isEmpty()) {
			n = s.peek();

			if (n.left != null && !n.left.visited) {
				s.push(n.left);
				continue;
			}

			System.out.print(n + ",");
			n.visited = true;
			s.pop();

			if (n.right != null && !n.right.visited) {
				s.push(n.right);
			}
		}
	}

}
