package chapter09;

import java.util.*;

public class TreeNode<T> {
	
	public static void main(String[] args)
	{
		TreeNode<Integer> tree = new TreeNode<Integer>(2);
		tree.left = new TreeNode<Integer>(1);
		beautifulPrint(tree);
	}
	
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
	
	public String toString()
	{
		return data.toString();
	}
	
	public ArrayList<T> inOrder()
	{
		ArrayList<T> result = new ArrayList<T>();
		inOrderRecur(this, result);
		return result;
	}
	
	private void inOrderRecur(TreeNode<T> root, ArrayList<T> result)
	{
		if(root == null)
		{
			return;
		}
		inOrderRecur(root.left,result);
		result.add(root.data);
		inOrderRecur(root.right,result);
	}
	
	public ArrayList<T> preOrder()
	{
		ArrayList<T> result = new ArrayList<T>();
		preOrderRecur(this, result);
		return result;
	}
	
	private void preOrderRecur(TreeNode<T> root, ArrayList<T> result)
	{
		if(root == null)
		{
			return;
		}
		result.add(root.data);
		preOrderRecur(root.left,result);
		preOrderRecur(root.right,result);
	}
	
	public ArrayList<T> postOrder()
	{
		ArrayList<T> result = new ArrayList<T>();
		postOrderRecur(this, result);
		return result;
	}
	
	private void postOrderRecur(TreeNode<T> root, ArrayList<T> result)
	{
		if(root == null)
		{
			return;
		}
		postOrderRecur(root.left,result);
		postOrderRecur(root.right,result);
		result.add(root.data);
	}
	
	@SuppressWarnings("rawtypes")
	public static LinkedList<LinkedList<TreeNode>> getNodesByLevel(TreeNode root)
	{
		//Do a BFS and print by level
		LinkedList<LinkedList<TreeNode>> nodesByLevel= new LinkedList<LinkedList<TreeNode>>();
		
		nodesByLevel.add(new LinkedList<TreeNode>());
		nodesByLevel.peekLast().add(root);
		boolean allNull = true;
		while(true)
		{
			LinkedList<TreeNode> currentLevel = nodesByLevel.peekLast();
			LinkedList<TreeNode> nextLevel = new LinkedList<TreeNode>();
			allNull = true;
			for(TreeNode node : currentLevel)
			{
				if(node == null)
				{
					nextLevel.add(null);
					nextLevel.add(null);
					continue;
				}
				nextLevel.add(node.left);
				nextLevel.add(node.right);
				if(node.left != null || node.right != null)
				{
					allNull = false;
				}
			}
			if(allNull)
			{
				break;
			}
			nodesByLevel.add(nextLevel);
		}
		return nodesByLevel;
	}
	
	@SuppressWarnings("rawtypes")
	public static void beautifulPrint(TreeNode root)
	{
		String intervalString = " ";
		String nullString = ".";
		LinkedList<LinkedList<TreeNode>> nodesByLevel = getNodesByLevel(root);
		StringBuilder sb = new StringBuilder();
		int padding = 0;
		int interval = 1;
		while(nodesByLevel.size() != 0)
		{
			LinkedList<TreeNode> currentLevel = nodesByLevel.pollLast();
			StringBuilder levelsb = new StringBuilder();
			for(int i = 0;i<padding;i++)
			{
				levelsb.append(intervalString);
			}
			for(TreeNode node : currentLevel)
			{
				if(node == null)
				{
					levelsb.append(nullString);
				}
				else
				{
					levelsb.append(node.data);
				}
				for(int i = 0;i<interval;i++)
				{
					levelsb.append(intervalString);
				}
			}
			levelsb.append("\n");
			sb.insert(0, levelsb);
			padding = padding * 2 + 1;
			interval = interval * 2 + 1;
		}
		System.out.println(sb.toString());
	}
}
