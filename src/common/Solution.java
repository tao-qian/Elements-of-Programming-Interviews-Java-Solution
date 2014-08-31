package common;

import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		// Faster than scanner
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter w = new BufferedWriter(
				new OutputStreamWriter(System.out));

		int N = Integer.parseInt(r.readLine());

		for (int i = 1; i <= N; i++) {
			boolean divByThree = (i % 3 == 0);
			boolean divByFive = (i % 5 == 0);
			if (divByThree) {
				w.write("Fizz");
			}
			if (divByFive) {
				w.write("Buzz");
			}
			if (!(divByThree || divByFive)) {
				w.write(String.valueOf(i));
			}
			w.write("\n");
		}
		w.flush();
	}
}
