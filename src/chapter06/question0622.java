package chapter06;

import java.util.ArrayList;

import Util.Utility;

public class question0622 {

	public static String[] mapping = new String[] { "", "", "ABC", "DEF",
			"GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ" };

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Utility.print(getAllCombination("1234"));
	}

	public static ArrayList<String> getAllCombination(String numbers) {
		ArrayList<StringBuilder> result = new ArrayList<StringBuilder>();
		result.add(new StringBuilder());
		for (int i = 0; i < numbers.length(); i++) {
			char num = numbers.charAt(i);
			char[] choices = mapping[num - '0'].toCharArray();
			if (choices.length == 0) {
				append(result, num);
				continue;
			}
			ArrayList<StringBuilder> clone = result;
			result = new ArrayList<StringBuilder>();
			for (int j = 0; j < choices.length; j++) {
				ArrayList<StringBuilder> newClone = clone(clone);
				append(newClone, choices[j]);
				result.addAll(newClone);
			}
		}
		ArrayList<String> stringResult = new ArrayList<String>();
		for (int i = 0; i < result.size(); i++)
			stringResult.add(result.get(i).toString());
		return stringResult;
	}

	public static ArrayList<StringBuilder> clone(ArrayList<StringBuilder> a) {
		ArrayList<StringBuilder> n = new ArrayList<StringBuilder>();
		for (int i = 0; i < a.size(); i++)
			n.add(new StringBuilder(a.get(i)));
		return n;
	}

	public static void append(ArrayList<StringBuilder> a, char c) {
		for (int i = 0; i < a.size(); i++)
			a.get(i).append(c);
	}

}
