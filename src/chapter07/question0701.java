package chapter07;

public class question0701 {

	public static void main(String[] args) {
		Node n1 = Node.randomSortedList(4, 100);
		Node n2 = Node.randomSortedList(1, 100);
		n1.printNode();
		n2.printNode();
		Node n3 = merge(n1, n2);
		n3.printNode();
	}

	public static Node merge(Node l, Node r) {
		Node pl = l;
		Node pr = r;
		Node top = l;
		Node last = l;
		if (l.n > r.n) {
			top = r;
			last = r;
			pr = pr.next;
		} else {
			pl = pl.next;
		}
		while (pl != null && pr != null) {
			if (pl.n > pr.n) {
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
