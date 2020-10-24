package sort;

import java.util.*;
import static sort.Util.*;

public class Quick
{
	private static int SMALL_THRESHOLD = 10;
	
	public static <T extends Comparable<T>> void sort(ArrayList<T> list)
	{
		sort(list, 0, list.size() - 1);
		ArrayList<Integer> i;
	}
	
	public static <T extends Comparable<T>> void sort(ArrayList<T> list, int lo, int hi)
	{
//		if (lo >= hi)
//			return;
		// 当表够小的时候，使用插入排序
		if (hi <= lo + SMALL_THRESHOLD)
		{
			Insertion.sort(list);
			return;
		}
		
		int j = partition(list, lo, hi);
		sort(list, lo, j - 1);
		sort(list, j + 1, hi);
	}
	
	public static <T extends Comparable<T>> int partition(ArrayList<T> list, int lo, int hi)
	{		
		int i = lo, j = hi + 1;
		T par = list.get(lo);
		// 此处可以三取样切分
		
		while (true)
		{
			while (less(list.get(++ i), par)) if (i == hi) break;
			while (less(par, list.get(-- j)));
			
			if (i >= j)
				break;
			
			exch(list, i, j);
		}
		
		exch(list, lo, j);
		
		return j;
	}
	
	public static void main(String[] args)
	{
		HashSet<Integer> set = new HashSet<>();
		ArrayList<Integer> strList;
		
		for (int i = 0; i < 20; i ++)
			set.add(new Random().nextInt(50));
		strList = new ArrayList<>(set);
		
		System.out.println("original: "); 
		show(strList);
		
		sort(strList);
		
		System.out.println("\nsorted: " + isSorted(strList)); 
		show(strList);
	}
}
