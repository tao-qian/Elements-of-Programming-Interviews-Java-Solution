package chapter13;

import java.util.*;

public class question1309 {

	public static class Tasks {
		int task1;
		int task2;

		public Tasks(int task1, int task2) {
			this.task1 = task1;
			this.task2 = task2;
		}
	}

	public static ArrayList<Tasks> assignTasks(int[] a) {
		Arrays.sort(a);
		ArrayList<Tasks> result = new ArrayList<Tasks>();
		for (int i = 0; i < a.length; i++) {
			result.add(new Tasks(a[i], a[a.length - 1 - i]));
		}
		return result;
	}
}
