package chapter06;

import java.util.Random;

public class question0609 {

	public static void main(String[] args) {
		Random r = new Random();
		for (int i = 0; i < 1000; i++) {
			int a = r.nextInt(1000);
			int b = r.nextInt(1000);
			int m = a * b;
			int mm = Integer.parseInt(multiply(String.valueOf(a),
					String.valueOf(b)));
			if (m != mm)
				System.out.println(a + " * " + b + " = " + m + " not " + mm);
		}
	}

	public static String multiply(String m, String n) {
		int carry = 0;
		StringBuilder sb = new StringBuilder();
		m = new StringBuilder(m).reverse().toString();
		n = new StringBuilder(n).reverse().toString();
		for (int i = 0; i < m.length() + n.length(); i++) {
			int sum = 0;
			int max = Math.min(m.length() - 1, i);
			for (int j = 0; j <= max; j++) {
				int k = i - j;
				if (k >= n.length())
					continue;
				sum += getNum(m.charAt(j)) * getNum(n.charAt(k));
			}
			sum += carry;
			sb.append(sum % 10);
			carry = sum / 10;
		}
		if (carry != 0)
			sb.append(carry);
		String result = sb.reverse().toString();
		if (result.charAt(0) == '0')
			result = result.substring(1, result.length());
		return result;
	}

	public static int getNum(char c) {
		if (c >= '0' && c <= '9')
			return c - '0';
		return -1;
	}

	public static String getZeros(int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++)
			sb.append('0');
		return sb.toString();
	}

}
