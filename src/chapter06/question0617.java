package chapter06;

import Util.Utility;

public class question0617 {

	public static void main(String[] args) {
		// int[][] rect = new int[][]{new int[]{1,2,3},new int[]{8,9,4},new
		// int[]{7,6,5}};
		int[][] rect = new int[][] { new int[] { 1, 2 }, new int[] { 4, 3 } };
		Utility.print(rotate(rect));
	}

	public static int[][] rotate(int[][] m) {
		int startX = 0;
		int endX = m.length - 1;
		int startY = 0;
		int endY = m.length - 1;
		while (startY < endY) {
			for (int i = 0; i < endY - startY; i++) {
				int temp = m[startX][startY + i];
				m[startX][startY + i] = m[endX - i][startY];
				m[endX - i][startY] = m[endX][endY - i];
				m[endX][endY - i] = m[startX + i][endY];
				m[startX + i][endY] = temp;
			}
			startX++;
			endX--;
			startY++;
			endY--;
		}
		return m;
	}

}
