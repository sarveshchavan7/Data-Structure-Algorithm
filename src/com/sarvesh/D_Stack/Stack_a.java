package com.sarvesh.D_Stack;

//Array implementation of stack
public class Stack_a {
	int a[];
	static int MAX_SIZE = 10;
	int front;
	int rear;

	Stack_a() {
		a = new int[MAX_SIZE];
		front = rear = -1;
	}

	// We will add element at the end of array time complexity O(1)
	public void push(int data) {
		// That means the array is empty
		if (front == -1 && rear == -1) {
			front = rear = 0;
			a[front] = data;
		} else {
			rear++;
			a[rear] = data;
		}
	}

	// We will delete the element from the end of the list i.e from rear or we
	// can say from top of the stack
	// Time complexity - O(1)
	public int pop() {
		if (front == -1 && rear == -1) {
			System.out.println("Empty stack");
			return -1;
		} else if (rear == 0) {
			front = rear = -1;
			return a[rear + 1];
		} else {
			rear--;
			return a[rear + 1];
		}

	}

	// This will return the value at the top - time complexity O(1)
	public int peek() {
		if (front == -1 && rear == -1) {
			System.out.println("stack is empty");
			return -1;
		}
		return a[rear];
	}

	// check if the stack is empty -time complexity -O(1)
	public boolean isEmpty() {
		if (front == -1 && rear == -1) {
			return true;
		} else {
			return false;
		}
	}

	// return the index if the element is present in the list
	// since the array can or cannot be sorted we cannot perform binary search
	// we will do liner search
	public int search(int data) {
		for (int i = 0; i < MAX_SIZE; i++) {
			if (a[i] == data) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String args[]) {
		Stack_a s = new Stack_a();
		s.push(2);
		s.push(3);
		s.push(7);
		s.push(5);
		System.out.println("front " + s.a[s.front] + " rear " + s.a[s.rear]);
		int value = s.pop();
		System.out.println("\nThe value poped was " + value + " New rear is " + s.a[s.rear]);
		System.out.println("peek " + s.peek());
		System.out.println("Is Empty :" + s.isEmpty());
		System.out.println(s.peek()+" is present at the index "+s.search(s.peek()));
	}
}
