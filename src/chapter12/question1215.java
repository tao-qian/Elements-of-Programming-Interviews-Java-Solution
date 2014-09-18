package chapter12;

import java.util.*;

public class question1215 {

	public static void main(String[] args) {
		String[] a = { "a", "b", "c", "d", "a", "c", "d" };
		String[] q = { "a", "d" };
		Util.Utility.print(subarraySequentialCoveringSet(a, q));
	}

	// The implementation here is different from that in the book.
	// we use more space O(a.length) instead of O(q.length)
	public static int[] subarraySequentialCoveringSet(String[] a, String[] q) {
		HashMap<String, Integer> indexMap = new HashMap<String, Integer>();
		for (int i = 0; i < q.length; i++) {
			indexMap.put(q[i], i);
		}

		int[] lastSeen = new int[q.length];
		int[] startingIndexForShortest = new int[a.length];

		// Used to record the best result
		int shortestLength = Integer.MAX_VALUE;
		int shortestStart = -1;
		int shortestEnd = -1;

		for (int i = 0; i < a.length; i++) {
			Integer wordIndex = indexMap.get(a[i]);
			if (wordIndex == null) {
				continue;
			}
			if (wordIndex == 0) {
				// starting index is itself if the word is the first one in q.
				startingIndexForShortest[i] = i;
			} else {
				int lastWordLastSeen = lastSeen[wordIndex - 1];
				startingIndexForShortest[i] = startingIndexForShortest[lastWordLastSeen];
				// Check for the case when we matched all words in q
				if (wordIndex == q.length - 1) {
					int newShortestLength = i - startingIndexForShortest[i];
					if (shortestLength > newShortestLength) {
						shortestLength = newShortestLength;
						shortestStart = startingIndexForShortest[i];
						shortestEnd = i;
					}
				}
			}

			// update lastSeen
			lastSeen[wordIndex] = i;
		}

		return new int[] { shortestStart, shortestEnd };
	}
}
