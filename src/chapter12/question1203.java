package chapter12;

import java.util.*;

public class question1203 {
	
	public int findClosetDistance(int[] a)
	{
		HashMap<Integer, Integer> lastSeen = new HashMap<Integer,Integer>();
		int minDist = Integer.MAX_VALUE;
		for(int i = 0; i < a.length;i++)
		{
			Integer last = lastSeen.get(a[i]);
			if(last != null)
			{
				minDist = Math.min(minDist,i-last);
			}
			lastSeen.put(i,a[i]);
		}
		return minDist;
	}
}
