package com.sarvesh.D_Queue;

/*
 * Implementing queue using linkedList
 * 
 */
public class Queue_l {

	Node head;
	Node tail;

	public Queue_l() {
		head = tail = null;
	}

	//return's the newNode
	public Node getNewNode(Object key) {
		Node newNode = new Node(key);
		return newNode;
	}

	class Node {
		Node next;
		Object key;

		Node(Object key) {
			this.key = key;
			next = null;
		}
	}

	// Adding to tail - O(1)
	public void enqueue(Object key) {
		if (head == null) {
			head = getNewNode(key);
			tail = head;
			
		} 
		
		else if (head == tail) {
			Node newNode = getNewNode(key);
			head.next = newNode;
			tail = newNode;
		} 
		
		else {
			Node newNode = getNewNode(key);
			Node temp = tail;
			temp.next = newNode;
			tail = newNode;
		}
	}

	// removing from head - O(1)
	public Object dequeue() {
		// if queue is empty
		if (head == null && tail == null) {
			System.out.println("queue is empty");
			return -1;
		}
		// exactly one element
		else if (head == tail) {
			Node temp = head;
			head = tail = null;
			return temp.key;
		} 
		//more than one element
		else {
			Node temp = head;
			head = head.next;
			return temp.key;
		}
	}

	// O(n)
	public void print() {
		System.out.println();
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.key + "->");
			temp = temp.next;
		}
	}
	
	public boolean isEmpty(){
		if(head==null && tail==null){
			return true;
		}else{
			return false;
		}
	}
	public static void main(String args[]){
		Queue_l l = new Queue_l();
		l.enqueue(3);
		l.enqueue(7);
		l.enqueue(2);
		l.enqueue(9);
		l.print();
		l.dequeue();
		l.dequeue();
		l.print();
		l.enqueue(11);
		l.enqueue(12);
		l.print();
		l.dequeue();
		l.dequeue();
		l.dequeue();
		l.dequeue();
		l.enqueue(22);
		l.print();
		
	}

}
