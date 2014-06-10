package chapter08;

public class question0806 {
	public static Stack<Integer> getSunsetWindows(int[] heights) throws Exception
	{
		Stack<Integer> good = new Stack<Integer>();
		for(int i = 0;i<heights.length;i++)
		{
			while(good.size > 0 && good.peek() <= heights[i])
			{
				good.pop();
			}
			//Here we only record the heights of the good windows,
			//it is better to record the index of those windows, as required by the question
			//to achieve that, create a new class which contains both index and height
			good.push(heights[i]);
		}
		return good;
	}
}
