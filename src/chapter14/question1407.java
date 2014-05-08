package chapter14;

import chapter09.Node;

public class question1407 {
	public static Node buildBalancedBST(int[] a, int p, int q) {
		if (p > q)
			return null;
		int middle = q + (p - q) / 2;
		Node n = new Node(a[middle]);
		Node left = buildBalancedBST(a, p, middle - 1);
		Node right = buildBalancedBST(a, middle + 1, q);
		n.left = left;
		n.right = right;
		return n;
	}

}
