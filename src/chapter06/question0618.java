package chapter06;

public class question0618 {

	public static void main(String[] args) {
		System.out.println(decoding(encoding("aaabbbccd")));
	}

	public static String encoding(String s) {
		StringBuilder sb = new StringBuilder();
		char lastChar = s.charAt(0);
		int count = 1;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == lastChar) {
				count++;
				continue;
			}
			sb.append(lastChar);
			sb.append(count);
			count = 1;
			lastChar = s.charAt(i);
		}
		sb.append(lastChar);
		sb.append(count);
		return sb.toString();
	}

	public static String decoding(String s) {
		int pointer = 0;
		StringBuilder sb = new StringBuilder();
		while (pointer < s.length()) {
			char c = s.charAt(pointer);
			pointer++;
			int count = s.charAt(pointer) - '0';
			pointer++;
			for (int i = 0; i < count; i++)
				sb.append(c);
		}
		return sb.toString();
	}
}
