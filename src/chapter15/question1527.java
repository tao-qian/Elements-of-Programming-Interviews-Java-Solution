package chapter15;

import java.util.*;

public class question1527 {
	
	public static void main(String []args)
	{
		Node root = new Node(3);
		Node c1 = new Node(1);
		Node c2 = new Node(4);
		root.children.add(c1);
		root.children.add(c2);
		reweight(root);
		System.out.println(c1);
	}
	
	public static class Node
	{
		HashSet<Node> children;
		int weight;
		public Node(int weight)
		{
			this.weight = weight;
			children = new HashSet<Node>();
		}
		public String toString()
		{
			return String.valueOf(weight);
		}
	}
	
	public static void reweight(Node root)
	{
		int goal = getHighestPath(root, 0);
		HashMap<Node, Integer> weightDiff = new HashMap<Node,Integer>();
		calculateWeightDiff(root, 0, goal, weightDiff);
	}
	
	public static int calculateWeightDiff(Node root, int lastWeights, int goal, HashMap<Node, Integer> weightDiff)
	{
		int diff = Integer.MAX_VALUE;
		if(root.children.size() == 0)
		{
			diff =  goal-lastWeights-root.weight;
		}
		else
		{
			for(Node child : root.children)
			{
				int childWeight = calculateWeightDiff(child, lastWeights+root.weight, goal, weightDiff);
				diff = Math.min(childWeight,diff);
			}
			// Then we update the weight in the child
			for(Node child:root.children)
			{
				child.weight += weightDiff.get(child) - diff;
			}
		}
		weightDiff.put(root,diff);
		return diff;
	}
	
	public static int getHighestPath(Node root, int lastWeights)
	{
		if(root.children.size() == 0)
		{
			return lastWeights+root.weight;
		}
		int currentHighest = Integer.MIN_VALUE;
		for(Node child : root.children)
		{
			int newHighest = getHighestPath(child, lastWeights+root.weight);
			currentHighest = Math.max(newHighest,currentHighest);
		}
		return currentHighest;
	}
}
