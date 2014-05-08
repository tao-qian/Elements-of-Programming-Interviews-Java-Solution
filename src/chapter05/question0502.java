package chapter05;

public class question0502 {
	public static void main(String[] args) {
		System.out.println(swapBit(2, 0, 1));
	}

	public static int swapBit(int n, int i, int j) {
		int b1 = (n >> i) & 1;
		int b2 = (n >> j) & 1;
		System.out.println("b1 " + b1);
		System.out.println("b2 " + b2);
		if (b1 == b2)
			return n;
		return n ^ ((1 << j) | (1 << i));
	}
}
