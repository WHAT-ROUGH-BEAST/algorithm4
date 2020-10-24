package Graph;

public class CC
{
	private boolean[] marked;
	private int[] id;
	private int count;
	
	public CC(Graph G)
	{
		int size = G.V();
		marked = new boolean[size];
		id = new int[size];
		count = 0;
		
		for (int s = 0; s < size; s ++)
		{
			if (!marked[s])
			{
				dfs(G, s);
				count ++;
			}
		}
	}
	
	private void dfs(Graph G, int v)
	{
		if (v > G.V())
			throw new RuntimeException("e > E");
		
		marked[v] = true;
		id[v] = count;
		
		for (int w : G.adj(v))
			if (!marked[w])
				dfs(G, w);
	}
	
	public boolean connected(int v, int w)
	{
		return id[v] == id[w];
	}
	
	public int id(int v)
	{
		return id[v];
	}
	
	public int count()
	{
		return count;
	}
	
	public static void main(String[] args)
	{
		CC cc = new CC(new Graph(new In("C:\\Users\\18069\\Desktop\\data.txt")));
		System.out.println(cc.connected(0, 5));
	}
}
