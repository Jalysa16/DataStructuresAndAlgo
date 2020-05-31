package com.datastructures.linkedlist;

import java.util.*;

public class LinkedListPracticeProblems {
	/*
	 * in this problem, im want to find the nth node from the right
	 * !!! this is the brute force attempt !!!!!!
	 * 1) find the length of the linked list
	 * 2)length - (pos-1) is the left version position
	 * 3)traverse until you get that node
	 * 4) return that node
	 */
	public int returnNthNodeFromRight(Node head,int pos) {
		Node current = head;
		int cnt = 0;
		
		if(head == null) {
			return -1;
		}
		
		while(current != null) {
			cnt++;
			current = current.next;
		}
		
		int position = cnt - (pos-1);
		
		if(position < 0) {
			return -1;
		}
		
		current = head;
		cnt = 1;
		
		while(current != null && cnt < position) {
			cnt++;
			current = current.next;
		}
		
		if(cnt == position) {
			return current.data;
		}
		
		
		
		return -1;
	}
	
	/*
	 * traverse through the linkedlist and store it in a list. 
	 *  
	 */
	public int returnNthPositionFromRightPt2(Node head, int pos) {
		Node current = head;
		List<Integer> list = new ArrayList<Integer>();
		
		if(head == null) {
			return -1;
		}
		
		while(current != null) {
			list.add(current.data);
			current = current.next;
		}
		
		int index = list.size() - pos;
		
		if(index < list.size() && index >= 0) {
			return list.get(index);
		}
		return -1;
	}
	
	public Node insert(Node head,int val) {
		Node newNode = new Node(val);
		
		if(head == null) {
			head = newNode;
			return head;
		}
		
		Node current = head;
		
		while(current.next != null) {
			current = current.next;
		}
		
		current.next = newNode;
		
		return head;
	}
	
	
	public Node reverseTheList(Node head) {
		Node prev = null;
		Node current = head;
		Node next = null;
		
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		
		
		return prev;
	}
	
	public Node reverseByDigit(Node head,int digit) {
		 //step 1) i need to find all the nodes i need to reverse 
		 
		 Node nodesToBeRev = head;
		 Node nodesReversed = null, finalNodeList = null, tail = null;
		 
		 while(nodesToBeRev != null) {
		 
		int cnt = 0;
		 nodesToBeRev = head;
		 
		 while(nodesToBeRev != null && cnt < digit) {
			 cnt++;
			 nodesToBeRev = nodesToBeRev.next;
		 }
		 
		//yes there are enough nodes to be reversed
		 if(cnt == digit) {
			 nodesReversed = reverseNodes(head,digit);
		 
		 
		 if(finalNodeList == null) {
			 finalNodeList = nodesReversed;
		 }
		 
		 if(tail != null) {
			 tail.next = nodesReversed;
		 }
		 
		 tail = head;
		 head = nodesToBeRev;
		 }
		 
		 }
		 
		 if(tail != null) {
			 tail.next = head;
		 }
		 
		 if(finalNodeList == null) {
			 return head;
		 }else {
			 return finalNodeList;
		 }
		 
	 }
	 
	 public Node reverseNodes(Node head,int digit) {
		 Node current = head;
		 Node next = null, previous = null;
		 while(digit > 0) {
			 next = current.next;
			 current.next = previous;
			 previous = current;
			 current = next;
			 digit --;
		 }
		 return previous;
	 }
	            
	
	public void printlnList(Node head) {
		Node current = head;
		
		if(head ==  null) {
			return;
		}
		
		while(current != null) {
			System.out.print(current.data+",");
			current = current.next;
		}
		
		System.out.println();
	}

	public static void main(String[] args) {
		Node h = null, k = null;
		LinkedListPracticeProblems obj = new LinkedListPracticeProblems();
		h  = obj.insert(h,1);
		h = obj.insert(h,2);
		h = obj.insert(h,3);
		h = obj.insert(h,4);
		h = obj.insert(h,5);
		k = h ;
		
		obj.printlnList(h);
		System.out.println("--------------------------------");
		h = obj.reverseByDigit(h,2);
		obj.printlnList(h);
		int x = -129;
		int y = -129;
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(x);
		list.add(y);
		
		System.out.println(list.get(0).equals(list.get(1)));
		
	}

}
