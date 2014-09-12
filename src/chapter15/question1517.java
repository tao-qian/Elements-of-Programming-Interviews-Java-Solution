package chapter15;

public class question1517 {
	
	public static int catchFish(int[][] map)
	{
		for(int i = 0;i<map.length;i++)
		{
			for(int j = 0;j<map[i].length;j++)
			{
				int upper = i > 0?map[i-1][j]:0;
				int left = j > 0?map[i][j-1]:0;
				map[i][j] += Math.max(upper,left);
			}
		}
		return map[map.length][map[0].length];
	}
}
