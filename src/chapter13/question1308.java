package chapter13;

import java.util.ArrayList;
import java.util.HashSet;

public class question1308 {
	
	public static void main(String[] args)
	{
		ArrayList<String> a = new ArrayList<String>();
		a.add("a");
		a.add("b");
		a.add("c");
		a.add("a");
		Util.Utility.print(removeDuplicate(a));
	}
	
	public static ArrayList<String> removeDuplicate(ArrayList<String> a)
	{
		HashSet<String> result = new HashSet<String>();
		result.addAll(a);
		return new ArrayList<String>(result);
	}
}
