package chapter07;

public class question0707 {
	
	public static void deleteNode (Node s)
	{
		s.n = s.next.n;
		s.next = s.next.next;
	}
}
