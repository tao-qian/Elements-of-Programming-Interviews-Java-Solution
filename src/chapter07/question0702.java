package chapter07;

public class question0702 {
	
	
	public static Node checkCycle(Node start)
	{
		Node p1 = start;
		Node p2 = start;
		if(p2 == null)
		{
			return null;
		}
		while(p2.next != null && p2.next.next != null)
		{
			p2 = p2.next.next;
			p1 = p1.next;
			if(p1 == p2)
			{
				//Count the length of the cycle
				//and advance a counter from the start 
				//by the same amount
				Node p3 = start;
				while(p1 != p2)
				{
					p1 = p1.next;
					p3 = p3.next;
				}
				p1 = start;
				while(p1 != p3)
				{
					p1 =p1.next;
					p3 = p3.next;
				}
				return p1;
			}
		}
		return null;
	}
}
