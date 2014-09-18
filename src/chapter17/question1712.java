package chapter17;

import java.util.*;

public class question1712 {

	public static void main(String[] args) throws Exception {
		System.out.println(collatzConjuncture(100000000));
	}

	public static boolean collatzConjuncture(int k) throws Exception {
		HashSet<Integer> tested = new HashSet<Integer>();
		for (int i = 2; i <= k; i++) {
			int n = i;
			HashSet<Integer> checked = new HashSet<Integer>();
			while (true) {
				if (n % 2 == 0) {
					n >>= 1;
					continue;
				}
				if (tested.contains(n) || n < i || n == 1) {
					break;
				}
				if (checked.contains(n)) {
					return false;
				}
				checked.add(n);
				int newN = n * 3 + 1;
				if (newN < n) {
					throw new Exception("Overflowed!");
				}
				n = newN;
			}
			for (Integer j : checked) {
				tested.add(j);
			}
			tested.add(i);
		}
		return true;
	}
}
