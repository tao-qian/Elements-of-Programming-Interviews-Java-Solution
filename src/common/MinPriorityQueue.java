package common;

import java.util.ArrayList;

public class MinPriorityQueue<T> {

	public static void main(String[] args) {
		MinPriorityQueue<Integer> queue = new MinPriorityQueue<>();
		queue.insert(2, 2);
		queue.insert(3, 3);
		queue.insert(1, 1);
		queue.insert(4, 4);
		queue.insert(-1, -1);
		queue.insert(5, 5);
		queue.printArray();
		queue.printArray();

	}

	public ArrayList<Node<T>> a;

	public int getSize() {
		return a.size();
	}

	public void printArray() {
		for (int i = 0; i < a.size(); i++) {
			System.out.print(a.get(i).key + " ");
		}
		System.out.println();
	}

	public MinPriorityQueue() {
		a = new ArrayList<Node<T>>();
	}

	public Node<T> extractMin() {
		if (a.size() == 0)
			return null;
		Node<T> result = a.get(0);
		a.set(0, a.get(a.size() - 1));
		a.remove(a.size() - 1);
		if (a.size() > 0)
			minHeapify(0);
		return result;
	}

	public void minHeapify(int i) {

		Node<T> n = a.get(i);
		while (true) {
			int l = left(i);
			int r = right(i);
			int min = i;
			if (l < a.size()) {
				Node<T> lNode = a.get(l);
				if (lNode.key < n.key) {
					min = l;
					n = lNode;
				}
			}
			if (r < a.size()) {
				Node<T> rNode = a.get(r);
				if (rNode.key < n.key) {
					min = r;
					n = rNode;
				}
			}
			if (min == i)
				return;
			swap(i, min);
			i = min;
		}
	}

	public void insert(T data, int key) {
		Node<T> n = new Node<T>();
		n.key = Integer.MAX_VALUE;
		a.add(n);
		decreaseKey(a.size() - 1, key);
	}

	public boolean decreaseKey(int index, int newKey) {
		Node<T> old = a.get(index);
		if (newKey > old.key)
			return false;
		old.key = newKey;
		int parent = parent(index);
		while (true) {
			if (parent < 0)
				return true;
			Node<T> p = a.get(parent);
			if (p.key < old.key)
				return true;
			swap(index, parent);
			index = parent;
			parent = parent(index);
		}
	}

	private void swap(int m, int n) {
		Node<T> temp = a.get(m);
		a.set(m, a.get(n));
		a.set(n, temp);
	}

	private static int parent(int i) {
		if (i == 0)
			return -1;
		return (i - 1) / 2;
	}

	private static int left(int i) {
		return i * 2 + 1;
	}

	private static int right(int i) {
		return i * 2 + 2;
	}

	public static class Node<T> {
		int key;
		T data;
	}
}
