package com.sarvesh.datastructure.D_LinkedList;



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

	//It will return a newNode with the data
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

	//add at the end Time complexity - O(1) 
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
		//means list is empty
		if (n == 0) {
			Node newNode = getNewNode(data);
			newNode.next = head;
			head = newNode;
			return head;
		}
		//If users give index which is out of range of list
		if (n >= sizeOf() + 1) {
			System.out.println("\ninvalid index");
			return head;
		}

		int count = 0;
		Node prev = null;
		Node current = head;
		while (count <= n) {
			//If we want to add at the end
			if (count == sizeOf()) {
				Node newNode = getNewNode(data);
				prev.next = newNode;
				newNode.next = current;
				tail = newNode;
			}
			//If we want to add except the last index
			else if (count == n) {
				Node newNode = getNewNode(data);
				prev.next = newNode;
				newNode.next = current;
			} 
			//Keep on moving until we get the nth position/index
			else 
			{
				prev = current;
				current = current.next;
			}
			count++;
		}
		return head;
	}

	//return size of linkedList  time complexity - O(n)
	public int sizeOf() {
		int count = 0;
		Node current = head;
		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}

	//Print the linkedList time complexity - O(n)
	public void print() {
		Node current = head;
		System.out.println();
		while (current != null) {
			System.out.print(current.data + "->");
			current = current.next;
		}
	}

	//delete time complexity - O(n)
	public void delete(int index) {
		//index  Out of range
		if (index < 0 || index >= sizeOf()) {
			System.out.println("\nInvalid index");
			return;
		}
		Node current = head;

		//first element deletion time complexity - O(n);
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
		if(forward.next ==null){
			//That means it's a last node
			//so just update the tail to the previous node
			tail = current;
		}
		forward.next = null;
	}
	
	//Reverse a linkedList time complexity - O(n)
	public void reverse(){
		//If the list has only one element simply return 
		if(sizeOf()==1){
			return;
		}
		Node current = head;
		tail = head;
		Node prev = null;
		Node forward = null;
		while(current != null){
			forward = current.next;
			current.next = prev;
			prev = current;
			current = forward;
		}
		head = prev;
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
		l.reverse();
		l.print();
		System.out.println("\n" + l.head.data + " : " + l.tail.data);
		l.add(67);
		l.print();
		System.out.println("\n" + l.head.data + " : " + l.tail.data);
		
		System.out.println("InterView Question");
		int mid = l.findMid();
		System.out.println("Mid is "+mid);
		
	}
	
	//InterView Questions
	//Find the mid of the linkedList
	public int findMid(){
		Node first_ref = head;
		Node sec_ref = head;
		while(sec_ref.next != null){
			sec_ref =sec_ref.next.next;
			first_ref = first_ref.next;
		}
		return first_ref.data;
	}
	
	
	
}
