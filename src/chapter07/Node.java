package chapter07;

import java.util.Arrays;
import java.util.Random;

public class Node {
	int n;
	public Node next;

	public Node(int n) {
		this.n = n;
	}

	public void printNode() {
		Node runner = this;
		while (runner != null) {
			System.out.print(runner.n + "->");
			runner = runner.next;
		}
		System.out.println("NULL");
	}

	public static Node randomList(int length, int max) {
		Random r = new Random();
		Node n = new Node(r.nextInt(max));
		n.next = null;
		for (int i = 1; i < length; i++) {
			Node nn = new Node(r.nextInt(max));
			nn.next = n;
			n = nn;
		}
		return n;
	}

	public static Node randomSortedList(int length, int max) {
		Random r = new Random();
		int[] list = new int[length];
		for (int i = 0; i < length; i++)
			list[i] = r.nextInt(max);
		Arrays.sort(list);
		return arrayToList(list);
	}

	public static Node arrayToList(int[] array) {
		Node n = new Node(array[0]);
		Node runner = n;
		for (int i = 1; i < array.length; i++) {
			Node nextNode = new Node(array[i]);
			runner.next = nextNode;
			runner = nextNode;
		}
		runner.next = null;
		return n;
	}
}