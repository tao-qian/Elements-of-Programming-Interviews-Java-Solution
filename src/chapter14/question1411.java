package chapter14;

import java.util.*;

import chapter09.TreeNode;
import chapter14.question1403;

public class question1411 {
	
	public static void main(String[] args)
	{
		TreeNode<Integer> root = null;
		root = question1403.insert(root, new TreeNode<Integer>(10));
		root = question1403.insert(root, new TreeNode<Integer>(12));
		root = question1403.insert(root, new TreeNode<Integer>(20));
		root = question1403.insert(root, new TreeNode<Integer>(30));
		root = question1403.insert(root, new TreeNode<Integer>(24));
		root = question1403.insert(root, new TreeNode<Integer>(7));
		root = question1403.insert(root, new TreeNode<Integer>(4));
		root = question1403.insert(root, new TreeNode<Integer>(11));
		root = question1403.insert(root, new TreeNode<Integer>(16));
		root = question1403.insert(root, new TreeNode<Integer>(17));
		TreeNode.beautifulPrint(root);
		ArrayList<Integer> largest = new ArrayList<Integer>();
		getKLargest(root, largest, 4);
		Util.Utility.print(largest);
	}
	
	public static void getKLargest(TreeNode<Integer> root, ArrayList<Integer> largest, int k)
	{
		if(root == null)
		{
			return;
		}
		if(largest.size() == k)
		{
			return;
		}
		getKLargest(root.right,largest,k);
		if(largest.size() == k)
		{
			return;
		}
		largest.add(root.data);
		if(largest.size() == k)
		{
			return;
		}
		getKLargest(root.left,largest,k);
	}
}
