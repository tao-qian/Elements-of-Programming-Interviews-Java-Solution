package chapter08;

import java.util.LinkedList;

import chapter07.Node;

public class Stack<T> {
	protected Node<T> head;
	protected int size;

	public Stack() {
		head = null;
		size = 0;
	}

	public LinkedList<Node<T>> toLinkedList() {
		LinkedList<Node<T>> list = new LinkedList<Node<T>>();
		Node<T> p = head;
		while (p != null) {
			list.addFirst(p);
			p = p.next;
		}
		return list;
	}

	public void push(T n) {
		Node<T> newNode = new Node<T>(n);
		newNode.next = head;
		head = newNode;
		size++;
	}

	public T pop() throws Exception {
		if (head == null) {
			throw new Exception("Stack is empty!");
		}
		T result = head.data;
		head = head.next;
		size--;
		return result;
	}

	public T peek() throws Exception {
		if (head == null) {
			throw new Exception("Stack is empty!");
		}
		return head.data;
	}
}
