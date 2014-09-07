package chapter14;

import java.util.ArrayList;

import chapter09.TreeNode;

public class question1412 {
	
	public static void main(String[] args)
	{
		TreeNode<Integer> root = new TreeNode<Integer>(10);
		root = question1403.insert(root, new TreeNode<Integer>(9));
		root = question1403.insert(root, new TreeNode<Integer>(8));
		root = question1403.insert(root, new TreeNode<Integer>(7));
		root = question1403.insert(root, new TreeNode<Integer>(12));
		root = question1403.insert(root, new TreeNode<Integer>(11));
		TreeNode.beautifulPrint(root);
		ArrayList<Integer> preOrder = root.preOrder();
		TreeNode<Integer> reconstructed = BSTfromPreorder(preOrder, new IntReference(0), Integer.MIN_VALUE, Integer.MAX_VALUE);
		TreeNode.beautifulPrint(reconstructed);
		
	}
	
	public static class IntReference
	{
		Integer n;
		public IntReference(Integer n)
		{
			this.n = n;
		}
	}
	
	public static TreeNode<Integer> BSTfromPreorder(ArrayList<Integer> preorder, IntReference index, int min, int max)
	{
		if(index.n >= preorder.size())
		{
			return null;
		}
		int value = preorder.get(index.n);
		// value cannot be equal to min or max because that indicates duplication of keys in the tree
		// which is not allowed because otherwise the tree will not be unique
		if(value < min || value > max)
		{
			return null;
		}
		TreeNode<Integer> root = new TreeNode<Integer> (value);
		index.n += 1;
		root.left = BSTfromPreorder(preorder, index, min, value);
		root.right = BSTfromPreorder(preorder,index, value,max);
		return root;
	}
}
