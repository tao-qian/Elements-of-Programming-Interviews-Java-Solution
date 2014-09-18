package chapter15;

public class question1516 {

	public static void main(String[] args) {
		boolean[][] map = new boolean[6][6];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = true;
			}
		}
		System.out.println(countPath(map));
	}

	public static int countPath(boolean[][] map) {
		int[] current = new int[map[0].length];
		for (int i = 0; i < current.length; i++) {
			current[i] = 1;
		}
		// We can safely start from i=1
		// because current is initialized to be all 1.
		for (int i = 1; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				// If obstacle
				if (!map[i][j]) {
					current[j] = 0;
					continue;
				}
				if (j == 0) {
					current[j] = 1;
					continue;
				}
				current[j] = current[j - 1] + current[j];
			}
		}
		return current[current.length - 1];
	}
}
