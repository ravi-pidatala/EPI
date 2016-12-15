package com.chapter10;

import java.util.Arrays;
import java.util.List;

public class TreeTraversal {

	public static void inOrder(TreeNode n) {
		if (n != null) {
			// visit left
			inOrder(n.left);
			System.out.print(n + ",");
			inOrder(n.right);
		}
	}

	public static void preOrder(TreeNode n) {
		if (n != null) {
			System.out.print(n + ",");
			preOrder(n.left);
			preOrder(n.right);
		}
	}

	public static void postOrder(TreeNode n) {
		if (n != null) {
			postOrder(n.left);
			postOrder(n.right);
			System.out.print(n + ",");

		}
	}
	
	
	/*
	 * 											19(a)
	 * 										   /   \ 
	 * 										 7(b)   43(i)
	 * 										/ \      / \
	 * 								      3(c) 11   23  47(o)
	 * 									  / \    \    \   \
	 * 								   2(d)  5	 17    37  53(p)
	 *                                           /     / \
	 * 										    13    29  41(n)
	 *                                                 \
	 *  											    31(m)
	 */
	public static List<TreeNode> getPreOrderforBST() {
		TreeNode a = new TreeNode("a",19);
		TreeNode b = new TreeNode("b", 7);
		TreeNode c = new TreeNode("c", 3);
		TreeNode d = new TreeNode("d", 2);
		TreeNode e = new TreeNode("e", 5);
		TreeNode f = new TreeNode("f", 11);
		TreeNode g = new TreeNode("g", 17); 
		TreeNode h = new TreeNode("h", 13);
		
		TreeNode i = new TreeNode("i", 43);
		TreeNode j = new TreeNode("j", 23);
		TreeNode k = new TreeNode("k", 37);
		TreeNode l = new TreeNode("l", 29);
		TreeNode m = new TreeNode("m", 31);
		TreeNode n = new TreeNode("n", 41);
		TreeNode o = new TreeNode("o", 47);
		TreeNode p = new TreeNode("p", 53);
		
		List<TreeNode> preOrder = Arrays.asList(new TreeNode [] {a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p});
		return preOrder;
	}
	
	public static List<TreeNode> getInvalidPreOrderforBST() {
		TreeNode a = new TreeNode("a",19);
		TreeNode b = new TreeNode("b", 7);
		TreeNode c = new TreeNode("c", 3);
		TreeNode d = new TreeNode("d", 2);
		TreeNode e = new TreeNode("e", 5);TreeNode z = new TreeNode("z", 1);
		TreeNode f = new TreeNode("f", 11);
		TreeNode g = new TreeNode("g", 17); 
		TreeNode h = new TreeNode("h", 13);
		
		TreeNode i = new TreeNode("i", 43);
		TreeNode j = new TreeNode("j", 23);
		TreeNode k = new TreeNode("k", 37);
		TreeNode l = new TreeNode("l", 29);
		TreeNode m = new TreeNode("m", 31);
		TreeNode n = new TreeNode("n", 41);
		TreeNode o = new TreeNode("o", 47);
		TreeNode p = new TreeNode("p", 53);
		
		List<TreeNode> preOrder = Arrays.asList(new TreeNode [] {a, b, c, d, e, z, f, g, h, i, j, k, l, m, n, o, p});
		return preOrder;
	}
	
	
	public static List<TreeNode> getPostOrderForBst() {
		TreeNode a = new TreeNode("a",19);
		TreeNode b = new TreeNode("b", 7);
		TreeNode c = new TreeNode("c", 3);
		TreeNode d = new TreeNode("d", 2);
		TreeNode e = new TreeNode("e", 5);
		TreeNode f = new TreeNode("f", 11);
		TreeNode g = new TreeNode("g", 17); 
		TreeNode h = new TreeNode("h", 13);
		
		TreeNode i = new TreeNode("i", 43);
		TreeNode j = new TreeNode("j", 23);
		TreeNode k = new TreeNode("k", 37);
		TreeNode l = new TreeNode("l", 29);
		TreeNode m = new TreeNode("m", 31);
		TreeNode n = new TreeNode("n", 41);
		TreeNode o = new TreeNode("o", 47);
		TreeNode p = new TreeNode("p", 53);
		
		List<TreeNode> postOrder = Arrays.asList(new TreeNode [] {d, e, c, h, g, f, b, m, l, n, k, j, p, o, i, a});
		return postOrder;
	}
}
