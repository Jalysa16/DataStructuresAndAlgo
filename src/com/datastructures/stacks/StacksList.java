package com.datastructures.stacks;

import java.util.*;
/*
 * this is stack with a dynamic array. i dont need a top index or a max size
 */
public class StacksList {
	List<Object> list;
	
	public StacksList() {
		list = new ArrayList<Object>();
	}
	
	/*
	 * im checking is the list is empty
	 */
	public boolean isEmpty() {
		return list.size() == 0;
	}
	
	/*
	 * Because this is an array i just need to add an element in the list
	 */
	public void push(Object data) {
		list.add(data);
	}
	
	/*
	 * pop the top element from the array list
	 */
	public Object pop() {
		if(!isEmpty()) { //if the arraylist is not emptyu
			Object obj = list.get(list.size()-1);
			list.remove(list.size()-1);
			return obj;
		}else {
			System.out.println("the dynamic list is null");
			return null;
		}
	}
	
	public Object peek() {
		if(!isEmpty()) {
		return list.get(list.size()-1);
		}
		else {
			System.out.println("the list is empty");
			return null;
		}
	}
	
	public void printList() {
		int cnt = list.size()-1;
		
		if(!isEmpty()) {
		while(cnt >= 0) {
			System.out.println(list.get(cnt));
			cnt--;
		}
	}
	}
	
	public static void main(String[] args) {
		StacksList obj = new StacksList();
		obj.push("A");
		obj.printList();
		System.out.println("----------------");
		obj.push("B");
		obj.push("C");
		obj.printList();
		//System.out.println("----------------");
		
	}
}
