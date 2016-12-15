package com.chapter10;

/*
 * Compute the lowest common ancestor Given two nodes in a binary tree.
 * Check if the nodes exist in the binary tree. 
 * if both nodes exist under, return LCA.
 * if one node exist return the node.
 * if right returns a node and left returns another node, current node is LCA.
 * 
 */
public class Q3 {
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
	
		Q3 q = new Q3();
		System.out.println(q.getLCA(a, e, g).s);
		System.out.println(q.getLCA2(a, e, g).s);
	}
/*
	Check if a is present in left
	Check if b is present in right
	both true or both false, return currentNode.
	Below is Brute force method.

*/
	private TreeNode getLCA(TreeNode node, TreeNode a, TreeNode b) {

		if (node == null) {
			return null;
		}
		
		if (node == a || node == b) {
			return node;
		}

		boolean leftA = check(node.left, a);
		boolean rightB = check(node.right, b);

		if (leftA == rightB) {
			return node;
		}

		if (leftA) {
			return getLCA(node.left, a, b);
		} else {
			return getLCA(node.right, a, b);
		}
	}

	/*
	instead of returning boolean , if both are present return LCA.
	if one is present return the found one.
	Assumes that nodes are present in tree.
	*/
	private TreeNode getLCA2(TreeNode node, TreeNode a, TreeNode b) {

		if (node == a && node == b) {
			return node;
		}
		if (node == null) {
			return null;
		}

		// check in left.
		TreeNode left = getLCA2(node.left, a , b);

		if (left != null && left != a && left != b) {
			return left;
		}
		TreeNode right = getLCA2(node.right, a, b);
		
		if (right != null &&  right != a && right != b) {
			return right;
		}
		
		if (right == null) {
			return left;
		}
		if (left == null) {
			return right;
		}
		
//		if (node == a || node == b) {
//			return node;
//		}
		return node; 
	}

	/*
	checks if a is present under n
	*/
	private boolean check(TreeNode n, TreeNode a) {
		if (n == null) {
			return false;
		} 
		if (n == a) {
			return true;
		}

		return check(n.left, a) || check(n.right, a);
	}
	
	private Status getLCAStatus(TreeNode node, TreeNode a, TreeNode b) {
		if (node == null) {
			return new Status(null, 0);
		}
		
		Status left = getLCAStatus(node.left, a, b);
		if (left.numberOfNodes == 2) {
			return left;// found ancestor
		}
		
		Status right = getLCAStatus(node.right, a, b);
		if (right.numberOfNodes == 2) {
			return right;
		}
		return new Status(node, right.numberOfNodes + left.numberOfNodes + (node == a ? 1: 0) + (node == b ? 1:0));
	}
}

class Status {
	int numberOfNodes;
	TreeNode node;
	
	Status(TreeNode node, int numberOfNodes) {
		this.node = node;
		this.numberOfNodes =numberOfNodes;
	}
}