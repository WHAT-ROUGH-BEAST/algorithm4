package Search;

public class Tree2_3ST<Key extends Comparable<? super Key>, Val> implements STInterface<Key, Val>
{
	public static final boolean RED = true;
	public static final boolean BLACK = false;
	
	private class Node
	{
		Key key;
		Val val;
		Node left = null, 
			 right= null;
		int size;
		boolean color;
		
		Node(Key key, Val val, int size, boolean color)
		{
			this.key = key;
			this.val = val;
			this.size = size;
			this.color = color;
		}
		
		boolean isRed()
		{
			return color;
		}
	}
	
	private Node root;

	@Override
	public void put(Key key, Val val)
	{
		root = put(root, key, val);
		root.color = BLACK;
	}
	
	private Node put(Node node, Key key, Val val)
	{
		if (null == node)
			return new Node(key, val, 1, RED);
		
		int cmp = key.compareTo(node.key);
		if (cmp > 0)
			node.right = put(node.right, key, val);
		else if (cmp < 0)
			node.left = put(node.left, key, val);
		else
			node.val = val;
		
		// rotate
		if (node.left.isRed() && node.left.left.isRed())
			node = rotateLeft(node);
		if (!node.left.isRed() && node.right.isRed())
			node = rotateRight(node);
		if (node.left.isRed() && node.right.isRed())
			flipColors(node);
		
		node.size = size(node.left) + size(node.right) + 1;
		
		return node;
	}
	
	private Node rotateRight(Node node)
	{
		Node temp = node;
		node = node.right;
		
		node.color = temp.color;
		temp.color = RED;
		temp.right = node.left;
		node.left = temp;
		
		node.size = temp.size;
		temp.size = size(temp.right) + size(temp.left) + 1;
		
		return node;
	}

	private Node rotateLeft(Node node)
	{
		Node temp = node;
		node = node.left;
		
		node.color = temp.color;
		temp.color = RED;
		temp.left = node.right;
		node.right = temp;
		
		node.size = temp.size;
		temp.size = size(temp.right) + size(temp.left) + 1;
		
		return node;
	}
	
	private void flipColors(Node node)
	{
		node.color = RED;
		node.left.color = BLACK;
		node.right.color = BLACK;
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
		
		while(node != null)
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
	public void delete(Key key)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMin()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public int size()
	{
		return size(root);
	}

	@Override
	public Key min()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Key max()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Key select(int k)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int rank(Key key)
	{
		// TODO Auto-generated method stub
		return 0;
	}
	
}
