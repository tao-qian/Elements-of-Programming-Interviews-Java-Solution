package chapter07;

public class question0706 {

	public static void main(String[] args) {
		LinkedListNode<Integer> list = LinkedListNode.arrayToList(new int[] { 0, 1, 2, 3, 4, 5 });
		list.printNode();
		evenOdd(list).printNode();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static LinkedListNode evenOdd(LinkedListNode n) {
		LinkedListNode even = n;
		if (even == null)
			return null;
		LinkedListNode odd = n.next;
		LinkedListNode oddTop = odd;
		while (odd != null && odd.next != null) {
			even.next = odd.next;
			even = even.next;
			odd.next = even.next;
			odd = odd.next;
		}
		even.next = oddTop;
		return n;
	}

}
