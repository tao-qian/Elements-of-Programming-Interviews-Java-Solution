package chapter14;

import chapter09.TreeNode;
import common.DoublyLinkedList;
import common.DoublyLinkedList.*;

public class question1408 {
	
	public static void main(String[] args)
	{
		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
		list.append(1);
		list.append(2);
		list.append(3);
		list.append(4);
		list.append(5);
		TreeNode<Integer> root = BSTfromLinkedList(new NodeReference<Integer>(list.head), 0, list.size);
		TreeNode.beautifulPrint(root);
	}
	
	// Necessary because node = node.next is assignment, so without the ref wrapper, the change will not be reflected on node.
	public static class NodeReference<T>
	{
		public DoublyLinkedListNode<T> node;
		
		public NodeReference(DoublyLinkedListNode<T> node)
		{
			this.node = node;
		}
	}
	
	public static TreeNode<Integer> BSTfromLinkedList(NodeReference<Integer> nodeRef, int start, int end)
	{
		if(start >= end)
		{
			return null;
		}
		int m = start + ((end-start) >> 1);
		TreeNode<Integer> left = BSTfromLinkedList(nodeRef, start, m);
		TreeNode<Integer> current = new TreeNode<Integer>(nodeRef.node.data);
		nodeRef.node = nodeRef.node.next;
		TreeNode<Integer> right = BSTfromLinkedList(nodeRef, m + 1, end);
		current.left = left;
		current.right = right;
		if(left != null)
		{
			left.parent = current;
		}
		if(right != null)
		{
			right.parent = current;
		}
		return current;
	}
}
