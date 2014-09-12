package chapter14;

import java.util.*;

public class question1417 {
	
	public static void main(String[] args) throws Exception
	{
		Log l = new Log();
		l.add("zz");
		l.add("zz");
		l.add("bb");
		l.add("aa");
		l.add("bb");
		l.add("aa");
		l.add("aa");
		l.add("cc");
		l.add("cc");
		l.add("aa");
		l.add("aa");
		l.add("aa");
		l.add("aa");
		l.add("aa");
		l.add("bb");
		l.add("bb");
		l.add("bb");
		l.add("aa");
		Util.Utility.print(l.common(3));
	}
	
	public static class LogEntry implements Comparable<LogEntry>
	{
		String timeStamp;
		String page;
		int count;
		
		public LogEntry(String page)
		{
			//Not used in code
			this.timeStamp = "";
			this.page = page;
			this.count = 0;
		}
		
		public int compareTo(LogEntry e)
		{
			int diff = e.count - this.count;
			if(diff != 0)
			{
				return diff;
			}
			return page.compareTo(e.page);
		}
		
		public String toString()
		{
			return page;
		}
		
	}
	
	public static class Log
	{
		TreeSet<LogEntry> entries;
		HashMap<String, LogEntry> map;
		
		public Log()
		{
			entries = new TreeSet<LogEntry>();
			map = new HashMap<String, LogEntry>();
		}
		
		public void add(String page)
		{
			LogEntry existing = map.get(page);
			if(existing == null)
			{
				existing = new LogEntry(page);
				map.put(page,existing);
			}
			else
			{
				entries.remove(existing);
			}
			existing.count += 1;
			entries.add(existing);
		}
		
		public LogEntry[] common(int k) throws Exception
		{ 
			if(k > entries.size())
			{
				throw new Exception ("Cannot get that many!");
			}
			LogEntry[] result = new LogEntry[k];
			int i = 0;
			for(LogEntry entry : entries)
			{
				result[i] = entry;
				i++;
				if(i == k)
				{
					break;
				}
			}
			return result;
		}
	}
}
