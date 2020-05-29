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
		Node h = null;
		LinkedListPracticeProblems obj = new LinkedListPracticeProblems();
		h  = obj.insert(h,12);
		h = obj.insert(h,14);
		h = obj.insert(h, 20);
		h = obj.insert(h, 34);
		h = obj.insert(h, 26);
		obj.printlnList(h);
		
		System.out.println(obj.returnNthPositionFromRightPt2(h, 5));
		obj.printlnList(h);

	}

}
