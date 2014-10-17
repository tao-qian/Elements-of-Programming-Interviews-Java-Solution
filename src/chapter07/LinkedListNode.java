package chapter07;

import java.util.Arrays;
import java.util.Random;

public class LinkedListNode<T> {
	public T data;
	public LinkedListNode<T> next;

	public LinkedListNode(T n) {
		this.data = n;
	}

	public void printNode() {
		LinkedListNode<T> runner = this;
		while (runner != null) {
			System.out.print(runner.data + "->");
			runner = runner.next;
		}
		System.out.println("NULL");
	}

	public String toString() {
		return data.toString();
	}

	public static LinkedListNode<Integer> randomList(int length, int max) {
		Random r = new Random();
		LinkedListNode<Integer> n = new LinkedListNode<Integer>(r.nextInt(max));
		n.next = null;
		for (int i = 1; i < length; i++) {
			LinkedListNode<Integer> nn = new LinkedListNode<Integer>(r.nextInt(max));
			nn.next = n;
			n = nn;
		}
		return n;
	}

	public static LinkedListNode<Integer> randomSortedList(int length, int max) {
		Random r = new Random();
		int[] list = new int[length];
		for (int i = 0; i < length; i++)
			list[i] = r.nextInt(max);
		Arrays.sort(list);
		return arrayToList(list);
	}

	@SuppressWarnings("rawtypes")
	public static void printList(LinkedListNode n) {
		while (n != null) {
			System.out.print(n.data + "->");
			n = n.next;
		}
		System.out.println("null");
	}

	public static LinkedListNode<Integer> arrayToList(int[] array) {
		LinkedListNode<Integer> n = new LinkedListNode<Integer>(array[0]);
		LinkedListNode<Integer> runner = n;
		for (int i = 1; i < array.length; i++) {
			LinkedListNode<Integer> nextNode = new LinkedListNode<Integer>(array[i]);
			runner.next = nextNode;
			runner = nextNode;
		}
		runner.next = null;
		return n;
	}
}