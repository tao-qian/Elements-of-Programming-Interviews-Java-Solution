package chapter09;

import java.util.*;

public class Trie<T> {
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
