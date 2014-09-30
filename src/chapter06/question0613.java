package chapter06;

public class question0613 {
	
	public static void main(String []args)
	{
		int[] a = {1,2,3,4,5};
		rotate(a,3);
		Util.Utility.print(a);
	}
	
	//012345
	//450123
	public static void rotate(int[] a, int offset)
	{
		//First reverse the entire array
		reverse(a, 0, a.length-1);
		//Then reverse the sub arrays
		offset = offset%a.length;
		reverse(a, 0, 0+offset-1);
		reverse(a, 0+offset,a.length-1);
	}
	
	public static void reverse(int[] a, int p, int q)
	{
		while(p < q)
		{
			int temp = a[p];
			a[p] = a[q];
			a[q] = temp;
			p++;
			q--;
		}
	}
}
