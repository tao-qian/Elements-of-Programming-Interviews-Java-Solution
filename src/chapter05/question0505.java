package chapter05;

import java.util.*;

public class question0505 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashSet<Integer> original = new HashSet<Integer>();
		original.add(0);
		original.add(1);
		original.add(2);
		original.add(3);
		original.add(4);

		HashSet<HashSet<Integer>> starter = new HashSet<HashSet<Integer>>();
		starter.add(new HashSet<Integer>());

		HashSet<HashSet<Integer>> result = powerSetK(starter, original, 3);
		for (HashSet<Integer> r : result) {

			Util.Utility.print(r);
			System.out.println();
		}
	}

	public static HashSet<HashSet<Integer>> powerSet(HashSet<Integer> set) {
		HashSet<HashSet<Integer>> powerSet = new HashSet<HashSet<Integer>>();
		powerSet.add(new HashSet<Integer>());
		for (Integer i : set) {
			HashSet<HashSet<Integer>> newPowerSet = cloneNested(powerSet);
			for (HashSet<Integer> old : newPowerSet) {
				old.add(i);
			}
			powerSet.addAll(newPowerSet);
		}
		return powerSet;
	}

	public static HashSet<HashSet<Integer>> powerSetK(
			HashSet<HashSet<Integer>> result, HashSet<Integer> set, int k) {
		if (k == 0)
			return result;
		HashSet<HashSet<Integer>> finalResult = new HashSet<HashSet<Integer>>();
		for (Integer i : set) {
			HashSet<HashSet<Integer>> newResult = cloneNested(result);
			for (HashSet<Integer> lastResult : newResult) {
				lastResult.add(i);
			}
			HashSet<Integer> cloned = clone(set);
			cloned.remove(i);
			finalResult.addAll(powerSetK(newResult, cloned, k - 1));
		}
		return finalResult;
	}

	public static HashSet<HashSet<Integer>> cloneNested(
			HashSet<HashSet<Integer>> s) {
		HashSet<HashSet<Integer>> newS = new HashSet<HashSet<Integer>>();
		for (HashSet<Integer> ss : s) {
			newS.add(clone(ss));
		}
		return newS;
	}

	public static HashSet<Integer> clone(HashSet<Integer> s) {
		HashSet<Integer> newS = new HashSet<Integer>();
		for (Integer i : s)
			newS.add(i);
		return newS;
	}
}
