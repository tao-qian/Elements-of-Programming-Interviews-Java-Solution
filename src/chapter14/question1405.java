package chapter14;

import chapter09.TreeNode;

public class question1405 {
	public static TreeNode<Integer> searchGreaterK(TreeNode<Integer> root, int k) {
		if (root == null)
			return null;
		TreeNode<Integer> greater = null;
		boolean foundK = false;
		while (root != null) {
			if (root.data > k) {
				greater = root;
				root = root.left;
			}
			if (root.data < k) {
				root = root.right;
			}
			if (root.data == k) {
				foundK = true;
				root = root.left;
			}
		}
		if (foundK)
			return greater;
		return null;
	}

}
