package chapter07;

public class question0707 {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void deleteNode(LinkedListNode s) {
		s.data = s.next.data;
		s.next = s.next.next;
	}
}
