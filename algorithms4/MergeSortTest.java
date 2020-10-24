package algorithms4;

import java.util.*;
import java.util.stream.IntStream;

public class MergeSortTest
{
	public static <T extends Comparable<T>> T[] merge(T[] a, T[] b)
	{
		int ai = 0, 
			bi = 0;
		
		@SuppressWarnings("unchecked")
		T[] ret = (T[]) new Comparable[a.length + b.length];
		
		int index = 0;
		while (ai < a.length && bi < b.length)
		{
			ret[index ++] = a[ai].compareTo(b[bi]) >= 0 ? b[bi ++] : a[ai ++];
		}
		while (ai < a.length) 
		{
			ret[index ++] = a[ai ++];
		}
		while (bi < b.length)
		{
			ret[index ++] = b[bi ++];
		}
		
		return ret;
	}
	
	public static <T extends Comparable<T>> T[] mergeSort(T[] list)
	{	
		return sort(list, 0, list.length - 1);
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> T[] sort(T[] list, int left, int right)
	{
		int mid = (left + right) / 2;
		if (left == right)
			return (T[]) new Comparable[] {list[mid]};
		
		T[] leftList = sort(list, left, mid);
		T[] rightList = sort(list, mid + 1, right);
		return merge(leftList, rightList);
	}
	
	public static void main(String[] args)
	{
		Integer[] a = {10, 23, 4, 6 ,20, 123, 45, 12, 7};
		
		System.out.println(Arrays.toString(mergeSort(a)));
	}
}
