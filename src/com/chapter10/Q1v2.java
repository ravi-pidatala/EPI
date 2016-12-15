package com.chapter10;

public class Q1v2 {

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
		a.right = i;
		b.left = c;
		b.right = f;
		c.left = d;
		c.right = e;
		f.right = g;
		g.left = h;
		i.left = j;
		i.right = o;
		o.right = p;
		j.right = k;
		k.left = l;
		k.right = n;
		l.right = m;
		
		Q1v2 q = new Q1v2();
		TreeNode result = q.getUnBalancedNode(a, 3);
		if (result.unbalanced) {
			System.out.println(result.s);
			System.out.println(result.height);
		} else {
			System.out.println("could not find unbalanced node");
		}
	}


/*	
Return node in binary tree such that node is not k balanced but all its subtrees are k balanced.

1. check if left subtree is k balanced. if  not return the result node . 
2. check if right subtree is height balanced. if not, return the result node.
3. check if right and left height balanced. if not return current node. if yes, return null.
*/

	public TreeNode getUnBalancedNode(TreeNode node, int k) {
		if (node == null) {
			return new TreeNode("z");
		}
		TreeNode left = getUnBalancedNode(node.left, k);

		if (left.unbalanced) {// left node returned node.  
			return left;
		}
		
		TreeNode right = getUnBalancedNode(node.right, k);
		if (right.unbalanced) { // right node returned.
			return right;
		}
		node.height = Math.max(left.height, right.height) + 1;
		if (Math.abs(left.height - right.height) >= k) {
			node.unbalanced = true;
		}
		return node;// if current node is not the one, it will have height of 0
	}


}


