package chapter12;

import java.util.*;

import common.DoublyLinkedList;
import common.DoublyLinkedList.DoublyLinkedListNode;

public class question1214 {

	public static void main(String[] args) {
		String[] a = { "a", "b", "c", "d", "a", "c", "d" };
		String[] q = { "a", "d" };
		Util.Utility.print(subarrayCoveringSet(a, q));
	}

	public static int[] subarrayCoveringSet(String[] a, String[] q) {
		// Store q in a HashSet for faster access.
		HashSet<String> qMatches = new HashSet<String>();
		for (int i = 0; i < q.length; i++) {
			qMatches.add(q[i]);
		}

		DoublyLinkedList<Integer> matchIndices = new DoublyLinkedList<Integer>();

		int minStart = -1;
		int minEnd = -1;
		int minInterval = Integer.MAX_VALUE;
		HashMap<String, DoublyLinkedListNode<Integer>> matchMap = new HashMap<String, DoublyLinkedListNode<Integer>>();
		for (int i = 0; i < a.length; i++) {
			// Do nothing if the next word in a does not match anything in q
			if (!qMatches.contains(a[i])) {
				continue;
			}

			// Find the last match we had and delete it
			DoublyLinkedListNode<Integer> lastMatch = matchMap.get(a[i]);
			if (lastMatch != null) {
				matchIndices.remove(lastMatch);
			}

			// Add the new match to the doubly linked list and HashMap
			DoublyLinkedListNode<Integer> newMatch = new DoublyLinkedListNode<Integer>(
					i);
			matchMap.put(a[i], newMatch);
			matchIndices.append(newMatch);

			// Then we update the min length if a better result is found
			if (matchIndices.size == q.length) {
				int newInterval = matchIndices.tail.data
						- matchIndices.head.data;
				if (newInterval < minInterval) {
					minStart = matchIndices.head.data;
					minEnd = matchIndices.tail.data;
					minInterval = newInterval;
				}
			}
		}
		return new int[] { minStart, minEnd };
	}
}
