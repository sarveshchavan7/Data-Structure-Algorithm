package com.sarvesh.D_Stack;

public class InfixToPostFix {

	public boolean isOperator(String value) {
		if (value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/") || value.equals("^")) {
			return true;
		} else {
			return false;
		}
	}

	// It will return true if the current element is of higher priority then
	// the element at the top of the stack
	public boolean checkTop(String current, Object top) {
		if (current.equals("+") || current.equals("-")) {
			if (top.equals("*") || top.equals("/") || top.equals("^")) {
				return false;
			}else{
				return true;
			}
		} else if (current.equals("*") || current.equals("/")) {
			if (top.equals("+") || top.equals("-")) {
				return true;
			} else if (top.equals("^")) {
				return false;
			}else{
				return true;
			}
		} else if (current.equals("^")) {
			return true;
		}
		return true;
	}

	public boolean isBraces(Object value) {
		if (value.equals("(") || value.equals(")")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isOpening(Object value) {
		if (value.equals("(")) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * infix to postFix with braces suppose we have array with infix expression
	 */
	public void infixToPostFixExp(String a[]) {
		Stack_l s = new Stack_l();
		String postfix = "";

		for (int i = 0; i < a.length; i++) {
			if (isOperator(a[i])) {
				if (checkTop(a[i], s.peek())) {

					s.push(a[i]);
				}
				// its of higher president so keep popping all higher president
				else {
					while (!s.isEmpty()) {
						postfix += s.pop();
						if (checkTop(a[i], s.peek())) {
							s.push(a[i]);
							break;
						}
					}
				}
			} else if (isBraces(a[i])) {
				if (isOpening(a[i])) {
					s.push(a[i]);
				} else {
					while (!s.isEmpty()) {
						postfix += s.pop();
						// isClosing checks for closing braces
						if (isOpening(s.peek())) {
							s.pop();
							break;
						}
					}
				}
			} else  /*(isOperand(a[i]))*/  {
				postfix += a[i];
			}
		}
		
		while(!s.isEmpty()){
			postfix+=s.pop();
		}

		System.out.print("postfix "+postfix);
	}
	
	public static void main(String args[]){
		InfixToPostFix l = new InfixToPostFix();
		String[] arrayTwo = {"a","+","(","b","*","c","-","(","d","/","e","^","f",")","*","g",")","*","h"};
		//String array[]={"(","a","+","b",")","*","(","c","+","d",")"};
		l.infixToPostFixExp(arrayTwo);
	}

}
