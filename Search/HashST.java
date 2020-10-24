package Search;

public class HashST<Key extends Comparable<? super Key>, Val> implements STInterface<Key, Val>
{
	private static final int DEFAULT_SIZE = 1000;
	private SeqST<Key, Val>[] keys;
	
	@SuppressWarnings("unchecked")
	public HashST()
	{
		keys = (SeqST<Key, Val>[]) new SeqST[DEFAULT_SIZE];
	}
	
	@SuppressWarnings("unchecked")
	public HashST(int initSize)
	{
		keys = (SeqST<Key, Val>[]) new SeqST[initSize];
	}
	
	private int hash(Key key)
	{	
		return (key.hashCode() & 0x7fffffff) % keys.length;
	}

	@Override
	public void put(Key key, Val val)
	{
		SeqST<Key, Val> list = keys[hash(key)];
		 
	}

	@Override
	public Val get(Key key)
	{
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return 0;
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
