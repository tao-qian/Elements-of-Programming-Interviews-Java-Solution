package chapter09;

public class question0912 {

	public static Node getCommonAncestor(Node n1, Node n2, Node root) {
		int d1 = getDepth(n1);
		int d2 = getDepth(n2);
		if (d1 > d2) {
			n1 = moveUp(n1, d1 - d2);
		} else if (d2 > d1) {
			n2 = moveUp(n2, d2 - d1);
		}
		while (n1 != null && n2 != null) {
			if (n1 == n2)
				return n1;
			n1 = n1.parent;
			n2 = n2.parent;
		}
		return null;
	}

	public static Node moveUp(Node n, int levels) {
		for (int i = 0; i < levels; i++)
			n = n.parent;
		return n;
	}

	public static int getDepth(Node n) {
		int count = 0;
		while (n.parent != null) {
			n = n.parent;
			count++;
		}
		return count;
	}

}
