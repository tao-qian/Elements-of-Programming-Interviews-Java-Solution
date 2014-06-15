package chapter14;

import chapter09.TreeNode;

public class question1407 {
	public static TreeNode<Integer> buildBalancedBST(int[] a, int p, int q) {
		if (p > q)
			return null;
		int middle = q + (p - q) / 2;
		TreeNode<Integer> n = new TreeNode<Integer>(a[middle]);
		TreeNode<Integer> left = buildBalancedBST(a, p, middle - 1);
		TreeNode<Integer> right = buildBalancedBST(a, middle + 1, q);
		n.left = left;
		n.right = right;
		return n;
	}

}
