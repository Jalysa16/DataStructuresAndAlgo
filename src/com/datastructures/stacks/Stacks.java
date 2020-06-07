package com.datastructures.stacks;

/*
 * This is stacks implemented by array, with a fixed size
 */
public class Stacks {
	final int maxSize = 10;
	int top;
	Object[] stack = new Object[10];
	
	
	//this is the method when the stack is inialized, we set top to position -1
	public Stacks() {
		top = -1;
	}
	
	//checks if the top is pointing to index -1, if so it is empty and i have nothing in the array.
	public boolean isEmpty() {
		return top == -1;
	}
	
	//i have stored the array full size, as maxSize = 10. if top is equal to N-1, 
	//then i have reached the end of the array
	public boolean isStackFull() {
		return top == maxSize-1;
	}
	
	//check if the array is full, if full aport mission, else -> insert element into array at point top
	//then increment the array
	public boolean push(Object data) {
		if(!isStackFull()) { //if stack is not full
			stack[++top] = data; //add stack at position top, then increment top
			return true; //return true, we successfully added a element in the array
		}else {
			return false; //false, we were not able to add a array
		}
	}
	
	//im deleting the top element from the queue, i first check if the array is empty
	//if yes, return false, theres nothing to pop
	//if no, decrement the top pointer and return the element
	public Object pop() {
		if(isEmpty()) {
			System.out.println("The stack is empty, theres nothing to pop");
			return 0; //if the array is empty, just return 0
		}else {
			return stack[top--]; //decrement the array and return the element value
		}
	}
	
	public void printStack() {
		int cnt = top;
		
		if(!isEmpty()) { //if the array is not empty
		while(cnt >= 0) { //while cnt is at the top
			System.out.println(stack[cnt]); //print it out
			cnt--; //decrement the pointer
		}
		}else {
		System.out.println("the stack is empty!");
		}
		
	}
	
	
	
	
	public static void main(String[] args) {
		Stacks s = new Stacks();
		s.pop();
		s.push("A");
		System.out.println("----------");
		s.printStack();
		System.out.println("----------");
		s.push("B");
		s.push("C");
		s.push("D");
		s.printStack();
		System.out.println("----------");
		s.pop();
		s.printStack();
		System.out.println("----------");
		s.pop();
		s.pop();
		//s.pop();
		s.printStack();
	}
	
}
