package chapter07;

public class question0701 {

	public static void main(String[] args) {
		LinkedListNode<Integer> n1 = LinkedListNode.randomSortedList(4, 100);
		LinkedListNode<Integer> n2 = LinkedListNode.randomSortedList(1, 100);
		n1.printNode();
		n2.printNode();
		LinkedListNode<Integer> n3 = merge(n1, n2);
		n3.printNode();
	}

	public static LinkedListNode<Integer> merge(LinkedListNode<Integer> l, LinkedListNode<Integer> r) {
		LinkedListNode<Integer> pl = l;
		LinkedListNode<Integer> pr = r;
		LinkedListNode<Integer> top = l;
		LinkedListNode<Integer> last = l;
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
