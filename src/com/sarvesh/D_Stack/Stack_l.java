package com.sarvesh.D_Stack;

//Implementing stack using a linkedList
/*
 * basically we will keep head at the top and no need of tail at the end and we will keep pushing 
 * or inserting the element at the head and will remove from head with the 
 * time complexity of O(1)
 */
public class Stack_l {

	Node head;

	class Node {
		Node next;
		Object key;

		Node(Object key) {
			this.key = key;
			next = null;
		}
	}

	// This will return the new Node
	public Node getNewNode(Object key) {
		Node newNode = new Node(key);
		return newNode;
	}

	// This will push on to the stack
	// insert element with time complexity O(1)
	public void push(Object key) {
		if (head == null) {
			Node newNode = getNewNode(key);
			head = newNode;
		} else {
			Node temp = getNewNode(key);
			temp.next = head;
			head = temp;
		}
	}

	// This will remove element from the head - time complexity O(1)
	public Object pop() {
		// This means the stack is already empty
		if (head == null) {
			return -1;
		} else {
			Node temp = head;
			head = head.next;
			return temp.key;
		}

	}

	// return the element at the top of stack - O(1)
	public Object peek() {
		// Stack is empty
		if (head == null) {
			return -1;
		} else {
			return head.key;
		}
	}

	// This will return the index with time complexity -O(n)
	public int search(int key) {
		if (head == null) {
			return -1;
		} else {
			int count = 0;
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
				count++;
				if (temp.key.equals(key)) {
					return count;
				}
			}
			return count;
		}
	}

	public boolean isEmpty() {
		if (head == null) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack_l sL = new Stack_l();
		sL.push(20);
		sL.push(10);
		sL.push(5);
		sL.push(8);
		System.out.println("Is Empty" + sL.isEmpty());
		System.out.println("search 10 index: " + sL.search(10));
		System.out.println("pop " + sL.pop());
		System.out.println("peek " + sL.peek());

		Stack_l stack = new Stack_l();
		stack.push("s");
		stack.push("o");
		stack.push("m");
		stack.push("e");
		stack.push("t");
		stack.push("h");
		stack.push("i");
		stack.push("n");
		stack.push("g");

		// Reverse using stack
		String s = "";
		while (!stack.isEmpty()) {
			s += stack.pop();
		}
		System.out.println("First Reverse using stack: " + s);

		String array[] = new String[s.length()];
		for (int i = 0; i < array.length; i++) {
			array[i] = s.substring(i, i + 1);
		}

		// reverse using for loop
		/*
		 * we will keep pointer toward start and end and we will keep swapping
		 * elements and increment start and decrement end until we reach the
		 * point where start will be <= end
		 */
		for (int i = 0, j = s.length()-1; i < j; i++, j--) {
			String x = array[i];
			array[i] = array[j];
			array[j] = x;
		}
		System.out.print("Sec Reverse using loop: ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
	}

}
