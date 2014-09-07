package chapter14;

import java.util.LinkedList;

import chapter09.TreeNode;
import chapter14.question1403;

public class question1409 {
	
	public static void main(String[] args)
	{
		TreeNode<Integer> root = new TreeNode<Integer>(10);
		root = question1403.insert(root, new TreeNode<Integer>(9));
		root = question1403.insert(root, new TreeNode<Integer>(8));
		root = question1403.insert(root, new TreeNode<Integer>(7));
		root = question1403.insert(root, new TreeNode<Integer>(12));
		root = question1403.insert(root, new TreeNode<Integer>(11));
		TreeNode.beautifulPrint(root);
		Util.Utility.print(BSTtoLinkedList(root));
	}
	
	// Only wrote solution using util.LinkedList. Solution with doubly linked list is not much different
	public static  LinkedList<Integer> BSTtoLinkedList(TreeNode<Integer> root)
	{
		if(root == null)
		{
			return new LinkedList<Integer>();
		}
		
		LinkedList<Integer> l = BSTtoLinkedList(root.left);
		l.add(root.data);
		l.addAll(BSTtoLinkedList(root.right));
		return l;
	}
}
