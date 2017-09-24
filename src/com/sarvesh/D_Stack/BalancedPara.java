package com.sarvesh.D_Stack;

import java.util.Scanner;;

/*
 * check for balanced parentheses using stack
 * In this we will check that the element which we want pushed on to the stack
 * is a closing for the previous open if yes simple pop the previous open
 * else just push that element on to the stack
 * if it's a  balanced parentheses then at the end stack will be empty
 * in this we are not handling the case if user input is invalid 
 * user should strictly enter the parentheses only without spaces,alphabets and numbers 
 */
public class BalancedPara {

	public String closingPara(String para) {
		if (para.equals("}")) {
			return "{";
		} else if (para.equals(")")) {
			return "(";
		} else if (para.equals("]")) {
			return "[";
		} else {
			return para;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BalancedPara b = new BalancedPara();
		Stack_l stack = new Stack_l();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the para");
		String string = sc.nextLine();
		String array[] = new String[string.length()];
		for (int i = 0; i < string.length(); i++) {
			array[i] = string.substring(i, i + 1);
		}
		for (int i = 0; i < array.length; i++) {
			// if it is a closing parentheses
			// just check the top of stack it should is opening for that
			// if yes just pop that element out
			if (stack.peek().equals(b.closingPara(array[i]))) {
				stack.pop();
			} else {
				stack.push(array[i]);
			}
		}
		
		if(stack.isEmpty()){
			System.out.println("Yes parentheses are balanced parentheses");
		}else{
			System.out.println("No parentheses are not balanced parentheses");
		}

	}

}
