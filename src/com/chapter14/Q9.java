package com.chapter14;

/*
 * Implement a fast sorting algorithm for linked lists.  It should be stable
 * 
 * Merge sort for linkedlist. o[n log n] and o[1] space because merging can be done in place for linkedlist. 
 * We should use recursion for this . log n levels. 
 * No memory is explicitly allocated. space complexity is o[log n] for the recursion.
 * 
 * 
 * 
 * 
 * o[n 2] with o[1] space can be done for linkedlists. 
 */
public class Q9 {

	public static void main(String[] args) {
		
	}

	/*
	 * go through once and get the least. 
	 * Swap the least with the head.
	 * remove the head and add it to the result.
	 */
//	public void sortInAsc(ListNode<Integer> head) {
//		// find the smallest node in and have it as head. iterate till the tail. 
//		ListNode<Integer> dummyHead = new ListNode<>(0);
//		
//		ListNode<Integer> current = head;
//		
//		/*
//		 * every time find the least node. 
//		 * Remove the least node from  current one. 
//		 * add it to the result.
//		 */
//		
//		
//		
//	}
	
	
//	private ListNode<Integer> getLeast(ListNode<Integer> currentHead) {
//		ListNode<Integer> least = currentHead;
//		
//		while (currentHead != null) {
//			if (least > currentHead.data) {
//				least = currentHead;
//			}
//		}
//	}
//	
	
	/*
	 * The sublist consisiting of nodes upto and including the iterator, is sorted in inceasing order. We need to ensure that after we move to next, this property
	 * continues to hold.
	 * We do this by swapping iter.next with its pre decessors in the list till its in the right place. 
	 */
	public ListNode<Integer> insertionSort(final ListNode<Integer> l) {
		ListNode<Integer> iter = l;
		ListNode<Integer> dummyHead = new ListNode<>(0);
		
		while (iter != null && iter.next != null) {
			if (iter.data <= iter.next.data) {
				iter = iter.next;
			} 
			// go through the list node and find value smaller than iter.data.
			
			ListNode<Integer> target = iter.next;
			ListNode<Integer> pre = dummyHead;
			
			while (pre.next.data < target.data) {
				pre = pre.next;
			}
			
			ListNode<Integer> temp = pre.next;
			pre.next = target;
			target.next = temp;
			iter.next = iter.next.next;
		}
		return  dummyHead.next;
	}
}


class ListNode<T> {
	T data;
	ListNode<T> next;
	
	ListNode(T data) {
		this.data = data;
	}
}