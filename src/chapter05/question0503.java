package chapter05;

public class question0503 {

	public static void main(String[] args) {
	}

	public static int reverse(int n) {
		for (int i = 0; i < 32; i++) {
			n = question0502.swapBit(n, i, 31 - i);
		}
		return n;
	}

}
