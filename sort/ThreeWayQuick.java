package sort;

import java.util.*;
import static sort.Util.*;

public class ThreeWayQuick
{
	private static int SMALL_THRESHOLD = 10;
	
	public static <T extends Comparable<T>> void sort(ArrayList<T> list)
	{
		sort(list, 0, list.size() - 1);
	}
	
	public static <T extends Comparable<T>> void sort(ArrayList<T> list, int lo, int hi)
	{
		if (hi <= lo + SMALL_THRESHOLD)
		{
			Insertion.sort(list);
			return;
		}
		
		// 选择3取样元素作边界
		int border = maxInThree(list, lo, (lo + hi) / 2, hi);
		
		int lt = lo, i = lo, gt = hi;
		T par = list.get(border); // 选取第一个元素作为边界
		
		while (i < gt)
		{
			int cmp = list.get(i).compareTo(par);
			
			if (cmp < 0)
			{
				exch(list, i ++, lt ++);
			}
			else if (cmp == 0)
			{
				i ++;
			}
			else
			{
				exch(list, i, gt --);
			}
		}
		
		sort(list, lo, lt - 1);
		sort(list, gt + 1, hi);
	}
	
	public static <T extends Comparable<T>> int maxInThree(ArrayList<T> list, int lo, int mid, int hi)
	{
		ArrayList<T> temp = new ArrayList<>(Arrays.asList(list.get(lo), list.get(mid), list.get(hi)));
		Insertion.sort(temp);
		
		list.set(lo, temp.get(0));
		list.set(mid, temp.get(1));
		list.set(hi, temp.get(2));
		
		return list.indexOf(temp.get(1));
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
		Collections.sort(strList);
	}
}
