package chapter09;

public class question0907 {

	public static void main(String[] args) {
		// String[] inorder = new String[]{"B","A","D","C","E"};
		// String[] preorder = new String[]{"A","B","C","D","E"};
		String[] inorder = new String[] { "F", "B", "A", "E", "H", "C", "D",
				"I", "G" };
		String[] preorder = new String[] { "H", "B", "F", "E", "A", "C", "D",
				"G", "I" };
		TreeNode<String> root = reconstructTree(inorder, preorder, 0,
				inorder.length, 0, preorder.length);
		Util.Utility.print(root.inOrder());

	}

	public static TreeNode<String> reconstructTree(String[] inorder,
			String[] preorder, int inStart, int inEnd, int preStart, int preEnd) {
		if (inStart - inEnd != preStart - preEnd) {
			System.out.println("Wrong answer!");
		}
		if (inEnd - inStart <= 0) {
			return null;
		}
		String rootKey = preorder[preStart];
		TreeNode<String> root = new TreeNode<String>(rootKey);
		int rootInorderIndex = search(inorder, rootKey, inStart, inEnd);
		int leftSize = rootInorderIndex - inStart;// start is inclusive
		int rightSize = inEnd - rootInorderIndex - 1; // end is exclusive
		root.left = reconstructTree(inorder, preorder, inStart,
				rootInorderIndex, preStart + 1, preStart + 1 + leftSize);
		root.right = reconstructTree(inorder, preorder, rootInorderIndex + 1,
				inEnd, preStart + 1 + leftSize, preStart + 1 + leftSize
						+ rightSize);
		return root;
	}

	public static int search(String[] a, String s, int start, int end) {
		for (int i = start; i < end; i++) {
			if (a[i].equals(s)) {
				return i;
			}
		}
		return -1;
	}
}
