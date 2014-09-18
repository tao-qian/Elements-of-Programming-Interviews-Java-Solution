package chapter15;

import java.util.Arrays;

public class question1521 {

	public static void main(String[] args) {
		int[] waitingTimes = new int[] { 3, 1, 2 };
		Arrays.sort(waitingTimes);
		Util.Utility.print(waitingTimes);
	}

	public static int minimizeWaitingTime(int[] waitingTimes) {
		Arrays.sort(waitingTimes);
		int minWaitTime = 0;
		for (int i = 0; i < waitingTimes.length; i++) {
			minWaitTime += waitingTimes[i] * (waitingTimes.length - 1 - i);
		}
		return minWaitTime;
	}
}
