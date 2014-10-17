package chapter09;

import java.util.*;

public class Trie<T> {
	
	public static void main(String[] args)
	{
		Trie<Integer> t1 = new Trie<Integer>(1);
		Trie<Integer> t2 = new Trie<Integer>(2);
		HashSet<Trie<Integer>> set = new HashSet<Trie<Integer>>();
		set.add(t1);
		set.add(t2);
		Util.Utility.print(set);
 	}
	
	T key;
	HashMap<T, Trie<T>> children;

	public Trie(T key) {
		this.key = key;
		children = new HashMap<T, Trie<T>>();
	}

	public int hashCode() {
		return key.hashCode();
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		return this.hashCode() == obj.hashCode();
	}
}
