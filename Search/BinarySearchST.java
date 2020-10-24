package Search;

import java.util.*;

public class BinarySearchST<Key extends Comparable<? super Key>, Val>
{
	private ArrayList<Key> keys = new ArrayList<>();
	private ArrayList<Val> vals = new ArrayList<>();

	// N
	public void put(Key key, Val val)
	{
		int rank = rank(key);
		
		if (rank < keys.size() && keys.get(rank).compareTo(key) == 0)
		{
			vals.set(rank, val);
			return;
		}
		
		keys.add(null);
		vals.add(null);
		int N = keys.size() - 1;
		for (int i = N; i > rank; i --)
		{
			keys.set(i, keys.get(i - 1));
			vals.set(i, vals.get(i - 1));
		}
		
		keys.set(rank, key);
		vals.set(rank, val);
	}

	public Val get(Key key)
	{
		int rank = rank(key);
		
		if (rank < keys.size() && keys.get(rank).compareTo(key) == 0)
		{
			return vals.get(rank);
		}
		
		return null;
	}
	
	// 返回小于目标的个数
	private int rank(Key key)
	{
		int lo = 0,
			hi = keys.size() - 1,
			mid;
		
		while (lo <= hi) 
		{
			mid = lo + (hi - lo) / 2;
			
			if (keys.get(mid).compareTo(key) > 0)
				hi = mid - 1;
			else if (keys.get(mid).compareTo(key) < 0)
				lo = mid + 1;
			else
				return mid;
		}
		
		return lo;
	}
}
