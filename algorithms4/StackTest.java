package algorithms4;

import java.util.*;

public class StackTest
{
	public static void main(String[] args)
	{
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < 10; i ++)
		{
			stack.push(i);
		}
		
		LinkedList<String> s;
		
		
	}
}

interface StackInterface<T>
{
	void push(T item);
	T pop();
}

class Stack<T> implements Iterable<T>, StackInterface<T>
{
	private static final int DEFAULT_CAP = 4;
	private T[] items;
	private int size;
	
	@SuppressWarnings("unchecked")
	public Stack()
	{
		items = (T[]) new Object[DEFAULT_CAP];
		size = -1;
	}
	
	@SuppressWarnings("unchecked")
	public Stack(int initCap)
	{
		items = (T[]) new Object[initCap];
		size = -1;
	}
	
	@Override
	public void push(T item)
	{
		if (null == item)
			throw new RuntimeException("null item");
		
		if (items[items.length - 1] != null)
			resize();
		
		items[++ size] = item;
	}

	@Override
	public T pop()
	{
		if (null == items[0])
			throw new RuntimeException("emptyStack");
		
		T ret = null;
		ret = items[size];
		items[size --] = null;
		
		return ret;
	}	
	
	private void resize()
	{
		if (items[items.length - 1] != null)
			items = Arrays.copyOf(items, items.length * 2);
		
		if (items[items.length / 4] == null && items.length > 4)
			items = Arrays.copyOf(items, items.length / 2);
	}
	
	@Override
	public Iterator<T> iterator()
	{
		return new Iterator<T>()
		{
			private int index = 0;

			@Override
			public boolean hasNext()
			{
				if (index >= size)
					return false;
				
				return true;
			}

			@Override
			public T next()
			{
				if (hasNext())
					return items[index ++];
				
				throw new RuntimeException("no more");
			}
			
		};
	}
	
	@Override
	public String toString()
	{
		return Arrays.toString(items);
	}

}