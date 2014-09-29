package chapter16;

import java.util.*;

public class question1602 {

	
	public static void main(String[] args)
	{
		HashSet<String> dict  = new HashSet<String>();
		dict.add("aa");
		dict.add("ab");
		dict.add("bb");
		System.out.println(stringTransformation("aa", "bb", dict));
	}
	
	// Tracking the length of the sequence requires an extra parameter attached to each string in the queue.
	// And we are not doing that here.
	public static boolean stringTransformation(String s, String d, Set<String> dictionary)
	{
		HashSet<String> checked = new HashSet<String>();
		LinkedList<String> queue = new LinkedList<String>();
		queue.add(s);
		checked.add(s);
		while(queue.size() != 0)
		{
			char[] current = queue.pollFirst().toCharArray();
			for(int i = 0;i<current.length;i++)
			{
				char currentC = current[i];
				for(int j = 0;j<26;j++)
				{
					char newC = (char)('a' + j);
					if(newC == currentC)
					{
						continue;
					}
					current[i] = newC;
					String newS = new String(current);
					if(checked.contains(newS))
					{
						current[i] = currentC;
						continue;
					}
					if(!dictionary.contains(newS))
					{
						current[i] = currentC;
						continue;
					}
					checked.add(newS);
					if(newS.equals(d))
					{
						return true;
					}
					queue.add(newS);
					current[i] = currentC;
				}
			}
		}
		return false;
	}
	
	public static Character[] toCharacterArray(String s)
	{
		Character[] result = new Character[s.length()];
		for(int i = 0;i<s.length();i++)
		{
			result[i] = s.charAt(i);
		}
		return result;
	}
}
