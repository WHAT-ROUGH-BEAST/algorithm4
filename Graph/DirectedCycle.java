package Graph;

import Graph.WeightedDigraph.DirectedEdge;

import java.util.*;

public class DirectedCycle
{
	private boolean[] onStack;
	private boolean[] marked;
	private LinkedList<Integer> cycle;
	private int[] edgeTo;
	
	public DirectedCycle(Digraph G)
	{
		onStack = new boolean[G.V()];
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		
		for (int v = 0; v < G.V(); v ++)
			if (!marked[v]) dfs(G, v);
	}
	
	private void dfs(Digraph G, int v)
	{
		if (v >= G.V())
			throw new RuntimeException();
		
		marked[v] = true;
		if (cycle != null)	return;
		
		onStack[v] = true;
		
		for (int w : G.adj(v))
		{
			if (!marked[w])
			{
				edgeTo[w] = v;
				dfs(G, w);
			}
			else if (onStack[w])
			{
				cycle = new LinkedList<>();
				for (int x = v; x != w; x = edgeTo[x])
					cycle.push(x);
				
				cycle.push(w);
				cycle.push(v);
			}
		}
		
		onStack[v] = false;
	}

	public boolean hasCycle()
	{
		return cycle != null;
	}

	public Iterable<Integer> cycle()
	{
		return cycle;
	}
}
