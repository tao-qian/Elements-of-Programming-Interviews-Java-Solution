package chapter17;

import java.util.*;

public class question1701 {
	
	public static void main(String[] args)
	{
		ArrayList<Integer> votes = new ArrayList<Integer>();
		votes.add(7);
		votes.add(5);
		System.out.println(isDrawPossible(votes));
	}
	
	public static boolean isDrawPossible(ArrayList<Integer> votes)
	{
		int sum = 0;
		for(Integer i : votes)
		{
			sum += i;
		}
		if(sum % 2 == 1)
		{
			return false;
		}
		int half = sum/2;
		
		Boolean[] feasibility = new Boolean[half+1];
		
		//Having 0 elements to fill 0 votes is feasible.
		//On the other hand, all the other values are false,
		//indicating it is impossible to fill 0+ votes with 0 elements
		feasibility[0] = true;
		for(int i = 1;i<feasibility.length;i++)
		{
			feasibility[i] = false;
		}
		
		for(int i = 0;i < votes.size();i++)
		{
			int currentVote = votes.get(i);
			for(int j = half;j >= currentVote ;j--)
			{
				// If the value is already attainable without the new vote,
				// we skip it.
				if(feasibility[j])
				{
					continue;
				}
				// We update feasibility for j only when 
				// the new vote can be included to make a difference
				if(feasibility[j-currentVote])
				{
					feasibility[j] = true;
				}
			}
		}
		return feasibility[feasibility.length-1];
	}
}
