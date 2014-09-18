package chapter11;

public class question1105 {

	public static void main(String[] args) {
		int[] a = new int[] { 3, 1, 2 };
		System.out.println(searchCyclicSorted(a));
	}

	public static int searchCyclicSorted(int[] a) {
		int p = 0;
		int q = a.length - 1;
		while (p < q) {
			int m = (p + q) / 2;
			if (a[m] > a[q]) {
				p = m + 1;
			} else {
				q = m;
			}
		}
		return p;
	}
}
