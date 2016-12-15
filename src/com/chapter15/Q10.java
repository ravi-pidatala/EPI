package com.chapter15;

import com.chapter10.TreeNode;

public class Q10 {

	public static void main(String[] args) {
		
	}
	
	/*
	 * Insertion and deletion in a BST.
	 * design efficient functions for inserting and deleting keys from BST. Assume all elements in BST are unique and insertion must preserve this property.
	 */
	boolean insertToBst(TreeNode root, TreeNode node) {
		/*
		 * insert always at leaf . o[h] time.
		 * if node found with same value, return false. 
		 */
		
		
		
		
		
		
		
	}
	
	
	boolean deleteNode(TreeNode root, TreeNode node) {
		/*
		 * if node is leaf, delete it.i.e. make parent's child as null.
		 * 
		 * if node one child only, delete the node and put it in its parent's place.
		 * 
		 * If node has both children. the replacement node is leftmost child of right child.i.e. in order successor of right child node.
		 * Get the data from in order successor , change the data of node to be deleted to this. delete the in order successor node.
		 */
		
		TreeNode parent = null;
		TreeNode temp = root;
		
		while (temp != null) {
			if (temp.data > node.data) {
				// go left.
				parent = temp;
				temp = temp.left;
			} else if (temp.data == node.data) {
				// found node to be deleted. 
				
				// node has no children.
				if (temp.left == null && temp.right == null) {
					if (parent == null) {// only root node present in the tree. delete it.
						root = null;
						return true;
					}
					if (temp == parent.left) {
						parent.left = null;
					} else {
						parent.right = null;
					}
					return true;
				} else if (temp.left == null || temp.right == null) {
					TreeNode nodeToInsert = (temp.left == null ? temp.right: temp.left);
					
					if (temp == parent.left) {
						parent.left = nodeToInsert;
					} else {
						parent.right = nodeToInsert;
					}
				} else {
					/*
					 *  two children. get the in order successor.get its data, modify the current data .Remove the in order successor node.
					 */
					
					TreeNode inOrderSuccessorParent = null;
					TreeNode inOrderSuccessor = temp;
					
					while (inOrderSuccessor.left != null) {
						inOrderSuccessorParent = inOrderSuccessor;
						inOrderSuccessor = inOrderSuccessor.left;
					}
					
					temp.data = inOrderSuccessor.data;
					inOrderSuccessorParent.left = inOrderSuccessor.right;
					return true;
				}
				
			} else {
				// gp right 
				parent = temp;
				temp = temp.right;
				
			}
		}
		return false;
	}

}
