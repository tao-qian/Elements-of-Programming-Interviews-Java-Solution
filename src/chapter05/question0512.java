package chapter05;

public class question0512 {

	public static void main(String[] args) {

	}

	public static class Rectangle {
		public Rectangle(int x, int y, int w, int h) {
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
		}

		int x;
		int y;
		int w;
		int h;
	}

	public static Rectangle getIntersection(Rectangle r1, Rectangle r2) {
		if (r1.x < r2.x + r2.w && r2.x < r1.x + r1.w && r1.y < r2.y + r2.h
				&& r2.y < r1.y + r1.h) {
			return new Rectangle(Math.max(r1.x, r2.x), Math.max(r1.y, r2.y),
					Math.min(r1.x + r1.w, r2.x + r2.w) - Math.max(r1.x, r2.x),
					Math.min(r1.y + r1.h, r2.y + r2.h) - Math.max(r1.y, r2.y));
		}
		return null;
	}

}
