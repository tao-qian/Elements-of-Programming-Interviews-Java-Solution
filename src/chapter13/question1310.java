package chapter13;

import java.util.Arrays;

public class question1310 {

	public static class EndPoint implements Comparable<EndPoint> {
		public int time;
		public boolean isStarting;

		public EndPoint(int time, boolean isStarting) {
			this.time = time;
			this.isStarting = isStarting;
		}

		@Override
		public int compareTo(EndPoint o) {
			int diff = this.time - o.time;
			if (diff != 0) {
				return diff;
			}

			if (isStarting ^ o.isStarting) {
				return isStarting == true ? 1 : -1;
			}
			return 0;
		}
	}

	public int getMaxOverLap(int[] startingEndPoint, int[] endingEndPoint) {
		if (startingEndPoint.length != endingEndPoint.length) {
			return -1;
		}
		EndPoint[] endPoints = new EndPoint[startingEndPoint.length
				+ endingEndPoint.length];
		int pointer = 0;
		int i = 0;
		while (pointer < endPoints.length) {
			endPoints[pointer] = new EndPoint(startingEndPoint[i], true);
			pointer++;
			endPoints[pointer] = new EndPoint(endingEndPoint[i], false);
			pointer++;
			i++;
		}
		Arrays.sort(endPoints);

		int maxCount = Integer.MIN_VALUE;
		int currentCount = 0;
		for (int j = 0; j < endPoints.length; j++) {
			if (endPoints[j].isStarting) {
				currentCount++;
			} else {
				currentCount--;
			}
			maxCount = Math.max(currentCount, maxCount);
		}
		return maxCount;

	}
}
