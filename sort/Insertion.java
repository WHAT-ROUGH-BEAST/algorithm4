package sort;

import java.util.*;
import static sort.Util.*;

public class Insertion
{
	public static <T extends Comparable<T>> void sort(ArrayList<T> list)
	{
		int N = list.size();
		
		for (int i = 0; i < N; i ++)
		{
			for (int j = i; j > 0 && less(list.get(j), list.get(j - 1)); j --)
			{
				exch(list, j, j - 1);
			}
		}
	}
	
	public static void main(String[] args)
	{
		ArrayList<Integer> strList = new ArrayList<>(Arrays.asList(10, 9, 7, 5, 4, 3, 2));
		
		sort(strList);
		show(strList);
	}
}
