package com.bridgelabz.datastructure.stack;

public class Stack<O> {
	Node top = null;

	public void push(O data) {

		Node temp = new Node(data);
		if (temp == null) {
			System.out.println("\nHeap Overflow");
			return;
		}
		temp.data = data;
		temp.link = top;
		top = temp;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public void pop() {
		if (top == null) {
			System.out.println("\nStack Underflow");
			return;
		}
		top = top.link;
	}

	public Object peek() {
		if (!isEmpty()) {
			return top.data;
		} else {
			System.out.println("Stack is empty");
			return -1;
		}
	}
}