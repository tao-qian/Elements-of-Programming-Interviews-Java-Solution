package chapter16;

import java.util.*;

public class question1604 {
	
	public static void main(String[] args)
	{
		GraphNode<Integer> node1 = new GraphNode<Integer>(1);
		GraphNode<Integer> node2 = new GraphNode<Integer>(2);
		GraphNode<Integer> node3 = new GraphNode<Integer>(3);
		GraphNode<Integer> node4 = new GraphNode<Integer>(4);
		GraphNode<Integer> node5 = new GraphNode<Integer>(5);
		GraphNode<Integer> node6 = new GraphNode<Integer>(6);
		
		node1.edges.put(node2,0);
		node2.edges.put(node3,0);
		node3.edges.put(node1,0);
		node3.edges.put(node4,0);
		HashMap<GraphNode<Integer>, Integer> discovery = new HashMap<GraphNode<Integer>, Integer> ();
		HashMap<GraphNode<Integer>, Integer> min = new HashMap<GraphNode<Integer>, Integer> ();
		discovery.put(node1,0);
		min.put(node1,Integer.MAX_VALUE);
		
		System.out.println(isTwoAllConnected(node1,discovery, min));
		
	}
	
	public static boolean isTwoAllConnected(GraphNode<Integer> node, HashMap<GraphNode<Integer>, Integer> discoveryTime, HashMap<GraphNode<Integer>, Integer> minDescendantsDiscovery)
	{
		int discovery = discoveryTime.get(node);
		int min = minDescendantsDiscovery.get(node);
		for(GraphNode<Integer> child: node.edges.keySet())
		{
			if(discoveryTime.get(child) == null)
			{
				discoveryTime.put(child, discovery+1);
				minDescendantsDiscovery.put(child, Integer.MAX_VALUE);
				if(!isTwoAllConnected(child, discoveryTime,minDescendantsDiscovery))
				{
					return false;
				}
				int childMin = Math.min(discovery+1, minDescendantsDiscovery.get(child));
				if(min > childMin)
				{
					min = childMin;
					minDescendantsDiscovery.put(node, min);
				}
			}
			else
			{
				int newMin = Math.min(discoveryTime.get(child),min);
				newMin = Math.min(minDescendantsDiscovery.get(child),newMin);
				if(newMin != min)
				{
					min = newMin;
					minDescendantsDiscovery.put(node, min);
				}
			}
		}
		if(min > discovery)
		{
			return false;
		}
		return true;
	}
	
	public static boolean isTwoExistConnected(GraphNode<Integer> node)
	{
		return hasCycle(node,new HashSet<GraphNode<Integer>>(), new HashSet<GraphNode<Integer>>());
	}
	
	public static boolean hasCycle(GraphNode<Integer> node, HashSet<GraphNode<Integer>> checked, HashSet<GraphNode<Integer>> checking)
	{
		// Existence of a loop
		if(checking.contains(node))
		{
			return true;
		}
		// Existence of a cross edge
		if(checked.contains(node))
		{
			return false;
		}
		
		checking.add(node);
		for(GraphNode<Integer> connection : node.edges.keySet())
		{
			if(hasCycle(connection, checked, checking))
			{
				return true;
			}
		}
		checking.remove(node);
		checked.add(node);
		return false;
	}
}
