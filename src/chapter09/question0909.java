package chapter09;

import java.util.*;

public class question0909 {
	
	public static void main(String[] args)
	{
		String[] preorder = new String[] {"H","B","F","null","null","E","A","null","null","null","C","null","D","null","G","I","null","null","null"};
		@SuppressWarnings("rawtypes")
		TreeNode root = question0908.reconstructTree(preorder);
		TreeNode.beautifulPrint(root);
		Util.Utility.print(getLeaves(root));
	}
	
	@SuppressWarnings("rawtypes")
	public static ArrayList<TreeNode> getLeaves(TreeNode root)
	{
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		ArrayList<TreeNode> result = new ArrayList<TreeNode>();
		while(queue.size() != 0)
		{
			TreeNode current = queue.pollFirst();
			if(current.left == null && current.right == null)
			{
				result.add(current);
				continue;
			}
			if(current.left != null)
			{
				queue.add(current.left);
			}
			if(current.right != null)
			{
				queue.add(current.right);
			}
		}
		return result;
	}
}
