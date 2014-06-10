package chapter08;

public class question0801 {
	
	public class MaxStack extends Stack
	{
		public Stack max;
		
		public MaxStack()
		{
			super();
			max = new Stack();
		}
		
		public void push(int n)
		{
			if(max.head == null || max.head.n <= n)
			{
				max.push(n);
			}
			super.push(n);
		}
		
		public int pop() throws Exception
		{
			int n = super.pop();
			if(n == max.head.n)
			{
				max.pop();
			}
			return n;
		}
	}
}
