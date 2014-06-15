package chapter07;

public class question0707 {
	
	public static void deleteNode (Node s)
	{
		s.data = s.next.data;
		s.next = s.next.next;
	}
}
