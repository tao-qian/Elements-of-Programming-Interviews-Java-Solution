package chapter15;

public class question1518 {

	public static void main(String[] args) {
		int[] coins = new int[] { 1, 2, 1, 1 };
		System.out.println(pickCoins(coins));
	}

	public static int pickCoins(int[] coins) {
		int[][] best = new int[coins.length + 1][coins.length + 1];
		for (int interval = 0; interval <= coins.length; interval += 2) {
			for (int i = 0; i < coins.length + 1 - interval; i++) {
				if (interval == 0) {
					best[i][i] = 0;
					continue;
				}
				best[i][i + interval] = Math.max(
						coins[i]
								+ Math.min(best[i + 1][i + interval - 1],
										best[i + 2][i + interval]),
						coins[i + interval - 1]
								+ Math.min(best[i + 1][i + interval - 1],
										best[i][i + interval - 2]));
			}
		}
		return best[0][coins.length];
	}

}
