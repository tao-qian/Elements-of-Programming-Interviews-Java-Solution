package chapter08;

public class question0811 {

	public static void main(String[] args) throws Exception {
		TwoIntQueue q = new TwoIntQueue();
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
		while (q.size != 0) {
			System.out.println(q.dequeue());
		}
	}

	public static class TwoIntQueue {
		private int n;
		private int size;

		public TwoIntQueue() {
			n = 0;
			size = 0;
		}

		public void enqueue(int k) {
			n = n * 10 + k;
			size++;
		}

		public int dequeue() throws Exception {
			if (size == 0) {
				throw new Exception("Queue is empty");
			}
			int d = (int) Math.pow(10, size - 1);
			int r = n / d;
			n = n - r * d;
			size--;
			return r;
		}

	}
}
