package chapter15;

public class question1524 {

	public static void main(String[] args)
	{
		int[] a = new int[]{1,2,3,4,5,6};
		int serverNum = 201;
		System.out.println(loadBalancing(a,serverNum));
		//System.out.println(willFit(1, 6, a));
	}
	
	public static int loadBalancing(int[] a, int serverNum)
	{
		int totalSize = 0;
		for(int i = 0;i<a.length;i++)
		{
			totalSize += a[i];
		}
		int p = 1;
		int q = totalSize;
		int bestSoFar = Integer.MAX_VALUE;
		while(p <= q)
		{
			int m = (p + q)/2;
			boolean canFit = willFit(m, serverNum, a);
			if(canFit)
			{
				bestSoFar = m;
				q = m - 1;
			}
			else
			{
				p = m + 1;
			}
		}
		return bestSoFar;
	}
	
	public static boolean willFit(int bucketSize, int numBucket, int[] a)
	{
		int currentNumBucket = 0;
		int currentBucketSize = 0;
		for(int i = 0;i<a.length;i++)
		{
			int newBucketSize = currentBucketSize + a[i];
			if(newBucketSize > bucketSize)
			{
				currentNumBucket ++;
				if(currentNumBucket >= numBucket)
				{
					return false;
				}
				newBucketSize = a[i];
				if(newBucketSize > bucketSize)
				{
					return false;
				}
			}
			currentBucketSize = newBucketSize;
		}
		return true;
	}
}
