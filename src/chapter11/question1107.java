package chapter11;

import java.util.Arrays;

public class question1107 {
	
	public float completionSearch(float[] a, float S)
	{
		Arrays.sort(a);
		
		float totalSum = 0;
		for(int i = 0; i < a.length;i++)
		{
			totalSum += a[i];
		}
		
		// Or we can use a binary search, but time complexity is still O(nlogn) because of sorting
		float partialSum = a[0];
		for(int i = 1; i < a.length;i++)
		{
			float mean = (totalSum - partialSum)/(a.length - i - 1);
			if(mean >= a[i] && mean <= a[i-1])
			{
				return mean;
			}
			partialSum += a[i];
		}
		return 0;
	}
}
