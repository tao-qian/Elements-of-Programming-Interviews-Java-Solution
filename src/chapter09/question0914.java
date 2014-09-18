package chapter09;

import chapter09.Trie;

public class question0914 {

	public static void main(String[] args) {
		String[] words = new String[] { "dog", "be", "cat" };
		System.out.println(getShortestPrefix(buildTrie(words), "cat"));
	}

	public static Trie<Character> buildTrie(String[] words) {
		Trie<Character> root = new Trie<Character>(' ');
		for (int i = 0; i < words.length; i++) {
			Trie<Character> temp = root;
			String word = words[i];
			for (int j = 0; j < words[i].length(); j++) {
				Trie<Character> existing = temp.children.get(word.charAt(j));
				if (existing == null) {
					existing = new Trie<Character>(word.charAt(j));
					temp.children.put(word.charAt(j), existing);
				}
				temp = existing;
			}
		}
		return root;
	}

	public static String getShortestPrefix(Trie<Character> trie, String word) {
		for (int i = 0; i < word.length(); i++) {
			if (!trie.children.containsKey(word.charAt(i))) {
				return word.substring(0, i);
			}
			trie = trie.children.get(word.charAt(i));
		}
		return word;
	}

}
