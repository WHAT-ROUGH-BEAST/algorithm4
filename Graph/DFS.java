package Graph;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;

public class DFS
{
	private Graph graph;
	private boolean[] marked;
	private int[] edge;
	private final int start;
	
	public DFS(Graph g, int start)
	{
		this.start = start;
		this.graph = g;
		
		marked = new boolean[g.E()];
		edge = new int[g.E()];
		Arrays.fill(edge, -1);
		Arrays.fill(marked, false);
		
		edge[start] = start;
		dfs(start);
	}
	
	private void dfs(int e)
	{
		if (e > graph.E())
			throw new RuntimeException("e > E");
		
		marked[e] = true;
		for (int w : graph.adj(e))
		{
			if (!marked[w])
			{
				edge[w] = e;
				dfs(w);
			}
		}
	}
	
	public boolean hasPathTo(int v)
	{
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v)
	{
		if (!hasPathTo(v))
			return null;
		
		LinkedList<Integer> stack = new LinkedList<>();
		stack.push(v);
		
		while (edge[v] != start)
		{
			stack.push(edge[v]);
			v = edge[v];
		}
		stack.push(start);
		
		return stack;
	}
	
	public static void main(String[] args)
	{
		DFS dfs = new DFS(new Graph(new In("C:\\Users\\18069\\Desktop\\data.txt")), 0);
		System.out.println(dfs.pathTo(5));
	}
}
