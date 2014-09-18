package chapter13;

import java.util.*;

// Not tested :(
public class question1311 {

	public static class Interval {
		int start;
		int end;
		boolean startInclusive;
		boolean endInclusive;

		public Interval(int start, int end, boolean startInclusive,
				boolean endInclusive) {
			this.start = start;
			this.end = end;
			this.startInclusive = startInclusive;
			this.endInclusive = endInclusive;
		}
	}

	public static ArrayList<Interval> unionOfIntervals(
			ArrayList<Interval> intervals) {
		ArrayList<Interval> union = new ArrayList<Interval>();
		Collections.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				int diff = o1.start - o2.start;
				if (diff != 0) {
					return diff;
				}
				if (o1.startInclusive) {
					return 1;
				} else {
					return -1;
				}
			}
		});
		Interval current = null;
		for (int i = 0; i < intervals.size(); i++) {
			if (current == null) {
				current = intervals.get(i);
				continue;
			}
			// The next interval and the current one are not connected
			if (intervals.get(i).start > current.end
					|| (intervals.get(i).start == current.end
							&& !intervals.get(i).startInclusive && !current.endInclusive)) {
				union.add(current);
				current = intervals.get(i);
				continue;
			}
			// Otherwise we update current to be an union of the old one and the
			// new interval
			current.end = intervals.get(i).end;
			current.endInclusive = intervals.get(i).endInclusive;
		}
		union.add(current);
		return union;
	}
}
