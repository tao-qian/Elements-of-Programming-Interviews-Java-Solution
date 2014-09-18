package common;

import java.util.*;

public class PartialOrdering<K> {

	public static void main(String[] args) {
		ArrayList<Box> boxes = new ArrayList<Box>();
		boxes.add(new Box(2, 3));
		boxes.add(new Box(2, 3));
		boxes.add(new Box(2, 3));
		System.out.println(getLongest(boxes));
	}

	// For testing
	public static class Box implements PartialComparable<Box> {
		int width;
		int height;

		public Box(int width, int height) {
			this.width = width;
			this.height = height;
		}

		@Override
		public int compareTo(Box o) {
			if (!isComparable(o)) {
				throw new RuntimeException("Not comparable");
			}
			int wDiff = width - o.width;
			int hDiff = height - o.height;
			if (wDiff == 0 && hDiff == 0) {
				return 0;
			} else if (wDiff >= 0 && hDiff >= 0) {
				return 1;
			}
			return -1;
		}

		@Override
		public boolean isComparable(Box o) {
			if ((width >= o.width && height >= o.height)
					|| (width <= o.width && height <= o.height)) {
				return true;
			}
			return false;
		}

	}

	public interface PartialComparable<T> extends Comparable<T> {
		boolean isComparable(T object);
	}

	public static <T extends PartialComparable<T>> int getLongest(ArrayList<T> a) {
		int longest = 0;
		HashMap<T, Integer> cache = new HashMap<T, Integer>();
		for (int i = 0; i < a.size(); i++) {
			longest = Math.max(longest, topologicalDFS(a, cache, a.get(i)));
		}
		return longest;
	}

	public static <T extends PartialComparable<T>> Integer topologicalDFS(
			ArrayList<T> a, HashMap<T, Integer> cache, T current) {
		// If already calculated, we return the result
		if (cache.containsKey(current)) {
			return cache.get(current);
		}
		// Otherwise, we get the longest result
		int longest = 0;
		for (T node : a) {
			if (node == current) {
				continue;
			}
			if (!node.isComparable(current)) {
				continue;
			}
			if (node.compareTo(current) > 0) {
				longest = Math.max(topologicalDFS(a, cache, node), longest);
			}
		}
		longest += 1;
		cache.put(current, longest);
		return longest;

	}
}
