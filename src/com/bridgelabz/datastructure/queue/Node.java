package com.bridgelabz.datastructure.queue;

class Node<O> { 
	O key; 
	Node next; 

	public Node(O key) 
	{ 
		this.key = key; 
		this.next = null; 
	} 
}