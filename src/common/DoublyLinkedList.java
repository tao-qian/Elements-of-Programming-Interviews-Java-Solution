package common;

public class DoublyLinkedList<T> {

	public static void main(String[] args) {
		DoublyLinkedList<Integer> l = new DoublyLinkedList<Integer>();
		DoublyLinkedListNode<Integer> i = new DoublyLinkedListNode<Integer>(1);
		DoublyLinkedListNode<Integer> j = new DoublyLinkedListNode<Integer>(2);
		DoublyLinkedListNode<Integer> k = new DoublyLinkedListNode<Integer>(3);
		l.append(i);
		l.append(j);
		l.remove(j);
		l.append(k);
		l.remove(l.tail);
		l.remove(l.head);
		// l.remove(i);
		System.out.println(l);
	}

	public static class DoublyLinkedListNode<T> {
		public T data;
		public DoublyLinkedListNode<T> next;
		public DoublyLinkedListNode<T> last;

		public DoublyLinkedListNode(T data) {
			this.data = data;
			next = null;
			last = null;
		}

		public String toString() {
			return data.toString();
		}
	}

	public int size;
	public DoublyLinkedListNode<T> head;
	public DoublyLinkedListNode<T> tail;

	public DoublyLinkedList() {
		this.size = 0;
		this.head = null;
		this.tail = null;
	}

	public void append(DoublyLinkedListNode<T> n) {
		size++;
		if (tail == null) {
			head = n;
			tail = n;
			return;
		}
		tail.next = n;
		n.last = tail;
		tail = n;
	}

	public void append(T data) {
		append(new DoublyLinkedListNode<T>(data));
	}

	public void remove(DoublyLinkedListNode<T> n) {
		size--;
		if (n.last != null) {
			n.last.next = n.next;
		}
		if (n.next != null) {
			n.next.last = n.last;
		}
		if (n == tail) {
			tail = n.last;
		}
		if (n == head) {
			head = n.next;
		}
		n.next = null;
		n.last = null;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("{ ");
		if (size > 0) {
			DoublyLinkedListNode<T> runner = head;
			while (runner != tail) {
				sb.append(runner + " ");
				runner = runner.next;
			}
			sb.append(tail);
		}
		sb.append(" }");
		return sb.toString();
	}
}
