package common;

import java.util.*;

public class Combination {
	
	public static void main(String[] args)
	{
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		for(HashSet<Integer> l : getCombination(set,2))
		{
			Util.Utility.print(l);
		}
	}
	

	
	public static ArrayList<HashSet<Integer>>getCombination(HashSet<Integer> set, int n)
	{
		if(n == 0)
		{
			ArrayList<HashSet<Integer>> result = new ArrayList<HashSet<Integer>>();
			result.add(new HashSet<Integer>());
			return result;
		}
		
		ArrayList<HashSet<Integer>> finalResult = new ArrayList<HashSet<Integer>>();
		for(Integer i : new ArrayList<Integer>(set))
		{
			set.remove(i);
			ArrayList<HashSet<Integer>> lastResult = getCombination((HashSet<Integer>) set.clone(), n-1);
			for(HashSet<Integer> s:lastResult)
			{
				s.add(i);
			}
			finalResult.addAll(lastResult);
		}
		return finalResult;	
	}
}
