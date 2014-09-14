package chapter15;

import java.util.LinkedList;

public class question1508 {
	
	public static void main(String[] args)
	{
		int[] h = new int[]{2,3,4,5,6,3,6,73,2,1};
		System.out.println(largestRectangle(h));
	}
	
	public static int largestRectangle(int[] h)
	{
		LinkedList<Integer> forwardStack = new LinkedList<Integer>();
		LinkedList<Integer> backwardStack = new LinkedList<Integer>();
		int[] leftRecWidth = new int[h.length];
		int[] rightRecWidth = new int[h.length];
		for(int i = 0;i<h.length;i++)
		{
			while(forwardStack.size() != 0 && h[forwardStack.peekLast()] >= h[i])
			{
				forwardStack.pollLast();
			}
			if(forwardStack.size() == 0)
			{
				/*
				 * When the stack is empty, there can be two cases.
				 * The first one is that we are at the beginning of the loop,
				 * in this case i = 0, and the width of i should also be 0.
				 * The second case is that we are in the middle of the loop,
				 * but h[i] is smaller than all the number in front of it,
				 * so the width should be i
				 */
				leftRecWidth[i] = i;
			}
			else
			{
				/*
				 * Otherwise the width is the difference
				 * between the current index and the last index whose height is
				 * smaller than the current height
				 */
				leftRecWidth[i] = i - forwardStack.peekLast() - 1;
			}
			forwardStack.addLast(i);
			
			
			//Do the same thing with the backwardStack
			int j = h.length - i - 1;
			while(backwardStack.size() != 0 && h[backwardStack.peekLast()] >= h[j])
			{
				backwardStack.pollLast();
			}
			if(backwardStack.size() == 0)
			{
				rightRecWidth[j] = i;
			}
			else
			{
				rightRecWidth[j] = backwardStack.peekLast() - j - 1;
			}
			backwardStack.addLast(j);
		}
		
		int max = Integer.MIN_VALUE;
		int maxIndex = -1;
		for(int i = 0; i < h.length;i++)
		{
			int newWidth = leftRecWidth[i] + rightRecWidth[i] + 1;
			int newArea = newWidth * h[i];
			if(newArea > max)
			{
				max = newArea;
				maxIndex = i;
			}
		}
		Util.Utility.print(leftRecWidth);
		Util.Utility.print(rightRecWidth);
		System.out.println(maxIndex - leftRecWidth[maxIndex]+","+(maxIndex + rightRecWidth[maxIndex]));
		return max;
	}
}
