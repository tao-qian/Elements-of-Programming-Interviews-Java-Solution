package chapter07;

import java.util.Arrays;
import java.util.Random;

public class Node<T> {
	public T data;
	public Node<T> next;

	public Node(T n) {
		this.data = n;
	}

	public void printNode() {
		Node<T> runner = this;
		while (runner != null) {
			System.out.print(runner.data + "->");
			runner = runner.next;
		}
		System.out.println("NULL");
	}

	public String toString() {
		return data.toString();
	}

	public static Node<Integer> randomList(int length, int max) {
		Random r = new Random();
		Node<Integer> n = new Node<Integer>(r.nextInt(max));
		n.next = null;
		for (int i = 1; i < length; i++) {
			Node<Integer> nn = new Node<Integer>(r.nextInt(max));
			nn.next = n;
			n = nn;
		}
		return n;
	}

	public static Node<Integer> randomSortedList(int length, int max) {
		Random r = new Random();
		int[] list = new int[length];
		for (int i = 0; i < length; i++)
			list[i] = r.nextInt(max);
		Arrays.sort(list);
		return arrayToList(list);
	}

	@SuppressWarnings("rawtypes")
	public static void printList(Node n) {
		while (n != null) {
			System.out.print(n.data + "->");
			n = n.next;
		}
		System.out.println("null");
	}

	public static Node<Integer> arrayToList(int[] array) {
		Node<Integer> n = new Node<Integer>(array[0]);
		Node<Integer> runner = n;
		for (int i = 1; i < array.length; i++) {
			Node<Integer> nextNode = new Node<Integer>(array[i]);
			runner.next = nextNode;
			runner = nextNode;
		}
		runner.next = null;
		return n;
	}
}