package chapter15;
import java.util.*;

public class question1515 {
	
	
	public static int countCombination(int k, HashSet<Integer> ways)
	{
		int[] count = new int[k+1];
		count[0] = 1;
		for(Integer n: ways)
		{
			for(int i = n;i <= k;i++)
			{
				count[i] += count[i-n];
			}
		}
		return count[k];
	}
	
	public static int countPermutation(int k, HashSet<Integer> ways)
	{
		int[] count = new int[k+1];
		count[0] = 1;
		for(int i = 0;i<k;i++)
		{
			for(Integer n : ways)
			{
				if(i >= n)
				{
					count[i] += count[i-n];
				}
			}
		}
		return count[k];
	}
}
