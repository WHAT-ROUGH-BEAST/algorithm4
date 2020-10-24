package Graph;

import java.util.HashSet;

public class Digraph
{
	private HashSet<Integer>[] adj;
	private final int V;
	private int E;
	
	@SuppressWarnings("unchecked")
	public Digraph(int V)
	{
		this.V = V;
		this.E = 0;
		
		adj = (HashSet<Integer>[]) new HashSet[V];
		for (int i = 0; i < V; i ++)
		{
			adj[i] = new HashSet<>();
		}
	}
	
	public Digraph(In data)
	{
		this(data.readInt()); 
		int E = data.readInt();
		
		Integer p = data.readInt();
		while (p != null)
		{
			addEdge(p, data.readInt());
			p = data.readInt();
		}
		
		this.E = E;
	}
	
	public int V() { return V; }
	
	public int E() { return E; }
	
	public void addEdge(int v, int w)
	{
		adj[v].add(w);
		E ++;
	}
	
	public Iterable<Integer> adj(int v)
	{
		return adj[v];
	}
	
	public Digraph reverse()
	{
		Digraph reverseG = new Digraph(V);
		for (int v = 0; v < V; v ++)
			for (int w : adj(v))
				reverseG.addEdge(w, v);
		
		return reverseG;
	}
}
