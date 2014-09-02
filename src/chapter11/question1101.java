package chapter11;

public class question1101 {
	
	public static void main(String[] args)
	{
		int[] a = new int[]{2};
		System.out.println(binarySearchFirstOccur(a,2));
	}
	
	public static int binarySearchFirstOccur(int[] a, int n)
	{
		int p = 0;
		int q = a.length-1;
		while(p <= q)
		{
			int m = (p + q)/2;
			if(a[m] == n)
			{
				//Find the first occurance
				while(m > 1 && a[m-1] == n)
				{
					m -= 1;
				}
				return m;
			}
			else if(a[m] > n)
			{
				q = m - 1;
			}
			else
			{
				p = m + 1;
			}
		}
		return -1;
	}
}
