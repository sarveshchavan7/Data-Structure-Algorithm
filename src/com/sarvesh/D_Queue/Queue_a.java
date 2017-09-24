package com.sarvesh.D_Queue;

/*
 * Implementing queue using circular array
 * insertion happens from one end and suppose tail
 * and deletion happens from head
 * Enqueue - O(1)
 * Dequeue - O(1)
 * isEmpty - O(1)
 * search - O(n)
 */
public class Queue_a {
	Object a[];
	int N = 5;
	int front, rear;

	Queue_a() {
		a = new Object[N];
		front = rear = -1;
	}

	public void enqueue(Object key) {
		// this means the queue is empty
		if (front == -1 && rear == -1) {
			front = rear = 0;
			a[front] = key;
		} 
		else if((rear+1)%N==front){
			System.out.println("Queue is full");
		}
		else {
			rear = (rear + 1) % N;
			a[rear] = key;
		}
	}

	public Object dequeue() {
		if (front == -1 && rear == -1) {
			System.out.println("queue is alredy empty");
			return -1;
		} else if (front == rear) {
			front = rear = -1;
		} else {
			front = (front + 1) % N;
		}
		return a[(front+N-1)%N];
	}
	
	public boolean isEmpty(){
		if(front==-1 && rear == -1){
			return true;
		}else{
			return false;
		}
	}
	
	//return the head of the queue or -1 if it is empty
	public Object peek(){
		if(front== -1 && rear ==-1){
			System.out.println("Queue os empty");
			return -1;
		}else{
			return a[front];
		}
	}
	
	public void print(){
		System.out.println("front :"+front+":"+"rear: "+rear);
	}
	
	public static void main(String args[]){
		Queue_a q = new Queue_a();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(70);
		q.print();
		q.dequeue();
		q.enqueue(79);
		q.print();
	}

}
