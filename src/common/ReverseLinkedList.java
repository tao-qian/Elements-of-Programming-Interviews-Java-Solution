package common;

import chapter07.Node;

public class ReverseLinkedList {

	public static void main(String[] args) {
		Node<Integer> n = Node.arrayToList(new int[] { 1, 2, 3, 4, 5, 6 });
		reverseLinkedListIterative(n).printNode();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Node reverseLinkedList(Node n) {
		if (n == null)
			return null;
		if (n.next == null)
			return n;
		Node last = n.next;
		Node front = reverseLinkedList(n.next);
		last.next = n;
		n.next = null;
		return front;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Node reverseLinkedListIterative(Node n) {
		Node newListStart = null;
		while (n != null) {
			Node temp = n.next;
			n.next = newListStart;
			newListStart = n;
			n = temp;
		}
		return newListStart;
	}

}
