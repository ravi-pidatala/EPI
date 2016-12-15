package com.chapter10.revision;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.chapter10.TreeNode;
import com.chapter10.TreeUtil;

public class Q11v1 {

	public static void main(String[] args) {
		TreeNode root = TreeUtil.getBinaryTree();
		Q11v1 q = new Q11v1();
		List<TreeNode> result1 = new ArrayList<>();
		List<TreeNode> result2 = new ArrayList<>();
		List<TreeNode> postOrder = new ArrayList<>();
		List<TreeNode> postOrderIter = new ArrayList<>();
		
		q.preOrderIterative(root, result1);
		q.preOrderIterative(root, result2);
		
		for (TreeNode node: result1) {
			System.out.print(node.s + ",");
		}
		System.out.println("");
		for (TreeNode node: result2) {
			System.out.print(node.s + ",");
		}
		
		q.postOrderRecursion(root, postOrder);
		
		System.out.println("");
		for (TreeNode node: postOrder) {
			System.out.print(node.s + ",");
		}
		
		
		q.postOrderIter(root, postOrderIter);
		System.out.println("");
		for (TreeNode node: postOrderIter) {
			System.out.print(node.s + ",");
		}
		
	}
	
	/*
	 * Pre order and post order traversal iteratively using o[1]  space
	 */
	void preOrderIterative(TreeNode root, List<TreeNode> path) {
		// current , left, right
		
		
		/*
		 * add the current one to result.
		 * go to left. 
		 * Current, right left add to stack.
		 * Use stack to do it. 
		 * stack space is o[h] ????
		 * 
		 * Nodes in the stack correspond to right children of the node popped from stack
		 */
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if (node == null) {
				continue;
			}
			path.add(node);
			stack.push(node.right);
			stack.push(node.left);
		}
	}
	
	void preOrderIterativeWithParentPointer(TreeNode root, List<TreeNode> path) {
		/*
		 * current, left, right. 
		 * 
		 * if the current node has left child , proceed to left.
		 * if current Node has right child, proceed to right.
		 *  
		 *  If going up from left node to parent, check for right node of parent. 
		 *  If going up from right node to parent, continue going up.
		 *  
		 *  prev pointer is necessary. 
		 */
		
		TreeNode current = root;
		TreeNode prev = null;
		TreeNode next = null;
		
		/*
		 * a, b, c, d, e, f, g, h, 
		 * 
		 * current is c, prev is d
		 * e, prev is c
		 * curr is c. prev is e
		 */
		while (current != null) {
			
			// came from left child to parent. check and go right. Else go up
			// do not add parent again to answer.
			if (current.left == prev) {
				if (current.right != null) {
					next = current.right;
				} else {
					next = current.parent;
				}
				continue;
			} else if (current.right == prev) {
				/*
				 * came from right child to parent
				 */
				// go up.
				next = current.parent;
				
			} else {
				path.add(current);
				
				if (current.left != null) {
					next = current.left;
				} else if (current.right != null){
					next = current.right;
				} else {
					next = current.parent;
				}
			}
			prev = current;
			current = next;
		}
	}
	
	
	void postOrderIterative(TreeNode root, List<TreeNode> path) {
		/*
		 * Nodes have parent pointers. 
		 * o[1] space.
		 * left, right, current. 
		 * 
		 * 
		 * Know if i am going up from right child or left child. 
		 * if going up from left child,check for right child. 
		 * If going up from right child, process the current and go up.
		 */
		TreeNode current = root;
		TreeNode prev = null;
		TreeNode next = null;
		
		while (current != null) {
			
			// check if i am going up from left child.
			if (current.parent != null && current.parent.rig)
			
			
			
			
		}
		
		
	}
	
	void postOrderRecursion(TreeNode node, List<TreeNode> path) {
		// left, right, current.
		
		if (node != null) {
			postOrderRecursion(node.left, path);
			postOrderRecursion(node.right, path);
			path.add(node);
		}
	}
	
	
	/*
	 * left, right, current.
	 * so add them in reverse order in stack.
	 * 
	 * We solved in order traversal as current, left, right iteratively. 
	 * Use above to solve this. 
	 * i.e. get solution for current, right, left and reverse it. i.e. use two stacks.
	 * 
	 * Post order iterator using two stacks.
	 * If only one stack need to be used , reverse the result obtained by using one stack. 
	 * 
	 */
	void postOrderIter(TreeNode root, List<TreeNode> path) {
		
		
		Stack<TreeNode> temp = new Stack<>();
		Stack<TreeNode> resultStack = new Stack<>();
		
		temp.push(root);
		
		while (!temp.isEmpty()) {
			TreeNode node = temp.pop();
			if (node != null) {
				resultStack.add(node);
				temp.push(node.left);
				temp.push(node.right);
			}
			
		}

		// result stack has entries current, right, left in reverse order i.e. left, right, current
		// add the stack result into list.
		while (!resultStack.isEmpty()) {
			path.add(resultStack.pop());
		}
		
	}

}
