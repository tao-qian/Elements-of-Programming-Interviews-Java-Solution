package chapter14;

import chapter09.TreeNode;

public class question1406 {

	// This solution is different from that one in the book.
	public static boolean searchInMinBST(TreeNode<Integer> root, int k) {
		TreeNode<Integer> current = root;
		while (current != null) {
			if (k < current.data) {
				return false;
			}
			if (k == current.data) {
				return true;
			}
			if (current.right != null && current.right.data <= k) {
				current = current.right;
			} else {
				current = current.left;
			}
		}
		return false;
	}
}
