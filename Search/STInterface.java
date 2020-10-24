package Search;

import java.util.List;

interface STInterface<Key extends Comparable<? super Key>, Val>
{
	void put(Key key, Val val);
	Val get(Key key);
	void delete(Key key);
	void deleteMin();
//	boolean contains(Key key);
	int size();
	Key min();
	Key max();
	Key select(int k);
	int rank(Key key);
//	Key floor(Key key);
//	Key ceiling(Key key);
	
	public static void fill(STInterface<String, Integer> table)
	{
		List<String> strs = Reader.mappedFile("C:\\Users\\18069\\Desktop\\text.txt");
		
		for (String s : strs)
		{
			if (table.get(s) == null)
			{
				table.put(s, 1);
			}
			else
			{
				table.put(s, table.get(s) + 1);
			}
		}
	}
}
