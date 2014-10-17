package chapter13;

import java.util.*;

public class question1312 {

	public static void main(String[] args) {
		TreeSet<Integer> m = new TreeSet<Integer>();
		HashSet<Integer> toBeRemoved = new HashSet<Integer>();
		m.add(1);
		m.add(2);
		m.add(3);
		for (Integer i : m) {
			toBeRemoved.remove(i);
		}
		for (Integer i : toBeRemoved) {
			m.remove(i);
		}
	}

	public static class Interval implements Comparable<Interval> {
		int start;
		int end;

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Interval o) {
			return this.end - o.end;
		}
	}

	public static ArrayList<Integer> coveringIntervals(
			ArrayList<Interval> intervals) {
		TreeSet<Interval> map = new TreeSet<Interval>(intervals);
		ArrayList<Integer> result = new ArrayList<Integer>();
		while (map.size() != 0) {
			Interval current = map.pollFirst();
			HashSet<Interval> toBeRemoved = new HashSet<Interval>();
			for (Interval i : map) {
				if (i.end <= current.end && i.start >= current.end) {
					toBeRemoved.add(i);
				}
			}
			for (Interval i : toBeRemoved) {
				map.remove(i);
			}
			result.add(current.end);
		}
		return result;
	}
}
