package chapter11;

public class question1102 {

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(findFirstLarger(a, 5));
	}

	public static int findFirstLarger(int[] a, int n) {
		int p = 0;
		int q = a.length - 1;
		int larger = -1;
		while (p <= q) {
			int m = (p + q) / 2;
			if (a[m] > n) {
				larger = m;
				q = m - 1;
			} else {
				p = m + 1;
			}
		}
		return larger;
	}
}
