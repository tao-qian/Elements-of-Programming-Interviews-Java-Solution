package chapter12;

public class question1208 {

	public static void main(String[] args) {
		System.out.println(canBePalindrome("asba"));
	}

	public static boolean canBePalindrome(String s) {
		int[] counts = new int[256];
		for (int i = 0; i < s.length(); i++) {
			counts[(int) s.charAt(i)] += 1;
		}
		int oddCount = 0;
		for (int i = 0; i < counts.length; i++) {
			if (counts[i] % 2 == 1) {
				oddCount++;
			}
		}
		if (oddCount > 1) {
			return false;
		}
		return true;
	}
}
