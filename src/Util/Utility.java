package Util;

import java.util.HashSet;
import java.util.List;

@SuppressWarnings({ "rawtypes" })
public class Utility {

	public static void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static void print(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			print(array[i]);
		}
	}

	public static String toString(List l) {
		StringBuilder sb = new StringBuilder();
		sb.append("{ ");
		for (Object item : l) {
			sb.append(item.toString() + " ");
		}
		sb.append("}");
		return sb.toString();
	}

	public static void print(HashSet<Integer> s) {
		System.out.print("{ ");
		for (Integer i : s)
			System.out.print(i + " ");
		System.out.print("}");
	}

	public static void print(List a) {
		System.out.println(toString(a));
	}
}
