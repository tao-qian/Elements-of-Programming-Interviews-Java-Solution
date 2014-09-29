package chapter06;

public class question0606 {
	
	
	public static void main(String[] args)
	{
		int[] a = new int[]{1,2,3,4,5,2,3,4,5,6,7,8,1,2,3};
		Util.Utility.print(getLongestIncreasingContiguous(a));
	}
	
	public static int[] getLongestIncreasingContiguous(int[] a)
	{
		int start = 0;
		int end = 0;
		int last = a[0];
		
		int longest = -1;
		int longestStart = start;
		int longestEnd = end;
		for(int i = 1;i< a.length;i++)
		{
			if(a[i] > last)
			{
				end++;
			}else
			{
				int newLongest = end - start + 1;
				if(newLongest > longest)
				{
					longest = newLongest;
					longestStart = start;
					longestEnd = end;
				}
				start = i;
				end = i;
			}
			last = a[i];
		}
		return new int[]{longestStart,longestEnd};
	}
}
