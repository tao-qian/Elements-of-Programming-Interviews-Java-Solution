package chapter09;

@SuppressWarnings("rawtypes")
public class question0911 {
	
	public static class MetaNode<T>
	{
		public TreeNode<T> treeNode;
		public boolean isLCA;
		public MetaNode(T n)
		{
			if(n == null)
			{
				this.treeNode = null;
			}
			else
			{
				this.treeNode = new TreeNode<T>(n);
			}
			isLCA = false;
		}
		
		public MetaNode(T n, boolean isLCA)
		{
			this(n);
			this.isLCA = isLCA;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static MetaNode getLCA(TreeNode a, TreeNode b, TreeNode root)
	{
		if(root == null)
		{
			return new MetaNode(null);
		}
		
		boolean foundA = false;
		boolean foundB = false;
		
		if(root.left != null)
		{
			MetaNode leftResult = getLCA(a,b,root.left);
			if(leftResult.isLCA)
			{
				return leftResult;
			}
			if(leftResult.treeNode == a)
			{
				foundA = true;
			}else if(leftResult.treeNode == b)
			{
				foundB = true;
			}
		}
		
		if(root.right != null)
		{
			MetaNode rightResult = getLCA(a,b,root.right);
			if(rightResult.isLCA)
			{
				return rightResult;
			}
			if(rightResult.treeNode == a)
			{
				foundA = true;
			}else if(rightResult.treeNode == b)
			{
				foundB = true;
			}
		}
		
		if(root == a)
		{
			foundA = true;
		}
		else if (root == b)
		{
			foundB = true;
		}
		
		if(foundA & foundB)
		{
			return new MetaNode(root,true);
		}
		
		if(foundA)
		{
			return new MetaNode(a);
		}
		else if(foundB)
		{
			return new MetaNode(b);
		}	
		
		return new MetaNode(null);
			
	}
}
