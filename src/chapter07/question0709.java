package chapter07;

public class question0709 {

	public static void main(String[] args) {
		Node<Integer> list = Node.arrayToList(new int[] { 0, 1, 2, 3, 4 });
		reverse(list).printNode();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Node reverse(Node n) {
		if (n == null)
			return null;
		Node front = n;
		Node end = n;
		while (end.next != null) {
			Node temp = front;
			front = end.next;
			end.next = front.next;
			front.next = temp;
		}
		end.next = null;
		return front;
	}

}
