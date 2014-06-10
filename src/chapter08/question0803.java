package chapter08;

import chapter09.Node;
import java.util.Stack;

public class question0803 {
	
	public static void printTree(Node root) throws Exception 
	{
		Stack<Node> s = new Stack<Node>();
		while(s.size() != 0)
		{
			Node node = s.pop();
			if(node.left == null)
			{
				System.out.print(node.n+" ");
				if(node.right != null)
				{
					s.push(node.right);
				}
			}
			else 
			{
				s.push(node.left);
			}
		}
		System.out.println();
	}
}
