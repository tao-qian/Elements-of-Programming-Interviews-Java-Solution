package chapter13;

import java.util.Arrays;

public class question1306 {
	
	public boolean teamPic(int[] front, int[] back)
	{
		Arrays.sort(front);
		Arrays.sort(back);
		for(int i = 0 ;i < front.length;i++)
		{
			if(front[i] > back[i])
			{
				return false;
			}
		}
		return true;
	}
}
