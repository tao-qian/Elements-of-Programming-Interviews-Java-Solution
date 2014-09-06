package chapter13;

import java.util.*;

public class question1307 {
	
	public static void main(String[] args)
	{
		Util.Utility.print(countOccurence("asfaxxasss"));
	}
	
	public static class Result
	{
		public char c;
		public int count;
		
		public Result(char c, int count)
		{
			this.c = c;
			this.count = count;
		}
		
		public String toString()
		{
			return c+","+count;
		}
	}
	
	public static ArrayList<Result> countOccurence(String s)
	{
		char[] c = s.toCharArray();
		Arrays.sort(c);
		Result lastResult = new Result(c[0], 1);
		ArrayList<Result> r = new ArrayList<Result>();
		
		for(int i = 1;i<c.length;i++)
		{
			if(c[i] == lastResult.c)
			{
				lastResult.count += 1;
			}
			else
			{
				r.add(lastResult);
				lastResult = new Result(c[i],1);
			}
		}
		r.add(lastResult);
		return r;
	}
}
