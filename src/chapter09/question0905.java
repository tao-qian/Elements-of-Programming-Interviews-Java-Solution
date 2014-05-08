package chapter09;

public class question0905 {
	// Not tested
	public void inOrder(Node n) {
		n.parent = null;
		Node current = n;
		Node prev = null;
		while (current != null) {
			Node next = null;
			if (prev == null || prev == current.parent) {
				if (current.left == null) {
					System.out.println(current.n);
					if (current.right == null)
						next = current.parent;
					else
						next = current.right;
				} else {
					next = current.left;
				}
			} else if (prev == current.left) {
				System.out.println(current.n);
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
	public void preorder(Node n) {
		n.parent = null;
		Node current = n;
		Node prev = null;
		while (current != null) {
			Node next = null;
			if (prev == null || prev == current.parent) {
				System.out.println(current.n);
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
		}
	}

}
