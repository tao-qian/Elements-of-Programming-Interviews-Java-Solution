package chapter08;

import chapter07.Node;

public class Stack<T> {
	protected Node<T> head;
	protected int size;
	
	public Stack()
	{
		head = null;
		size = 0;
	}
	
	public void push(T n)
	{
		Node<T> newNode = new Node<T>(n);
		newNode.next = head;
		head = newNode;
		size ++;
	}
	
	public T pop() throws Exception
	{
		if(head == null)
		{
			throw new Exception("Stack is empty!");
		}
		T result = head.n;
		head = head.next;
		size--;
		return result;
	}
	
	public T peek() throws Exception
	{
		if(head == null)
		{
			throw new Exception("Stack is empty!");
		}
		return head.n;
	}
}
