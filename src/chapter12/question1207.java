package chapter12;

import java.util.Arrays;

public class question1207 {
	
	public static void main(String[] args)
	{
		System.out.println(hashString("haha"));
	}
	
	public static String hashString(String s)
	{
		char[] c = s.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
}
