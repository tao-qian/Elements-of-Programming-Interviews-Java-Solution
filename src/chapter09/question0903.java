package chapter09;

public class question0903 {

	public static boolean isSymmetric(TreeNode<Integer> root) {
		if (root == null)
			return true;
		return isSymmetric(root.left, root.right);
	}

	public static boolean isSymmetric(TreeNode<Integer> left,
			TreeNode<Integer> right) {
		if (left == null && right == null) {
			return true;
		}
		if (left.data != right.data) {
			return false;
		}
		return isSymmetric(left.left, right.right)
				&& isSymmetric(left.right, right.left);
	}
}
