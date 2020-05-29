package com.datastructures.linkedlist;

public class LinkedList {
	
	Node head;
	
	/*
	 * this is the method where im going to count the number of nodes in the list
	 */
	public int lengthList(Node head) {
		//if the node is null, return 0, there is nothing in the list
		if(head == null) {
			return 0;
		}
		
		//saving my incrementer for the linkedlist 
		int inc = 0;
		//copying over my node for me to traverse
		Node current = head;
		
		while(current != null) { //while im not at the end of the list
			inc++; //increment counter
			current = current.next; //setting the node to the next node
		}
		return inc;
	}
	
	/*
	 * inserting a new node at the beginning of a linked list
	 */
	public void insertAtBeginning(int value) {
		Node newNode = new Node(value);
		
		if(head == null) { //if head is null
			head = newNode; //give it a value
			return;
		}
		
		newNode.next = head; //new node is pointing to the old head node
		head = newNode; //new node 
		
		
	}
	
	/*
	 * inserting a new node at a particular index, linked list is NOT 0 indexed
	 */
	public void insertAtIndex(int value, int pos) {
		Node newNode = new Node(value);
		Node previous = null;
		int cnt = 1;
		
		if(head == null && pos != 1) { //what if head is null and position is not null
			return;
		}
		
		if(pos == 1) { //if im inserting at position 1, i need to just change the head and the newNode pointer
			newNode.next = head; //newNode is pointing to head
			head = newNode; //the new head pointer is pointing to newNode
			return; 
		}
		
		Node current = head;
		
		while(current != null && cnt < pos) { 
			cnt++; //increasing my pointer
			previous = current; //im storing the value before the position
			current = current.next; //im storing the value at the position
		}
		
		//previous node needs to point to the newNode
		//newNode needs to point to current
		if(cnt == pos) {
			previous.next = newNode;
			newNode.next = current;
		}
	
	}
	
	/*
	 * I want to insert a value at the end of a list
	 */
	public void insertAtEnd(int value) {
		Node newNode = new Node(value); //creating a newNode with the set value
		
		if(head == null) { //if head is empty
			head = newNode; //just assign it as newNode
		}
		
		Node current = head; //if not, create a copy of the head
		while(current.next != null) {
			current = current.next; //im going to keep updating the current node, until the current.next is null 
		}
		
		current.next = newNode; //this current.next is empty, so i am assigning it a val
	}
	
	/*
	 * I want to delete the first node in my linked list
	 */
	public void deleteHeadNode() {
		if(head == null) {
			return;
		}
		
		head = head.next;
	}
	
	/*
	 * I want to delete the last node in my linked list
	 */
	public void deleteLastNode() {
		if(head == null) {
			return;
		}
		
		Node current = head;
		Node previous = null;
		
		while(current.next != null) { //im using a current.next because i want to make im not skipping over an null node
			previous = current;
			current = current.next; //current is not null, but its ok if current.next is ok to be null
			}
		
		previous.next = current.next; //which is null, im not getting a null pointer because current is not null, only the next value
		
		
	}
	
	/*
	 * I want to delete the node at a certain index, remember linkedlist is 0 indexed
	 */
	public void deleteAtIndex(int pos) {
		int cnt = 1;
		
		if(head == null) {
			return;
		}
		
		if(pos == 1) {
			head = head.next;
		}
		
		Node current = head;
		Node previous = null;
		
		while(current.next != null && cnt < pos) { //i want to make sure my current is always not null
			cnt++;
			previous = current;
			current = current.next;
		}
		
		if(pos == cnt) {
			previous.next = current.next;
		}
		
		
	}
	
	/*
	 * I want to delete all nodes in a linked list with a certain value
	 */
	public void deleteNodeAtCertainValue(int value) {
		if(head == null) {
			return;
		}
		
		while(head.data == value) { //im removing all the data values, in the beginning of list
			head = head.next;
		}
		
		Node current = head;
		Node previous = null;
		
		while(current != null) {
			
			//keep going in list when the current.data is not equal to data
			while(current.data != value && current != null) {
				previous = current;
				current = current.next;
			}
			
			//once i break out the while loop, either current is equal to data or curent is null
			
			if(current == null) {
				return;
			}
			//when the current data is equal to the value
			previous.next = current.next;
			current = previous.next;
		}
		
		
	}
	
	
	
	public void printNodes() {
		Node current = head;
		
		while(current != null) {
			System.out.print(current.data+",");
			current = current.next;
		}
		System.out.println();
	}
	
	

	public static void main(String[] args) {
		LinkedList obj = new LinkedList();
		obj.insertAtIndex(12, 1);
		obj.insertAtBeginning(5);
		obj.insertAtIndex(7, 2);
		obj.insertAtIndex(13, 4);
		obj.insertAtEnd(45);
		obj.insertAtEnd(22);
		obj.insertAtBeginning(34);
		obj.deleteLastNode();
		obj.deleteLastNode();
		obj.deleteHeadNode(); //5,7,12,13
		obj.deleteAtIndex(3); 
		obj.deleteAtIndex(3);
		obj.insertAtBeginning(71);
		obj.insertAtEnd(71);
		obj.insertAtIndex(71, 3);
		obj.insertAtBeginning(71);
		obj.insertAtEnd(71);
		obj.printNodes();
		obj.deleteNodeAtCertainValue(71);
		obj.insertAtIndex(13, 2);
		obj.insertAtIndex(1313, 2);
		
		obj.printNodes();

	}

}
