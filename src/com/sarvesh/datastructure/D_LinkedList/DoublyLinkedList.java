package com.sarvesh.datastructure.D_LinkedList;



public class DoublyLinkedList {

	Node head;
	Node tail;

	DoublyLinkedList() {
		head = tail = null;
	}

	class Node {
		int data;
		Node next;
		Node prev;

		Node(int data) {
			this.data = data;
			next = prev = null;
		}

	}

	Node getNewNode(int data) {
		Node newNode = new Node(data);
		return newNode;
	}

	//Add method time complexity - O(1)
	public void add(int data) {
		// Its a first element
		if (head == null && tail == null) {
			Node newNode = getNewNode(data);
			head = tail = newNode;
			return;
		}
		// This will add to the end of list with time complexity -O(1)
		Node newNode = getNewNode(data);
		tail.next = newNode;
		newNode.prev = tail;
		tail = newNode;
	}

	//Time complexity - O(n)
	public void printForward(){
		Node current = head;
		System.out.println();
		while(current!=null){
			System.out.print(current.data+"->");
			current = current.next;
		}
	}
	
	//Time complexity - O(n)
	public void printReverse(){
		Node current = tail;
		System.out.println();
		while(current!=null){
			System.out.print(current.data+"->");
			current = current.prev;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinkedList dl = new DoublyLinkedList();
		dl.add(20);
		dl.add(5);
		dl.add(11);
		dl.printForward();
		dl.printReverse();
		
	}

}
