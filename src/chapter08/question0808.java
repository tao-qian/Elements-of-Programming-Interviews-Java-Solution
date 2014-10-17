package chapter08;

import java.util.LinkedList;
import java.util.StringTokenizer;

import chapter07.LinkedListNode;

public class question0808 {

	public static void main(String[] args) throws Exception {
		System.out.println(getShortestPath("/./../tao/../tt/../..//ss"));
	}

	public static String getShortestPath(String original) throws Exception {
		Stack<String> pathStack = new Stack<String>();
		StringTokenizer st = new StringTokenizer(original);
		while (st.hasMoreTokens()) {
			String token = st.nextToken("/");
			if (token.equals("..")) {
				if (pathStack.size == 0 || pathStack.peek() == "..") {
					pathStack.push("..");
				} else {
					pathStack.pop();
				}
			} else if (token.equals(".")) {
				continue;
			} else if (token.equals("")) {
				continue;
			} else {
				pathStack.push(token);
			}
		}
		StringBuilder sb = new StringBuilder();
		if (original.startsWith("/")) {
			sb.append("/");
		}
		LinkedList<LinkedListNode<String>> list = pathStack.toLinkedList();
		for (LinkedListNode<String> s : list) {
			sb.append("/" + s.data);
		}
		return sb.toString();
	}
}
