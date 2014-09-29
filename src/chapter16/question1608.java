package chapter16;

import java.util.*;

public class question1608 {
	
	public static void main(String[] args)
	{
		GraphNode<Integer> task1 = new GraphNode<Integer>(1);
		GraphNode<Integer> task2 = new GraphNode<Integer>(2);
		GraphNode<Integer> task3 = new GraphNode<Integer>(3);
		GraphNode<Integer> task4 = new GraphNode<Integer>(20);
		task1.edges.put(task2,0);
		task1.edges.put(task3,0);
		task2.edges.put(task1,0);
		HashSet<GraphNode<Integer>> tasks = new HashSet<GraphNode<Integer>>();
		tasks.add(task1);
		tasks.add(task2);
		tasks.add(task3);
		tasks.add(task4);
		System.out.println(findCompletionTime(tasks));
	}
	
	public static int findCompletionTime(Set<GraphNode<Integer>> tasks)
	{
		HashMap<GraphNode<Integer>, Integer> completionTime = new HashMap<GraphNode<Integer>, Integer>();
		HashSet<GraphNode<Integer>> parents = new HashSet<GraphNode<Integer>>();
		int max = Integer.MIN_VALUE;
		for(GraphNode<Integer> node : tasks)
		{
			if(completionTime.containsKey(node))
			{
				continue;
			}
			int result = DFS(node, completionTime,parents);
			if(result == -1)
			{
				// Found loop, never mind
				return -1;
			}
			max = Math.max(max,result);
		}
		return max;
	}
	
	public static int DFS(GraphNode<Integer> node, HashMap<GraphNode<Integer>, Integer> completionTime, HashSet<GraphNode<Integer>> parents)
	{
		// If there is a loop
		if(parents.contains(node))
		{
			return -1;
		}
		
		// Get previous calculated result
		Integer maxCompletionTime = completionTime.get(node);
		if(maxCompletionTime != null)
		{
			return maxCompletionTime;
		}
		
		// Add current node to parents
		parents.add(node);
		
		maxCompletionTime = Integer.MIN_VALUE;
		for(GraphNode<Integer> child:node.edges.keySet())
		{
			int childCompletionTime = DFS(child, completionTime,parents);
			// If a loop is already detected
			if(childCompletionTime == -1)
			{
				return -1;
			}
			// Take the maximum among all the children
			maxCompletionTime = Math.max(maxCompletionTime, childCompletionTime);
		}
		//If have no child
		if(node.edges.keySet().size() == 0)
		{
			maxCompletionTime = 0;
		}
		
		completionTime.put(node, maxCompletionTime + node.data);
		
		parents.remove(node);
		return maxCompletionTime + node.data;
	}
}
