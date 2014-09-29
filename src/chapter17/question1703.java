package chapter17;

import java.util.*;

public class question1703 {
	
	public static void main(String[] args)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(5);
		System.out.println(divideTheSum(list));
	}
	
	public static int divideTheSum(ArrayList<Integer> l)
	{
		int sum = 0;
		for(int i = 0;i< l.size();i++)
		{
			sum += l.get(i);
		}
		boolean[] feasible = new boolean[sum+1];
		feasible[0] = true;
		for(int i = 0;i<l.size();i++)
		{
			for(int j = feasible.length-1;j >= 0;j--)
			{
				if(feasible[j])
				{
					feasible[j+l.get(i)] = true;
				}
			}
		}
		
		int half = sum/2;
		while(!feasible[half])
		{
			half --;
		}
		return half;
	}
}
