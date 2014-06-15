package chapter09;

public class question0905 {
	// Not tested
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void inOrder(TreeNode n) {
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
	public void preorder(TreeNode n) {
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
			current = next;
		}
	}

}
