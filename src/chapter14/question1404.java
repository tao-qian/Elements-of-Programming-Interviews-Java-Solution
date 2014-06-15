package chapter14;

import chapter09.TreeNode;

public class question1404 {
	public static TreeNode<Integer> search(TreeNode<Integer> n, int num) {
		TreeNode<Integer> found = null;
		while (n != null) {
			if (n.data == num) {
				found = n;
				n = n.left;
			} else if (n.data > num) {
				n = n.right;
			} else if (n.data < num) {
				n = n.right;
			}
		}
		return found;
	}
}
