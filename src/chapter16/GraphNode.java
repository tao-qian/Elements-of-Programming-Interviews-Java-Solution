package chapter16;

import java.util.*;

public class GraphNode<T> {
	T data;
	HashMap<GraphNode<T>, Integer> edges;
	public GraphNode(T data)
	{
		this.data = data;
		edges = new HashMap<GraphNode<T>, Integer>();
	}
}
