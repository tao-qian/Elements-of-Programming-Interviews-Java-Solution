package chapter09;

import java.util.*;

@SuppressWarnings("rawtypes")
public class question0910 {

	// Combine the getLeaves function in question0909 with the two functions in
	// this class.

	public static ArrayList<TreeNode> getLeftExterior(TreeNode root) {
		ArrayList<TreeNode> result = new ArrayList<TreeNode>();
		while (root.left != null || root.right != null) {
			result.add(root);
			if (root.left != null) {
				root = root.left;
			} else {
				root = root.right;
			}
		}
		return result;
	}

	public static ArrayList<TreeNode> getRightExterior(TreeNode root) {
		ArrayList<TreeNode> result = new ArrayList<TreeNode>();
		while (root.right != null || root.left != null) {
			result.add(root);
			if (root.right != null) {
				root = root.right;
			} else {
				root = root.left;
			}
		}
		return result;
	}
}
