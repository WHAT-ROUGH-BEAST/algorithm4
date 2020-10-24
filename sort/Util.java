package sort;

import static sort.Util.less;
import static sort.Util.show;

import java.util.ArrayList;
import java.util.Arrays;

public class Util
{
	// 访问4次数组
	public static <T extends Comparable<? super T>> void exch(ArrayList<T> list, int i, int j) 
	{
		T temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}
	
	public static <T extends Comparable<? super T>> boolean less(T a, T b)
	{
		return a.compareTo(b) < 0; 
	}
	
	public static <T extends Comparable<? super T>> void show(ArrayList<T> list)
	{
		System.out.println(list.toString());
	}
	
	public static <T extends Comparable<? super T>> boolean isSorted(ArrayList<T> list)
	{
		for (int i = 0; i < list.size() - 1; i ++)
		{
			if (!less(list.get(i), list.get(i + 1)))
				return false;
		}
		
		return true;
	}
}
