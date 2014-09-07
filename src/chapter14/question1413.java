package chapter14;

import chapter09.TreeNode;

public class question1413 {
	
	public TreeNode<Integer> LCABST(TreeNode<Integer> root, int s, int b)
	{
		TreeNode<Integer> current = root;
		while(current.data < s || current.data > b)
		{
			if(current.data < s)
			{
				current = current.right;
			}
			if(current.data > b)
			{
				current = current.left;
			}
		}
		return current;
	}
}
