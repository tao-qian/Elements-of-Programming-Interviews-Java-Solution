package chapter07;

public class question0706 {

	public static void main(String[] args) {
		Node<Integer> list = Node.arrayToList(new int[] { 0, 1, 2, 3, 4, 5 });
		list.printNode();
		evenOdd(list).printNode();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Node evenOdd(Node n) {
		Node even = n;
		if (even == null)
			return null;
		Node odd = n.next;
		Node oddTop = odd;
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
