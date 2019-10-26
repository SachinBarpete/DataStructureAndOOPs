package com.bridgelabz.datastructure.linkedlist;


public class LinkedList<T> {
	int size = 0;
	Node head = null;

	public void add(T data) {
		size++;
		Node node = new Node(data);
		if (head == null) {
			head = node;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = node;
		}

	}

	public void remove(T data) {
		size--;
		Node current = head;
		Node prev = null;
		if (current != null && current.data.equals(data)) {
			head = current.next;
			return;
		}
		while (current != null) {
			prev = current;
			current = current.next;
			if (current == null)
				return;
			if (current.data.equals(data)) {
				prev.next = current.next;
			}
		}
	}

	public boolean search(T item) {
		Node current = head;
		while (current != null) {
			if (current.data.equals(item)) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}

	public int size() {
		return size;
	}

	public int index(T item) {
		int index = 0;
		Node n = head;
		while (!n.data.equals(item)) {
			n = n.next;
			index++;
		}
		return index;

	}

	public void insert(int pos, T item) throws IndexOutOfBoundsException {
		if (pos > size || pos < 0) {
			throw new IndexOutOfBoundsException();
		}
		int index = 0;
		Node n = head;
		Node node = new Node(item);
		if (pos == 0) {
			node.next = head;
			head = node;
		} else {
			while (index != pos) {
				n = n.next;
			}
			node.next = n.next;
			n.next = node;
		}
		size++;
	}

	public T pop() {
		Node n = head;
		if (size == 1) {
			head = head.next;
			size--;
			return (T) n.data;
		}
		while (n.next != null) {
			n = n.next;
		}
		T ret = (T) n.data;
		n = n.next;
		size -= 1;
		return ret;
	}

	public T pop(int pos) {
		int index = 0;
		Node n = head;
		if (pos == 0) {
			head = head.next;
			size--;
			return (T) n.data;
		}
		Node prev = null;
		while (index != pos) {
			prev = n;
			n = n.next;
			index++;
		}
		prev.next = n.next;
		size -= 1;
		return (T) n.data;
	}

	public void removeAll(T key) {
		Node temp = head, prev = null;
		if (temp != null && temp.data.equals(key)) {
			head = temp.next;
		}
		while (temp != null) {
			prev = temp;
			temp = temp.next;
			if (temp == null)
				return;
			if (temp.data.equals(key)) {
				prev.next = temp.next;
			}
		}
	}

	public void sortList() {
		// Node current will point to head
		Node current = head, index = null;
		int temp;

		if (head == null) {
			return;
		}

		while (current != null) {

			index = current.next;

			while (index != null) {

				if ((int) current.data > (int) index.data) {
					temp = (int) current.data;
					current.data = index.data;
					index.data = temp;
				}
				index = index.next;
			}
			current = current.next;
		}
	}

//	Node newNode(int data) {
//		Node x = new Node(data);
//		return x;
//	}
//
//	void sortedInsert(Node new_node) {
//		Node current;
//		if (head == null || (int) head.data >= (int) new_node.data) {
//			new_node.next = head;
//			head = new_node;
//		} else {
//			current = head;
//
//			while (current.next != null && (int) current.next.data < (int) new_node.data)
//				current = current.next;
//
//			new_node.next = current.next;
//			current.next = new_node;
//		}
//	}

	public String list() {
		Node current = head;
		String result = "";
		while (current != null) {
			result += current.data + " ";
			current = current.next;
		}
		return result;
	}
}