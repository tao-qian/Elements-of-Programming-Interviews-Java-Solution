package chapter13;

import java.util.Arrays;

public class question1314 {
	public static void main(String[] args) {
		int[] a = new int[] { 2, 3, 4, 3, 5, 6, 7, 3, 2, 3, 4 };
		int sum = 18;
		System.out.println(threeSum(a, sum));
	}

	public static boolean threeSum(int[] a, int sum) {
		Arrays.sort(a);
		for (int i = 0; i < a.length; i++) {
			int twoSum = sum - a[i];
			int p1 = i + 1;
			int p2 = a.length - 1;
			while (p1 < p2) {
				int currentTwoSum = a[p1] + a[p2];
				if (currentTwoSum == twoSum) {
					return true;
				}
				if (currentTwoSum > twoSum) {
					p2--;
				} else {
					p1++;
				}
			}
		}
		return false;
	}
}
