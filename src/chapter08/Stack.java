package chapter08;

import chapter07.Node;

public class Stack {
	Node head;
	int size;
	
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
	
	public int pop(int n) throws Exception
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
}
