package chapter06;

public class question0603 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int getCapacity(int[] heights) {
		int capacity = 0;
		int minHeight = Integer.MIN_VALUE;
		for (int i = 0; i < heights.length; i++) {
			capacity = Math.max(capacity, heights[i] - minHeight);
			minHeight = Math.min(minHeight, heights[i]);
		}
		return minHeight;
	}

}
