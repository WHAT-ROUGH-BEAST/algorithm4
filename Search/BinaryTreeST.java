package Search;

public class BinaryTreeST<Key extends Comparable<? super Key>, Val> implements STInterface<Key, Val>
{
	private class Node
	{
		Key key;
		Val val;
		Node left = null,
			 right= null;
		int size;
		
		Node(Key key, Val val, int size)
		{
			this.key = key;
			this.val = val;
			this.size = size;
		}
	}
	
	private Node root;

	@Override
	public void put(Key key, Val val)
	{
		root = put(root, key, val);
	}
	
	private Node put(final Node node, Key key, Val val)
	{
		if (null == node)
			return new Node(key, val, 1);
		
		int cmp = key.compareTo(node.key);
		if (cmp < 0)
			node.left = put(node.left, key, val);
		else if (cmp > 0)
			node.right = put(node.right, key, val);
		else
			node.val = val;
		
		node.size = size(node.left) + size(node.right) + 1;
		
		return node;
	}
	
	@Override
	public int size()
	{
		return size(root);
	}
	
	private int size(Node node)
	{
		if (null == node)
			return 0;
		
		return node.size;
	}

	@Override
	public Val get(Key key)
	{
		Node node = root;
		int cmp;
		
		while (node != null)
		{
			cmp = key.compareTo(node.key);
			
			if (cmp > 0)
				node = node.right;
			else if (cmp < 0)
				node = node.left;
			else
				return node.val;
		}
		
		return null;
	}

	@Override
	public Key min()
	{
		Node node = root;
		
		while (node.left != null)
		{
			node = node.left;
		}
		
		return node.key;
	}

	@Override
	public Key max()
	{
		Node node = root;
		
		while (node.right != null)
		{
			node = node.right;
		}
		
		return node.key;
	}
	
	@Override
	public Key select(int k)
	{
		return select(root, k).key;
	}
	
	// Ñ°ÕÒµÚk¸öÖµ
	private Node select(Node node, int k)
	{
		if (null == node || k > node.size)
			return null;
		
		int t = size(node.left);
		if (k > t)
			return select(node.right, k - t - 1);
		else if (k < t)
			return select(node.left, k);
		else
			return node;
	}

	@Override
	public int rank(Key key)
	{
		return rank(root, key);
	}
	
	private int rank(Node node, Key key)
	{
		if (null == node)
			return 0;
		
		int cmp = key.compareTo(node.key);
		if (cmp > 0)
			return 1 + size(node.left) + rank(node.right, key);
		else if (cmp < 0)
			return rank(node.left, key);
		else
			return size(node.left);
	}

	@Override
	public void delete(Key key)
	{
		root = delete(root, key);
	}
	
	private Node delete(Node node, Key key)
	{
		if (null == node)
			throw new RuntimeException();
		
		int cmp = key.compareTo(node.key);
		if (cmp > 0)
			node.right = delete(node.right, key);
		else if (cmp < 0)
			node.left = delete(node.left, key);
		else
		{
			if (null == node.left) 
				node = node.right;
			else if (null == node.right)
				node = node.left;
			else
			{
				Node temp = node;
				node = min(node.right);
				node.left = temp.left;
				node.right = temp.right;
			}
		}
		
		node.size = size(node.left) + size(node.right) + 1;
		
		return node;
	}
	
	private Node min(Node node)
	{
		if (null == node)
			return null;
		
		if (null == node.left)
			return node;
		else
			return min(node.left);
	}

	@Override
	public void deleteMin()
	{
		root = deleteMin(root);
	}
	
	private Node deleteMin(Node node)
	{
		if (null == node)
			throw new RuntimeException();
		
		if (node.left != null)
			node.left = deleteMin(node.left);
		else
			node = node.right;
		
		node.size = size(node.left) + size(node.right) + 1;
		
		return node;
	}
	
	public static void main(String[] args)
	{
		STInterface<String, Integer> table = new BinaryTreeST<>();
		
		for (int i = 10; i >= 1 ; i --)
		{
			table.put(String.valueOf(i), i);
		}
		
		System.out.println(table.size());
		System.out.println(table.get("5"));
		
		table.delete("5");
		
		System.out.println(table.size());
		System.out.println(table.get("5"));
	}
}
