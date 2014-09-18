package chapter15;

import java.util.*;

public class question1512 {

	public static void main(String[] args) {
		HashSet<String> hash = new HashSet<String>();
		hash.add("ha");
		hash.add("tao");
		System.out.println(wordBreaking("taotao", hash));
	}

	public static boolean wordBreaking(String s, HashSet<String> dictionary) {
		boolean[] possible = new boolean[s.length()];
		for (int i = 0; i < possible.length; i++) {
			possible[i] = false;
			for (int j = 0; j < i; j++) {
				if (possible[j]
						&& dictionary.contains(s.substring(j + 1, i + 1))) {
					possible[i] = true;
					break;
				}
			}

			if (!possible[i] && dictionary.contains(s.substring(0, i + 1))) {
				possible[i] = true;
			}
		}
		return possible[possible.length - 1];
	}
}
