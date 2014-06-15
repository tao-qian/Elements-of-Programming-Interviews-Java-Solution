package chapter08;

import chapter09.TreeNode;

public class question0809 {

	public static void traverseByLevel(TreeNode<Integer> root) throws Exception {
		Queue<TreeNode<Integer>> q = new Queue<TreeNode<Integer>>();
		int levelCount = 1;
		int nextLevelCount = 0;
		q.enqueue(root);
		while (q.size != 0) {
			while (levelCount != 0) {
				TreeNode<Integer> n = q.dequeue();
				System.out.print(n + " ");
				if (n.left != null) {
					q.enqueue(n.left);
					nextLevelCount++;
				}
				if (n.right != null) {
					q.enqueue(n.right);
					nextLevelCount++;
				}
			}
			System.out.println();
			levelCount = nextLevelCount;
			nextLevelCount = 0;
		}
	}
}
