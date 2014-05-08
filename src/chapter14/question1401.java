package chapter14;

import chapter09.Node;

public class question1401 {
	public static boolean isBST(Node n, int upper, int lower) {
		boolean leftBST = true;
		boolean rightBST = true;
		if (n.left != null)
			leftBST = isBST(n.left, lower, n.n);
		if (n.right != null)
			rightBST = isBST(n.right, n.n, upper);
		return leftBST && rightBST && n.n < upper && n.n > lower;
	}

}
