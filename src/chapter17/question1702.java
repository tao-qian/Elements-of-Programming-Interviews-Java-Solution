package chapter17;

public class question1702 {

	public static void main(String[] args)
	{
		int[] weights = new int[]{2,1};
		int[] value = new int[]{1,10};
		int weightGoal = 4;
		System.out.println(KnapSack(weights,value, weightGoal));
	}
	
	public static int KnapSack(int[] weights, int[] value, int weightGoal) {
		// Illegal arguments
		if (weights.length != value.length) {
			return -1;
		}

		int[] valueArray = new int[weightGoal + 1];
		for (int i = 0; i < weights.length; i++) {
			Util.Utility.print(valueArray);
			int currentWeight = weights[i];
			// Here we started from the end, this is important
			// because all the values to the left of j in the array
			// is from the last i loop.
			for (int j = weightGoal; j >= weights[i]; j--) {
				valueArray[j] = Math.max(valueArray[j], valueArray[j
						- currentWeight]
						+ value[i]);
			}
		}
		return valueArray[weightGoal];
	}
}
