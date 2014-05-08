package chapter05;

public class question0513 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(multiplyNoOperator(11, 22));
	}

	public static int addNoOperator(int x, int y) {
		int sum = 0;
		int k = 1;
		int c = 0;
		while (k != 0) {
			int a = k & x;
			int b = k & y;
			// Think about full adder
			sum |= a ^ b ^ c;
			c = (a & c) | (b & c) | (a & b);
			c <<= 1;
			k <<= 1;
		}
		return sum;
	}

	public static int multiplyNoOperator(int x, int y) {
		int result = 0;
		int k = 1;
		int scaledY = y;
		while (k != 0) {
			if ((k & x) != 0)
				result = addNoOperator(result, scaledY);
			scaledY <<= 1;
			k <<= 1;
		}
		return result;
	}

}
