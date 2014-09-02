package common;

public class SelectIndexEqualValue {

	public static void main(String[] args) {
		// 0, 1,2,3,4,5,6,7,8,9,10
		int[] a = new int[] { -2, 0, 2, 2, 2, 4, 8, 9, 10 };
		System.out.println(selectDuplicate(a, 0, a.length - 1));

	}

	public static int selectDuplicate(int[] a, int p, int q) {
		if (q < p)
			return -1;
		int m = (p + q) / 2;
		int num = a[m];
		if (num == m)
			return m;
		if (num < m) {
			int rightResult = selectDuplicate(a, m + 1, q);
			if (rightResult != -1)
				return rightResult;
			int leftResult = selectDuplicate(a, Math.max(p, num), m - 1);
			if (leftResult != -1)
				return leftResult;
		}
		if (num > m) {
			int rightResult = selectDuplicate(a, m + 1, Math.min(q, num));
			if (rightResult != -1)
				return rightResult;
			int leftResult = selectDuplicate(a, p, m - 1);
			return leftResult;
		}
		return -1;
	}

	/**
	 * Find the index in array a which has the property a[i] = i. The elements
	 * of the array must be distinct.
	 * 
	 * @param a
	 *            the array
	 * @return the index if such element exists, -1 otherwise.
	 */
	public static int selectDistinct(int[] a) {
		int m = a.length / 2;
		int p = 0;
		int q = a.length - 1;
		while (p <= q) {
			m = (p + q) / 2;
			int num = a[m];
			if (num == m)
				return m;
			if (num < m)
				p = m + 1;
			else if (num > m)
				q = m - 1;
		}
		return -1;
	}

}
