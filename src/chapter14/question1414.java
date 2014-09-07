package chapter14;

import chapter09.TreeNode;

public class question1414 {
	
	public static boolean descendantAndAncestor(TreeNode<Integer> r, TreeNode<Integer> s, TreeNode<Integer> m)
	{
		return existenceSearch(r, m, s) || existenceSearch(s, m, r);
	}
	
	public static boolean existenceSearch(TreeNode<Integer> top, TreeNode<Integer> middle, TreeNode<Integer> bottom)
	{
		boolean encountered = false;
		while(top != null)
		{
			if(top.data == middle.data)
			{
				encountered = true;
			}
			if(top.data == bottom.data)
			{
				break;
			}
			if(top.data > bottom.data)
			{
				top = top.left;
			}
			else
			{
				top = top.right;
			}
		}
		return encountered;
	}
}
