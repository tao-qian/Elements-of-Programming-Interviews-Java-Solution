package chapter09;

public class question0906 {

	//Off-by-one is not properly handled
	public static SizedTreeNode<Integer> getNth(SizedTreeNode<Integer> root, int n)
	{
		//Not possible
		if(root.size < n)
		{
			return null;
		}
		int leftSize = 0;
		if(root.left != null)
		{
			leftSize = root.left.size;
		}
		if(leftSize > n)
		{
			return getNth(root.left,n);
		}
		if(leftSize < n)
		{
			return getNth(root.right, n - leftSize);
		}
		return root;
		
	}
	
	public class SizedTreeNode<T> {
		public SizedTreeNode<T> left;
		public SizedTreeNode<T> right;
		public SizedTreeNode<T> parent;
		public T data;
		public int size;

		public SizedTreeNode(T n) {
			this.data = n;
			left = null;
			right = null;
			parent = null;
			size = 0;
		}
	}
}
