package sort;

import java.util.*;
import static sort.Util.*;

interface pqInterface<T extends Comparable<? super T>>
{
	void insert(T v);
	T max();
	T delMax();
	boolean isEmpty();
	int size();
}

public class PriorityQueue<T extends Comparable<? super T>> implements pqInterface<T>
{
	private ArrayList<T> list; // list[0] 不使用
	private int N = 0;

	public PriorityQueue()
	{
		list = new ArrayList<>();
		list.add(null); // 从1开始
	}
	
	@Override
	public void insert(T v)
	{
		list.add(v);
		N ++;
		swim(N);
	}

	@Override
	public T max()
	{
		T ret = null;
		
		if (list.size() >= 1)
			ret = list.get(1);
		
		return ret;
	}

	@Override
	public T delMax()
	{
		T ret = list.get(1);
		exch(list, 1, N --);
		list.remove(N + 1);
		
		sink(1);
		
		return ret;
	}

	@Override
	public boolean isEmpty()
	{
		return N == 0;
	}

	@Override
	public int size()
	{
		return N;
	}
	
	private void swim(int k)
	{
		while (k > 1 && less(list.get(k/2), list.get(k)))
		{
			exch(list, k/2, k);
			k /= 2;
		}
	}
	
	private void sink(int k)
	{
		while (2*k <= N)
		{
			int i = 2*k;
			if (i < N && less(list.get(i), list.get(i + 1)))
				i ++;
			exch(list, k, i);
			k = i;
		}
	}
}
