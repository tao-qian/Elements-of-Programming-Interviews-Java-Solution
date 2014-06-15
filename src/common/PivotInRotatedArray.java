package common;

public class PivotInRotatedArray {

	public static void main(String[] args) {
		int[] a = new int[] { 4, 5 };
		System.out.println(findRotationPoint(a));
	}

	public static int findRotationPoint(int[] a) {
		int p = 0;
		int q = a.length - 1;
		while (p <= q) {
			int m = (p + q) / 2;
			if (a[m] > a[q]) {
				p = m + 1;
				if (a[p] < a[m])
					return a[m];
			} else if (a[m] < a[p]) {
				q = m - 1;
				if (a[q] > a[m])
					return a[q];
			}
		}
		return -1;
	}
}
