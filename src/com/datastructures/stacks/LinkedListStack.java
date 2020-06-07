package com.datastructures.stacks;

import com.datastructures.linkedlist.Node;

public class LinkedListStack {
		
		Node head;
		/*
		 * push: is where you add an element to the top of the stack
		 * for the linkedlist, if linkedlist is null create a new node
		 * if not add it to the head of the list
		 */
		public void  push(int data) {
			Node newNode = new Node(data); //created a new node
			if(head == null) { //if its null
				head = newNode; //create a new node and thats it
				return;
			}
			else {
				newNode.next = head; //assigning the next node to head
				head = newNode;
			}
		}
		
		/*
		 * pop: skip over the first element in the linked list
		 */
		public void pop() {
			head = head.next;
		}
		
		/*
		 * isEmpty(): checking if the linked list is emptyu
		 */
		public boolean isEmpty() {
			return head == null;
		}
		
		/*
		 * return the top data from the linklist
		 */
		public int top() {
			return head.data;
		}
		
		public void printList() {
			Node current = head;
			
			while(current != null) {
				System.out.println(current.data);
				current = current.next;
			}
		}

	public static void main(String[] args) {
		LinkedListStack obj = new LinkedListStack();
		obj.push(1);
		obj.printList();
		System.out.println("-----------");
		obj.push(2);
		obj.push(3);
		obj.push(4);
		obj.printList();
		System.out.println("-----------");
		System.out.println(obj.top());
		System.out.println("-----------");
		obj.pop();
		obj.pop();
		obj.printList();
		
	}

}
