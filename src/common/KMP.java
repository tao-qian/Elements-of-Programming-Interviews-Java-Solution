package common;

public class KMP {

	public static void main(String[] args) {
		String w = "abc";
		String s = "cdabdabc";
		System.out.println(stringMatching(w, s));
	}

	public static int stringMatching(String w, String s) {
		int[] table = partialMatchTable(w);
		int sp = 0;
		int wp = 0;
		while (sp < s.length()) {
			if (s.charAt(sp + wp) == w.charAt(wp)) {
				wp++;
				if (wp == w.length()) {
					return sp;
				}
				continue;
			}
			// It works because table[0] = -1
			sp = sp + wp - table[wp];
			if (wp > 0) {
				wp = table[wp];
			}
		}
		return -1;
	}

	public static int[] partialMatchTable(String w) {
		int[] table = new int[w.length()];
		table[0] = -1;
		table[1] = 0;
		int lastMatch = 0;
		int p = 2;
		while (p < table.length) {
			if (w.charAt(p - 1) == w.charAt(lastMatch)) {
				lastMatch++;
				table[p] = lastMatch;
				p++;
				continue;
			}
			if (lastMatch != 0) {
				lastMatch = table[lastMatch];
				continue;
			}
			table[p] = lastMatch;
			p++;
		}
		return table;
	}
}
