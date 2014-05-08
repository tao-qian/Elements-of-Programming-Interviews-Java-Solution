package common;

public class Selection {

	public static void main(String[] args) {
		int[] a = new int[] { 0, 3, 2, 1 };
		System.out.println(rank(a, 0, a.length - 1, 2));
	}

	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}

	public static int randomIntInRange(int min, int max) {
		return randomInt(max + 1 - min) + min;
	}

	public static int partition(int[] array, int left, int right, int pivot) {
		while (true) {
			while (left <= right && array[left] <= pivot) {
				left++;
			}

			while (left <= right && array[right] > pivot) {
				right--;
			}

			if (left > right) {
				return left - 1;
			}
			swap(array, left, right);
		}
	}

	public static int max(int[] array, int left, int right) {
		int max = Integer.MIN_VALUE;
		for (int i = left; i <= right; i++) {
			max = Math.max(array[i], max);
		}
		return max;
	}

	public static int rank(int[] array, int left, int right, int rank) {
		int pivot = array[randomIntInRange(left, right)];
		int leftEnd = partition(array, left, right, pivot); // returns end of
															// left partition
		int leftSize = leftEnd - left + 1;
		if (leftSize == rank + 1) {
			return max(array, left, leftEnd);
		} else if (rank < leftSize) {
			return rank(array, left, leftEnd, rank);
		} else {
			return rank(array, leftEnd + 1, right, rank - leftSize);
		}
	}

	public static void swap(int[] a, int p, int q) {
		int temp = a[p];
		a[p] = a[q];
		a[q] = temp;

	}
}
