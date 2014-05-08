package chapter13;

import java.util.ArrayList;

import Util.Utility;

public class question1305 {

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 2, 3, 4, 5, 6, 8 };
		int[] b = new int[] { 1, 3, 4, 5 };
		Utility.print(findDuplicates(a, b));
	}

	public static ArrayList<Integer> findDuplicates(int[] a, int[] b) {
		int p1 = 0;
		int p2 = 0;
		ArrayList<Integer> result = new ArrayList<Integer>();
		while (p1 < a.length && p2 < b.length) {
			if (a[p1] == b[p2]) {
				result.add(a[p1]);
				p1++;
				p2++;
			} else if (a[p1] > b[p2]) {
				p2++;
			} else {
				p1++;
			}
		}
		return result;
	}

}
