package Graph;

import java.util.*;

public class DFOrder
{
	private boolean marked[];
	private LinkedList<Integer> stack;
	
	public DFOrder(Digraph G)
	{
		marked = new boolean[G.V()];
		stack = new LinkedList<>();
		
		for (int v = 0; v < G.V(); v ++)
			if (!marked[v]) dfs(G, v);
	}
	
	private void dfs(Digraph G, int v)
	{
		if (v >= G.V())
			throw new RuntimeException();
		
		marked[v] = true;
		
		for (int w : G.adj(v))
			if (!marked[w])
				dfs(G, w);
		
		stack.push(v);
	}

	public Iterable<Integer> reverseOrder()
	{
		return stack;
	}
}
