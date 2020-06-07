package com.datastructures.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StackPracticeProblems {
	
	public int getMaxSquareArea(char[][] matrix) {
		int max = 0;
		
		if(matrix.length == 0) {
			return 0;
		}
		char[][] newMatrix = new char[matrix.length+1][matrix[0].length+1];
		
		//fill in the first row with 0's
		for(int i = 0; i < matrix[0].length+1; i++ ) {
			newMatrix[0][i] = '0';
		}
		
		//fill in the first column
		for(int i = 0; i < matrix.length+1; i++) {
			newMatrix[i][0] = '0';
		}
		
		for(int a = 0; a < matrix.length; a++) {
			for(int b = 0; b < matrix[0].length; b++) {
				int xPnt = a+1, yPnt = b+1;
				char num = matrix[a][b]; //getting the value in the matrix
				int x = Integer.parseInt(String.valueOf(num));
				
				if(x == 0) {
					newMatrix[xPnt][yPnt] = num; //assigning the value of 0
				}else {
					char xx = newMatrix[a][b+1];
				    System.out.println(xPnt+" "+yPnt+" "+newMatrix[xPnt-1][yPnt]);
				    
					int x1y1 = Integer.parseInt(String.valueOf(newMatrix[xPnt-1][yPnt]));
					int x1y2 = Integer.parseInt(String.valueOf(newMatrix[xPnt-1][yPnt-1]));
					int x1y3 = Integer.parseInt(String.valueOf(newMatrix[xPnt][yPnt-1]));
					
					int num1 = Math.min(x1y1,x1y2); //get the min value of all the corner values
					num1 = Math.min(num1, x1y3);
					
					int sum = num1+x;
					newMatrix[a+1][b+1] = Integer.toString(sum).charAt(0); //adding the values plus the min corner values to the array
					
				}
			}
		}
		
		
		//now i want to get the max num
		for(int i = 0; i < newMatrix.length; i++) {
			for(int x = 0; x < newMatrix[0].length; x++) {
				max = (Integer.parseInt(String.valueOf(newMatrix[i][x])) > max ) ? Integer.parseInt(String.valueOf(newMatrix[i][x])) : max;
			}
		}
		return max*max;
	}
	
	public int getMaxRectangleHistogram(int[] arr) {
		if(arr.length == 0) {
			return 0;
		}
		
		int area = -1, maxArea = 0, pnt = 0;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i < arr.length; i++) {
			if(stack.isEmpty()) { //if the stack is empty, just go ahead and add it
				stack.push(i);
			}else {
				//if there something in  the stack and its less than the current top
				if(arr[stack.peek()] < arr[i]) {
					stack.push(i);
				}else { //if the value is higher, keep popping until i find a value lower
					while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
						int x = stack.pop(); //grabbing the value, and popping it off
						//calculate the area
						if(!stack.isEmpty()) {
							area = arr[x] * (i - stack.peek() - 1);
							maxArea = Math.max(area, maxArea);
						}else {
							area = arr[x]*i;
							maxArea = Math.max(area, maxArea);
						}
					}
					//once i have found a value lower, now i can push the new value on the stack
					stack.push(i);
				}
			}
			pnt = i; //grabbing the value of i
			//System.out.println(Arrays.toString(stack.toArray()));
		}
		pnt++; //need to increment by 1
		
		while(!stack.isEmpty()) { //keep going, only if the stack is not empty, im just popping at this point
			int a = stack.pop();
			
			if(stack.isEmpty()) {
				area = arr[a]*pnt;
				maxArea = Math.max(area,maxArea);
				//System.out.println(area);
			}else {
				area = arr[a] * (pnt - stack.peek() - 1);
				maxArea = Math.max(area, maxArea);
				//System.out.println(area);
			}
		}
		
		
		return maxArea;
	}
	
	public int maximumRectangleInMatrix(char[][] arr) {
		int maxArea = 0;
		int area = -1;
		
		if(arr.length == 0) {
			return 0;
		}
		int[] copy = new int[arr[0].length];
		
		for(int a = 0; a < arr.length; a++) {
			for(int b = 0; b < arr[0].length; b++) {
				//copy array first row of values
				copy[b] = arr[a][b] == '0' ? 0 : copy[b]+1;
			}
			//now that i have all the values copied in
			maxArea = Math.max(maxArea,histoGramPt2(copy));
		}
		
		return maxArea;
	}

	private int histoGramPt2(int[] copy) {
		int area = 0 , maxArea = -1;
		
		if(copy.length == 0) {
			return 0;
		}
		
		//create a stack
		//if stack is empty push value, if stack.peek value is less than current value push on stack
		//if not, pop stack and calculate area, arr[top]*i or arr[top]* (i-peekValue-1)
		//if stack is not empty, keep popping until its over
		
		Stack<Integer> stack = new Stack<Integer>();
		int i;
		for(i = 0; i < copy.length; i++) {
			//if stack is empty || if stack.peek is < copy[i], simply push the stack value index
			if(stack.isEmpty() || copy[stack.peek()] < copy[i]) {
				stack.push(i);
			}else {
				//the stack is greater than the current value, keep popping until the value is lower
				while(!stack.isEmpty() && copy[stack.peek()] > copy[i]) {
					int x = stack.pop(); //i have popped the top value, now i need to calculate the area
					
					if(stack.isEmpty()) { //if stack is empty, use the empty formula
						area = copy[x] * i;
						maxArea = Math.max(maxArea, area);
					}else { //if the stack is not empty, use the not empty stack formula
						area = copy[x] * (i - stack.peek()-1);
						maxArea = Math.max(area, maxArea);
					}
				}
				//now that either the stack is empty, or if the top is, finally lower add value
				stack.push(i);
			}
		}
		
		while(!stack.isEmpty()) {
			int a =  stack.pop();
			if(stack.isEmpty()) {
				area = copy[a] * i;
				maxArea = Math.max(maxArea, area);
			}else {
				area = copy[a] * (i - stack.peek() -1);
				maxArea = Math.max(maxArea, area);
			}
		}
		
		return maxArea;
	}
	
	 public String removeDuplicateLetters(String s) {
		 Stack<Character> stack = new Stack<Character>();
		 
		 for(int i = 0; i < s.length(); i++) {
			 if(stack.isEmpty() || (stack.peek() < s.charAt(i) && !stack.contains(s.charAt(i)))) {
				 stack.push(s.charAt(i));
			 }else {
				 while(!stack.isEmpty() && stack.peek() > s.charAt(i)&& !stack.contains(s.charAt(i))) {
					 if(s.substring(i).contains(stack.peek().toString())) {
						 stack.pop();
					 }else {
						 break;
					 }
				 }
				 if(!stack.contains(s.charAt(i))) {
					 stack.push(s.charAt(i));
				 }
				 
			 }
		 }
		 
		 StringBuilder sb = new StringBuilder();
		 
		 while(!stack.isEmpty()) {
			 sb.append(stack.pop());
		 }
		 
		 return sb.reverse().toString();
	 }
	 
	 public String decodeString(String s) {
		String  returnStr = "";
		Stack<Integer> integerStack = new Stack<Integer>();
		Stack<String> stringStack = new Stack<String>();
		
		int index = 0;
		
		while(index < s.length()) {
			if(Character.isDigit(s.charAt(index))) {
				int count = 0;
				while(Character.isDigit(s.charAt(index))) {
					count = 10 * count + (s.charAt(index)- '0');
					index++;
				}
				integerStack.push(count);
			}
			
			else if(s.charAt(index) == '[') {
				stringStack.push(returnStr);
				returnStr = "";
				index++;
			}
			
			else if(s.charAt(index) == ']') {
				StringBuilder sb = new StringBuilder(stringStack.pop());
				int cnt = integerStack.pop();
				
				for(int i = 0; i < cnt; i++) {
					sb.append(returnStr);
				}
				
				returnStr = sb.toString();
				index++;
			}
			else {
				returnStr += s.charAt(index);
				index++;
			}
		}
		
		return returnStr;
	 }
	 
	 public int reveresPolishNotation(String[] arr) {
		 if(arr.length == 0) {
			 return 0;
		 }
		 
		 int answer = 0;
		 Stack<Integer> stack = new Stack<Integer>();
		 
		 int point = 0;
		 
		 while(point < arr.length) {
			 //check if string is digit or operand
			 if(isDigit(arr[point])) {
				stack.push(Integer.parseInt(arr[point]));
			}else {
				 int x1 = stack.pop();
				 int x2 = stack.pop();
				 int ans = 0;
				 
				 if(arr[point].equals("/")) {
					 ans = x2/x1;
					 stack.push(ans);
				 }else if(arr[point].equals("*")) {
					 ans = x2*x1; 
					 stack.push(ans);
				 }else if(arr[point].equals("+")) {
					 ans = x2+x1;
					 stack.push(ans);
				 }else {
					 ans = x2-x1;
					 stack.push(ans);
				 }
				 
			 }
			 point++;
		 }
		 
		 if(!stack.isEmpty()) {
			 answer = stack.pop();
		 }
		 
		 
		 
		 return answer;
	 }
	 
	 public boolean isDigit(String str) {
		 if(str == null) {
			 return false;
		 }
		 
		try { 
		 int digit = Integer.parseInt(str);
		}catch(Exception ex) {
			return false;
		}
		
		return true;
	 }
	 
	 public int basicCalculator(String s) {
		 //first convert string to postfix expression array
		 //send array to reversePolishNotation where it evulatates expression
		 List<String> list = new ArrayList<String>();
		 Stack<Character> stack = new Stack<Character>();
		 int i = 0;
		 
		 while(i < s.length()) {
			 //loop through every character, and adding it to the list
			 if(Character.isDigit(s.charAt(i))) { //its a number
				 int count = 0;
				 while(i < s.length() && Character.isDigit(s.charAt(i))) {
					 count = 10*count + (s.charAt(i++)- '0');
				 }
				 list.add(String.valueOf(count));
			 }else if(s.charAt(i) != ' '){ //if the character is an operator
				 //if its not a space, its an operator
				 if(s.charAt(i) == '(') {
					 stack.push(s.charAt(i));
					 i++;
				 }
				 //if the operator is an ), then we need to keep popping from the stack until we find the  )
				 else if(s.charAt(i) == ')') {
					 while(!stack.isEmpty() && stack.peek() != '(') {
						 list.add(stack.pop().toString());
					 }
					if(!stack.isEmpty() && stack.peek() == '(') {
					 stack.pop();
					}
					 i++;
				 }
				 else {
					 //if the character is an operator * / + -
					 //if the peek is (, just push the operator
					 if(stack.isEmpty() || stack.peek() == '(' ) {
						 stack.push(s.charAt(i));
					 }else if(outPrec(s.charAt(i)) > inPrec(stack.peek())) {
						 stack.push(s.charAt(i));
					 }else {
						 while(!stack.isEmpty() && outPrec(s.charAt(i)) < inPrec(stack.peek())) {
							if(stack.peek() != '(') { 
							 list.add(stack.pop().toString());
							}else {
								stack.pop();
							}
						 }
						 stack.push(s.charAt(i));
					 }
					 i++;
				 }
				}else {
				 //its a space, and i want to increment the counter
				 i++;
			 }
			 
			 
			 
		 }
		 
		 while(!stack.isEmpty()) {
			 list.add(stack.pop().toString());
		 }
		 
		
		 String[] arr = new String[list.size()];
		 arr = list.toArray(arr);
		 
		 for(String str : list) {
			 System.out.print(str+" ");
		 }
		 System.out.println();
		 
		 return reveresPolishNotation(arr);
		 
	 }
	 // function to return precedence value 
	    // if operator is present in stack 
	    static int inPrec(char input) 
	    { 
	        switch (input) { 
	        case '+': 
	        case '-': 
	            return 2; 
	        case '*': 
	        case '%': 
	        case '/': 
	            return 4; 
	        case '(': 
	            return 0; 
	        } 
	        return 0; 
	    } 
	  
	    // function to return precedence value 
	    // if operator is present outside stack. 
	    static int outPrec(char input) 
	    { 
	        switch (input) { 
	        case '+': 
	        case '-': 
	            return 1; 
	        case '*': 
	        case '%': 
	        case '/': 
	            return 3; 
	        case '(': 
	            return 100; 
	        } 
	        return 0; 
	    } 

	public static void main(String[] args) {
		char[][] matrix = {
				{'1','0','1','0','0'},//newMatrix[a][b+1]
				{'1','0','1','1','1'},
				{'1','1','1','1','1'},
				{'1','0','0','1','0'}
		};
		
		int[] arr = {6, 7, 5, 2, 4, 5, 9, 3};
		String[] strArr = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
		
		
		StackPracticeProblems obj = new StackPracticeProblems();
		//System.out.println(obj.getMaxSquareArea(matrix));
		//System.out.println(obj.getMaxRectangleHistogram(arr));
		System.out.println(obj.maximumRectangleInMatrix(matrix));
		System.out.println(obj.removeDuplicateLetters("cbacdcbc"));
		System.out.println(obj.decodeString("100[leetcode]"));
		System.out.println(obj.reveresPolishNotation(strArr));
		//System.out.println("jalysa".substring(0,0+1));
		System.out.println(obj.basicCalculator("2-4-(8+2-6+(8+4-(1)+8-10))"));
		
	}

}
