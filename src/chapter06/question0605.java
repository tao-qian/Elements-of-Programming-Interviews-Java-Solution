package chapter06;

import java.util.*;

public class question0605 {
	
	public static List<Integer> findModnSubset(Integer[] n)
	{
		int[] modList = new int[n.length];
		int sumSoFar = 0;
		for(int i = 0;i<n.length;i++)
		{
			sumSoFar += n[i];
			int mod = sumSoFar % n.length;
			if(mod == 0)
			{
				return toArrayList(n, 0, i+1);
			}
			if(modList[mod] != 0)
			{
				return toArrayList(n,modList[mod], i + 1);
			}
			modList[mod] = i;
		}
		return null;
	}
	
	public static <T> ArrayList<T> toArrayList(T[] a, int start, int end)
	{
		ArrayList<T> result = new ArrayList<T>();
		for(int i = start;i<end;i++)
		{
			result.add(a[i]);
		}
		return result;
	}
}
