package chapter09;

public class question0901 {

	public static void main(String[] args) {

	}

	public static int isBalanced(TreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		int leftResult = isBalanced(root.left);
		int rightResult = isBalanced(root.right);

		if (leftResult == -1 || rightResult == -1) {
			return -1;
		}
		if (leftResult != rightResult) {
			return -1;
		}
		return leftResult + 1;
	}
}
