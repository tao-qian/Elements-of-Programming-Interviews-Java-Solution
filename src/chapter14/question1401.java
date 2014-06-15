package chapter14;

import chapter09.TreeNode;

public class question1401 {
	public static boolean isBST(TreeNode<Integer> n, int upper, int lower) {
		boolean leftBST = true;
		boolean rightBST = true;
		if (n.left != null)
			leftBST = isBST(n.left, lower, n.data);
		if (n.right != null)
			rightBST = isBST(n.right, n.data, upper);
		return leftBST && rightBST && n.data < upper && n.data > lower;
	}

}
