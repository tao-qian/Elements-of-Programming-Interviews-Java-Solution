package chapter06;

public class question0620 {
	
	public static void main(String []args)
	{
		Util.Utility.print(buildTable("ababaababa"));
	}
	
	//Here we use KMP
	public static int KMP(String s, String w)
	{
		int[] table = buildTable(w);
		int sp = 0;
		int wp = 0;
		while (sp < s.length()) {
			if (s.charAt(sp + wp) == w.charAt(wp)) {
				wp++;
				if (wp == w.length()) {
					return sp;
				}
				continue;
			}
			// It works because table[0] = -1
			sp = sp + wp - table[wp];
			if (wp > 0) {
				wp = table[wp];
			}
		}
		return -1;
	}
	
	//a  b a b a 
	//-1 0 0 1 2
	public static int[] buildTable(String w)
	{
		char[] a = w.toCharArray();
		int[] table = new int[a.length];
		table[0] = -1;
		int p = 0;
		for(int i = 1;i<table.length;i++)
		{
			table[i] = p;
			if(a[i] == a[p])
			{
				p++;
			}
			else
			{
				while(p != 0 && a[table[p]] != a[i])
				{
					p = table[p];
				}
			}
		}
		return table;
	}
}
