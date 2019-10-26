package com.bridgelabz.datastructure.queue;

public class Queue<O> {
	Node front, rear;
	int size;
	public Queue() {
		this.front = this.rear = null;
		this.size =0;
	}

	public void enqueue(O key) {
		Node temp = new Node(key);
		size++;
		if (this.rear == null) {
			this.front = this.rear = temp;
			return;
		}
		
		this.rear.next = temp;
		this.rear = temp;
	}

	public Node dequeue() {
		size--;
		if (this.front == null)
			return null;

		Node temp = this.front;
		this.front = this.front.next;

		if (this.front == null)
			this.rear = null;
		return temp;
	}
	public boolean isEmpty() {
		return this.front == null;
	}
	public int size() {
		return size;
	}

}