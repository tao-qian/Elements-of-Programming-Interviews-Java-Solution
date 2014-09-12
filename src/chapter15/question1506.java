package chapter15;

import java.util.ArrayList;
import java.util.Collections;

public class question1506 {
	
	public static void main(String[] args)
	{
		int[] a = new int[]{2,-1,3,-3,4,-4,5,6};
		ArrayList<Integer> result = longestNondecreasingSubsequence(a);
		for(int i = 0;i<result.size();i++)
		{
			System.out.println(a[result.get(i)]);
		}
	}
	
	public static ArrayList<Integer> longestNondecreasingSubsequence(int[] a)
	{
		int[] last = new int[a.length];
		int[] bestCount = new int[a.length];
		int bestSoFar = Integer.MIN_VALUE;
		int bestIndex = -1;
		for(int i = 0;i<a.length;i++)
		{
			last[i] = -1;
			bestCount[i] = 0; 
			for(int j = 0;j<i;j++)
			{
				if(a[j] <= a[i])
				{
					if(bestCount[i] < bestCount[j])
					{
						bestCount[i] = bestCount[j];
						last[i] = j;
					}
				}
			}
			bestCount[i] = bestCount[i] + 1;
			if(bestCount[i] > bestSoFar)
			{
				bestSoFar = bestCount[i];
				bestIndex = i;
			}
		}
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(bestIndex);
		int lastIndex = a[bestIndex];
		while(lastIndex != -1)
		{
			result.add(lastIndex);
			lastIndex = last[lastIndex];
		}
		Collections.reverse(result);
		return result;
	}
}
