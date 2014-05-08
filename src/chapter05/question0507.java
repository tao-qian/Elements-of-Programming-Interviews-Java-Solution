package chapter05;

public class question0507 {

	public static void main(String[] args) {
		System.out.println(baseConversion(10, 16, "31"));
	}

	public static String baseConversion(int b1, int b2, String s) {
		int sum = 0;
		boolean isNeg = false;
		int i = 0;
		if (s.charAt(0) == '-') {
			i = 1;
			isNeg = true;
		}
		for (; i < s.length(); i++) {
			sum = b1 * sum + toNum(s.charAt(i));
		}

		StringBuilder sb = new StringBuilder();
		while (sum != 0) {
			char c = toChar(sum % b2);
			sum /= b2;
			sb.append(c);
		}
		if (isNeg)
			sb.append('-');
		return sb.reverse().toString();
	}

	public static char toChar(int n) {
		if (n <= 9 && n >= 0)
			return (char) (n + '0');
		if (n >= 10 && n <= 15)
			return (char) (n - 10 + 'A');
		return 'G';
	}

	public static int toNum(char c) {
		if (c <= '9' && c >= '0')
			return c - '0';
		if (c <= 'F' && c >= 'A')
			return c - 'A' + 10;
		return -1;
	}

}
