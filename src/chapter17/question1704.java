package chapter17;

import java.util.*;

public class question1704 {
	
	public static void main(String[] args)
	{
		Jug[] jugs = new Jug[3];
		jugs[0] = new Jug(230,240);
		jugs[1] = new Jug(290,310);
		jugs[2] = new Jug(500,515);
		LinkedList<Integer> result = new LinkedList<Integer>();
		HashSet<Jug> infeasiblePairs = new HashSet<Jug>();
		Util.Utility.print(checkFeasible(jugs, 2300, 2100, result, infeasiblePairs));
	}
	
	public static class Jug
	{  
		int high;
		int low;
		public Jug(int high, int low)
		{
			this.high = high;
			this.low = low;
		}
		
		public int hashCode()
		{
			return high ^ low;
		}
		
		public boolean equals(Object o)
		{
			if(o == this)
			{
				return true;
			}
			if(! (o instanceof Jug))
			{
				return false;
			}
			Jug other = (Jug) o;
			return other.high == this.high && other.low == this.low;
		}
	}
	
	public static List<Integer> checkFeasible(Jug[] jugs, int high, int low, List<Integer> result, HashSet<Jug> infeasiblePairs)
	{
		if(high < low || high < 0 || infeasiblePairs.contains(new Jug(high, low)))
		{
			return null;
		}
		
		for(int i = 0;i<jugs.length;i++)
		{
			Jug j = jugs[i];
			if(j.high <= high && j.low >= low)
			{
				result.add(i);
				return result;
			}
			int newHigh = high - j.low;
			int newLow = low - j.high;
			result.add(i);
			List<Integer> r = checkFeasible(jugs, newHigh, newLow, result, infeasiblePairs);
			if(r != null)
			{
				return r;
			}
			infeasiblePairs.add(new Jug(high, low));
			result.remove(result.size()-1);
		}
		return null;
	}
}
