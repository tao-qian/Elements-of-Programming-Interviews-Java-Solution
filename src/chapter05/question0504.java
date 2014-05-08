package chapter05;

public class question0504 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int getSmallest(int n) {
		for (int i = 0; i < 31; i++)
			if (((n >> i) & 1) != ((n >> (i + 1)) & 1))
				return n ^ (1 << n | 1 << (n + 1));
		return 0;
	}

}
