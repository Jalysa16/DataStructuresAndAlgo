package com.datastructures.queues;

import java.util.*;

public class Queues {
	//this is where you store elements
	private List<Integer> data;
	
	//pointer with in stack
	private int starterPnt;
	
	public Queues() {
		data = new ArrayList<Integer>();
		starterPnt = 0;
	}
	
	/*
	 * checks if the queue is empty
	 */
	public boolean isEmpty() {
		return starterPnt >= data.size();
	}
	
	/*
	 * this is the method that adds elements to the back of the array list
	 */
	public boolean enQueue(int x) {
		data.add(x);
		return true;
	}
	
	/*
	 * this is the method that removes elements to the front of the array list
	 */
	public boolean deQueue() {
		if(isEmpty()) {
			return false;
		}
		starterPnt++;
		return true;
	}
	
	/*
	 * this returns the front value from the list
	 */
	public int front() {
		return data.get(starterPnt);
	}
	
	/*
	 * print the queue
	 */
	public void printList() {
		for(int i = starterPnt; i < data.size(); i++) {
			System.out.print(data.get(i)+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Queues obj =  new Queues();
		obj.enQueue(34);
		obj.enQueue(44);
		obj.enQueue(21);
		obj.enQueue(89);
		obj.printList();
		obj.deQueue();
		obj.deQueue();
		obj.printList();
	}
}
