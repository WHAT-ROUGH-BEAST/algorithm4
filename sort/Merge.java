package sort;

import java.util.*;
import static sort.Util.*;
import static java.lang.Math.*;

public class Merge
{
	private static ArrayList<? super Comparable<?>> aux;
	
	// N*logN
	public static <T extends Comparable<T>> void sort(ArrayList<T> list)
	{
		aux = new ArrayList<>(list);
		sort(list, 0, list.size() - 1);
	}
	
	public static <T extends Comparable<T>> void sort(ArrayList<T> list, int lo, int hi)
	{
		if (lo >= hi)
			return;
		
		int mid = (lo + hi) / 2;
		
		sort(list, lo, mid);
		sort(list, mid + 1, hi);
		
		merge(list, lo, mid, hi);
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> void merge(ArrayList<T> list, int lo, int mid, int hi)
	{	
		// both left and right parts of array are sorted, if list[mid]<=list[mid + 1], 
		// means the lo~hi part is sorted
		if (less(list.get(mid), list.get(mid + 1)))
			return;
		
		int left = lo, right = mid + 1;
		
		for (int i = lo; i <= hi; i ++)
		{
			aux.set(i, list.get(i));
		}
		
		for (int i = lo; i <= hi; i ++)
		{
			if (left > mid) 
				list.set(i, (T) aux.get(right ++));
			else if (right > hi)
				list.set(i, (T) aux.get(left ++));
			else if (less((T) aux.get(left), (T) aux.get(right)))
				list.set(i, (T) aux.get(left ++));
			else
				list.set(i, (T) aux.get(right ++));
		}
	}
	
	public static <T extends Comparable<T>> void iterSort(ArrayList<T> list)
	{
		int N = list.size();
		aux = new ArrayList<>(list);
		
		for (int size = 2; size < N + 2; size += size)
		{
			for (int i = 0; i < N; i += size)
			{
				int left = i,
					right = min(i + size - 1, N - 1);
				if (left == right)
					continue;
				
				int mid = (left + right) / 2;
				
				merge(list, left, mid, right);
			}
		}
	}
	
	public static void main(String[] args)
	{
		ArrayList<Integer> strList = new ArrayList<>(Arrays.asList(10, 9, 7, 5, 4, 3, 2));
		
		iterSort(strList);
		show(strList);
	}
}
