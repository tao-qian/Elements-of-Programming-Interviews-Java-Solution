package chapter14;

import chapter09.Node;

public class question1405 {
	public static Node searchGreaterK(Node root, int k) {
		if (root == null)
			return null;
		Node greater = null;
		boolean foundK = false;
		while (root != null) {
			if (root.n > k) {
				greater = root;
				root = root.left;
			}
			if (root.n < k) {
				root = root.right;
			}
			if (root.n == k) {
				foundK = true;
				root = root.left;
			}
		}
		if (foundK)
			return greater;
		return null;
	}

}
