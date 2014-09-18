package chapter15;

public class question1513 {

	public static void main(String[] args) {
		String[] words = new String[] { "I", "have", "shit" };
		System.out.println(prettyPrinting(words, 5));
	}

	public static int prettyCost(int lineLength, int occupied) {
		return 1 << (lineLength - occupied);
	}

	public static int prettyPrinting(String[] words, int lineLength) {
		int[] costsByWords = new int[words.length];

		for (int i = 0; i < costsByWords.length; i++) {
			if (i == 0) {
				costsByWords[i] = prettyCost(lineLength, words[i].length());
				continue;
			}
			int min = Integer.MAX_VALUE;
			int index = i;
			int currentLength = words[index].length();
			while (currentLength <= lineLength) {
				int previousCost = 0;
				if (index > 0) {
					previousCost = costsByWords[index - 1];
				}
				int newCost = prettyCost(lineLength, currentLength)
						+ previousCost;
				min = Math.min(min, newCost);

				index--;
				if (index < 0) {
					break;
				}
				currentLength += 1 + words[index].length();
			}
			costsByWords[i] = min;
		}
		return costsByWords[words.length - 1];
	}
}
