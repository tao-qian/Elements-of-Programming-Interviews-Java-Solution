package chapter09;

import java.util.Stack;

public class question0908 {
	public static void main(String[] args)
	{
		String[] preorder = new String[] {"H","B","F","null","null","E","A","null","null","null","C","null","D","null","G","I","null","null","null"};
		Util.Utility.print(reconstructTree(preorder).inOrder());
	}
	
	public static TreeNode<String> reconstructTree(String[] preorder)
	{
		Stack<TreeNode<String>> stack = new Stack<TreeNode<String>>();
		TreeNode<String> root = null;
		for(int i = preorder.length -1;i >= 0;i--)
		{
			if(preorder[i].equals("null"))
			{
				stack.push(null);
			}
			else
			{
				root = new TreeNode<String>(preorder[i]);
				root.left = stack.pop();
				root.right = stack.pop();
				stack.push(root);
			}
		}
		return root;
	}
}
