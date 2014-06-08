package chapter06;

import java.util.LinkedList;

public class question0616 {

	public static void painting(boolean[][] map, int startX, int startY) {
		boolean color = !map[startX][startY];
		LinkedList<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(startX, startY));
		int height = map.length;
		int width = map[0].length;
		while (queue.size() > 0) {
			Pair current = queue.pollFirst();
			if (current.x + 1 < width && map[current.x + 1][current.y] != color) {
				queue.add(new Pair(current.x + 1, current.y));
			}
			if (current.x - 1 > 0 && map[current.x - 1][current.y] != color) {
				queue.add(new Pair(current.x - 1, current.y));
			}
			if (current.y + 1 < height
					&& map[current.x][current.y + 1] != color) {
				queue.add(new Pair(current.x, current.y + 1));
			}
			if (current.y - 1 > 0 && map[current.x][current.y - 1] != color) {
				queue.add(new Pair(current.x, current.y - 1));
			}
			map[current.x][current.y] = color;
		}
	}

	public static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
