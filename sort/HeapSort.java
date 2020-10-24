package sort;

import java.util.*;
import static sort.Util.*;

public class HeapSort
{
	public static <T extends Comparable<T>> void sort(ArrayList<T> list)
	{
		int N = list.size();
		
		// construct a heap
		for (int i = N / 2; i > 0; i --)
		{
			sink(list, i, N);
		}
		
		// sort 相当于不断delMax
		while (N >= 1)
		{
			exch(list, 1, N);
			N --;
			sink(list, 1, N);
		}
	}
	
	public static <T extends Comparable<T>> void exch(ArrayList<T> list, int i, int j)
	{
		Util.exch(list, i - 1, j - 1);
	}
	
	public static <T extends Comparable<T>> boolean less(ArrayList<T> list, int i, int j)
	{
		return Util.less(list.get(i - 1), list.get(j - 1));
	}
	
	public static void main(String[] args)
	{
		ArrayList<Integer> strList = new ArrayList<>(Arrays.asList(10, 9, 7, 5, 4, 3, 2));
		
		sort(strList);
		show(strList);
	}
	
	public static <T extends Comparable<T>> void sink(ArrayList<T> list, int start, int end)
	{
		while (start * 2 <= end)
		{
			int bigger = start * 2;
			if (bigger < end && less(list, bigger, bigger + 1))
				bigger ++;
			
			if (!less(list, start, bigger))
				break;
			
			exch(list, bigger, start);
			start = bigger;
		}
	}
}
