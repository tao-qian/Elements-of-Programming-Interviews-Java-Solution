package chapter14;

import chapter09.TreeNode;

public class question1403 {

	public static void main(String[] args) {
		TreeNode<Integer> root = null;
		root = insert(root, new TreeNode<Integer>(10));
		root = insert(root, new TreeNode<Integer>(12));
		root = insert(root, new TreeNode<Integer>(20));
		root = insert(root, new TreeNode<Integer>(30));
		root = insert(root, new TreeNode<Integer>(24));
		root = insert(root, new TreeNode<Integer>(7));
		root = insert(root, new TreeNode<Integer>(4));
		root = insert(root, new TreeNode<Integer>(11));
		root = insert(root, new TreeNode<Integer>(16));
		root = insert(root, new TreeNode<Integer>(17));
		TreeNode.beautifulPrint(root);
		root = delete(root, root.right.right);
		TreeNode.beautifulPrint(root);
		root = delete(root, root.right.right);
		TreeNode.beautifulPrint(root);
	}

	public static TreeNode<Integer> delete(TreeNode<Integer> root,
			TreeNode<Integer> n) {
		// First case, if n has no left child
		if (n.left == null) {
			transplant(n, n.right);
			if (n == root) {
				root = n.right;
			}
			return root;
		}
		// If n only has its left child
		if (n.right == null) {
			transplant(n, n.left);
			if (n == root) {
				root = n.left;
			}
			return root;
		}
		// If n has both children, find its succesor, which is in the right
		// subtree
		TreeNode<Integer> succesor = question1402.successor(n);
		// When succesor is the right child of n, the successor have no left
		// child.
		if (succesor == n.right) {
			transplant(n, n.right);
			n.right.left = n.left;
			n.left.parent = n.right;
			if (n == root) {
				root = n.right;
			}
			return root;
		}
		// When successor is the left most child of the right child of n
		transplant(succesor, succesor.right);
		succesor.right = n.right;
		n.right.parent = succesor;
		succesor.left = n.left;
		n.left.parent = succesor;
		transplant(n, succesor);
		if (n == root) {
			root = succesor;
		}
		return root;
	}

	public static void transplant(TreeNode<Integer> oldNode,
			TreeNode<Integer> newNode) {
		if (newNode != null) {
			newNode.parent = oldNode.parent;
		}
		if (oldNode.parent != null) {
			if (oldNode == oldNode.parent.left) {
				oldNode.parent.left = newNode;
			} else {
				oldNode.parent.right = newNode;
			}
		}
	}

	public static TreeNode<Integer> insert(TreeNode<Integer> root,
			TreeNode<Integer> n) {
		if (root == null) {
			return n;
		}
		TreeNode<Integer> current = root;
		while (true) {
			if (current.data == n.data) {
				// do nothing
				return root;
			}
			if (current.data > n.data) {
				if (current.left == null) {
					current.left = n;
					n.parent = current;
					return root;
				}
				current = current.left;
			} else if (current.data < n.data) {
				if (current.right == null) {
					current.right = n;
					n.parent = current;
					return root;
				}
				current = current.right;
			}
		}
	}

}
