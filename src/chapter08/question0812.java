package chapter08;

public class question0812 {
	public static void main(String[] args) throws Exception {

		TwoStackQueue<Integer> q = new TwoStackQueue<Integer>();
		q.enqueue(0);
		q.enqueue(0);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(0);
		q.enqueue(0);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(0);
		q.enqueue(0);
		while (q.size() != 0) {
			System.out.println(q.dequeue());
		}
	}

	public static class TwoStackQueue<T> {
		private Stack<T> input;
		private Stack<T> output;

		public int size() {
			return input.size + output.size;
		}

		public TwoStackQueue() {
			input = new Stack<T>();
			output = new Stack<T>();
		}

		public void enqueue(T data) {
			input.push(data);
		}

		public T dequeue() throws Exception {
			if (output.size == 0) {
				while (input.size != 0) {
					output.push(input.pop());
				}
			}
			if (output.size == 0) {
				throw new Exception("Queue is empty");
			}
			return output.pop();
		}
	}
}
