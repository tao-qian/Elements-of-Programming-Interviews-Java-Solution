package chapter06;

import java.util.LinkedList;

import Util.Utility;

public class question0612 {
	
	public static void main(String[] args)
	{
		int[] vector = new int[]{0,1,2};
		int count = 0;
		while(true)
		{
			System.out.println(permutationIndex(vector)+":");
			Utility.print(getNthPermutation(vector.length, count));
			count++;
			Utility.print(vector);
			vector = nextPermutation(vector);
			if(vector == null)
			{
				break;
			}
		}
		//Utility.print(getNthPermutation(3, 0));
	}
	
	public static int[] getNthPermutation(int k, int n)
	{
		 int[] factorials = new int[k];
		 int[] factNum = new int[k];
		 factorials[0] = 1;
		 for(int i = 1;i<factorials.length;i++)
		 {
			 factorials[i] = factorials[i-1]*(i+1);
		 }
		 // If n is greater than k!, there is no valid answer
		 if(n >= factorials[factorials.length-1])
		 {
			 return null;
		 }
		 for(int i = factNum.length-1;i > 0;i--)
		 {
			 factNum[i] = n/factorials[i-1];
			 n = n%factorials[i-1];
		 }
		 reverse(factNum,0,factNum.length-1);
		 return lehmerDecoding(factNum);
	}
	
	public static int[] lehmerEncoding(int[] a)
	{
		a = a.clone();
		for(int i = 0;i<a.length;i++)
		{
			for(int j = i+1;j<a.length;j++)
			{
				if(a[j] > a[i])
				{
					a[j] --;
				}
			}
		}
		return a;
	}
	
	public static int[] lehmerDecoding(int[] a)
	{
		a = a.clone();
		for(int i = a.length-1;i>=0;i--)
		{
			for(int j = i+1;j < a.length;j++)
			{
				if(a[j] >= a[i])
				{
					a[j]++;
				}
			}
		}
		return a;
	}
	
	public static int permutationIndex(int[] a)
	{
		a = a.clone();
		int mul = 1;
		int sum = 0;
		a = lehmerEncoding(a);
		for(int i = a.length-2; i >= 0;i--)
		{
			sum += a[i] * mul;
			mul *= (i + 1);
		}
		return sum;
	}
	
	public static int permutationIndexOld(int[] a)
	{
		a = a.clone();
		reverse(a,0,a.length-1);
		int mul = 1;
		int sum = 0;
		LinkedList<Integer > list = new LinkedList<Integer>();
		for(int i = 0; i < a.length;i++)
		{
			//Add the element to the sorted list
			int index = insertToSortedList(list,a[i]);
			sum += (i - index) * mul;
			mul *= (i + 1);
		}
		return sum;
	}
	
	public static int insertToSortedList(LinkedList<Integer> list, int n)
	{
		for(int i = 0;i<list.size();i++)
		{
			if(list.get(i) < n)
			{
				list.add(i, n);
				return i;
			}
		}
		list.add(n);
		return list.size()-1;
	}
	
	public static int[] nextPermutation(int[] a)
	{
		int k = a.length - 2;
		while(k >= 0 && a[k] >= a[k+1])
		{
			k--;
		}
		if(k < 0)
		{
			return null;
		}
		//Everything after k is a descending array with a[k] < a[k+1]
		//so we find l with a[l] > a[k] and a[l+1] < a[k]
		int l = k + 1;
		for(int i = l; i< a.length;i++)
		{
			if(a[i] > a[k])
			{
				l = i;
			}
			else
			{
				break;
			}
		}
		//Swap
		int temp = a[l];
		a[l] = a[k];
		a[k] = temp;
		
		//Reverse everything after k, which is still a descending array after the swap
		reverse(a, k+1, a.length-1);
		return a;
	}
	
	public static void reverse(int[] a,int start, int end)
	{
		while(start < end)
		{
			int tmp = a[start];
			a[start] = a[end];
			a[end] = tmp;
			start ++;
			end--;
		}
	}
}
