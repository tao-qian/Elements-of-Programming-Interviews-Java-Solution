package chapter16;

import java.util.*;

public class question1609 {

	public static class MetaData
	{
		int distance;
		int steps;
		GraphNode<MetaData> lastNode;
		
		public MetaData()
		{
			this(Integer.MAX_VALUE, Integer.MAX_VALUE, null);
		}
		
		public MetaData(int distance, int steps)
		{
			this(distance, steps, null);
		}
		
		public MetaData(int distance, int steps, GraphNode<MetaData> lastNode)
		{
			this.distance = distance;
			this.steps = steps;
			this.lastNode = lastNode;
		}
	}
	
	public static LinkedList<GraphNode<MetaData>> shortestPathFewestEdges(GraphNode<MetaData> start, GraphNode<MetaData> end, Set<GraphNode<MetaData>> nodes)
	{
		TreeSet<GraphNode<MetaData>> minQueue = new TreeSet<GraphNode<MetaData>>(new Comparator<GraphNode<MetaData>>(){
			@Override
			public int compare(GraphNode<MetaData> o1, GraphNode<MetaData> o2) {
				int distanceDiff = o1.data.distance - o2.data.distance;
				if(distanceDiff != 0)
				{
					return distanceDiff;
				}
				return o1.data.steps - o2.data.steps;
			}
		});
		
		minQueue.addAll(nodes);
		minQueue.remove(start);
		start.data.distance = 0;
		start.data.steps = 0;
		minQueue.add(start);
		
		while(minQueue.size() != 0)
		{
			GraphNode<MetaData> current = minQueue.pollFirst();
			for(GraphNode<MetaData> child : current.edges.keySet())
			{
				int newDistance = current.data.distance + current.edges.get(child);
				int newSteps = current.data.steps + 1;
				if(child.data.distance > newDistance ||(child.data.distance == newDistance && child.data.steps > newSteps))
				{
					minQueue.remove(child);
					child.data.distance = newDistance;
					child.data.steps = newSteps;
					child.data.lastNode = current;
					minQueue.add(child);
				}
			}
		}
		
		LinkedList<GraphNode<MetaData>> result = new LinkedList<GraphNode<MetaData>>();
		while(end != null)
		{
			result.addFirst(end);
			end = end.data.lastNode;
		}
		return result; 
	}
}
