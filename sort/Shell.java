package sort;

import java.util.*;
import static sort.Util.*;

public class Shell
{
	// < N^2
	public static <T extends Comparable<T>> void sort(ArrayList<T> list)
	{
		int N = list.size();
		int h = 1;
		while (h < N/3)
			h = 3*h + 1;
		
		while (h >= 1)
		{
			for (int i = h; i < N; i ++)
			{
				for (int j = i; j >= h; j -= h)
				{
					if (less(list.get(j), list.get(j - h)))
						exch(list, j, j - h);
				}
			}
			
			h = h / 3;
		}
	}
	
	public static void main(String[] args)
	{
		ArrayList<Integer> strList = new ArrayList<>(Arrays.asList(10, 9, 7, 5, 4, 3, 2));
		
		sort(strList);
		show(strList);
	}
}
