package sort;

import java.util.*;
import static sort.Util.*;

public class Selection
{
	// (4N)^2
	public static <T extends Comparable<T>> void sort(ArrayList<T> list)
	{
		int length = list.size();
		
		for (int i = 0; i < length; i ++)
		{
			int minIndex = i;
			for (int j = i; j < length; j ++)
			{
				if (less(list.get(j), list.get(minIndex)))
					minIndex = j;
			}
			
			exch(list, i, minIndex);
		}
	}
	
	public static void main(String[] args)
	{
		ArrayList<Integer> strList = new ArrayList<>(Arrays.asList(10, 9, 7, 5, 4, 3, 2));
		
		sort(strList);
		show(strList);
	}
}
