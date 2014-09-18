package chapter13;

public class question1315 {

	public static void main(String[] args) {
		int[] a = new int[] { 3, 2, 4, 5, 2, 1, 3 };
		pancakeSort(a);
		Util.Utility.print(a);
	}

	public static void pancakeSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int maxIndex = findMax(a, a.length - i);
			if (maxIndex != a.length - i - 1) {
				flip(a, maxIndex + 1);
				flip(a, a.length - i);
			}
		}
	}

	public static int findMax(int[] a, int n) {
		if (n > a.length) {
			return -1;
		}
		int max = Integer.MIN_VALUE;
		int maxIndex = -1;
		for (int i = 0; i < n; i++) {
			if (a[i] > max) {
				max = a[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}

	public static void flip(int[] a, int n) {
		if (n > a.length) {
			return;
		}
		for (int i = 0; i < n / 2; i++) {
			int temp = a[i];
			a[i] = a[n - 1 - i];
			a[n - 1 - i] = temp;
		}
	}
}
