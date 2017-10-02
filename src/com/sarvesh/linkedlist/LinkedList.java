package com.sarvesh.linkedlist;

public class LinkedList {

	Node head;
	Node tail;

	LinkedList() {
		head = null;
		tail = null;
	}

	public class Node {
		Node next;
		int data;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	// It will return a newNode with the data
	public Node getNewNode(int data) {
		return new Node(data);
	}

	// Add at the beginning time complexity will be O(1)
	public Node addBeginning(int data) {
		if (head == null && tail == null) {
			head = getNewNode(data);
			tail = head;
			;
			return head;
		}
		Node newNode = getNewNode(data);
		Node current = head;
		newNode.next = current;
		return head = newNode;
	}

	// add at the end Time complexity - O(1)
	public Node addLast(int data) {
		if (head == null && head == null) {
			head = getNewNode(data);
			tail = head;
			return head;
		}
		Node lastNode = tail;
		Node newNode = getNewNode(data);
		lastNode.next = newNode;
		tail = newNode;
		return head;
	}

	// Add at the end with the time complexity be O(1)
	public Node add(int data) {
		if (head == null && tail == null) {
			Node newNode = getNewNode(data);
			head = newNode;
			tail = head;
			return head;
		}
		Node newNode = getNewNode(data);
		tail.next = newNode;
		tail = newNode;
		return head;
	}

	// insert/add at index n (n starts from 0)
	public Node add(int data, int n) {
		// means list is empty
		if (n == 0) {
			Node newNode = getNewNode(data);
			newNode.next = head;
			head = newNode;
			return head;
		}
		// If users give index which is out of range of list
		if (n >= sizeOf() + 1) {
			System.out.println("\ninvalid index");
			return head;
		}

		int count = 0;
		Node prev = null;
		Node current = head;
		while (count <= n) {
			// If we want to add at the end
			if (count == sizeOf()) {
				Node newNode = getNewNode(data);
				prev.next = newNode;
				newNode.next = current;
				tail = newNode;
			}
			// If we want to add except the last index
			else if (count == n) {
				Node newNode = getNewNode(data);
				prev.next = newNode;
				newNode.next = current;
			}
			// Keep on moving until we get the nth position/index
			else {
				prev = current;
				current = current.next;
			}
			count++;
		}
		return head;
	}

	// return size of linkedList time complexity - O(n)
	public int sizeOf() {
		int count = 0;
		Node current = head;
		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}

	// Print the linkedList time complexity - O(n)
	public void print() {
		Node current = head;
		System.out.println();
		while (current != null) {
			System.out.print(current.data + "->");
			current = current.next;
		}
	}

	// delete time complexity - O(n)
	public void delete(int index) {
		// index Out of range
		if (index < 0 || index >= sizeOf()) {
			System.out.println("\nInvalid index");
			return;
		}
		Node current = head;

		// first element deletion time complexity - O(n);
		if (index == 0) {
			head = current.next;
			current.next = null;
			return;
		}

		// In between and last time complexity -O(n)
		int count = 1;
		while (count < index) {
			count++;
			current = current.next;
		}
		Node forward = current.next;
		current.next = forward.next;
		if (forward.next == null) {
			// That means it's a last node
			// so just update the tail to the previous node
			tail = current;
		}
		forward.next = null;
	}

	// Reverse a linkedList time complexity - O(n)
	public void reverse() {
		// If the list has only one element simply return
		if (sizeOf() == 1) {
			return;
		}
		Node current = head;
		tail = head;
		Node prev = null;
		Node forward = null;
		while (current != null) {
			forward = current.next;
			current.next = prev;
			prev = current;
			current = forward;
		}
		head = prev;
	}

	Node xyz = head;
	Node forward = null;
	Node prev = null;

	// Reverse using recursion - O(n)
	// current is the head node which we will pass
	public void reverse(Node current) {
		if (current == null) {
			return;
		}
		forward = current.next;
		current.next = prev;
		prev = current;
		reverse(forward);
		head = prev;
		tail = current;
	}

	public static void main(String args[]) {
		LinkedList l = new LinkedList();
		l.add(20);
		l.add(10);
		l.add(5);
		l.print();
		System.out.println("\n" + l.head.data + " : " + l.tail.data);
		l.add(44, 3);
		l.print();
		System.out.println("\n" + l.head.data + " : " + l.tail.data);
		l.addBeginning(2);
		l.print();
		l.addLast(17);
		l.print();
		l.delete(4);
		l.print();
		System.out.println("\n" + l.head.data + " : " + l.tail.data);
		l.add(5);
		l.print();
		System.out.println("\n" + l.head.data + " : " + l.tail.data);
		System.out.println("\nafter reverse");
		l.reverse(l.head);
		l.print();
		System.out.println("\n" + l.head.data + " : " + l.tail.data);

		l.add(67);
		l.print();
		System.out.println("\n" + l.head.data + " : " + l.tail.data);

		System.out.println("InterView Question");
		int mid = l.findMid();
		System.out.println("Mid is " + mid);

		l.print();

		int value = l.findFromLast(2);
		System.out.println("\nThe valueOne " + value);
		
		int valueTwo = l.findFromLastMethodTwo(2);
		System.out.println("\nValueTwo "+valueTwo);
	}

	// InterView Questions
	// Find the mid of the linkedList
	public int findMid() {
		Node first_ref = head;
		Node sec_ref = head;
		while (sec_ref.next != null) {
			sec_ref = sec_ref.next.next;
			first_ref = first_ref.next;
		}
		return first_ref.data;
	}

	// Interview Question
	// Given a number travel the singly linkedList by that number from the end

	// Method 1 - we can simply travel the list and get the length and minus
	// with that
	// number and again travel the list by the number which get got from
	// subtraction (minus)
	// but it will be n^2 solution
	//T -O(n^2)
	public int findFromLast(int num) {
		Node current = head;
		int count = 1;
		while (current.next != null) {
			current = current.next;
			count++;
		}
		int lengthOfList = count;
		int x = lengthOfList - num;

		int countTwo = 1;
		Node currentTwo = head;
		while (countTwo < x + 1) {
			currentTwo = currentTwo.next;
			countTwo++;
		}
		return currentTwo.data;
	}

	// Method 2 - we can keep 2 pointer at the head and travel one pointer by
	// number given and start traveling
	// another pointer afterwards parallel so when we hit the first pointer null
	// the
	// sec pointer will be on correct node
	//T-O(n)
	public int findFromLastMethodTwo(int num) {
		Node firstPointer = head;
		Node SecoundPointer = head;
		int count = 1;
		while (count < num) {
			firstPointer = firstPointer.next;
			count++;
		}
		while(firstPointer.next!=null){
			firstPointer = firstPointer.next;
			SecoundPointer = SecoundPointer.next;
		}
		return SecoundPointer.data;
	}
}
