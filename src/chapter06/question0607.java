package chapter06;

public class question0607 {
	
	
	public static void main(String[] args)
	{
		int[] A= new int []{1,5,3,6};
		int[] B = new int[]{2,1,0,5};
		Util.Utility.print(equivalentClass(A, B, 7));
	}
	
	public static int[] equivalentClass(int[] A, int[] B, int n)
	{
		int[] classes = new int[n];
		//Each element is initialized to be in its own class
		for(int i = 0;i<classes.length;i++)
		{
			classes[i] = i;
		}
		
		for(int i = 0;i<A.length;i++)
		{
			int aClass = classes[A[i]];
			int bClass = classes[B[i]];
			if(aClass < bClass)
			{
				classes[B[i]] = aClass; 
			}
			else if(aClass > bClass)
			{
				classes[A[i]] = bClass; 
			}
		}
		
		for(int i = 0;i< classes.length;i++)
		{
			if(classes[i] != i)
			{
				int value = classes[i];
				while(classes[value] != value)
				{
					value = classes[value];
				}
				classes[i] = value;
			}
		}
		return classes;
	}
}
