package chapter09;

public class TreeNode<T> {
	public TreeNode<T> left;
	public TreeNode<T> right;
	public TreeNode<T> parent;
	public T data;

	public TreeNode(T n) {
		this.data = n;
		left = null;
		right = null;
		parent = null;
	}
}
