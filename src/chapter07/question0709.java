package chapter07;

public class question0709 {

	public static void main(String[] args) {
		LinkedListNode<Integer> list = LinkedListNode.arrayToList(new int[] { 0, 1, 2, 3, 4 });
		reverse(list).printNode();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static LinkedListNode reverse(LinkedListNode n) {
		if (n == null)
			return null;
		LinkedListNode front = n;
		LinkedListNode end = n;
		while (end.next != null) {
			LinkedListNode temp = front;
			front = end.next;
			end.next = front.next;
			front.next = temp;
		}
		end.next = null;
		return front;
	}

}
