package chapter08;

import chapter07.Node;

public class Stack {
	protected Node head;
	protected int size;
	
	public Stack()
	{
		head = null;
		size = 0;
	}
	
	public void push(int n)
	{
		Node newNode = new Node(n);
		newNode.next = head;
		head = newNode;
		size ++;
	}
	
	public int pop() throws Exception
	{
		if(head == null)
		{
			throw new Exception("Stack is empty!");
		}
		int result = head.n;
		head = head.next;
		size--;
		return result;
	}
	
	public int peek() throws Exception
	{
		if(head == null)
		{
			throw new Exception("Stack is empty!");
		}
		return head.n;
	}
}
