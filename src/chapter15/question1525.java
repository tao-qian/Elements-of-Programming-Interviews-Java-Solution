package chapter15;

import java.util.TreeSet;

public class question1525 {
	
	public static void main(String[] args)
	{
		int[] items = new int[]{4,3,2,1};
		int boxSize = 5;
		System.out.println(boxPacking(items, boxSize));
	}
	
	public static class Box implements Comparable<Box>
	{
		int remainingSpace;
		int insertSequence;
		public Box(int remainingSpace, int insertSequence)
		{
			this.remainingSpace = remainingSpace;
			this.insertSequence = insertSequence;
		}
		
		public String toString()
		{
			return insertSequence+":"+remainingSpace;
		}
		
		public int compareTo(Box b)
		{
			int diff =   b.remainingSpace - remainingSpace;
			if(diff != 0)
			{
				return diff;
			}
			return insertSequence - b.insertSequence;
		}
	}
	
	public static int boxPacking(int[] items, int boxSize)
	{
		TreeSet<Box> boxes = new TreeSet<Box>();
		int boxCount = 0;
		boxes.add(new Box(boxSize, boxCount));
		boxCount ++;
		for(int i = 0;i<items.length;i++)
		{
			int currentBestRemaining = boxes.first().remainingSpace;
			if(currentBestRemaining < items[i])
			{
				boxes.add(new Box(boxSize-items[i],boxCount));
				boxCount++;
			}
			else
			{
				Box current = boxes.pollFirst();
				current.remainingSpace -= items[i];
				boxes.add(current);
			}
		}
		return boxes.size();
	}
	
}
