package Graph;

import java.io.*;
import java.util.*;

public class Graph
{
	private HashSet<Integer>[] adj;
	private final int V;
	private int E;
	
	@SuppressWarnings("unchecked")
	public Graph(int V)
	{
		this.V = V;
		this.E = 0;
		
		adj = (HashSet<Integer>[]) new HashSet[V];
		for (int i = 0; i < V; i ++)
		{
			adj[i] = new HashSet<>();
		}
	}
	
	public Graph(In data)
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
		adj[w].add(v);
		E ++;
	}
	
	public Iterable<Integer> adj(int v)
	{
		return adj[v];
	}
}
