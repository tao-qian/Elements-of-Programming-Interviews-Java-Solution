package chapter09;

public class question0905 {
	
	public static void main(String[] args)
	{
		TreeNode<Integer> node = new TreeNode<Integer>(2);
		node.left = new TreeNode<Integer>(1);
		node.right = new TreeNode<Integer>(3);
		node.left.parent = node;
		node.right.parent=node;
		postorder(node);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void inorder(TreeNode n) {
		n.parent = null;
		TreeNode current = n;
		TreeNode prev = null;
		while (current != null) {
			TreeNode next = null;
			if (prev == null || prev == current.parent) {
				if (current.left == null) {
					System.out.println(current.data);
					if (current.right == null)
						next = current.parent;
					else
						next = current.right;
				} else {
					next = current.left;
				}
			} else if (prev == current.left) {
				System.out.println(current.data);
				if (current.right == null)
					next = current.parent;
				else
					next = current.right;
			} else {
				next = current.parent;
			}
			prev = current;
			current = next;
		}
	}

	// Not tested
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void preorder(TreeNode n) {
		n.parent = null;
		TreeNode current = n;
		TreeNode prev = null;
		while (current != null) {
			TreeNode next = null;
			if (prev == null || prev == current.parent) {
				System.out.println(current.data);
				if (current.left != null) {
					next = current.left;
				} else if (current.right != null) {
					next = current.right;
				} else
					next = current.parent;
			} else if (prev == current.left) {
				if (current.right != null)
					next = current.right;
				else {
					next = current.parent;
				}
			} else if (prev == current.right) {
				next = current.parent;
			}
			prev = current;
			current = next;
		}
	}
	
	// Not tested
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void postorder(TreeNode root)
	{
		root.parent = null;
		TreeNode prev = null;
		TreeNode current = root;
		while(current != null)
		{
			TreeNode next = null;
			if(prev == null || prev == current.parent)
			{
				if(current.left == null)
				{
					if(current.right == null)
					{
						System.out.println(current.data);
						next = current.parent;
					}
					else
					{
						next = current.right;
					}
				}
				else
				{
					next = current.left;
				}
			}
			else if(prev == current.left)
			{
				if(current.right == null)
				{
					System.out.println(current.data);
					next = current.parent;
				}
				else
				{
					next = current.right;
				}
			}
			else if(prev == current.right)
			{
				System.out.println(current.data);
				next = current.parent;
			}
			prev = current;
			current = next;
		}
	}


}
