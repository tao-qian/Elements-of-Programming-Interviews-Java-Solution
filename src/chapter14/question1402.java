package chapter14;

import chapter09.TreeNode;
import chapter09.question0908;

public class question1402 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		String[] preorder = new String[] { "H", "B", "F", "null", "null", "E",
				"A", "null", "null", "null", "C", "null", "D", "null", "G",
				"I", "null", "null", "null" };
		@SuppressWarnings("rawtypes")
		TreeNode root = question0908.reconstructTree(preorder);
		TreeNode.beautifulPrint(root);
		// Cannot be tested because parent node is not set properly
		System.out.println(successor(root.left.left));
	}

	public static TreeNode<Integer> successor(TreeNode<Integer> n) {
		// First check if the node has a right child. If it does,
		// the successor is the left most node in the right child
		if (n.right != null) {
			TreeNode<Integer> successor = n.right;
			while (successor.left != null) {
				successor = successor.left;
			}
			return successor;
		}

		// Go up the tree until cannot go up anymore or the current node is the
		// left child of the parent
		while (n.parent != null) {
			if (n.parent.left == n) {
				return n.parent;
			}
			n = n.parent;
		}

		return null;
	}
}
