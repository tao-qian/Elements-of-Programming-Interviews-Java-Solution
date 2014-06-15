package chapter08;

import chapter09.TreeNode;
import java.util.Stack;

public class question0803 {
	
	public static void printTree(TreeNode root) throws Exception 
	{
		Stack<TreeNode> s = new Stack<TreeNode>();
		while(s.size() != 0)
		{
			TreeNode node = s.pop();
			if(node.left == null)
			{
				System.out.print(node.data+" ");
				if(node.right != null)
				{
					s.push(node.right);
				}
			}
			else 
			{
				s.push(node.left);
			}
		}
		System.out.println();
	}
}
