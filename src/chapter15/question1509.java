package chapter15;

public class question1509 {

	public static void main(String[] args) {
		Boolean[][] a = new Boolean[5][5];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (i == 3 || j == 3) {
					a[i][j] = false;
				} else {
					a[i][j] = true;
				}
			}
		}

		Util.Utility.print(a);
		System.out.println(twoDimensionAllOne(a));

	}

	public static int twoDimensionAllOne(Boolean[][] a) {

		int h = a.length;
		int w = a[0].length;
		int[][] horizontalMax = new int[h][w];
		int[][] verticalMax = new int[h][w];

		// Build the horizontal max.
		for (int i = 0; i < h; i++) {
			int start = 0;
			for (int j = 0; j < w; j++) {
				if (a[i][j] == false) {
					int max = 0;
					for (int k = j; k >= start; k--) {
						horizontalMax[i][k] = max;
						max++;
					}
					start = j + 1;
				}
			}
			if (start < w) {
				int max = 1;
				for (int k = w - 1; k >= start; k--) {
					horizontalMax[i][k] = max;
					max++;
				}
			}
		}

		// Build the vertical max
		for (int i = 0; i < w; i++) {
			int start = 0;
			for (int j = 0; j < h; j++) {
				if (a[j][i] == false) {
					int max = 0;
					for (int k = j; k >= start; k--) {
						verticalMax[k][i] = max;
						max++;
					}
					start = j + 1;
				}
			}
			if (start < h) {
				int max = 1;
				for (int k = h - 1; k >= start; k--) {
					verticalMax[k][i] = max;
					max++;
				}
			}
		}

		int maxArea = Integer.MIN_VALUE;

		// Here we calculate and record the max rectangle area
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (!a[i][j]) {
					continue;
				}
				if (horizontalMax[i][j] * verticalMax[i][j] < maxArea) {
					continue;
				}
				int minWidth = Integer.MAX_VALUE;
				for (int k = 0; k < verticalMax[i][j]; k++) {
					minWidth = Math.min(minWidth, horizontalMax[i + k][j]);
					maxArea = Math.max(maxArea, minWidth * (k + 1));
				}
			}
		}
		return maxArea;
	}
}
