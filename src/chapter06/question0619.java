package chapter06;

public class question0619 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(switchWords("  tao loves yihan  "));
	}

	public static String switchWords(String s) {
		s = reverse(s, 0, s.length() - 1);
		int start = 0;
		int end = 0;
		while (start < s.length()) {
			while (end < s.length() && s.charAt(end) != ' ') {
				end++;
			}
			s = reverse(s, start, end - 1);
			end++;
			start = end;
		}
		return s;
	}

	public static String reverse(String s, int start, int end) {
		char[] as = s.toCharArray();// No better way to do in place string
									// manipulation in Java
		while (start < end) {
			char temp = as[start];
			as[start] = as[end];
			as[end] = temp;
			start++;
			end--;
		}
		return new String(as);
	}

}
