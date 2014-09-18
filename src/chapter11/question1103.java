package chapter11;

public class question1103 {

	public static int searchIndexEqualValue(int[] a) {
		int p = 0;
		int q = a.length - 1;
		while (p <= q) {
			int m = (p + q) / 2;
			if (a[m] == m) {
				return m;
			} else if (a[m] > m) {
				q = m - 1;
			} else {
				p = m + 1;
			}
		}
		return -1;
	}
}
