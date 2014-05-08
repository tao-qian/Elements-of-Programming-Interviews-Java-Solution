package chapter06;

public class question0621 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out
				.println(removeBReplaceA("bbbbbbbabbbbbbaabbbbbxxxxsabbbbaaaaaaaaaaaaaaas"));
	}

	public static String removeBReplaceA(String s) {
		char[] c = s.toCharArray();// Mimic in-place string manipulation with a
									// char array
		int writePointer = -1;
		int aCount = 0;

		// First remove b
		for (int readPointer = 0; readPointer < c.length; readPointer++) {
			if (c[readPointer] == 'b')
				continue;
			if (c[readPointer] == 'a')
				aCount++;
			writePointer++;
			c[writePointer] = c[readPointer];
		}

		char[] newC = new char[writePointer + 1 + aCount];
		for (int i = 0; i <= writePointer; i++)
			newC[i] = c[i];

		int endWritePointer = newC.length;
		for (int readPointer = writePointer; readPointer >= 0; readPointer--) {
			if (newC[readPointer] == 'a') {
				endWritePointer--;
				newC[endWritePointer] = 'd';
				endWritePointer--;
				newC[endWritePointer] = 'd';
				continue;
			}
			endWritePointer--;
			newC[endWritePointer] = newC[readPointer];
		}
		return new String(newC);
	}

}
