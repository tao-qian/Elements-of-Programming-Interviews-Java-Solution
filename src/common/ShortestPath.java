package common;

import java.util.*;

public class ShortestPath {

	public static int NO_PATH = -1;

	public static int Dijkstra(int[][] matrix, int start, int end) {
		HashSet<Integer> unvisited = new HashSet<Integer>(0);
		for (int i = 0; i < matrix.length; i++) {
			unvisited.add(i);
		}
		int[] distance = new int[matrix.length];
		for (int i = 0; i < distance.length; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		distance[start] = 0;
		while (unvisited.size() != 0) {
			// First get the node with the shortest distance from start
			int shortestDistance = Integer.MAX_VALUE;
			int closestNode = -1;
			// O(N) operation here. Use min-heap to improve running time
			for (Integer i : unvisited) {
				if (shortestDistance > distance[i]) {
					shortestDistance = distance[i];
					closestNode = i;
				}
			}

			unvisited.remove(closestNode);

			if (closestNode == end) {
				return shortestDistance;
			}

			for (int i = 0; i < matrix[closestNode].length; i++) {
				if (matrix[closestNode][i] == NO_PATH || !unvisited.contains(i)) {
					continue;
				}
				int newDis = distance[closestNode] + matrix[closestNode][i];
				if (newDis < distance[i]) {
					distance[i] = newDis;
				}
			}
		}
		return -1;
	}
}
