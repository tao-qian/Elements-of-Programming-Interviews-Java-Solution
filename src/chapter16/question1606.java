package chapter16;

import java.util.*;

public class question1606 {

	public static void main(String[] args) {
		ArrayList<Constraint> equal = new ArrayList<Constraint>();
		ArrayList<Constraint> notEqual = new ArrayList<Constraint>();
		equal.add(new Constraint(1, 2));
		equal.add(new Constraint(2, 3));
		equal.add(new Constraint(3, 4));
		equal.add(new Constraint(1, 3));
		equal.add(new Constraint(2, 4));
		equal.add(new Constraint(1, 5));

		notEqual.add(new Constraint(1, 5));
		System.out.println(isPossible(equal, notEqual));

	}

	public static class Constraint {
		int a;
		int b;

		public Constraint(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

	public static boolean isPossible(ArrayList<Constraint> equal,
			ArrayList<Constraint> notEqual) {
		// First build the groups
		HashMap<Integer, HashSet<Integer>> group = new HashMap<Integer, HashSet<Integer>>();
		for (int i = 0; i < equal.size(); i++) {
			int a = equal.get(i).a;
			int b = equal.get(i).b;
			HashSet<Integer> currentGroup1 = group.get(a);
			HashSet<Integer> currentGroup2 = group.get(b);
			if (currentGroup1 == null && currentGroup2 == null) {
				HashSet<Integer> newSet = new HashSet<Integer>();
				newSet.add(a);
				newSet.add(b);
				group.put(a, newSet);
				group.put(b, newSet);
			} else if (currentGroup1 == null) {
				currentGroup2.add(a);
				group.put(a, currentGroup2);
			} else if (currentGroup2 == null) {
				currentGroup1.add(b);
				group.put(b, currentGroup1);
			} else {
				for (Integer n : currentGroup2) {
					group.put(n, currentGroup1);
				}
				currentGroup1.addAll(currentGroup2);
			}
		}

		// Then check for inequality.
		for (int i = 0; i < notEqual.size(); i++) {
			int a = notEqual.get(i).a;
			int b = notEqual.get(i).b;
			if (group.get(a) == group.get(b)) {
				return false;
			}
		}
		return true;
	}
}
