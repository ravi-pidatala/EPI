package com.chapter10.revision;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import com.chapter10.TreeNode;
import com.chapter10.TreeUtil;

public class Q7 {

	public static void main(String[] args) {
		TreeNode root = TreeUtil.getBinaryTree();
		
		Q7 q = new Q7();
		q.inOrderRecursion(root);
		System.out.println("");
		q.inOrderTraversal(root);
		System.out.println("");
		
		q.inOrderBTree(root);
		
		
		System.out.println("");
//		Stack<TreeNode> stack = new Stack<>();
//		stack.push(root);
//		q.inOder(stack);
		
	}
	
	/*
	 * Implement an inorder traversal without recursion.
	 * left, current, right
	 */
	void inOrderRecursion(TreeNode node) {
		if (node != null) {
			inOrderRecursion(node.left);
			System.out.print(node.s + ",");
			inOrderRecursion(node.right);
		}
	}
	
	/*
	 * Use iteration. 
	 * 
	 * have a stack ??? 
	 * Stack will save the node and goes to the left node. 
	 * if left node is not null, save the left node,
	 * if left node is null, print current node, remove the current node, add right node.
	 * if right also null, proceed with node on stack
	 * 
	 * Should have visited flag. or have a map of visited nodes.
	 * 
	 * 
	 */
	void inOrderTraversal(TreeNode root) {
		Stack<TreeNode> helperStack = new Stack<>();
		Set<TreeNode> visited = new HashSet<>();
		
		if (root != null) {
			helperStack.add(root);
			inOder(helperStack, visited);
		}
	}
	
	/*
	 * for visited set => o[n] space.
	 * For stack [h] space.
	 */
	private void inOder(Stack<TreeNode> stack, Set<TreeNode> visited) {
		
		while (!stack.isEmpty()) {
			TreeNode node = stack.peek();

			if (node.left != null && !visited.contains(node.left)) {
				stack.add(node.left);
				continue;
			}  
			
			// print the current node and remove it from stack.
			System.out.print(node.s + ",");
			visited.add(node);
			stack.pop();
			
			
			if (node.right != null && !visited.contains(node.right)) {
				stack.add(node.right);
			}
		}
	}
	
	
	/*
	 *  It can be implemented without saving the visited feild.
	 *  
	 *  if it has left child, add left child to stack.
	 *  if no left child, print current one. remove current from stack.
	 *  If right child, add right child to stack and print current one. Remove current from stack.m
	 *  if current one printed is left child of parent, 
	 *  
	 *  
	 *  
	 *  If going up from left child, 
	 *  If going up from right child, do not go to parent. go to its parent's parent till current is left child of parent. 
	 *  
	 *  If popping from the stack , it means , current and left subtree already processed. Check if right exists. Do not check for left again. 
	 *   So if current is null,  from the stack go right. 
	 *   If current is not null, push the current to the stack and go left . if current is null
	 *   get the one from the stack. print it. go right.
	 *   
	 *   No need of visited feild. 
	 *  
	 */
	public List<TreeNode> inOrderBTree(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		List<TreeNode> result = new ArrayList<>();
		TreeNode curr = root;
		
		while (!stack.isEmpty() || curr != null) {
			if (curr != null) {
				stack.push(curr);
				curr = curr.left;
			} else {
				
				//going up
				curr = stack.pop();
				result.add(curr);
				System.out.print(curr.s + ",");
				
				curr = curr.right;
			}
		}
		return result;
	}
 	
	private void inOder(Stack<TreeNode> stack) {
		
		while (!stack.isEmpty()) {
			TreeNode node = stack.peek();

			if (node.left != null) {
				stack.add(node.left);
				continue;
			}  
			
			// print the current node and remove it from stack.
			System.out.print(node.s + ",");
			//visited.add(node);
			stack.pop();
			node = stack.peek();
			
			
			if (node.right != null) {
				stack.add(node.right);
			}
		}
	}
	
	

}
