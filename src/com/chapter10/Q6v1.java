package com.chapter10;

import java.util.ArrayList;
import java.util.List;

public class Q6v1 {

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
		
		
		Q6v1 q = new Q6v1();
		
		List<ArrayList<TreeNode>> result = new ArrayList<>();
		q.populateAllPaths(a, 619, result, new ArrayList<>());
		
		for(ArrayList<TreeNode> list: result) {
			System.out.println();;
			for(TreeNode tNode: list) {
				System.out.print(tNode + ",");
			}
		}
	}
	
	/*
	 * Get all the paths whose weights is equal to s
	 */
	public void populateAllPaths(TreeNode node, int sum, List<ArrayList<TreeNode>> result, ArrayList<TreeNode> local) {
		if (node == null) {
			return;
		}
		
		local.add(node);
		sum -= node.data;
		
		if (node.left == null && node.right == null) {
			if (sum == 0) {
				result.add(new ArrayList<>(local));
			}
			sum += node.data;
			local.remove(local.size() - 1);
			return;
		} 
		
		if (node.left != null) {
			populateAllPaths(node.left, sum, result, local);
		}
		
		if (node.right != null) {
			populateAllPaths(node.right, sum, result, local);
		}
		local.remove(local.size() - 1);
		sum += node.data;
	}
	

}
