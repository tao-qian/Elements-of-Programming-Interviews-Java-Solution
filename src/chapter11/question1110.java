package chapter11;

public class question1110 {
	public static void main(String[] args) {
		int[][] a = new int[][] { new int[] { 1, 2 }, new int[] { 3, 4 } };
		Util.Utility.print(searchIn2D(a, 1));
	}

	public static int[] searchIn2D(int[][] a, int n) {
		int numRow = a.length;
		int numCol = a[0].length;
		int rowIndex = 0;
		int colIndex = numCol - 1;
		while (rowIndex < numRow && colIndex >= 0) {
			if (a[rowIndex][colIndex] == n) {
				return new int[] { rowIndex, colIndex };
			} else if (a[rowIndex][colIndex] < n) {
				rowIndex++;
			} else {
				colIndex--;
			}
		}
		return new int[] { -1, -1 };
	}
}
