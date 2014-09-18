package chapter17;

public class question1702 {

	public static int KnapSack(int[] weights, int[] value, int weightGoal) {
		// Illegal arguments
		if (weights.length != value.length) {
			return -1;
		}

		int[] valueArray = new int[weightGoal + 1];
		for (int i = 0; i < weights.length; i++) {
			int currentWeight = weights[i];
			for (int j = weightGoal; j >= weights[i]; j--) {
				valueArray[j] = Math.max(valueArray[j], valueArray[j
						- currentWeight]
						+ value[i]);
			}
		}
		return valueArray[weightGoal];
	}
}
