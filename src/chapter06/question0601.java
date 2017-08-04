package chapter06;

import Util.*;

public class question0601 {

	public static void main(String[] args) {
		int[] a = new int[] { 2, 4, 1, 5, 2, 3, 6, 2 };
		partition(a, 0);
		Utility.print(a);
	}

	public static void partition(int[] a, int i) {
		int pivot = a[i];
		int smaller = 0;
		int equal = 0;
		int larger = a.length - 1;
		while (equal <= larger) {
			if (a[equal] < pivot) {
				swap(a, smaller, equal);
				smaller++;
				equal++;
			} else if (a[equal] == pivot) {
				equal++;
			} else {
				swap(a, equal, --larger);
			}
		}
	}

	public static void swap(int[] a, int p, int q) {
		int temp = a[q];
		a[q] = a[p];
		a[p] = temp;
	}

}
