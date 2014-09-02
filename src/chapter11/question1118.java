package chapter11;

public class question1118 {
	
	public static int searchCloseArray(int[] a, int n)
	{
		int start = 0;
		while(start < a.length)
		{
			if(a[start] == n)
			{
				return start;
			}
			start += Math.abs(n-a[start]);
		}
		if(start >= a.length)
		{
			return -1;
		}
		return start;
	}
}
