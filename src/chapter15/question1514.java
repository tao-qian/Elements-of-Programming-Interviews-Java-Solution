package chapter15;

public class question1514 {
	
	public static void main(String[] args)
	{
		System.out.println(combination(10,5));
	}
	
	public static int combination(int n, int k)
	{
		int[][] combination = new int[n+1][n+1];
		for(int i = 0;i<=n;i++)
		{
			for(int j = 0;j<=i;j++)
			{
				if(j == 0 || i == j)
				{
					combination[i][j] = 1;
				}
				else
				{
					combination[i][j] = combination[i-1][j] + combination[i-1][j-1];
				}
				if(j == k && i == n)
				{
					return combination[i][j];
				}
			}
		}
		return -1;
	}
}
