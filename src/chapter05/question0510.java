package chapter05;

public class question0510 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getGCD(42, 42));
	}

	public static int getGCD(int x, int y) {
		if (x == 0)
			return y;
		if (y == 0)
			return x;
		boolean xEven = isEven(x);
		boolean yEven = isEven(y);
		if (xEven && yEven)
			return 2 * getGCD(x >> 1, y >> 1);
		if (xEven)
			return getGCD(x >> 1, y);
		if (yEven)
			return getGCD(x, y >> 1);
		if (x >= y)
			return getGCD(y, x - y);
		return getGCD(x, y - x);
	}

	public static boolean isEven(int x) {
		return (x & 1) == 0;
	}
}
