package chapter08;

import java.util.LinkedList;

import chapter07.LinkedListNode;

public class Queue<T> {

	protected LinkedListNode<T> head;
	protected LinkedListNode<T> tail;
	protected int size;

	public Queue() {
		head = null;
		tail = null;
		size = 0;
	}

	public LinkedList<LinkedListNode<T>> toLinkedList() {
		LinkedList<LinkedListNode<T>> list = new LinkedList<LinkedListNode<T>>();
		LinkedListNode<T> p = head;
		while (p != null) {
			list.addLast(p);
			p = p.next;
		}
		return list;
	}

	public void enqueue(T n) {
		LinkedListNode<T> newNode = new LinkedListNode<T>(n);
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
