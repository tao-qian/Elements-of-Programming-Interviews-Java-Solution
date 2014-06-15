package chapter08;

public class question0801 {

	public class MaxStack extends Stack<Integer> {
		public Stack<Integer> max;

		public MaxStack() {
			super();
			max = new Stack<Integer>();
		}

		public void push(int n) {
			if (max.head == null || max.head.data <= n) {
				max.push(n);
			}
			super.push(n);
		}

		public Integer pop() throws Exception {
			int n = super.pop();
			if (n == max.head.data) {
				max.pop();
			}
			return n;
		}
	}
}
