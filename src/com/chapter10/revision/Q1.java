package com.chapter10.revision;

import com.chapter10.TreeNode;
import com.chapter10.TreeUtil;

/*
 * Test if binary tree is height balanced. 
 * Note that this can be local property. not global.
 */
public class Q1 {

	public static void main(String[] args) {
		TreeNode root = TreeUtil.getTree();
		
		Q1 q = new Q1();
		
		int height = q.isBalanced(root, 0);
		
		if (height < 0) {
			System.out.println("tree is not balanced");
		} else {
			System.out.println("tree is balanced");
		}
			
		
	}
	
	/*
	 * Use recursion.
	 * Check the height of left subtree, get height of right subtree. 
	 * if the diff in heights <= 1, current height will be maximum height of the two.
	 * 
	 * if not balanced, short circuit return false.
	 */
	int isBalanced(TreeNode node, int heightOfNode) {
		if(node == null) {// leaf node
			return 0;
		}
		int leftHeight = -1;
		int rightHeight = -1;
		
		if (node.left != null) {
			leftHeight = isBalanced(node.left, heightOfNode + 1);
			if (leftHeight == -1) {// short circuit end
				return -1;
			}
		}
		
		if (node.right != null) {
			rightHeight = isBalanced(node.right, heightOfNode + 1);
			if (rightHeight == -1) {// short circuit end
				return -1;
			}
		}
		if (Math.abs(rightHeight - leftHeight) > 1) {
			return -1;// current node is unbalanced.
		}
		
		return Math.max(leftHeight, rightHeight) + 1;
	}
	
	

}
