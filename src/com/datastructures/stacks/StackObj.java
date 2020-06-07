package com.datastructures.stacks;

public class StackObj {
	
	final int maxSize = 100;
	String[] arr = new String[maxSize];
	int top;
	
	public StackObj() {
		top = -1;
	}
	
	public boolean isFull() {
		return top == maxSize-1;
	}
	
	public boolean push(String val) {
		if(!isFull()) {
			arr[++top] = val;
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public String pop() {
		if(!isEmpty()) {
			String val = arr[top];
			top--;
			return val;
		}
		else {
			return "the stack is empty";
		}
	}
	
	public boolean isStringBalanced(String str) {
		for(int i = 0; i < str.length(); i++) {
			String s = Character.toString(str.charAt(i));
			
			if(s.equals("{") || s.equals("[") || s.equals("(")) {
				arr[++top] = s;
			}
			else if(s.equals("}") || s.equals("]") || s.equals(")")) {
				String x = pop();
				
				if(s.equals("}") && !x.equals("{")) {
					return false;
				}else if(s.equals("]") && !x.equals("[")) {
					return false;
				}else if( s.equals(")") && !x.equals("(")) {
					return false;
				}
				
			}
			
			
		}
		
		if(isEmpty()) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public void printStack() {
		if(!isEmpty()) {
			int x = top;
			
			while(x > -1) {
				System.out.println(arr[x]);
				x--;
			}
		}
	}
	
	public static void main(String[] args) {
		StackObj obj = new StackObj();
		System.out.println(obj.isStringBalanced("{()}[](){}jalysa()[]{[{}]}"));
		

	}

}
