package chapter07;

public class question0708 {
	public static void main(String[] args) {
		LinkedListNode<Integer> n = LinkedListNode.arrayToList(new int[] { 1, 2, 3, 4, 5, 6 });
		LinkedListNode.printList(n);
		System.out.println(deleteLastK(n, 6));
		LinkedListNode.printList(n);

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean deleteLastK(LinkedListNode s, int k) {
		LinkedListNode p1 = s;
		LinkedListNode p2 = s;
		for (int i = 0; i < k; i++) {
			if (p1 == null) {
				return false;
			}
			p1 = p1.next;
		}
		if (p1 == null) {
			return false;
		}
		while (p1.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		p2.next = p2.next.next;
		return true;
	}
}
