package com.chapter10.revision;

import com.chapter10.TreeNode;

public class Q17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * implement locking in a binary tree.
	 * A node's state can not be set to lock if any of the descendants or ancestors are in lock.
	 * 
	 * Each node has a parent feild.
	 * brute force => o[n] time to check for lock in descendants
	 * o[log n] time to check for ascendants.
	 * o[log n] time to lock and update the count of all its direct parents till the root.
	 * 
	 * Have a field, telling number of nodes locked in the current node and all its descendants. This will reduce the lock check to o[log n].
	 */
	
	// if node can not be locked return false;
	public boolean lock(TreeNode node) {
		if (node == null) {
			return false;
		}
		
		// check if any of descendants or parent is locked.
		if (node.locked) {
			return true;
		}
		
		if (node.lockedDescendants > 0) {
			return false;
		}
		
		// check if any of the parent is locked.
		TreeNode temp = node;
		while (temp != null) {
			if (temp.locked) {
				return false;
			}
			temp = temp.parent;
		}
		
		// now lock the current node, increase the count of locked and all of its direct parents and return true.
		temp = node;
		node.locked = true;
		
		while (temp != null) {
			temp.lockedDescendants++;
			temp = temp.parent;
		}
		
		return true;
	}
	
	// o [log n] time to update the lockedDesc count of current node and its parents.
	public boolean unlock(TreeNode node) {
		if (node.locked) {
			node.locked = false;
			TreeNode temp = node;
			
			while (temp != null) {
				temp.lockedDescendants--;
				temp = temp.parent;
			}
		}
		return true;
	}
	
	public boolean isLocked(TreeNode node) {
		return node != null ? node.locked: false;
	}

}
