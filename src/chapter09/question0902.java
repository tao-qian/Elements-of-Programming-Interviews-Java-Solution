package chapter09;

public class question0902 {

	public static Result getKBalanced(TreeNode<Integer> root, int k) {
		if (root == null) {
			return new Result(0, null);
		}
		Result leftResult = getKBalanced(root.left, k);
		if (leftResult.n != null) {
			return leftResult;
		}
		Result rightResult = getKBalanced(root.right, k);
		if (rightResult.n != null) {
			return rightResult;
		}
		if (Math.abs(rightResult.size - leftResult.size) > k) {
			return new Result(0, root);
		}
		return null;
	}

	public static class Result {
		int size;
		TreeNode<Integer> n;

		Result(int size, TreeNode<Integer> n) {
			this.size = size;
			this.n = n;
		}
	}
}
