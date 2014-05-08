package chapter05;

public class question0501 {
	public static void main(String[] args) {
		System.out.println(getParity(3));
	}

	public static int getParity(int n) {
		int count = 0;
		while (n > 0) {
			n = n & (n - 1);
			count++;
		}
		return count;
	}

}
