package chapter07;

public class question0703 {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		int[] a = new int[] { 2, 2, 2, 3, 3, 4, 4 };
		Node s = Node.arrayToList(a);
		Node p1 = s;
		for (int i = 0; i < a.length - 1; i++) {
			p1 = p1.next;
		}
		p1.next = s;
		System.out.println(getMedian(s));
	}

	public static double getMedian(Node<Integer> s) {
		Node<Integer> p1 = s;
		int count = 1;
		Node<Integer> smallest = s;
		boolean different = false;

		while (p1.next != s) {
			if (p1.next.data < p1.data) {
				smallest = p1.next;
			}
			if (!different && p1.next.data != p1.data) {
				different = true;
			}
			p1 = p1.next;
			count++;
		}
		if (!different) {
			return s.data;
		}
		if (count % 2 == 1) {
			for (int i = 0; i < count / 2; i++) {
				smallest = smallest.next;
			}
			return smallest.data;
		}
		for (int i = 0; i < count / 2 - 1; i++) {
			smallest = smallest.next;
		}
		return ((double) smallest.data + smallest.next.data) / 2;
	}
}
