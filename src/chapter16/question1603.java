package chapter16;

import java.util.*;

public class question1603 {

	public boolean colorNodes(boolean[][] matrix) {
		int[] distance = new int[matrix.length];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		while (queue.size() != 0) {
			Integer current = queue.pollFirst();
			for (int i = 0; i < matrix[current].length; i++) {
				if (!matrix[current][i]) {
					continue;
				}
				if (distance[i] == 0) {
					queue.add(i);
					distance[i] = distance[current] + 1;
				} else if (distance[current] == distance[i]) {
					return false;
				}
			}
		}
		return true;
	}
}
