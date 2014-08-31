package chapter09;

import java.util.*;

public class TreeNode<T> {
	public TreeNode<T> left;
	public TreeNode<T> right;
	public TreeNode<T> parent;
	public T data;

	public TreeNode(T n) {
		this.data = n;
		left = null;
		right = null;
		parent = null;
	}
	
	public String toString()
	{
		return data.toString();
	}
	
	public ArrayList<T> inOrder()
	{
		ArrayList<T> result = new ArrayList<T>();
		inOrderRecur(this, result);
		return result;
	}
	
	private void inOrderRecur(TreeNode<T> root, ArrayList<T> result)
	{
		if(root == null)
		{
			return;
		}
		inOrderRecur(root.left,result);
		result.add(root.data);
		inOrderRecur(root.right,result);
	}
}
