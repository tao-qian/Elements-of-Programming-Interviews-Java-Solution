package chapter14;

import chapter09.Node;

public class question1404 {
	public static Node search(Node n, int num) {
		Node found = null;
		while (n != null) {
			if (n.n == num) {
				found = n;
				n = n.left;
			} else if (n.n > num) {
				n = n.right;
			} else if (n.n < num) {
				n = n.right;
			}
		}
		return found;
	}
}
