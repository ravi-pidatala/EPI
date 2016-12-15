package com.chapter10;

import java.util.ArrayList;
import java.util.List;

public class Q6 {

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
		
		Q6 q = new Q6();
		
		List<TreeNode> path = new ArrayList<>();
		
		if (q.rootToLeafSp(a, path, 580)) {
			for(TreeNode node: path) {
				System.out.print(node + ",");
			}
		}
		
	}
	
	private boolean rootToLeafSp(TreeNode node, List<TreeNode> result, int sum) {
		if (node == null) {
			return false;
		}
		sum -= node.data;
		result.add(node);
		
		// base case
		if (node.left == null && node.right == null) {
			if (sum == 0) {
				return true;
			} 
			result.remove(result.size() - 1);
			sum += node.data;
			return false;
		}
		
		if (node.left != null) {
			if (rootToLeafSp(node.left, result, sum)) {
				return true;
			}
		}
		
		if (node.right != null) {
			if (rootToLeafSp(node.right, result, sum)) {
				return true;
			}
		}
		result.remove(result.size() - 1);
		sum += node.data;
		return false;
	}

}
