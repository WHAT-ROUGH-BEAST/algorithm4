package algorithms4;

import java.util.Iterator;

public class LinkListTest
{
	public static void main(String[] args)
	{
		LinkList<String> strs = new LinkList<>();
		strs.add("this");
		strs.add("is");
		strs.add("a");
		strs.add("test");
		
		for (String s : strs)
		{
			System.out.println(s);
		}
	}
}

class LinkList<T> implements Iterable<T>
{	
	private class Node
	{
		T item = null;
		Node next = null;
	}
	
	private Node head = null;
	
	public void add(T item)
	{
		if (null == item)
			throw new RuntimeException();
		
		Node first = new Node();
		first.item = item;
		first.next = head;
		
		head = first;
	}

	@Override
	public Iterator<T> iterator()
	{
		return new Iterator<>() 
		{
			Node curr = head;
			
			@Override
			public boolean hasNext()
			{
				return curr != null;
			}

			@Override
			public T next()
			{
				if (hasNext())
				{
					T ret = curr.item;
					curr = curr.next;
					return ret;
				}
				
				throw new RuntimeException("no more");
			}
		};
	}
}
