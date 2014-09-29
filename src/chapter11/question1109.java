package chapter11;

public class question1109 {

	public static void main(String[] args) {
		System.out.println(squareRoot((float) 0.8, (float) 0.0001));

	}

	public static float squareRoot(float n, float precision) {
		float p = -1;
		float q = -1;
		if (n > 1) {
			p = 1;
			q = n;
		} else if (n >= 0 && n <= 1) {
			p = 0;
			q = 1;
		} else {
			return -1;
		}
		while (q - p >= precision) {
			float m = (p + q) / 2;
			float square = m * m;
			if (Math.abs(square - n) < precision) {
				return m;
			}
			if (square > n) {
				q = m;
			} else {
				p = m;
			}
		}
		return p;
	}
}
