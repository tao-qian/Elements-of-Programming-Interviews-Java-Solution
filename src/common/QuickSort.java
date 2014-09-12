package common;

import Util.Utility;

public class QuickSort {

	public static void main(String[] args) {
		int[] array = new int[] { 2,9 ,4,2,3,2,1,4,5,1 };
		quicksort(array, 0, array.length - 1);
		Utility.print(array);
	}

	public static void quicksort(int[] a, int p, int q) {
		if (p >= q)
			return;
		int m = partition(a, p, q);
		quicksort(a, p, m - 1);
		quicksort(a, m, q);
	}

	public static int partition(int[] a, int p, int q) {
		int pivot = a[(p + q) / 2];
		while (p <= q) {
			if (a[p] < pivot)
				p++;
			else if (a[q] > pivot)
				q--;
			else {
				int temp = a[p];
				a[p] = a[q];
				a[q] = temp;
				p++;
				q--;
			}
		}
		return p;
	}
}
