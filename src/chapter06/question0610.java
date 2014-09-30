package chapter06;

public class question0610 {
	
	public static void main(String [] args)
	{
		char[] a = "abc".toCharArray();
		int[] permutation = new int[]{2,0,1};
		applyPermutation(a, permutation);
		System.out.println(new String(a));
	}
	
	public static void applyPermutation(char[] a, int[] permutation)
	{
		boolean[] checked = new boolean[a.length];
		for(int i = 0;i<permutation.length;i++)
		{
			if(checked[i])
			{
				continue;
			}
			char tempChar = a[i];
			int tempIndex = i;
			while(permutation[tempIndex] != i)
			{
				a[tempIndex] = a[permutation[tempIndex]];
				checked[permutation[tempIndex]] = true;
				tempIndex = permutation[tempIndex];
			}
			a[tempIndex] = tempChar;
			checked[i ]= true;
		}
	}
}
