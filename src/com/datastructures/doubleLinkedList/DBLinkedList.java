package com.datastructures.doubleLinkedList;

public class DBLinkedList {
	DBNode head;
	
	/*
	 * I'm going to insert a value in the linked list at the beginning of the list
	 * 1) set newnode.next to old head node
	 * 2) set newnode.prev to null, its at the beginging its not pointing to anything
	 * 3) set old head.prev to newNode (to connect the oldhead back to the newNode)
	 * 4) point head to newNode
	 */
	public void insertAtBeginning(int value) {
		DBNode newNode = new DBNode(value);
		
		if(head == null) {
			head = newNode;
			return;
		}
		
		newNode.next = head;
		newNode.previous = null;
		head.previous = newNode;
		
		head = newNode;
		
	}
	/*
	 * just like the single linked list
	 * Pre* make sure the node is not empty, if yes set head to newNode
	 * Pre* initalize the new node
	 * 1) loop until you reach the last node
	 * 2) lastNode.next = newNode
	 * 3)newNode.next = null
	 * 4)newNode.previous = lastNode
	 * 
	 */
	public void insertAtEnd(int value) {
		DBNode newNode = new DBNode(value);
		if(head == null) {
			head = newNode;
			return;
		}
		
		DBNode current = head;
		
		while(current.next != null) {
			current = current.next; //i want the last element, which is a element where next is null
		}
		
		current.next = newNode;
		newNode.previous = current;
		newNode.next = null;
		
	}
	
	/*
	 * Similiar as single linked list
	 * Pre*: i want the value before the position
	 * newNode.next = positionNode.next
	 * newNode.prev = positionNode
	 * positionNode.next = newNode
	 * 
	 * remember linkedlist is not 0 indexed, it starts at 1
	 */
	public void insertAtPosition(int value,int pos) {
		DBNode newNode = new DBNode(value);
		int cnt = 1;
		
		if(head == null && pos == 1) {
			head = newNode;
			return;
		}
		
		if(pos == 1) { //if position is at the beginning
			newNode.previous = null; //the newNode previous is null
			newNode.next = head; //the newNode.next is the old head
			head.previous = newNode; //head.previous is now the newNode
			head = newNode; //reset the head as the newNode
			return;
		}
		
		DBNode current = head;
		DBNode previous = null;
		
		while(current != null && cnt < pos) {
			cnt++; //increaring the pointer 
			previous = current;
			current = current.next; //moving to the next current
		}
		//if the position and cnt are the same insert, i now have the node before the insert index
		if(pos == cnt) {
			newNode.next = current;
			newNode.previous = previous;
			current.previous = newNode;
			previous.next = newNode;
		}
	}
	
	/*
	 * deleting the first node in a linked list
	 */
	public void deleteFirstNode() {
		head = head.next;
		head.previous = null;
	}
	
	/*
	 * deleting the last node in a linked list
	 */
	public void deleteLastNode() {
		if(head == null) {
			return;
		}
		
		
		DBNode current = head;
		DBNode previous = null;
		while(current.next != null) { //i dont want the last current to be null, so thats why i use current.next
			previous = current; //the value before the last
			current = current.next;
		}
		
		previous.next = current.next;
	}
	
	/*
	 * delete at a specific index
	 */
	public void deleteAtIndex(int pos) {
		int cnt = 1;
		if(head == null) {
			return;
		}
		
		if(pos == 1) {
			head = head.next;
			head.previous = null;
		}
		
		DBNode current = head;
		DBNode previous = null;
		
		while(current.next != null && cnt < pos) {
			cnt++;
			previous = current;
			current = current.next;
		}
		
		if(pos == cnt) {
			previous.next = current.next;
			current.next.previous = previous;
		}
		
		
	}
	
	public void printList() {
		DBNode current = head;
		
		while(current != null) {
			System.out.print(current.val+",");
			current = current.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		DBLinkedList bd = new DBLinkedList();
		bd.insertAtBeginning(45);
		bd.insertAtBeginning(22);
		bd.insertAtBeginning(33);
		bd.insertAtBeginning(32);
		bd.insertAtEnd(98);
		bd.insertAtEnd(99);
		bd.insertAtEnd(100);
		bd.insertAtPosition(1995,2);
		bd.printList();
		bd.deleteFirstNode();
		bd.deleteFirstNode();
		bd.deleteLastNode();
		bd.deleteLastNode();
		bd.printList();
		bd.deleteAtIndex(3);
		bd.printList();

	}

}
