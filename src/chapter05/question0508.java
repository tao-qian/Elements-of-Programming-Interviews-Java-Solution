package chapter05;

public class question0508 {

	public static void main(String[] args) {
		System.out.println(toNumber("AA"));
	}

	public static int toNumber(String s) {
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			sum *= 26;
			sum += (s.charAt(i) - 'A' + 1);
		}
		return sum;
	}

}
