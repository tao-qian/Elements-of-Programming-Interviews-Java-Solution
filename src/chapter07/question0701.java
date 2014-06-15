package chapter07;

public class question0701 {

	public static void main(String[] args) {
		Node<Integer> n1 = Node.randomSortedList(4, 100);
		Node<Integer> n2 = Node.randomSortedList(1, 100);
		n1.printNode();
		n2.printNode();
		Node<Integer> n3 = merge(n1, n2);
		n3.printNode();
	}

	public static Node<Integer> merge(Node<Integer> l, Node<Integer> r) {
		Node<Integer> pl = l;
		Node<Integer> pr = r;
		Node<Integer> top = l;
		Node<Integer> last = l;
		if (l.data > r.data) {
			top = r;
			last = r;
			pr = pr.next;
		} else {
			pl = pl.next;
		}
		while (pl != null && pr != null) {
			if (pl.data > pr.data) {
				last.next = pr;
				last = pr;
				pr = pr.next;
			} else {
				last.next = pl;
				last = pl;
				pl = pl.next;
			}
		}
		if (pl != null)
			last.next = pl;
		else
			last.next = pr;

		return top;
	}
}
