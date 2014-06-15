package chapter08;

public class question0804 {
	public void traversePostingList(PostingListNode s) throws Exception {
		Stack<PostingListNode> stack = new Stack<PostingListNode>();
		int order = 0;
		stack.push(s);
		while (stack.size != 0) {
			PostingListNode n = stack.pop();
			if (n.order == -1) {
				continue;
			}
			n.order = order;
			order++;
			stack.push(n.next);
			stack.push(n.jump);
		}
	}
}
