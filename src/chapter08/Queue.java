package chapter08;

import java.util.LinkedList;

import chapter07.Node;

public class Queue<T> {

	protected Node<T> head;
	protected Node<T> tail;
	protected int size;

	public Queue() {
		head = null;
		tail = null;
		size = 0;
	}

	public LinkedList<Node<T>> toLinkedList() {
		LinkedList<Node<T>> list = new LinkedList<Node<T>>();
		Node<T> p = head;
		while (p != null) {
			list.addLast(p);
			p = p.next;
		}
		return list;
	}

	public void enqueue(T n) {
		Node<T> newNode = new Node<T>(n);
		if (tail == null) {
			head = newNode;
		} else {
			tail.next = newNode;
		}
		tail = newNode;
		size++;
	}

	public T dequeue() throws Exception {
		if (head == null) {
			throw new Exception("queue is empty!");
		}
		T result = head.data;
		head = head.next;
		if (head == null) {
			tail = null;
		}
		size--;
		return result;
	}

	public T peek() throws Exception {
		if (head == null) {
			throw new Exception("Queue is empty!");
		}
		return head.data;
	}

	public T peekTail() throws Exception {
		if (tail == null) {
			throw new Exception("Queue is empty");
		}
		return tail.data;
	}

}
