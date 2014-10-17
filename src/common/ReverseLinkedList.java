package common;

import chapter07.LinkedListNode;

public class ReverseLinkedList {

	public static void main(String[] args) {
		LinkedListNode<Integer> n = LinkedListNode.arrayToList(new int[] { 1, 2, 3, 4, 5, 6 });
		reverseLinkedListIterative(n).printNode();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static LinkedListNode reverseLinkedList(LinkedListNode n) {
		if (n == null)
			return null;
		if (n.next == null)
			return n;
		LinkedListNode last = n.next;
		LinkedListNode front = reverseLinkedList(n.next);
		last.next = n;
		n.next = null;
		return front;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static LinkedListNode reverseLinkedListIterative(LinkedListNode n) {
		LinkedListNode newListStart = null;
		while (n != null) {
			LinkedListNode temp = n.next;
			n.next = newListStart;
			newListStart = n;
			n = temp;
		}
		return newListStart;
	}

}
