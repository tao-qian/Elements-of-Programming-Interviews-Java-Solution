package chapter15;

public class question1505 {

	public static int circularMaxSubarraySum(int[] a) {
		int lastMin = 0;
		int min = Integer.MAX_VALUE;
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
			lastMin = Math.min(0, lastMin + a[i]);
			min = Math.min(lastMin, min);
		}
		return sum - min;
	}

	public static int maxSubarraySum(int[] a) {
		int max = Integer.MIN_VALUE;
		int lastMax = 0;
		for (int i = 0; i < a.length; i++) {
			lastMax = Math.max(0, lastMax + a[i]);
			max = Math.max(max, lastMax);
		}
		return max;
	}
}
