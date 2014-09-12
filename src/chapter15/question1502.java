package chapter15;

public class question1502 {

	public static void main(String[] args) {
		int[] a = new int[] { 1, 3, 2, 5, 3, 4, 6, 7, 4, 2, 8 };
		mergesort(a, 0, a.length - 1);
		Util.Utility.print(a);
	}

	public static int mergesort(int[] a, int p, int q) {
		if (q <= p)
			return 0;
		int m = (p + q) / 2;
		int inversion = 0;
		inversion += mergesort(a, p, m);
		inversion += mergesort(a, m + 1, q);
		inversion += merge(a, p, q, m);
		return inversion;
	}

	public static int merge(int[] a, int p, int q, int m) {
		int inversion = 0;
		int[] helper = new int[q - p + 1];
		for (int i = p; i <= q; i++)
			helper[i - p] = a[i];
		int r1 = p;
		int r2 = m + 1;
		int r3 = p;
		while (r1 <= m && r2 <= q) {
			if (a[r1] <= a[r2]) {
				a[r3] = helper[r1 - p];
				r1++;
			} else {
				inversion += m - r1 + 1;
				a[r3] = helper[r2 - p];
				r2++;
			}
			r3++;
		}
		while (r1 <= m) {
			a[r3] = helper[r1 - p];
			r3++;
			r1++;
		}
		return inversion;
	}

}
