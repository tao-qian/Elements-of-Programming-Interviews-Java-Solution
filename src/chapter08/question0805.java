package chapter08;

public class question0805 {
	
	public static void towerOfHanoi(int from, int to, int temp, int n)
	{
		if(n == 1)
		{
			System.out.println(from+" -> "+to);
			return;
		}
		towerOfHanoi(from,temp,to,n-1);
		towerOfHanoi(from,to,temp,1);
		towerOfHanoi(temp,to,from,n-1);
	}
}
