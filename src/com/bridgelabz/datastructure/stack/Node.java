package com.bridgelabz.datastructure.stack;

class Node<T> {
	T data;
	Node link;
	Node top;

	Node(T data) {
		this.data = data;
		this.link = null;
	}
}