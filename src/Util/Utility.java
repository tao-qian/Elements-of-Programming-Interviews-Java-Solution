package Util;

import java.util.ArrayList;
import java.util.HashSet;

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

	public static void print(HashSet<Integer> s) {
		System.out.print("{ ");
		for (Integer i : s)
			System.out.print(i + " ");
		System.out.print("}");
	}

	public static void print(ArrayList a) {
		for (int i = 0; i < a.size(); i++)
			System.out.print(a.get(i) + " ");
		System.out.println();
	}
}
