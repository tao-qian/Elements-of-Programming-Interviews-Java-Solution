package common;

import java.util.*;

public class Permutation {
	
	public static void main(String[] args)
	{
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		for(LinkedList<Integer> l : getPermutation(set))
		{
			Util.Utility.print(l);
		}
	}
	
	public static ArrayList<LinkedList<Integer>> getPermutation(HashSet<Integer> set)
	{
		if(set.size() == 1)
		{
			LinkedList<Integer> r = new LinkedList<Integer>();
			for(Integer i : set)
			{
				r.add(i);
			}
			ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
			result.add(r);
			return result;
		}
		ArrayList<LinkedList<Integer>> finalResult = new ArrayList<LinkedList<Integer>>();
		for(Integer i : new ArrayList<Integer>(set))
		{
			set.remove(i);
			ArrayList<LinkedList<Integer>> lastResult = getPermutation(set);
			for(LinkedList<Integer> l : lastResult)
			{
				l.add(i);
			}
			finalResult.addAll(lastResult);
			set.add(i);
		}
		return finalResult;
	}
}
