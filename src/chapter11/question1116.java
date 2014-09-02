package chapter11;

import java.util.Random;

public class question1116 {
	
	public static void main(String[] args) 
	{
		int[] a = new int[10];
		for(int i = 0; i < a.length;i++)
		{
			a[i] = i;
		}
		Random r = new Random();
		int missing = r.nextInt(a.length);
		int extra = r.nextInt(a.length);
		if(missing == extra)
		{
			System.out.println("Bad luck, try again");
			return;
		}
		a[missing] = extra;
		System.out.println(missing+" , "+extra);
		Util.Utility.print(findDuplicateAndMissing(a, a.length));
	}
	
	//7 1
	
	public static int[] findDuplicateAndMissing(int[] a, int range)
	{
		if(a.length != range)
		{
			//throw new Exception ("Illegal parameters");
			return new int[]{-1,-1};
		}
		int xor = 0;
		for(int i = 0; i < a.length;i++)
		{
			xor ^= a[i];
			xor ^= i;
		}
		//xor is the xor of the missing element m and extra element l.
		//find the first bit where m differs from l
		int diffBit = 0;
		while(((xor>>diffBit) & 1) == 0)
		{
			diffBit ++;
		}
		// mOrL is m or l
		int mOrL = 0;
		for(int i = 0;i<a.length;i++)
		{
			if(((a[i] >> diffBit) & 1) == 1)
			{
				mOrL ^= a[i];
			}
			if(((i >> diffBit) & 1) == 1)
			{
				mOrL ^= i;
			}
		}
		//Then we find if mOrL is m or l
		for(int i = 0;i<a.length;i++)
		{
			//mOrL is l
			if(a[i] == mOrL)
			{
				return new int[]{mOrL ^ xor, mOrL};
			}
		}
		return new int[]{mOrL, mOrL ^ xor};
	}
}
