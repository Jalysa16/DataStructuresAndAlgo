package com.datastructures.circleLinkedList;

public class CRLLinkedList {
	CRLNode head;
	
	/*
	 * Counting the number of linked list nodes
	 * Will keep traversing the linked list, until current once again equals the value of the head
	 */
	public int countLinkedList() {
		int cnt = 0;
		
		if(head == null) {
			return cnt;
		}
		CRLNode current = head;
		
		do {
			current = current.next;
			cnt++;
		}while(current != head);
		
		return cnt;
	}
	
	/*
	 * its the same as counting all the nodes
	 */
	public void printList() {
		if(head == null) {
			return;
		}
		
		CRLNode current = head;
		
		do {
			System.out.print(current.value+",");
			current = current.next;
		}while(current != head);
		
		System.out.println();
		
		
	}
	
	/*
	 * inserting a node at the end
	 * 1) create a new node with value
	 * 2) set newNode.next to be the head value
	 * 3) traverse the list until you get the last node
	 * 4) set that lastnode.next to the new node
	 */
	
	public void insertNodeAtEnd(int value) {
		CRLNode node = new CRLNode(value);
		
		if(head == null) {
			head = node;
			head.next = head;
			return;
		}
		
		node.next = head;
		CRLNode current = head;
		
		while(current.next != head) { //the linked list is never null, but we need to make sure its not head
			current = current.next;
		}
		
		current.next = node;
		
		
	}
	
	/*
	 * inserting at the beginning
	 * 1) create a new node
	 * 2) if the head is null, just assign it the value of the newNode
	 * 3) if not, newNode.next should point to old head
	 * 4) traverse through the list and get the last node
	 * 5) set the lastNode.next to the newNode
	 * 6) update the head pointer to newNode
	 */
	
	public void insertAtBegininng(int value) {
		CRLNode newNode = new CRLNode(value);
		
		if(head == null) {
			head = newNode;
			head.next = head;
			return;
		}
		
		newNode.next = head;
		
		CRLNode current = head;
		
		while(current.next != head) {
			current = current.next;
		}
		
		current.next = newNode;
		head = newNode;
	}
	
	/*
	 * Deleting the last node in a circular linked list
	 * 1)if head is null, return nothing (nothing to delete)
	 * 2)create a current pointing to head, create another pointer for previous 
	 * 3) i need the last node and the one before it
	 * 4) once i get it, set previous.next = current.next
	 */
	
	public void deleteLastNode() {
		if(head == null) {
			return;
		}
		
		CRLNode previous = null;
		CRLNode current = head;
		
		while(current.next != head) {
			previous = current; //the one before
			current = current.next; //the one after
		}
		
		//now that i have the last node
		previous.next = current.next; //which is head
	}
	
	/*
	 * Deleting the first node
	 * 1)get the tail node
	 * 2) point the tail node.next to the head.next
	 * 3)update the head value
	 */
	public void deleteFirstNode() {
		if(head == null) {
			return;
		}
		
		CRLNode current = head;
		while(current.next != head) {
			current = current.next;
		}
		
		current.next = head.next;
		head = head.next;
	}

	public static void main(String[] args) {
		CRLLinkedList obj = new CRLLinkedList();
		obj.insertAtBegininng(12);
		obj.insertAtBegininng(32);
		obj.insertAtBegininng(45);
		obj.insertNodeAtEnd(100);
		obj.insertNodeAtEnd(500);
		obj.printList();
		obj.deleteFirstNode();
		obj.printList();
		obj.deleteLastNode();
		obj.printList();
		System.out.println(obj.countLinkedList());
		

	}

}
