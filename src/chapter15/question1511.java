package chapter15;

public class question1511 {
	
	public static void main(String[] args)
	{
		System.out.println(levenshteinDistance("a", "b"));
	}
	
	public static int INSERT_COST = 1;
	public static int DELETE_COST = 1;
	public static int REPLACE_COST = 2;
	
	public static int levenshteinDistance(String a, String b)
	{
		int[][] costMap = new int[a.length()+1][b.length()+1];
		
		for(int i = 0;i<costMap.length;i++)
		{
			costMap[i][0] = i * DELETE_COST;
		}
		
		for(int j = 0;j<costMap[0].length;j++)
		{
			costMap[0][j] = j * INSERT_COST;
		}
		
		for(int i = 1;i<costMap.length;i++)
		{
			for(int j = 1;j<costMap[i].length;j++)
			{
				if(a.charAt(i-1) == b.charAt(j-1))
				{
					costMap[i][j] = costMap[i-1][j-1];
					continue;
				}
				int replace = costMap[i-1][j-1]+REPLACE_COST;
				int insert = costMap[i][j-1] + INSERT_COST;
				int delete = costMap[i-1][j] + DELETE_COST;
				costMap[i][j] = Math.min(delete,Math.min(replace,insert));
			}
		}
		return costMap[a.length()][b.length()];
	}
}
