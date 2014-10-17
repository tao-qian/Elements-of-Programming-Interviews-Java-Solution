package chapter07;

public class question0704 {
	// Not tested
	@SuppressWarnings("rawtypes")
	public static LinkedListNode findStart(LinkedListNode n1, LinkedListNode n2) {
		int l1 = getLength(n1);
		int l2 = getLength(n2);
		LinkedListNode r1 = n1;
		LinkedListNode r2 = n2;
		if (l1 > l2) {
			advance(r1, l1 - l2);
		} else if (l2 > l1) {
			advance(r2, l2 - l1);
		}
		while (r1 != null && r2 != null) {
			if (r1 == r2)
				return r1;
			r1 = r1.next;
			r2 = r2.next;
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	public static LinkedListNode advance(LinkedListNode n, int steps) {
		for (int i = 0; i < steps; i++) {
			n = n.next;
		}
		return n;
	}

	@SuppressWarnings("rawtypes")
	public static int getLength(LinkedListNode n) {
		int length = 0;
		while (n != null) {
			n = n.next;
			length++;
		}
		return length;
	}
}
