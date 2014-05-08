package chapter06;

import java.util.ArrayList;

import Util.Utility;

public class question0615 {

	public static void main(String args[]) {
		int[][] rect = new int[][] { new int[] { 1, 2, 3 },
				new int[] { 4, 5, 6 }, new int[] { 7, 8, 9 } };
		Utility.print(spiralOrder(rect));
	}

	public static ArrayList<Integer> spiralOrder(int[][] rect) {
		int totalSize = rect.length * rect[0].length;
		ArrayList<Integer> result = new ArrayList<Integer>();

		int xStart = 0;
		int yStart = 0;
		int xEnd = rect.length - 1;
		int yEnd = rect[0].length - 1;

		while (result.size() != totalSize) {
			// Special case when the rect is a single row
			if (xStart == xEnd) {
				for (int i = yStart; i <= yEnd; i++)
					result.add(rect[xStart][i]);
				continue;
			}
			// Special case when the rect is a single col
			if (yStart == yEnd) {
				for (int i = xStart; i <= xEnd; i++)
					result.add(rect[i][yStart]);
				continue;
			}
			for (int i = yStart; i <= yEnd - 1; i++)
				result.add(rect[xStart][i]);
			for (int i = xStart; i <= xEnd - 1; i++)
				result.add(rect[i][yEnd]);
			for (int i = yEnd; i >= yStart + 1; i--)
				result.add(rect[xEnd][i]);
			for (int i = xEnd; i >= xStart + 1; i--)
				result.add(rect[i][yStart]);
			xStart++;
			yStart++;
			xEnd--;
			yEnd--;
		}
		return result;
	}

}
