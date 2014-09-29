package chapter05;

import java.util.*;

public class question0509 {
	
	public static void main(String[] args)
	{
		ArrayList<Integer> ints = new ArrayList<Integer>();
		ints.add(5);
		ints.add(17);
		ints.add(32);
		String code = EliasGammaEncode(ints);
		Util.Utility.print(EliasGammaDecode(code));
	}
	
	public static String EliasGammaEncode(List<Integer> l)
	{
		StringBuilder sb = new StringBuilder();
		for(Integer i : l)
		{
			String s = toBinary(i);
			for(int j = 0;j<s.length()-1;j++)
			{
				sb.append("0");
			}
			sb.append(s);
		}
		return sb.toString();
	}
	
	public static List<Integer> EliasGammaDecode(String s)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		char[] a = s.toCharArray();
		int p = 0;
		int len = 0;
		while(p < a.length)
		{
			if(a[p] == '0')
			{
				len ++;
				p++;
			}
			else
			{
				int i = Integer.parseInt(new String(a,p,len + 1),2);
				//System.out.println(i);
				result.add(i);
				p += len + 1;
				len = 0;
			}
		}
		return result;
	}
	
	public static String toBinary(Integer i)
	{
		return Integer.toBinaryString(i);
	}
}
