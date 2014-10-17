package chapter08;

import java.util.LinkedList;
import java.util.Random;

import Util.Utility;
import chapter07.LinkedListNode;

public class question0813 {

	public static void main(String[] args) throws Exception {
		System.out.println("Test started");
		MaxQueue q = new MaxQueue();
		Random r = new Random();
		for (int i = 0; i < 1000; i++) {
			int randomAction = r.nextInt(3);
			if (randomAction >= 1 && q.size() > 0) {
				q.dequeue();
			} else {
				q.enqueue(r.nextInt(1000));
			}
			if (q.size() > 0) {
				int nMax = q.naiveMax();
				int max = q.max();
				if (nMax != max) {
					System.out.println(q.toString());
					System.out.print(max);
					System.out.println(" " + nMax);
				}
			}
		}
		System.out.println("Test ended");
	}

	public static class MaxQueue {
		private Queue<Integer> q;
		private LinkedList<Integer> max;

		public String toString() {
			LinkedList<LinkedListNode<Integer>> l = q.toLinkedList();
			String result = "q " + Utility.toString(l) + "\n";
			result += "max " + Utility.toString(max);
			return result;
		}

		public int size() {
			return q.size;
		}

		public int naiveMax() {
			LinkedList<LinkedListNode<Integer>> l = q.toLinkedList();
			int max = Integer.MIN_VALUE;
			for (LinkedListNode<Integer> n : l) {
				if (n.data > max) {
					max = n.data;
				}
			}
			return max;
		}

		public MaxQueue() {
			q = new Queue<Integer>();
			max = new LinkedList<Integer>();
		}

		public void enqueue(int n) throws Exception {
			q.enqueue(n);
			while (max.size() != 0 && max.getLast() < n) {
				max.removeLast();
			}
			max.addLast(n);
		}

		public int dequeue() throws Exception {
			if (q.size == 0) {
				throw new Exception("Queue is empty");
			}
			int result = q.dequeue();
			if (result == max.peek()) {
				max.removeFirst();
			}
			return result;
		}

		public int max() throws Exception {
			if (q.size == 0) {
				throw new Exception("Queue is empty");
			}
			return max.getFirst();
		}
	}
}
