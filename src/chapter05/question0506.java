package chapter05;

public class question0506 {

	public static void main(String[] args) {
		System.out.println(stringToInt("0"));
	}

	public static int stringToInt(String s) {
		boolean isNeg = false;
		int i = 0;
		if (s.charAt(0) == '-') {
			isNeg = true;
			i = 1;
		}
		int sum = 0;
		for (; i < s.length(); i++) {
			sum = sum * 10 + (s.charAt(i) - '0');
		}
		if (isNeg)
			sum *= -1;
		return sum;
	}

}
