package chapter07;

public class question0708 {
	public static void main(String[] args) {
		Node<Integer> n = Node.arrayToList(new int[] { 1, 2, 3, 4, 5, 6 });
		Node.printList(n);
		System.out.println(deleteLastK(n, 6));
		Node.printList(n);

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean deleteLastK(Node s, int k) {
		Node p1 = s;
		Node p2 = s;
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
