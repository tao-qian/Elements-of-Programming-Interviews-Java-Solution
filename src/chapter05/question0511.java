package chapter05;

import java.util.ArrayList;

import Util.Utility;

public class question0511 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Utility.print(sieve(43));
	}

	public static ArrayList<Integer> sieve(int n) {
		boolean[] a = new boolean[n + 1];
		for (int i = 0; i < a.length; i++)
			a[i] = true;
		for (int i = 2; i <= n / 2; i++) {
			int crossout = i * i;
			while (crossout <= n) {
				a[crossout] = false;
				crossout += i;
			}
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 2; i < a.length; i++)
			if (a[i])
				list.add(i);
		return list;
	}

}
